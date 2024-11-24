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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  
        if (o == null || getClass() != o.getClass()) return false;
        ChessPosition that = (ChessPosition) o;
        return row == that.row && column == that.column;
    }
}