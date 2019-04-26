package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Queen implements IMove {

    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board board) {
        List<IChess.ChessPosition> moves;
        moves = new ArrayList<>();
        IChess.ChessPosition pos2;
        
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x + i, pos.y + i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x - i, pos.y + i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x - i, pos.y - i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x + i, pos.y - i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }


        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x , pos.y - i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }


        }

        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x , pos.y + i);
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }


        }

        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x -i , pos.y );
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }


        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x + i, pos.y );
            if (pos2.isValid()) {
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                } else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }


        }

        return moves;
    }
}





