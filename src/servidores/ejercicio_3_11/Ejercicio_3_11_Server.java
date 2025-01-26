package servidores.ejercicio_3_11;

import java.io.*;
import java.net.*;

public class Ejercicio_3_11_Server {
    public static void main(String[] args) {
        int port = 6000;
        byte[] buffer = new byte[1024];

        // Inicializar array de objetos Alumno
        Alumno[] alumnos = {
                new Alumno("1", "Juan Perez", new Curso("101", "Matemáticas"), 85),
                new Alumno("2", "Ana Gómez", new Curso("102", "Historia"), 90),
                new Alumno("3", "Luis Sánchez", new Curso("103", "Ciencias"), 88),
                new Alumno("4", "Maria López", new Curso("104", "Inglés"), 92),
                new Alumno("5", "Carlos Ruiz", new Curso("105", "Física"), 80)
        };

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor UDP listo para recibir solicitudes de idAlumno");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                ObjectInputStream in = new ObjectInputStream(byteStream);
                String idAlumno = (String) in.readObject();

                System.out.println("idAlumno solicitado: " + idAlumno);
                Alumno respuesta = new Alumno("", "Alumno no encontrado", new Curso("", ""), 0);

                for (Alumno alumno : alumnos) {
                    if (alumno.getIdAlumno().equals(idAlumno)) {
                        respuesta = alumno;
                        break;
                    }
                }

                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
                out.writeObject(respuesta);

                byte[] sendData = byteOutStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, packet.getAddress(), packet.getPort());
                socket.send(sendPacket);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}