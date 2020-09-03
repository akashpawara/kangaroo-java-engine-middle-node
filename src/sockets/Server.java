package sockets;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import file.log.FileHelper;

public class Server {
	public static Thread run(int port, String filePath) throws Exception {
		return new Connector(port, filePath);
	}
}

class Connector extends Thread {
	ServerSocket serverSocket = null;
	String filePath = "";

	public Connector(int port, String filePath) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.filePath = filePath;
	}

	public boolean closeSocket() {
		try {
			serverSocket.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();

				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath));
				
				String[] data = in.readUTF().split("$");
				
				if (data[0].equals("1")) {
					FileHelper.writeStudentAttendanceToFile(null, data[1], this.filePath);
				}
				if (data[0].equals("2")) {
					FileHelper.writeStudentAttendanceToFile(null, data[1], this.filePath);
				}
				if (data[0].equals("3")) {
					FileHelper.writeStudentAttendanceToFile(null, data[1], this.filePath);
				}
				
				
				bw.write(in.readUTF()+"\n");
				bw.close();
				
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("ack");
				server.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				try {
					Thread.sleep(10000);
				} catch(Exception e) {
					e.printStackTrace();
					break;
				}
				//break;
			} catch (IOException e) {
				e.printStackTrace();
				try {
					Thread.sleep(10000);
				} catch(Exception es) {
					es.printStackTrace();
					break;
				}
				//break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}