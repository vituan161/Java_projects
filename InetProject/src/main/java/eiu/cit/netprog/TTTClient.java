package eiu.cit.netprog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.text.ParseException;

public class TTTClient {
	static String move = "";
	static String board = "nothing";
	static String strategy = "";

	public static void main(String[] args) throws ParseException {
		String hostname = "localhost";
		Socket socket = null;
		while (!(move.equals("quit")))
			startClient(hostname, socket);
	}

	static void startClient(String hostname, Socket socket) {
		try {
			socket = new Socket(hostname, 10);
			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader bif = new BufferedReader(reader);

			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			BufferedWriter bout = new BufferedWriter(out);

			// Enter data using BufferReader
			BufferedReader terminal = new BufferedReader(new InputStreamReader(System.in));

			if (strategy == "") {
				System.out.println("`left` or `right` or nothing to indicate strategy");
				strategy = terminal.readLine();
			}
			bout.write(strategy+":"+board+ "\r\n");
			bout.flush();
			move = terminal.readLine();
			bout.write(move + "\r\n");
			bout.flush();
			readBoard(bif);
			board = bif.readLine();
			socket.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	static void readBoard(BufferedReader bif) {
		try {
			String encodedBoard = bif.readLine();
			board = encodedBoard;
			System.out.println(encodedBoard);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
