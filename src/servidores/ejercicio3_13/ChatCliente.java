package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatCliente {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 11223;

        try (Socket socket = new Socket(serverName, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de chat. Introduce texto (\"*\" para salir):");

            String input;
            while (true) {
                input = scanner.nextLine();
                out.writeUTF(input);
                if (input.equals("*")) {
                    break;
                }

                String response = in.readUTF();
                System.out.println("Servidor: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

