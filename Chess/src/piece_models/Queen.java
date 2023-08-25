package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Queen extends piece {

	public Queen() {

		unicode = "\u265B";
		x = 0;
		y = 3;
		name = "queen black";
	}

	public Queen(boolean white) {
		is_white = true;
		unicode = "\u2655";
		x = 7;
		y = 3;
		name = "queen white";

	}

	@Override
	public Point[] allowed_moves(ArrayList<piece> pieces) {
		List<Point> moves = new ArrayList<>();
		boolean legal;
		// Generate possible moves in the horizontal and vertical directions (same as a
		// rook)
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
		// Generate possible vertical moves
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
		//diagonal movess like bishop
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
