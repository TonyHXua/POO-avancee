package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import java.util.ArrayList;
import java.util.List;

public class King implements IMove {

    public List<IChess.ChessPosition> getPossibleMoves(IChess.ChessPosition pos, Board board){

        List<IChess.ChessPosition> moves;
        moves = new ArrayList<>();

        int[][] moveVector = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}} ;

        for(int i = 0 ; i < moveVector.length ; i++){
            IChess.ChessPosition pos2 = new IChess.ChessPosition(pos.x + moveVector[i][0], pos.y + moveVector[i][1]);

            if(pos2.isValid()){
                Piece pieceTest = board.getPiece(pos2);
                if(pieceTest != null){
                    if(pieceTest.getColor() != board.getPiece(pos).getColor()){
                        moves.add(new IChess.ChessPosition(pos2.x,pos2.y));
                    }
                }
                else {
                    moves.add(new IChess.ChessPosition(pos2.x,pos2.y));
                }
            }
        }
        //Si le roi et la tour n'ont pas bougé   KINGSIDE
        if(!board.getPiece(pos).hasMoved() && !board.getPiece(new IChess.ChessPosition(pos.x + 3,pos.y)).hasMoved()){
            //Si l'espace entre le roi et la tour est vide
            if( (board.getPiece(new IChess.ChessPosition(pos.x + 1,pos.y)) == null) && (board.getPiece(new IChess.ChessPosition(pos.x + 2,pos.y)) == null) ){
                moves.add(new IChess.ChessPosition(pos.x + 3,pos.y));
            }
        }

        //Si le roi et la tour n'ont pas bougé   QUEENSIDE
        if(!board.getPiece(pos).hasMoved() && !board.getPiece(new IChess.ChessPosition(pos.x - 4,pos.y)).hasMoved()){
            //Si l'espace entre le roi et la tour est vide
            if( (board.getPiece(new IChess.ChessPosition(pos.x - 1,pos.y)) == null) && (board.getPiece(new IChess.ChessPosition(pos.x - 2,pos.y)) == null) && (board.getPiece(new IChess.ChessPosition(pos.x - 3,pos.y)) == null)){
                moves.add(new IChess.ChessPosition(pos.x - 4 ,pos.y));
            }
        }
        return moves;
    }
}