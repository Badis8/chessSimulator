package com.simulation.chess.Domain.pieces;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;

public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValid(ChessMove chessmove, Board chessBoard) {
        int currentRow = chessmove.getOldRow();
        int currentColumn = chessmove.getOldColumn();
        int targetRow = chessmove.getRow();
        int targetColumn = chessmove.getColumn();

        if (currentColumn == targetColumn) {
            int step = (targetRow > currentRow) ? 1 : -1;  
            for (int row = currentRow + step; row != targetRow; row += step) { 
                if (chessBoard.getFromPosition(row,currentColumn)==null ){ 
                 
                    return false;
                }
            }
            return true;
        }

       
        if (currentRow == targetRow) {
            int step = (targetColumn > currentColumn) ? 1 : -1;  
            for (int col = currentColumn + step; col != targetColumn; col += step) {
                if (chessBoard.getFromPosition(currentRow,col)!= null) {         
                    return false;
                }
            } 
            
            return true;
        }
        return false;  
    }
}