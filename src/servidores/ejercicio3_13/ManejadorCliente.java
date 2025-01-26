package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;

public class ManejadorCliente implements Runnable {
    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            String input;
            while (!(input = in.readUTF()).equals("*")) {
                System.out.println("Recibido: " + input);
                String processed = input.replaceAll("[AEIOUaeiou]", "");
                out.writeUTF(processed);
            }
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
