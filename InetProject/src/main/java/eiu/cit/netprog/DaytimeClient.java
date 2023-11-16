package eiu.cit.netprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
	
	public static final String SERVER = "localhost";

	public static final int PORT = 13;

	public static void main(String[] args) throws InterruptedException {
		Socket socket = null;
		for(int i =0 ;i<Integer.parseInt(args[0]);i++) {
			connectToServer(SERVER, PORT, socket);
			Thread.sleep(1000);
		}
	}

	public static void connectToServer(String SERVER, int PORT, Socket socket) {
		try {
			socket = new Socket(SERVER, PORT);
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader bur = new BufferedReader(in);
			
			int c;
			while((c = bur.read()) != -1) {
				System.out.print((char)c);
			}
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
