package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.List;

public class Piece {

    private IChess.ChessColor Color;
    private IChess.ChessType Type;
    private IMove move;

    public Piece(IChess.ChessColor color, IChess.ChessType type,IMove mv) {
        Color = color;
        Type = type;
        this.move = mv;
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

}
