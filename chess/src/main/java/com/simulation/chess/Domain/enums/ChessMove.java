package com.simulation.chess.Domain.enums;

public class ChessMove {

 
    private ChessPosition from; 
    private ChessPosition to; 
    
 
    public ChessMove(ChessPosition from, ChessPosition to) {
        this.from = from;
        this.to = to;
    }

 
    public ChessPosition getFrom() {
        return from;
    }

 
    public ChessPosition getTo() {
        return to;
    }
}
