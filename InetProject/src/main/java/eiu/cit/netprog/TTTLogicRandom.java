package eiu.cit.netprog;

import java.util.Random;

public class TTTLogicRandom extends OOPAbstractLogic {
	@Override
	public void makeMove(char[] board) {
		Random random = new Random();
		boolean check = false;
		while(!check) {
			int number = random.nextInt(9);
			if(board[number] == '-') {
				board[number] = 'x';
				check = true;
			}
		}
	}
}
