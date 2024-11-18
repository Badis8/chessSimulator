package com.simulation.chess.Domain.pieces;
import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;


public abstract class Piece {
    private boolean color; 
 
    
    public Piece(boolean color){
        this.color=color;
 
    }
  
    public abstract boolean isValid(ChessMove chessmove, Board chessBoard);

}
