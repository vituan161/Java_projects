package eiu.cit.netprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class callBackClient {

	public final static String SERVER = "localhost";
	public final static int PORT = 13;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(SERVER,PORT);
			socket.setSoTimeout(15000);
			
			Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer = new BufferedWriter(writer);
			
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in , "UTF-8"));
			BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));
			
			String line = terminal.readLine();
			while(!line.equals("quit")) {
				writer.write(line+"\r\n");
				writer.flush();
				readLine(reader);
				line = terminal.readLine();
			}
			writer.write("quit"+"\r\n");
			writer.flush();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	private static void readLine(BufferedReader br) {
		try {
			String echo = br.readLine();
			System.out.println(echo);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
