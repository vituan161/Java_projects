package eiu.cit.netprog;

public class TTTLogicLeft extends OOPAbstractLogic {
	@Override
	public void makeMove(char[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == '-') {
				board[i] = 'x';
				break;
			}
		}
	}
}
