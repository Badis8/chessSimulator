package com.simulation.chess.Domain;

import com.simulation.chess.Domain.enums.ChessPosition;
import com.simulation.chess.Domain.enums.PieceName;
import com.simulation.chess.Domain.pieces.Piece;
import com.simulation.chess.Domain.pieces.Rook;

import java.util.HashMap;
import java.util.Map;



public class Board {

    
	Map<ChessPosition, Piece> pieces = new HashMap<>(); 


    Board(){
      pieces.put(ChessPosition.A1,new Rook(true,ChessPosition.A1));
      pieces.put(ChessPosition.H1,new Rook(true,ChessPosition.H1));
    }
    public Piece getFromPosition(ChessPosition pos) {
            return pieces.get(pos);
        
    }



}
