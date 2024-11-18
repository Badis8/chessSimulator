package com.simulation.chess.Domain.pieces;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;

public class Pawn extends Piece {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValid(ChessMove chessmove, Board chessBoard) {
        int currentRow = chessmove.getOldRow();
        int currentColumn = chessmove.getOldColumn();
        int targetRow = chessmove.getRow();
        int targetColumn = chessmove.getColumn();
        
      
        int direction = super.color ? -1 : 1;

 
        if (targetColumn == currentColumn && targetRow == currentRow + direction) {
            if (chessBoard.getFromPosition(targetRow, targetColumn) == null) {
                return true;  
            }
        }

 
        if (targetColumn == currentColumn && 
            targetRow == currentRow + 2 * direction &&
            (super.color ? currentRow == 6 : currentRow == 1)) {  
            if (chessBoard.getFromPosition(currentRow + direction, currentColumn) == null &&
                chessBoard.getFromPosition(targetRow, targetColumn) == null) {
                return true;  
            }
        }

 
        if (Math.abs(targetColumn - currentColumn) == 1 && targetRow == currentRow + direction) {
            if (chessBoard.getFromPosition(targetRow, targetColumn) != null) {
                return true;  
            }
        }

        return false;  
    }
}
