package eiu.cit.netprog;

import eiu.cit.netprog.TicTacToeWinningCombinations;

public abstract class OOPAbstractLogic {
	private char[] board;
	private final static int[][] winners = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 },
			{ 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

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
	public abstract void makeMove(char[] board);

	// update board
	public void updateBoard(char[] board, int cell) {
		board[cell] = 'o';
		// return board;

	}

}
