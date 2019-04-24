package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Piece {

    private IChess.ChessColor Color;
    private IChess.ChessType Type;

    public Piece(IChess.ChessColor color, IChess.ChessType type) {
        Color = color;
        Type = type;
    }

    public IChess.ChessColor getColor() {
        return Color;
    }

    public IChess.ChessType getType() {
        return Type;
    }

}
