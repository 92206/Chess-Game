package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Pawn extends piece {

	public Pawn(int y) {
		unicode = "\u265F";
		x = 1;
		this.y = y;
		name = " black pawn";
	}

	public Pawn(int y, boolean white) {
		is_white = true;
		unicode = "\u2659";
		x = 6;
		this.y = y;
		name = "white pawn";
	}

	@Override
	public Point[] allowed_moves(ArrayList<piece> pieces) {
		List<Point> moves = new ArrayList<>();
		if (is_white) {

			if (is_valid(pieces, x - 1)) {
				moves.add(new Point(x - 1, y));
				if (x == 6)
					moves.add(new Point(x - 2, y));
			}
			//check for extra eat move for white pawn
			for (piece piece : pieces) {
				if (piece.x == x-1 && piece.y == y+1) {
					moves.add(new Point(x - 1, y+1));
				}
				if(piece.x == x-1 && piece.y == y-1) {
					moves.add(new Point(x - 1, y-1));

				}
			}
			 for(Point move:moves)
				 System.out.println(move.x+" "+ move.y);
			return moves.toArray(new Point[0]);
		}

		if (is_valid(pieces, x + 1)) {
			moves.add(new Point(x + 1, y));
			if (x == 1)
				moves.add(new Point(x + 2, y));
		}
		//check for extra eat move for black pawn
		for (piece piece : pieces) {
			if (piece.x == x+1 && piece.y == y+1) {
				moves.add(new Point(x + 1, y+1));
			}
			if(piece.x == x+1 && piece.y == y-1) {
				moves.add(new Point(x + 1, y-1));

			}
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
