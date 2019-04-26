package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Board {

    private Piece[][] tab;

    public Board() {
        tab = new Piece[IChess.BOARD_WIDTH][IChess.BOARD_HEIGHT];

        for( int i=0 ; i<8 ; i++ ){
            tab[i][IChess.BOARD_POS_Y_BLACK_PAWNS] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_PAWN,new Knight()) ;
            tab[i][IChess.BOARD_POS_Y_WHITE_PAWNS] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_PAWN,new Knight());
        }
        tab[IChess.BOARD_POS_X_QUEENSIDE_ROOK][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_KNIGHT][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_BISHOP][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP,new Knight());
        tab[IChess.BOARD_POS_X_QUEEN][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_QUEEN,new Knight());
        tab[IChess.BOARD_POS_X_KING][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KING,new King());
        tab[IChess.BOARD_POS_X_KINGSIDE_BISHOP][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_KNIGHT][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_ROOK][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK,new Knight());


        tab[IChess.BOARD_POS_X_QUEENSIDE_ROOK][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_KNIGHT][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_BISHOP][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP,new Knight());
        tab[IChess.BOARD_POS_X_QUEEN][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_QUEEN,new Knight());
        tab[IChess.BOARD_POS_X_KING][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KING,new King());
        tab[IChess.BOARD_POS_X_KINGSIDE_BISHOP][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_KNIGHT][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_ROOK][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK,new Knight());


    }

    public void movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1) {

        this.tab[p1.x][p1.y] = this.tab[p0.x][p0.y];
        this.tab[p0.x][p0.y] = null;
    }

    public Piece getPiece(IChess.ChessPosition pos){
//Sets limits so that clicks outside the board aren't counted as piece getters, now the game won't crash trying to get
// impossible coordinates
        if ( (pos.x < 8) && (pos.x >= 0) && (pos.y < 8) && (pos.y >= 0) ) {
            return tab[pos.x][pos.y];
        }

        return null ;
    }

    public int getNbPiece(IChess.ChessColor color){
        int nbPiece = 0;

        for(int i=0; i<8 ; i++){
            for(int j=0; j<8 ; j++){

                if(tab[i][j] != null){
                    if(tab[i][j].getColor() == color ){
                        nbPiece++;
                    }
                }

            }
        }

        return nbPiece;
    }

}
