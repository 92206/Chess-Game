package master;

import java.awt.Point;

import javax.swing.SwingUtilities;

import piece_models.Rook;
import piece_models.piece;

public class Player {
	public static Point cord = new Point();
	public board board;
	public static piece clicked_piece;

	public Player() {
		board = new board();
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				Player p = new Player();
			}

		});
	}

}
