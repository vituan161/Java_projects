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

public class TTTServer {

	private final static int PORT = 10;
	private static OOPAbstractLogic logic;

	public static void main(String[] args) throws IOException {

		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				Socket connection = server.accept();
				Runnable connectionHandler = new connectToNewClient(connection);
				new Thread(connectionHandler).start();
			}
		}
	}

	public static class connectToNewClient implements Runnable {

		private final Socket socket;

		public connectToNewClient(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				Writer out = new OutputStreamWriter(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String strategy = in.readLine();
				runGame(strategy, socket, out, in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void runGame(String strategy, Socket connection, Writer out, BufferedReader in) throws IOException {
		final TTTGame ttt = new TTTGame();
		if (strategy.equals("left")) {
			logic = new TTTLogicLeft();
		} else if (strategy.equals("right")) {
			logic = new TTTLogicRight();
		} else {
			logic = new TTTLogicRandom();
		}
		// initialize
		ttt.initialize();

		while (true) {
			String move = in.readLine();
			if (move.equals("quit")) {
				break;
			} else {
				// get move
				/*
				 * This method returns the numeric value of the character, as a non-negative int
				 * value; -2 if the character has a numeric value that is not a non-negative
				 * integer; -1 if the character has no numeric value.
				 */
				int cell = Character.getNumericValue(move.charAt(0));
				// check that the move is within range
				if (cell >= 0 && cell < 9) {
					// check that the move is to an empty cell
					boolean empty = logic.checkMove(ttt.getBoard(), cell);
					// System.out.println(empty);
					if (empty) {
						/// update board
						logic.updateBoard(ttt.getBoard(), cell);
						// check status for player 'o'
						// 0. player has not won yet
						// 1. player won
						if (logic.checkStatus(ttt.getBoard(), 'o') == 0) {
							if (logic.checkBoard(ttt.getBoard()) == 0) {
								logic.makeMove(ttt.getBoard());
								// check status for player 'x'
								if (logic.checkStatus(ttt.getBoard(), 'x') == 0) {
									// check status of board
									// 0. no draw yet
									// 1. draw
									if (logic.checkBoard(ttt.getBoard()) == 0) {
										// return new board
										out.write(ttt.encodeBoard() + "\r\n");
										out.flush();
									} else {
										// return new board
										out.write(ttt.encodeBoard() + " *** ");
										out.write("It's a draw!" + " *** ");
										out.write("Let's play again!" + " *** " + "\r\n");
										out.flush();
										ttt.initialize();
									}
								} else {
									// return new board
									out.write(ttt.encodeBoard() + " *** ");
									out.write("I won!" + " *** ");
									out.write("Let's play again!" + " *** " + "\r\n");
									out.flush();
									ttt.initialize();
								}

							} else {
								// return new board
								out.write(ttt.encodeBoard() + " *** ");
								out.write("It's a draw!" + " *** ");
								out.write("Let's play again!" + " *** " + "\r\n");
								out.flush();
								ttt.initialize();
							}

						} else {
							// return new board
							out.write(ttt.encodeBoard() + " *** ");
							out.write("You won!" + " *** ");
							out.write("Let's play again!" + " *** " + "\r\n");
							out.flush();
							ttt.initialize();
						}

					} else {
						// return new board
						out.write("Occupied cell!" + "\r\n");
						out.flush();
					}

				} else {
					// return new board
					out.write("Wrong input!" + "\r\n");
					out.flush();
				}
			}

		}
		connection.close();
	}

}
