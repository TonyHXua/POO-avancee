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
    public ChessKingState getKingState(ChessColor color) {
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
