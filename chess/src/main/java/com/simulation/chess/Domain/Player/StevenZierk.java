package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.PieceName;
 
public class StevenZierk extends BasePlayer{ 
    ChessMove[] moves = {
        new ChessMove(0, 6, 2, 5), // 1. Nf3 (knight from g1 to f3)
        new ChessMove(6, 3, 4, 3), // 1... d5 (pawn from d7 to d5)
        new ChessMove(1, 2, 3, 2), // 2. c4 (pawn from c2 to c4)
        new ChessMove(4, 3, 3, 3), // 2... d4 (pawn from d5 to c4)
        new ChessMove(1, 1, 2, 1), // 3. b4 (pawn from b2 to b3)
        new ChessMove(5, 5, 4, 5), // 3... f6 (pawn from f7 to f6)
        new ChessMove(1, 4, 2, 4), // 4. e3 (pawn from e2 to e3)
        new ChessMove(6, 4, 4, 4), // 4... e5 (pawn from e7 to e5)
        new ChessMove(3, 2, 4, 2), // 5. c5 (pawn from c4 to c5)
        new ChessMove(6, 0, 5, 0), // 5... a5 (pawn from a7 to a6)
        new ChessMove(0, 3, 3, 0), // 6. Qa4+ (queen from d1 to a4, check)
        new ChessMove(7, 1, 6, 2), // 6... Bd7 (bishop from c8 to d7)
        new ChessMove(1, 1, 2, 1), // 7. b5 (pawn from b3 to b4)
        new ChessMove(6, 2, 2, 1), // 7... Bxc5 (bishop from d7 to b4, captures)
        new ChessMove(0, 2, 4, 4), // 8. Bc4 (bishop from c1 to c4)
        new ChessMove(7, 3, 6, 4), // 8... Qe7 (queen from d8 to e7)
        new ChessMove(0, 6, 2, 6), // 9. O-O (castle kingside)
        new ChessMove(4, 3, 3, 4), // 9... dxe3 (pawn from d4 captures e3)
        new ChessMove(1, 5, 3, 5), // 10. fxe3 (pawn from f2 captures e3)
        new ChessMove(7, 1, 5, 2), // 10... Nh6 (knight from b8 to d7)
        new ChessMove(0, 5, 1, 5), // 11. Nc3 (knight from b1 to c3)
        new ChessMove(7, 2, 5, 4), // 11... Be6 (bishop from c8 to e6)
        new ChessMove(1, 5, 2, 3), // 12. Nd5 (knight from c3 to d5)
        new ChessMove(5, 4, 2, 3), // 12... Bxd5 (bishop from e6 captures d5)
        new ChessMove(4, 4, 2, 3), // 13. Bxd5 (bishop from c4 captures d5)
        new ChessMove(7, 0, 6, 0), // 13... Ra7 (rook from a8 to a7)
        new ChessMove(3, 3, 4, 1), // 14. d4 (pawn from d2 to d4)
        new ChessMove(4, 1, 6, 2), // 14... Bb6 (bishop from a7 to b6)
        new ChessMove(2, 3, 4, 1), // 15. Ba3 (bishop from b4 to a3)
        new ChessMove(7, 3, 6, 3), // 15... Qd7 (queen from d8 to d7)
        new ChessMove(3, 0, 2, 3), // 16. Qc4 (queen from a4 to c4)
        new ChessMove(5, 4, 4, 4), // 16... e4 (pawn from e6 to e5)
        new ChessMove(2, 5, 4, 2), // 17. Nd2 (knight from b1 to d2)
        new ChessMove(3, 2, 4, 2), // 17... c6 (pawn from c7 to c6)
        new ChessMove(4, 2, 4, 3), // 18. Be6 (bishop from a3 to e6)
        new ChessMove(6, 4, 6, 3), // 18... Qc7 (queen from e7 to c7)
        new ChessMove(2, 3, 3, 3), // 19. Nxe4 (knight from d5 captures e4)
        new ChessMove(6, 2, 3, 2), // 19... Nd7 (knight from b6 to d7)
        new ChessMove(4, 1, 4, 2), // 20. Nd6+ (knight from d5 to e7, check)
        new ChessMove(7, 4, 6, 4), // 20... Kd8 (king moves to e6)
        new ChessMove(1, 5, 2, 5), // 21. bxc5 (pawn captures c5)
        new ChessMove(6, 6, 3, 6) };
        private int moveCounter=1;
        public StevenZierk(Board board){ 
        super(board);
    }

    @Override
    public ChessMove Move() {
  
      
        int curentmove=this.moveCounter;
        this.moveCounter+=2;
  
        return this.moves[curentmove];
       
      
    }

    
   
}


