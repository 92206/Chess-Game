package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Horse extends piece {
	static boolean white = true;

	public Horse(int y) {

		unicode = "\u265E";
		x = 0;
		this.y = y;
		name = "horse black ";

	}

	public Horse(int y, boolean white) {
		is_white = true;
		unicode = "\u2658";
		x = 7;
		this.y = y;
		name = "horse white ";

	}

	@Override
	public Point[] allowed_moves(ArrayList<piece> pieces) {
		List<Point> moves = new ArrayList<>();

		int[][] knightMoves = { { x + 2, y + 1 }, { x + 2, y - 1 }, { x - 2, y + 1 }, { x - 2, y - 1 },
				{ x + 1, y + 2 }, { x + 1, y - 2 }, { x - 1, y + 2 }, { x - 1, y - 2 } };

		for (int[] move : knightMoves) {
			int moveX = move[0];
			int moveY = move[1];

			if (isValid(moveX, moveY,pieces)) {
				moves.add(new Point(moveX, moveY));
			}
		}

		return moves.toArray(new Point[0]);
	}

	public boolean isValid(int x, int y,ArrayList<piece> pieces) {
		for(piece piece : pieces) {
			if(piece.x==x&&piece.y==y&&piece.is_white==this.is_white)
				return false;
		}

		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
}
