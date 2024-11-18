package com.simulation.chess.Domain.pieces;

import java.util.ArrayList;
import java.util.List;

 
import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;
 

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

        @Override
    public ChessPosition[] Threads(Board chessBoard, int currentRow, int currentColumn) {
        List<ChessPosition> threatenedPositions = new ArrayList<>();
 
        int[][] directions = {
            {1, 0},  
            {-1, 0},  
            {0, 1},   
            {0, -1}   
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