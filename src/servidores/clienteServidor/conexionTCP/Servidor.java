package servidores.clienteServidor.conexionTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args){

        ServerSocket servidor = null;
        Socket sc = null; //socket del cliente
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");


            while (true){
                sc = servidor.accept();//se queda a la espera

                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());//leer/recibir los mensajes del cliente
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();

                System.out.println(mensaje);

                out.writeUTF("Hola mundo desde el servidor");
                sc.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
