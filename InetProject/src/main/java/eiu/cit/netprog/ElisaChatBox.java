package eiu.cit.netprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ElisaChatBox {

	public static final String SERVER = "telehack.com";

	public static final int PORT = 23;

	public static final int TIMEOUT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket(SERVER, PORT);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);

			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			for (char c = (char) reader.read();; c = (char) reader.read()) {
				System.out.print(c);
				if (c == '.') {
					char d = (char) reader.read();
					char e = (char) reader.read();
					char f = (char) reader.read();
					System.out.print(d);
					System.out.print(e);
					System.out.print(f);
					if (f == '.') {
						break;
					}

				}

			}
//			boolean check = false;
//			int c;
//			while((c = reader.read()) != -1) {
//				if ((char)c == '.') {
//					if (check) {
//						break;
//					}
//				}else if {
//					check = false;
//				}
//				System.out.print((char)c);
//			}
			writer.write("eliza\r\n");
			readEliza(reader);
			writer.flush();
			

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void readEliza(BufferedReader bif) {
		int c;
		int count = 0;
		try {
			while((c = bif.read()) !=0){
				if((char) c == '\r') {
					if (count == 3) {
						break;
					}else {
						count++;
					}
				}
				if (count == 2) {
					System.out.println((char)c);
				}
			}
			System.out.println();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public static void readEliz(BufferedReader bif){
		int c;
		int count =0;
		try {
			while((c = bif.read()) != 0) {
				if((char)c =='\r') {
					if (count ==2) {
						break;
					}else {
						count++;
					}
				}
				if(count == 2) {
					System.out.println((char)c);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
