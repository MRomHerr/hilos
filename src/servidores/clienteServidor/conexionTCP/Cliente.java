package servidores.clienteServidor.conexionTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){

        final String HOST = "192.168.241.1";//tiene que ser la ip de mi maquina
        final int PUERTO=5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola mundo desde el cliente");

            String mensaje = in.readUTF();
            System.out.println(mensaje);
            sc.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
