import java.io.*;
import java.net.*;


public class EchoServer{

	public static final int PORT = 3131;

	public static void main(String[] args){

		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server started at port: " + PORT);
		Socket clientSocket = serverSocket.accept();

	}
}