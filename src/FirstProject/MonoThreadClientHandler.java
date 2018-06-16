package FirstProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class MonoThreadClientHandler implements Runnable {
    private static Socket clientDialog;
    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.clientDialog = client;
    }
    @Override
    public void run(){
            try{
                CommandContainer commands = new CommandContainer();
                new AllComands(commands);
                DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
                DataInputStream in = new DataInputStream(clientDialog.getInputStream());
                out.writeUTF("BlackServer v0.0.2 ALPHA");
                while (!clientDialog.isClosed()) {
                    String command = in.readUTF();
                    System.out.println("command - " + command);
                    int com = commands.findCommand(command);
                    if(com == -1) out.writeUTF("Unknown command.");
                    if(com == 0) out.writeUTF(commands.GetAllCommands());
                    out.flush();
                }
                System.out.println("Client disconnected");
                in.close();
                out.close();
                clientDialog.close();
                System.out.println("Closing connections & channels - DONE.");
            } catch (IOException e){
                System.out.println("Client disconnected");
            }
    }
}