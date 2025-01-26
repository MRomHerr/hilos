package servidores.clienteServidor.conexionUDP;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class cliente {
    public static void main(String[] args){

        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];


        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "hola mundo desde el servidor";
            buffer = mensaje.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            socketUDP.send(pregunta);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(peticion);

            mensaje = new String (peticion.getData());
            System.out.println(mensaje);

            socketUDP.close();



        } catch (SocketException e) {
            System.out.println("Error al abrir el socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en el envío/recepción de datos: " + e.getMessage());
        }
    }
}
