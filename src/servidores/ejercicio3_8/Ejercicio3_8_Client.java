package servidores.ejercicio3_8;

/*
Crea una clase java llamada Numeros que defina 3 atributos: un entero y dos
long: int numero, long cuadrado y long cubo.
Escribe un constructor con y otro sin parámetros y los getters y setters.
Crea un programa cliente que introduzca por teclado un número e inicialice un
objeto Numeros. El atributo numero debe contener el número introducido por
teclado. Debe enviar ese objeto al servidor. El proceso se repetirá mientras el
número introducido sea mayor que 0.
Crea el programa servidor que reciba un objeto Numeros. Debe calcular el cuadrado
y el cubo del atributo numero y debe enviar el objeto al cliente con los cálculos
realizados, el cuadrado y el cubo en sus atributos respectivos. El cliente recibirá el
objeto y visualizará el cuadrado y el cubo. El programa servidor finalizará cuando el
número recibido en el objeto Numeros sea menor o igual que cero.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_8_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Introduce un número entero (<= 0 para salir): ");
                int numero = scanner.nextInt();

                Numeros numeros = new Numeros(numero);
                out.writeObject(numeros);

                if (numero <= 0) {
                    break;
                }

                numeros = (Numeros) in.readObject();
                System.out.println("Cuadrado: " + numeros.getCuadrado() + ", Cubo: " + numeros.getCubo());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
