package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Bishop extends piece {

	public Bishop(int y) {

		unicode = "\u265D";
		x = 0;
		this.y = y;
		name = "bishop black";
	}

	public Bishop(int y, boolean white) {
		is_white = true;
		unicode = "\u2657";
		x = 7;
		this.y = y;
		name = "bishop white";
	}

	@Override
	public Point[] allowed_moves(ArrayList<piece> pieces) {
		 boolean legal;
		List<Point> moves = new ArrayList<>();

		// Generate possible moves in the top-right diagonal direction
		for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == j) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, j));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, j));
		}

		// Generate possible moves in the top-left diagonal direction
		for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == j) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, j));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, j));
		}

		// Generate possible moves in the bottom-right diagonal direction
		for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == j) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, j));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, j));
		}

		// Generate possible moves in the bottom-left diagonal direction
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == j) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, j));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, j));
		}

		return moves.toArray(new Point[0]);
	}

}
