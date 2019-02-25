package FirstProject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

    public static void main(String[] args){
        ServerBase serverBase = new ServerBase();
        serverBase.start();
    }
    //ready
}
