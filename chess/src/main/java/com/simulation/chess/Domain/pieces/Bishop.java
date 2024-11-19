package com.simulation.chess.Domain.pieces;

import java.util.ArrayList;
import java.util.List;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;

public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValid(ChessMove chessmove, Board chessBoard) {
        int currentRow = chessmove.getOldRow();
        int currentColumn = chessmove.getOldColumn();
        int targetRow = chessmove.getRow();
        int targetColumn = chessmove.getColumn();

      
        int rowDifference = Math.abs(targetRow - currentRow);
        int columnDifference = Math.abs(targetColumn - currentColumn);

        if (rowDifference != columnDifference) {
            return false;  
        }

 
        int rowStep = (targetRow > currentRow) ? 1 : -1;
        int colStep = (targetColumn > currentColumn) ? 1 : -1;

   
        int row = currentRow + rowStep;
        int col = currentColumn + colStep;
        while (row != targetRow && col != targetColumn) {
            if (chessBoard.getFromPosition(row, col) != null) {
                return false;  
            }
            row += rowStep;
            col += colStep;
        }

        return true;  
    }

    @Override
    public ChessPosition[] Threads(Board chessBoard, int currentRow, int currentColumn) {
        List<ChessPosition> threatenedPositions = new ArrayList<>();
 
        int[][] directions = {
            {1, 1},  
            {-1, -1}
           
        };

        for (int[] direction : directions) {
            int row = currentRow;
            int col = currentColumn;

            while (true) {
                row += direction[0];
                col += direction[1];
 
                if (!chessBoard.isWithinBounds(row, col)) {
                    break;  
                }
 
                threatenedPositions.add(new ChessPosition(row, col));

               
                if (chessBoard.getFromPosition(row, col) != null) {
                    break;
                }
            
        }

    }
    return threatenedPositions.toArray(new ChessPosition[0]);
}
}