package com.simulation.chess.Domain;

import com.simulation.chess.Domain.enums.ChessPosition;
import com.simulation.chess.Domain.enums.PieceName;
import com.simulation.chess.Domain.pieces.Piece;
import com.simulation.chess.Domain.pieces.Rook;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class Board {

    
	Map<ChessPosition, Piece> pieces = new HashMap<>(); 


    Board(){
      pieces.put(ChessPosition.A1,new Rook(true ));
      pieces.put(ChessPosition.B1,new Rook(false ));
    }
    public Piece getFromPosition(ChessPosition pos) {
            return pieces.get(pos);
        
    }
    public void update(ChessPosition from, ChessPosition to) {
      Piece movingPiece = pieces.get(from);
      if (movingPiece != null) {
          pieces.remove(from);
          pieces.put(to, movingPiece);
      }



}
}