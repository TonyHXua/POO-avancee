package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.List;

public class Piece {

    private IChess.ChessColor Color;
    private IChess.ChessType Type;
    private IMove move;
    private int nbMove;

    public Piece(IChess.ChessColor color, IChess.ChessType type,IMove mv) {
        Color = color;
        Type = type;
        this.move = mv;
        this.nbMove = 0;
    }

    public IChess.ChessColor getColor() {
        return Color;
    }

    public IChess.ChessType getType() {
        return Type;
    }

    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition pos , Board board){
        return move.getPossibleMoves(pos,board);
    }

    public boolean hasMoved(){

        /*if(this.nbMove != 0){
            return true;
        }else{
            return false;
        }*/

        return this.nbMove != 0;
    }

    public void incNbMove(){
        this.nbMove++;
    }

    public void decNbMove(){
        this.nbMove--;
    }

}
