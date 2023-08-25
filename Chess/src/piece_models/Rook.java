package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Rook extends piece {

	public Rook(int y) {
		unicode = "\u265C";
		name = "black rook";
		x = 0;
		this.y = y;

	}

	public Rook(int y, boolean white) {
		is_white = true;
		x = 7;
		unicode = "\u2656";
		name = "white rook";
		this.y = y;

	}

	public Point[] allowed_moves(ArrayList<piece> pieces) {
		boolean legal;
		List<Point> moves = new ArrayList<>();

		// Generate possible vertical moves
		for (int i = x + 1; i < 8; i++) {

			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == y) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, y));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, y));
		}
		// Generate possible opposite side vertical moves
		for (int i = x - 1; i >= 0; i--) {


			legal = true;
			for (piece piece : pieces) {
				if (piece.x == i && piece.y == y) {
					if(piece.is_white != is_white)
						moves.add(new Point(i, y));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(i, y));
		}

		// Generate possible horizental moves
		for (int i = y + 1; i < 8; i++) {

			legal = true;
			for (piece piece : pieces) {
				if (piece.x == x && piece.y == i) {
					if(piece.is_white != is_white)
						moves.add(new Point(x, i));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(x, i));
		}
		// Generate possible opposite horizental moves
		for (int i = y - 1; i >= 0; i--) {
			legal = true;

			for (piece piece : pieces) {
				if (piece.x == x && piece.y == i) {
					if(piece.is_white != is_white)
						moves.add(new Point(x, i));
					legal = false;
					break;
				}
			}
			if (!legal)
				break;
			moves.add(new Point(x, i));

		}

		return moves.toArray(new Point[0]);

	}

	public boolean is_valid(ArrayList<piece> pieces, int a) {
		boolean legal = true;
		for (piece piece : pieces) {
			if (piece.x == a && piece.y == y) {
				legal = false;
				break;
			}
		}
		return legal;
	}

}
