package servidores.ejercicio3_3;

/*
Escribe un programa cliente que solicite por teclado un número entero y se lo envíe
al servidor. El servidor le devolverá el cuadrado del número.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_3_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un número entero: ");
            int number = scanner.nextInt();

            out.println(number);
            String response = in.readLine();
            System.out.println("El cuadrado del número es: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
