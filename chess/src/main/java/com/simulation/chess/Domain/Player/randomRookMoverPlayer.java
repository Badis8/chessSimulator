package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;
import com.simulation.chess.Domain.enums.PieceName;
 
public class randomRookMoverPlayer extends BasePlayer {

    public randomRookMoverPlayer(Board board){ 
        super(board);
    }

    @Override
    public ChessMove Move() {
      
        

        return new ChessMove(1,1,1,5);
       

      
    }
    
   
}


