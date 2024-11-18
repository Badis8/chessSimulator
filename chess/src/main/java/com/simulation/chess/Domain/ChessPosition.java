package com.simulation.chess.Domain;

public class ChessPosition {
    int row;
    int column;
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public ChessPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }
}