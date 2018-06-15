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
        System.out.println("Client writing channel = out & reading channel = in initialized.");
        while(!socket.isOutputShutdown()){
            if(input.ready()){
                System.out.println("Client start writing in channel...");
                Thread.sleep(1000);
                String clientCommand = input.readLine();
                
            }
        }
    }
}
