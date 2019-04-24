package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Piece {

    private IChess.ChessColor Color;
    private IChess.ChessType Type;


    public IChess.ChessColor getColor() {
        return Color;
    }

    public void setColor(IChess.ChessColor color) {
        Color = color;
    }

    public IChess.ChessType getType() {
        return Type;
    }

    public void setType(IChess.ChessType type) {
        Type = type;
    }
}
