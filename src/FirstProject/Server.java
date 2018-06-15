package FirstProject;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Server {
    public static void println(String s){ System.out.println(s);}
    public static void main(String[] args)throws Exception {
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        System.out.println("Connection accepted");
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        System.out.println("DataOutputStream  created");
        DataInputStream in = new DataInputStream(client.getInputStream());
        System.out.println("DataInputStream created");

        while(client.isConnected()){
            System.out.println("Server reading from channel");
            String entry = in.readUTF();
            System.out.println("READ from client message - " + entry);
            if(entry.equalsIgnoreCase("quit")){
                println("Client initialize connections suicide ...");
                out.writeUTF("Server reply - " + entry + " - OK");
                out.flush();
                Thread.sleep(3000);
                break;
            }
            out.writeUTF("Server reply - "+entry + " - OK");
            System.out.println("Server Wrote message to client.");
            out.flush();
        }
        System.out.println("Client disconnected");
        System.out.println("Closing connections & channels.");
        in.close();
        out.close();
        client.close();
        System.out.println("Closing connections & channels - DONE.");
    }
}
