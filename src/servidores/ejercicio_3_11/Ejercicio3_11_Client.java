package servidores.ejercicio_3_11;


/*
Utilizando sockets UDP crea un programa servidor que inicialice un array de 5
objetos de tipo Alumno. Invéntate los datos, cada objeto Alumno deberá tener un
idAlumno distinto, igualmente cada curso tiene su id. El servidor se ejecutará en
un bucle infinito, recibirá del cliente un idAlumno y le devolverá el objeto Alumno
que corresponda con ese identificador. El servidor debe visualizar el identificador
solicitado por el cliente.

Objetos en Sockets UDP.
Ejercicio 3.11.-
Crea un programa cliente en el que se introduzca por teclado el idAlumno que se
desea consultar (el programa realizará la lectura en un proceso repetitivo hasta que
el idAlumno leído por teclado sea *). Se enviará al servidor el idAlumno a
consultar. El servidor le devolverá un objeto Alumno con los datos solicitados. Si el
alumno no existe, también le devolverá un objeto Alumno con datos que indiquen
que el alumno no existe. El cliente debe visualizar todos los datos, incluido el curso
del alumno
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_11_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(serverName);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Introduce el idAlumno (introduce * para salir): ");
                String idAlumno = scanner.nextLine();

                if (idAlumno.equals("*")) {
                    break;
                }

                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
                out.writeObject(idAlumno);

                byte[] sendData = byteOutStream.toByteArray();
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
                socket.send(packet);

                byte[] buffer = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                ByteArrayInputStream byteStream = new ByteArrayInputStream(responsePacket.getData(), 0, responsePacket.getLength());
                ObjectInputStream in = new ObjectInputStream(byteStream);
                Alumno alumno = (Alumno) in.readObject();

                System.out.println("Recibido: idAlumno = " + alumno.getIdAlumno() + ", nombre = " + alumno.getNombre() +
                        ", curso = " + alumno.getCurso().getDescripcion() + ", nota = " + alumno.getNota());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}