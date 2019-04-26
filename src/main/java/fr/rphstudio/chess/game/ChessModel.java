/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoxxualettony
 */
public class ChessModel implements IChess {


    private static IChess instance = null;
    private static Board board;

    private ChessModel(){
        reinit();
    }

    public static IChess getInstance(){

        if( ChessModel.instance == null ) {
            ChessModel.instance = new ChessModel();
        }

        return ChessModel.instance;

    }


    @Override
    public void reinit() {
        board = new Board();

    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {

        Piece current = this.board.getPiece(p);

        if(p.x<0 || p.x>7 || p.y<0 || p.y>7){
            throw new OutOfBoardException();
        }
        else if(current == null){
           throw new EmptyCellException();
        }
        else{
            return current.getType();
        }




    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece current = this.board.getPiece(p);

        if(p.x<0 || p.x>7 || p.y<0 || p.y>7){
            throw new OutOfBoardException();
        }
        else if(current == null){
            throw new EmptyCellException();
        }
        else{
            return current.getColor();
        }
    }

    @Override
    public int getNbRemainingPieces(ChessColor color) {

        int nb = this.board.getNbPiece(color) ;
        return nb;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        Piece current = this.board.getPiece(p);
        if(current == null)
        {
            return new ArrayList<>();
        }else{
           return current.getMoves(p,this.board);
        }
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        this.board.movePiece(p0, p1);
    }

    @Override
    //returns the King's status (safe or threatened)
    public ChessKingState getKingState(ChessColor color) {
        ChessPosition KingPosition = null;

        //loops to browse the whole board
        for(int i = 0; i<8 && KingPosition == null ; i++){
            for(int j = 0; j<8 && KingPosition == null ; j++){

                ChessPosition pos = new ChessPosition(i, j);
                Piece current = board.getPiece(pos);

                //checks if there is a piece on the case
                if(current !=null){
                    //checks if the piece's type is KING and of the playing color
                    if(current.getType()==ChessType.TYP_KING && current.getColor()==color){
                        //gets the King of the playing color' coordinates
                        KingPosition = new ChessPosition(i, j);
                    }
                }
            }
        }
        //default state of the King is SAFE
        if(KingPosition == null){
            return ChessKingState.KING_SAFE;
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){

                ChessPosition pos = new ChessPosition(i, j);
                Piece current = board.getPiece(pos);

                if(current != null){
                    //checks if the piece is of the opponent's color
                    if(current.getColor() != color){
                        ChessPosition currentPos = new ChessPosition(i,j);
                        //checks all the possible moves of all the opponent's pieces
                        List<ChessPosition> positionList = current.getMoves(currentPos,board);
                        for(ChessPosition threat: positionList){
                            //checks if YOUR King is on any of the opponent's pieces' possible moves
                            if(threat.equals(KingPosition)){
                                return ChessKingState.KING_THREATEN;
                            }
                        }

                    }
                }
            }
        }
        return ChessKingState.KING_SAFE;

    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return 0;
    }
}
