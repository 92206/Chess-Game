package piece_models;

import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLabel;

import master.board;

public abstract class piece {
	public int x, y;
	public String unicode;
	public boolean is_white = false;

	public String name;

	public Point[] allowed_moves(ArrayList<piece> pieces) {
		// TODO Auto-generated method stub
		return null;
	}

	public Point update_pos(int x, int y, board board) {

		board.spot[this.x][this.y].remove((JLabel) board.spot[this.x][this.y].getComponent(0));
		board.spot[this.x][this.y].revalidate();
		board.spot[this.x][this.y].repaint();
		board.clearHighlights();
		this.x = x;
		this.y = y;
		if(board.spot[this.x][this.y].getComponents().length!=0) {
		board.spot[this.x][this.y].remove( board.spot[this.x][this.y].getComponent(0));
		board.spot[this.x][this.y].revalidate();
		board.spot[this.x][this.y].repaint();}
		JLabel chessPiece = new JLabel(this.unicode);
		chessPiece.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 70));
		board.spot[this.x][this.y].add(chessPiece);
		if(is_white)
			board.white_turn=false;
		else
			board.white_turn=true;


		return new Point(this.x, this.y);
		}

}
