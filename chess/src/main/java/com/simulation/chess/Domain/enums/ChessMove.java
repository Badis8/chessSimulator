package com.simulation.chess.Domain.enums;

public class ChessMove {
 
    private int oldRow;
    private int oldColumn;
 
    private int row; 
    private int column;
    public int getOldRow() {
        return oldRow;
    }
    public ChessMove(int oldRow, int oldColumn, int row, int column) {
        this.oldRow = oldRow;
        this.oldColumn = oldColumn;
  
        this.row = row;
        this.column = column;
    }
    public void setOldRow(int oldRow) {
        this.oldRow = oldRow;
    }
    public int getOldColumn() {
        return oldColumn;
    }
    public void setOldColumn(int oldColumn) {
        this.oldColumn = oldColumn;
    }
    
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }


 
    
}
