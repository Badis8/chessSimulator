package com.simulation.chess.Domain.pieces;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessPosition;

public class Rook extends Piece {
 
 
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    @Override
         
    public boolean IsValid(ChessPosition curentPosition, ChessPosition toGo , Board chessBoard) {
            int i= curentPosition.ordinal()+8;
        
           if(toGo.ordinal() % 8 ==  curentPosition.ordinal() % 8){
                while(i<toGo.ordinal()){
                        if(chessBoard.getFromPosition(ChessPosition.values()[i])!=null){
                            return false;
                        }
                    i=i+8;
                }
            return true; 
           }
    
           if(toGo.ordinal() / 8 ==  curentPosition.ordinal() / 8){
            while(i<toGo.ordinal()){
                    if(chessBoard.getFromPosition(ChessPosition.values()[i])!=null){
                        return false;
                    }
                i=i+1;
            }
        return true; 
       }
        return false;
      
        }

      

}   