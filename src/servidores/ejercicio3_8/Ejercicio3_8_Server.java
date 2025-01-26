package servidores.ejercicio3_8;

import java.io.*;
import java.net.*;

public class Ejercicio3_8_Server {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor listo para calcular cuadrado y cubo");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                Numeros numeros = (Numeros) in.readObject();

                if (numeros.getNumero() <= 0) {
                    System.out.println("Número recibido <= 0. Finalizando servidor.");
                    break;
                }

                int numero = numeros.getNumero();
                numeros.setCuadrado((long) numero * numero);
                numeros.setCubo((long) numero * numero * numero);

                out.writeObject(numeros);
                System.out.println("Procesado: número = " + numero + ", cuadrado = " + numeros.getCuadrado() + ", cubo = " + numeros.getCubo());

                clientSocket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
