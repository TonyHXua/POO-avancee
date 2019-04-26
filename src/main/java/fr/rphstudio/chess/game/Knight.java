package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess.ChessPosition;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Knight implements IMove {

    public List<ChessPosition> getPossibleMoves(ChessPosition pos, Board board){
        List<ChessPosition> moves;
        moves = new ArrayList<>();

        int[][] moveVector = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}} ;

        for(int i = 0 ; i < moveVector.length ; i++){
            ChessPosition pos2 = new ChessPosition(pos.x + moveVector[i][0], pos.y + moveVector[i][1]);

            if(pos2.isValid()){
                Piece pieceTest = board.getPiece(pos2);
                if(pieceTest != null){
                    if(pieceTest.getColor() != board.getPiece(pos).getColor()){
                        moves.add(new ChessPosition(pos2.x,pos2.y));
                    }
                }
                else {
                    moves.add(new ChessPosition(pos2.x,pos2.y));
                }
            }
        }

        return moves;
    }
}
