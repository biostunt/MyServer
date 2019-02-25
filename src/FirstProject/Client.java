package FirstProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",5421);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        while(!socket.isOutputShutdown()){
            out.writeUTF("моя команда");
            String answer = in.readUTF(); // Ответ Сервера
            out.flush();
        }
    }

}
