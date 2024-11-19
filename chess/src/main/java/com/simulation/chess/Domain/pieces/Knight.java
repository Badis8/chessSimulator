package com.simulation.chess.Domain.pieces;

import java.util.ArrayList;
import java.util.List;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;

public class Knight extends Piece {

    public Knight(boolean isWhite) {
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

 
        if ((rowDifference == 2 && columnDifference == 1) || 
            (rowDifference == 1 && columnDifference == 2)) {
            return true;  
        }

        return false;  
    }

      @Override
    public ChessPosition[] Threads(Board chessBoard, int currentRow, int currentColumn) {
        int[][] directions = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
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

        return threats.toArray(new ChessPosition[0]);
    }
}
