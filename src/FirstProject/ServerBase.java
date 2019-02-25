package FirstProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ServerBase {
    private Semaphore semaphore;
    public ServerBase(){
        semaphore = new Semaphore();
    }
    public void start(){
        while(true){
            try{
                runServer();
            } catch (Exception e){
                println("[Server] Error with server, trying to relaunch...");
            }
        }
    }
    private void runServer() throws Exception{
        ServerSocket server = new ServerSocket(5421);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        println("[Server] Server launched");
        while (!server.isClosed()) {
            Socket client = server.accept();
            new Thread(new ThreadClientHandler(semaphore,client)).start();
        }
    }
    private void println(String action){
        System.out.println(
                (new SimpleDateFormat("[HH:mm:ss] ")).format(new Date()) + action
        );
    }


    //ready
}
