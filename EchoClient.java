import java.io.*;
import java.net.*;


public class EchoClient{

    public static final int PORT = 3131;

    public static void main(String[] args){

        Socket clientSocket = new Socket("localhost",PORT);
        System.out.println("Client started at port: " + PORT);

        DataInputStream in = clientSocket.getInputStream();
        DataOutputStream out = clientSocket.getOutputStream();


    }
}