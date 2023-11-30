package eiu.cit.netprog;

public class TTTLogicRight extends OOPAbstractLogic {
	@Override
	public void makeMove(char[] board) {
		for (int i = board.length-1; i >=0; i--) {
			if (board[i] == '-') {
				board[i] = 'x';
				break;
			}
		}
	}
}
