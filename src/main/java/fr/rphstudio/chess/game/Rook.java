package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Rook implements IMove {

    //Méthode qui permet de récupérer une liste de position possible
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board board){
        List<IChess.ChessPosition> moves;
        moves = new ArrayList<>();
        IChess.ChessPosition pos2;

        //Boucle sur les case de la ligne
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x + i, pos.y);
            if (pos2.isValid()) {
                //SI case vide
                if (board.getPiece(pos2) == null) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                }
                //SI piece est d'une autre couleur et peut donc être manger
                else if (board.getPiece(pos2).getColor() != board.getPiece(pos).getColor()) {
                    moves.add(new IChess.ChessPosition(pos2.x, pos2.y));
                    break;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            pos2 = new IChess.ChessPosition(pos.x - i, pos.y);
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
            pos2 = new IChess.ChessPosition(pos.x, pos.y + i);
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
            pos2 = new IChess.ChessPosition(pos.x, pos.y - i);
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