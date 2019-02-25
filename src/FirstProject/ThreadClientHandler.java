package FirstProject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ThreadClientHandler implements Runnable {
    private Socket client;
    private Semaphore semaphore;
    private boolean isAlive = true;

    public ThreadClientHandler(Semaphore semaphore, Socket client) {
        this.semaphore = semaphore;
        this.client = client;
        println("[Client] connected");
    }
    @Override
    public void run(){
            while(isAlive){
                try{
                    work();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
    }

    private void work(){
        try{

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            while (!client.isClosed()) {
                String command = in.readUTF();
                println("[Client] " + command);
                commandHandler(command);
                out.writeUTF("answer");
                out.flush();
            }
            in.close();
            out.close();
            client.close();
            println("[Server] Closing connections & channels at");
        } catch (IOException e){
            println("[Client] disconnected");
        } finally {
            isAlive = false;
        }
    }

    private void commandHandler(String comand){
        semaphore.take();
        semaphore.release();
    }



    private void println(String action){
        System.out.println(
                (new SimpleDateFormat("[HH:mm:ss] ")).format(new Date()) + action
        );
    }

}