package com.simulation.chess.Domain.pieces;
import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessPosition;


public abstract class Piece {
    private boolean color; 
    protected ChessPosition curentPosition;
    
    public Piece(boolean color,ChessPosition setUpPosition){
        this.color=color;
        this.curentPosition=setUpPosition;
    }
    public void move(ChessPosition boardPlace ){this.curentPosition=boardPlace;} 
    abstract boolean IsValid(ChessPosition tp,Board chessBoard);

}
