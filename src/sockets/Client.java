package sockets;

import java.net.*;
import java.io.*;

public class Client {
	// initialize socket and input output streams
	private Socket socket = null;
//	private DataInputStream input = null;
	private DataOutputStream out = null;
	private String message = null;

	// constructor to put ip address and port
	public Client(String address, int port, String message,String hash) throws Exception {
		// establish a connection
		this.message = message;
	
		socket = new Socket(address, port);
		System.out.println("Connected");

		Thread.sleep(500);
		
		// takes input from terminal
//		input = new DataInputStream(System.in);

		// sends output to the socket
		out = new DataOutputStream(socket.getOutputStream());

		// string to read message from input
//		String line = ""; 

		// keep reading until "Over" is input

		out.writeUTF(this.message);
/*
		Thread.sleep(5000);
		URL url = new URL("http://localhost:5000/arrived?hash="+this.message);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		br.close();
*/
		// close the connection

//		input.close();
		out.close();
		socket.close();
		new HttpReq().sendData(hash);
//		
		
	}
/*
	 //usage
	public static void main(String args[]) throws Exception {
		Client client = new Client("192.168.0.107", 3001, "jaa be At some point");
	}
	*/
}
