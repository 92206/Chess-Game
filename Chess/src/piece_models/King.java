package piece_models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class King extends piece {
	public King() {

		unicode = "\u265A";
		x = 0;
		y = 4;
		name = "king white";

	}

	public King(boolean white) {
		is_white = true;
		unicode = "\u2654";
		x = 7;
		y = 4;
		name = "king black";

	}

	@Override
	public Point[] allowed_moves(ArrayList<piece> pieces) {
		List<Point> moves = new ArrayList<>();
		int[][] kingMoves = { { x + 1, y }, { x + 1, y + 1 }, { x, y + 1 }, { x - 1, y + 1 }, { x - 1, y },
				{ x - 1, y - 1 }, { x, y - 1 }, { x + 1, y - 1 } };

		for (int[] move : kingMoves) {
			int moveX = move[0];
			int moveY = move[1];

			if (isValid(moveX, moveY,pieces)) {
				moves.add(new Point(moveX, moveY));
			}
		}

		return moves.toArray(new Point[0]);
	}
//not out of map
	public boolean isValid(int x, int y,ArrayList<piece> pieces) {
		for(piece piece : pieces) {
			if(piece.x==x&&piece.y==y&&piece.is_white==this.is_white)
				return false;
		}

		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}

}
