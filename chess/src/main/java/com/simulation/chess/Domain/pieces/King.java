package com.simulation.chess.Domain.pieces;

import java.util.ArrayList;
import java.util.List;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.ChessPosition;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.PieceName;

public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValid(ChessMove chessMove, Board chessBoard) {
        int currentRow = chessMove.getOldRow();
        int currentColumn = chessMove.getOldColumn();
        int targetRow = chessMove.getRow();
        int targetColumn = chessMove.getColumn();

 
        int rowDifference = Math.abs(targetRow - currentRow);
        int columnDifference = Math.abs(targetColumn - currentColumn);

 
        if (rowDifference > 1 || columnDifference > 1) {
            return false;
        }

    
        Piece targetPiece = chessBoard.getFromPosition(targetRow, targetColumn);
        if (targetPiece != null && targetPiece.getColor() == this.getColor()) {
            return false;
        }

        return true;
    }

    @Override
    public List<ChessPosition> Threads(Board chessBoard, int currentRow, int currentColumn) {
        List<ChessPosition> threatenedPositions = new ArrayList<>();

  
        int[][] directions = {
            {1, 0},     
            {-1, 0},    
            {0, 1},     
            {0, -1},    
            {1, 1},     
            {-1, -1},   
            {1, -1},    
            {-1, 1}     
        };

        for (int[] direction : directions) {
            int row = currentRow + direction[0];
            int col = currentColumn + direction[1];

 
            if (chessBoard.isWithinBounds(row, col)) {
                threatenedPositions.add(new ChessPosition(row, col));
            }
        }

        return threatenedPositions;
    } 
    @Override
    public PieceName getSymbol() {
        return this.color ? PieceName.K : PieceName.k;
    }
}