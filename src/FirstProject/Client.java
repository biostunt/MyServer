package FirstProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",8888);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println("Client connected to socket.");
        while(!socket.isOutputShutdown()){
            if(input.ready()){
                Thread.sleep(1000);
                System.out.print("Type message: ");
                String clientCommand = input.readLine();
                out.writeUTF(clientCommand);
                out.flush();
            }
        }
        //должен кидать не только сообщения но и команды. а сервер должен их выполнять 
    }
}
