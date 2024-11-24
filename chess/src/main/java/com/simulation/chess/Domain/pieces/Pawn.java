package com.simulation.chess.Domain.pieces;

import java.util.ArrayList;
import java.util.List;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.PieceName;

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
        
    
        int direction = super.color ? 1 : -1;

 
        if (targetColumn == currentColumn && targetRow == currentRow + direction) {
 
            if (chessBoard.getFromPosition(targetRow, targetColumn) == null) {
                return true;  
            }
        }

            
        if (targetColumn == currentColumn && 
            targetRow == currentRow + 2 * direction &&
            (super.color ? currentRow == 1 : currentRow == 6)) {  
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

   @Override
    public List<ChessPosition> Threads(Board chessBoard, int currentRow, int currentColumn) {
        int[][] directions = {
            {1, 1}, {1, -1}
      
        };

        List<ChessPosition> threats = new ArrayList<>();

        for (int[] direction : directions) {
            int newRow = currentRow + direction[0];
            int newColumn = currentColumn + direction[1];

           
            if (newRow >= 0 && newRow < 8 &&
                newColumn >= 0 && newColumn < 8) {
                threats.add(new ChessPosition(newRow, newColumn));
            }
        }

        return threats;
    } 
    @Override
    public PieceName getSymbol() {
        return this.color ? PieceName.P : PieceName.p;
    }
}
