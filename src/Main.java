import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		try {
	        Thread t = new Connector(3000);
	        t.start();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

class Connector extends Thread {
	ServerSocket serverSocket = null;
	int lock = 0;
	
	public Connector(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.serverSocket.setSoTimeout(10000);
	}
	
	public boolean closeSocket() {
		try {
			serverSocket.close();
		} catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void run() {
	      while(true) {
	         try {
	            System.out.println("Waiting for client on port " + 
	               serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
	               + "\nGoodbye!");
	            server.close();
	            
	         } catch (SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         } catch (IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	
}
