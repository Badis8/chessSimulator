package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.PieceName;

public class RandomRookMovePlayer extends BasePlayer{
        public RandomRookMovePlayer(Board board){ 
        super(board);
    }

    @Override
    public ChessMove Move() {
  
      

        return new ChessMove(0,0,0,5);
       
      
    }

 
    
}
