package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;

public class RandomRookMovePlayer extends BasePlayer{
        public RandomRookMovePlayer(Board board){ 
        super(board);
    }

    @Override
    public ChessMove Move() {
        ChessPosition start = ChessPosition.B1;  
        ChessPosition end =   ChessPosition.B5 ;

        return new ChessMove(start, end);
       
      
    }
    
}
