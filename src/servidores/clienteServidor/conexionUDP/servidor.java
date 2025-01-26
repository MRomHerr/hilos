package servidores.clienteServidor.conexionUDP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class servidor {
    public static void main(String[] args){

        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Servidor UDP iniciado");
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            while(true){
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);
                System.out.println("Recivo la informacion del cliente");

                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola mundo desde el servidor";
                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                System.out.println("Envio informacion al cliente");

                socketUDP.send(respuesta);
            }


        } catch (SocketException e) {
            System.out.println("Error al abrir el socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en el envío/recepción de datos: " + e.getMessage());
        }


    }
}


