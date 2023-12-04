package eiu.cit.netprog;

public class TTTGame {
	private char[] board;
	private final static int[][] winners = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
			{ 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

	public TTTGame() {
		super();
		this.board = new char[9];
		
	}
	
	public TTTGame(String board) {
		char[] b = new char[9];
		for(int i = 0;i<b.length;i++) {
			b[i] = board.charAt(2*i);
			System.out.print(b[i]+" ");
		}
		this.board = b;
	}

	public char[] getBoard() {
		return board;
	}

	public void setBoard(char[] board) {
		this.board = board;
	}

	// initialize
	public void initialize() {
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
	}

	// encoding the current board
	public String encodeBoard() {
		StringBuilder builder = new StringBuilder();
		for (char c : board) {
			builder.append(c).append('.');
		}
		return builder.toString();

	}
	
	// check validity of move
		public boolean checkMove(char[] board, int cell) {
			return board[cell] == '-';
		}

		// check status for a player
		// 0. player has not won yet
		// 1. player won

		public int checkStatus(char[] board, char player) {
			int status = 0;
			//
			for (int[] winner : winners) {
				if (checkWinner(winner, board, player)) {
					status = 1;
					break;
				}
			}
			return status;

		}

		public int checkBoard(char[] board) {
			int status = 1;
			//
			for (char c : board) {
				if (c == '-') {
					status = 0;
					break;
				}
			}
			return status;

		}

		public boolean checkWinner(int[] winner, char[] board, char player) {
			boolean check = true;
			for (int cell : winner) {
				if (board[cell] != player) {
					check = false;
					break;
				}
			}

			return check;

		}

		// make move
		public void makeMove(char[] board) {
				for (int i = 0; i < board.length; i++) {
					if (board[i] == '-') {
						board[i] = 'x';
						break;
					}
				}
		}

		// update board
		public void updateBoard(char[] board, int cell) {
			board[cell] = 'o';
			// return board;

		}

}
