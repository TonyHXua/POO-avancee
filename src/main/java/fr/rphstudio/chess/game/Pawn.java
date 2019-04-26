package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.game.Piece;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board board) {
        List<IChess.ChessPosition> moves;
        moves = new ArrayList<>();

      //si pion = noir
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_BLACK) {

           IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y+1 );
           IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x-1, pos.y +1);
           IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x+1, pos.y +1);
           IChess.ChessPosition pos5 = new IChess.ChessPosition(pos.x, pos.y +2);

           //si pas de piece

            if(board.getPiece(pos2) == null) {
                moves.add(pos2);

            }
            if(board.getPiece(pos3) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos3).getColor()){
                    moves.add(pos3);
                }

            }
            if(board.getPiece(pos4) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos4).getColor()){
                    moves.add(pos4);
                }

            }
            if(!board.getPiece(pos).hasMoved()){
                moves.add(pos5);
            }
        }

        //si pion = blanc
        if (board.getPiece(pos).getColor() == IChess.ChessColor.CLR_WHITE) {

            IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x, pos.y -1);
            IChess.ChessPosition pos3 = new IChess.ChessPosition(pos.x+1, pos.y -1);
            IChess.ChessPosition pos4 = new IChess.ChessPosition(pos.x-1, pos.y -1);
            IChess.ChessPosition pos5 = new IChess.ChessPosition(pos.x, pos.y -2);


            //si pas de piece

            if(board.getPiece(pos2) == null) {
                moves.add(pos2);

            }
            if(board.getPiece(pos3) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos3).getColor()){
                    moves.add(pos3);
                }

            }
            if(board.getPiece(pos4) != null){
                if(board.getPiece(pos).getColor() != board.getPiece(pos4).getColor()){
                    moves.add(pos4);
                }

            }
            if(!board.getPiece(pos).hasMoved()){
                moves.add(pos5);
            }
        }


        return moves;

    }



}


