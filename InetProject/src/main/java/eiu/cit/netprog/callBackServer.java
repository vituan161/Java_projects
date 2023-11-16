package eiu.cit.netprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class callBackServer {
	
	public final static int PORT = 13;

	public static void main(String[] args) {
		try(ServerSocket socket = new ServerSocket(PORT)){
			while(true) {
					try(Socket connection = socket.accept()){
						Writer writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
						writer = new BufferedWriter(writer);
						
						Reader in = new InputStreamReader(connection.getInputStream(), "UTF-8");
						BufferedReader reader = new BufferedReader(in);
						
						for(String line = reader.readLine(); line != "quit"+"\r\n" ; line = reader.readLine()) {
							writer.write(line+"\r\n");
							writer.flush();
						}
						connection.close();
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
			}
		}catch (IOException e) {
			System.out.println(e);
		}
	}

}
