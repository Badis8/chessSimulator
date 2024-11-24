package com.simulation.chess.Domain.pieces;
import java.util.List;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.PieceName;
 

public abstract class Piece {
    protected boolean color; 
 
    
    public Piece(boolean color){
        this.color=color;
 
    }
  
    public abstract boolean isValid(ChessMove chessmove, Board chessBoard);
    public abstract List<ChessPosition>  Threads(Board chessBoard, int currentRow, int currentColumn); 
    public abstract PieceName getSymbol(); 
    public boolean getColor(){return this.color;} 
}
