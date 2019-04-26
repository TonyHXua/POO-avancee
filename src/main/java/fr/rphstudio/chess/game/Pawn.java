package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.game.Piece;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

    //Méthode qui permet de récupérer une liste de position possible
    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board board) {
        List<IChess.ChessPosition> moves;
        moves = new ArrayList<>();

      //Si pion = noir
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_BLACK) {

            //Declaration des position à tester
           IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y+1 );
           IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x-1, pos.y +1);
           IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x+1, pos.y +1);
           IChess.ChessPosition pos5 = new IChess.ChessPosition(pos.x, pos.y +2);

            //Si la case devant le pion est vide
            if(board.getPiece(pos2) == null) {
                moves.add(pos2);

            }
            //Si la diagonale n'est pas vide
            if(board.getPiece(pos3) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos3).getColor()){
                    moves.add(pos3);
                }

            }
            //Si la diagonale n'est pas vide
            if(board.getPiece(pos4) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos4).getColor()){
                    moves.add(pos4);
                }

            }
            //Si le pion n'a pas bouger il peux se déplacer de deux cases
            if(!board.getPiece(pos).hasMoved()){
                moves.add(pos5);
            }
        }

        //si pion = blanc
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE) {

            //Declaration des position à tester
            IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y -1);
            IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x+1, pos.y -1);
            IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x-1, pos.y -1);
            IChess.ChessPosition pos5 = new IChess.ChessPosition(pos.x, pos.y -2);


            //Si la case devant le pion est vide
            if(board.getPiece(pos2) == null) {
                moves.add(pos2);

            }
            //Si la diagonale n'est pas vide
            if(board.getPiece(pos3) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos3).getColor()){
                    moves.add(pos3);
                }

            }
            //Si la diagonale n'est pas vide
            if(board.getPiece(pos4) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos4).getColor()){
                    moves.add(pos4);
                }

            }
            //Si le pion n'a pas bouger il peux se déplacer de deux cases
            if(!board.getPiece(pos).hasMoved()){
                moves.add(pos5);
            }
        }


        return moves;

    }



}


