package servidores.ejercicio3_4;

/*
Escribe un programa servidor que pueda atender hasta 3 clientes. Debe enviar a
cada cliente un mensaje indicando el número de cliente que es. Este número será 1,
2 o 3. El cliente mostrará el mensaje recibido. Cambia el programa para que lo haga
con N clientes, siendo N un parámetro que tendrás que definir en el programa.
 */
import java.io.*;
import java.net.*;

public class Ejercicio3_4_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();
            System.out.println("Mensaje del servidor: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
