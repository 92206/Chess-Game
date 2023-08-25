package master;

import javax.swing.*;

import piece_models.Bishop;
import piece_models.Horse;
import piece_models.King;
import piece_models.Pawn;
import piece_models.Queen;
import piece_models.Rook;
import piece_models.piece;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class board {
	private JFrame frame;
	public JPanel[][] spot = new JPanel[8][8];
	ArrayList<piece> pieces = new ArrayList<piece>();
	

	ArrayList<JPanel> highlights = new ArrayList<JPanel>();
	public static piece clicked_piece;
	Point[] legalMoves = null;
	public boolean white_turn=true;

	public board() {
		setup_board_view();
		set_initial_pieces();
	}

	/**
	 * 
	 */
	public void setup_board_view() {
		frame = new JFrame("Chess Board");
		frame.setLayout(new GridLayout(8, 8));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				spot[row][col] = panel;

				if ((row + col) % 2 == 0) {
					panel.setBackground(new Color(240, 217, 181)); // Gentle white color

				} else {
					panel.setBackground(new Color(181, 136, 99)); // Gentle black color
				}
				final int finalRow = row;
				final int finalCol = col;
				panel.addMouseListener(new MouseAdapter() {
					@Override

					public void mouseClicked(MouseEvent e) {
						// Perform actions when the panel is clicked
						System.out.println("Grid cell clicked:  (x " + finalRow + ", y " + finalCol + ")");
						Player.cord.y = finalCol;
						Player.cord.x = finalRow;
						//checks whether a piece is clicked with the right turn ie black or white piece
						if (getPieceOnClickedSpot() != null&&getPieceOnClickedSpot().is_white&&white_turn||getPieceOnClickedSpot() != null&&!getPieceOnClickedSpot().is_white&&!white_turn) {
							clicked_piece=getPieceOnClickedSpot();
							System.out.println(clicked_piece.name);

							legalMoves = (clicked_piece.allowed_moves(pieces));
							displayAllowedMoves(legalMoves);

						} 
							if (legalMoves == null)
								return;
							//check whether the move is an eat move , if so remove the eaten piece 
							for (Point legalMove : legalMoves) {
								if (Player.cord.x == legalMove.x && Player.cord.y == legalMove.y) {
									for(piece piece:pieces) {
										if(piece.x==legalMove.x&&piece.y==legalMove.y&&piece!=clicked_piece) {
											pieces.remove(piece);
											break;
										}
									}
									clicked_piece.update_pos(legalMove.x, legalMove.y, board.this);
								}
							}		
					
				
						
					}
					}

						);

				frame.add(panel);

			}
			frame.setVisible(true);
		}
	}

	public void set_initial_pieces() {
		Rook rook = new Rook(0);pieces.add(rook);
		Rook rook2 = new Rook(7);pieces.add(rook2);
		Rook rook3 = new Rook(0, true);pieces.add(rook3);
		Rook rook4 = new Rook(7, true);pieces.add(rook4);
		Bishop bishop1 = new Bishop(1);pieces.add(bishop1);
		Bishop bishop2 = new Bishop(6);pieces.add(bishop2);
		Bishop bishop3 = new Bishop(1, true);pieces.add(bishop3);
		Bishop bishop4 = new Bishop(6, true);pieces.add(bishop4);
		Queen queen1 = new Queen();pieces.add(queen1);
		Queen queen2 = new Queen(true);pieces.add(queen2);
		King king1 = new King();	pieces.add(king1);
		King king2 = new King(true);	pieces.add(king2);
		Horse horse1 = new Horse(2);pieces.add(horse1);
		Horse horse2 = new Horse(5);pieces.add(horse2);
		Horse horse3 = new Horse(2, true);pieces.add(horse3);
		Horse horse4 = new Horse(5, true);pieces.add(horse4);
		
		for (int i = 0; i < 16; i++) {
			if (i < 8) {
				Pawn pawn = new Pawn(i);
				pieces.add(pawn);
			} else {
				Pawn pawn = new Pawn(15 - i, true);
				pieces.add(pawn);

			}
		}

		for (piece piece : pieces) {
			JLabel chessPiece = new JLabel(piece.unicode);
			chessPiece.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 70));
			spot[piece.x][piece.y].add(chessPiece);

		}

	}

	public piece getPieceOnClickedSpot() {
		for (piece piece : pieces) {
			if (Player.cord.x == piece.x && Player.cord.y == piece.y) {
				return piece;
			}
		}
		return null;

	}

	public void displayAllowedMoves(Point[] moves) {

		// flush all prior highlights

		clearHighlights();

		for (Point move : moves) {

			JPanel highlight = new JPanel();
			highlight.setBackground(new Color(252, 119, 3));
			highlight.setPreferredSize(new Dimension(70,70));
			

	        spot[move.x][move.y].add(highlight);
	        spot[move.x][move.y].setBorder(BorderFactory.createLineBorder(Color.red));
			spot[move.x][move.y].revalidate();
			spot[move.x][move.y].repaint();
			highlights.add(highlight);
		}
	}

	public void clearHighlights() {
		if (!highlights.isEmpty()) {
			for (JPanel highlight : highlights) {
				Container parent = highlight.getParent();
				parent.remove(highlight);
				((JPanel) parent).setBorder(BorderFactory.createLineBorder(Color.black));
				parent.revalidate();
				parent.repaint();

			}
		}
		highlights.clear();
	}
	
	

}
