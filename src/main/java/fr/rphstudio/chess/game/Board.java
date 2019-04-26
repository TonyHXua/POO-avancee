package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class  Board {

    private Piece[][] tab;

    public Board() {
        tab = new Piece[IChess.BOARD_WIDTH][IChess.BOARD_HEIGHT];

        for( int i=0 ; i<8 ; i++ ){
            tab[i][IChess.BOARD_POS_Y_BLACK_PAWNS] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_PAWN,new Pawn()) ;
            tab[i][IChess.BOARD_POS_Y_WHITE_PAWNS] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_PAWN,new Pawn());
        }
        tab[IChess.BOARD_POS_X_QUEENSIDE_ROOK][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK,new Rook());
        tab[IChess.BOARD_POS_X_QUEENSIDE_KNIGHT][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_BISHOP][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP,new Bishop());
        tab[IChess.BOARD_POS_X_QUEEN][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_QUEEN,new Queen());
        tab[IChess.BOARD_POS_X_KING][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KING,new King());
        tab[IChess.BOARD_POS_X_KINGSIDE_BISHOP][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_BISHOP,new Bishop());
        tab[IChess.BOARD_POS_X_KINGSIDE_KNIGHT][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_ROOK][IChess.BOARD_POS_Y_WHITE_PIECES] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_ROOK,new Rook());


        tab[IChess.BOARD_POS_X_QUEENSIDE_ROOK][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK,new Rook());
        tab[IChess.BOARD_POS_X_QUEENSIDE_KNIGHT][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_QUEENSIDE_BISHOP][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP,new Bishop());
        tab[IChess.BOARD_POS_X_QUEEN][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_QUEEN,new Queen());
        tab[IChess.BOARD_POS_X_KING][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KING,new King());
        tab[IChess.BOARD_POS_X_KINGSIDE_BISHOP][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_BISHOP,new Bishop());
        tab[IChess.BOARD_POS_X_KINGSIDE_KNIGHT][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_KNIGHT,new Knight());
        tab[IChess.BOARD_POS_X_KINGSIDE_ROOK][IChess.BOARD_POS_Y_BLACK_PIECES] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_ROOK,new Rook());


    }

    public void movePiece(IChess.ChessPosition p0, IChess.ChessPosition p1) {

        this.tab[p0.x][p0.y].incNbMove();

        //ROQUE
        //SI la case n'est pas vide
        if(this.tab[p1.x][p1.y] != null){
            //SI les couleur des deux piece sont identique et que leurs type sont KING et ROOK
            if((tab[p0.x][p0.y].getColor() == tab[p1.x][p1.y].getColor()) && tab[p0.x][p0.y].getType() == IChess.ChessType.TYP_KING && tab[p1.x][p1.y].getType() == IChess.ChessType.TYP_ROOK){
                //SI la tour est a GAUCHE
                if(p0.x > p1.x){
                    //Déplace le roi
                    this.tab[p0.x-2][p0.y] = this.tab[p0.x][p0.y];
                    this.tab[p0.x][p0.y] = null;
                    //Déplace la tour
                    this.tab[p1.x+3][p1.y] = this.tab[p1.x][p1.y];
                    this.tab[p1.x][p1.y] = null;
                }

                //SI la tour est a DROITE
                if(p0.x < p1.x){
                    //Déplace le roi
                    this.tab[p0.x+2][p0.y] = this.tab[p0.x][p0.y];
                    this.tab[p0.x][p0.y] = null;
                    //Déplace la tour
                    this.tab[p1.x-2][p1.y] = this.tab[p1.x][p1.y];
                    this.tab[p1.x][p1.y] = null;
                }
            }
        }
        //SI le pion BLANC atteint la premiere ligne
        if(this.tab[p0.x][p0.y].getType() == IChess.ChessType.TYP_PAWN && this.tab[p0.x][p0.y].getColor() == IChess.ChessColor.CLR_WHITE && p1.y == 0){
            this.tab[p0.x][p0.y] = null;
            this.tab[p0.x][p0.y] = new Piece(IChess.ChessColor.CLR_WHITE, IChess.ChessType.TYP_QUEEN,new Queen());
        }

        //SI le pion NOIR atteint la derniere ligne
        if(this.tab[p0.x][p0.y].getType() == IChess.ChessType.TYP_PAWN && this.tab[p0.x][p0.y].getColor() == IChess.ChessColor.CLR_BLACK && p1.y == 7){
            this.tab[p0.x][p0.y] = null;
            this.tab[p0.x][p0.y] = new Piece(IChess.ChessColor.CLR_BLACK, IChess.ChessType.TYP_QUEEN,new Queen());
        }

        this.tab[p1.x][p1.y] = this.tab[p0.x][p0.y];
        this.tab[p0.x][p0.y] = null;

    }

    public Piece getPiece(IChess.ChessPosition pos){

        if(pos.x <8 && pos.x >=0 && pos.y <8 && pos.y >=0 ){
            return tab[pos.x][pos.y];
        }
        return null;

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
