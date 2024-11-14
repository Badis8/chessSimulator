package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;
 
public class randomRookMoverPlayer extends BasePlayer {

    public randomRookMoverPlayer(Board board){ 
        super(board);
    }

    @Override
    public ChessMove Move() {
        ChessPosition start = ChessPosition.A1;  
        ChessPosition end =   ChessPosition.A5 ;

        return new ChessMove(start, end);
       
      
    }
    
   
}


