package eiu.cit.netprog;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeWinningCombinations {
	private int boardSize; // Change this to the desired size of the Tic-Tac-Toe board
	private int[][] winningCombinations;


	public TicTacToeWinningCombinations(int boardSize) {
		super();
		this.boardSize = boardSize;
		this.winningCombinations = generateWinningCombinations(boardSize);
		for (int[] combination : winningCombinations) {
            System.out.println(java.util.Arrays.toString(combination));
        }
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int[][] getWinningCombinations() {
		return winningCombinations;
	}

	public void setWinningCombinations(int[][] winningCombinations) {
		this.winningCombinations = winningCombinations;
	}

	public static int[][] generateWinningCombinations(int boardSize) {
		List<int[]> combinations = new ArrayList<>();

		// Check rows
		for (int i = 0; i < boardSize; i++) {
			int[] row = new int[boardSize];
			for (int j = 0; j < boardSize; j++) {
				row[j] = i * boardSize + j;
			}
			combinations.add(row);
		}

		// Check columns
		for (int j = 0; j < boardSize; j++) {
			int[] column = new int[boardSize];
			for (int i = 0; i < boardSize; i++) {
				column[i] = i * boardSize + j;
			}
			combinations.add(column);
		}

		// Check diagonals
		int[] mainDiagonal = new int[boardSize];
		int[] antiDiagonal = new int[boardSize];
		for (int i = 0; i < boardSize; i++) {
			mainDiagonal[i] = i * (boardSize + 1);
			antiDiagonal[i] = (i + 1) * (boardSize - 1);
		}
		combinations.add(mainDiagonal);
		combinations.add(antiDiagonal);

		return combinations.toArray(new int[0][]);
	}
}
