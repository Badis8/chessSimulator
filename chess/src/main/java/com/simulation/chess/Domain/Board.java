package com.simulation.chess.Domain;

import com.simulation.chess.Domain.enums.ChessMove;
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
  Map<PieceName, ChessPosition> pieceMapper = new HashMap<>();  
  Piece[][] piecesBoard = new Piece[63][63];

    Board(){

      pieceMapper.put(PieceName.ROOK,ChessPosition.A1);
      pieceMapper.put(PieceName.ROOK,ChessPosition.B1); 
      piecesBoard[0][0]=new Rook(true ); 
      piecesBoard[1][1]=new Rook(false ); 
    }
    public Piece getFromPosition(int row,int column) {
            return piecesBoard[row][column];
        
    } 
    public ChessPosition getPiecePosition(PieceName pieceName){
          return pieceMapper.get(pieceName);
    }
    public void update(ChessMove move) {
      Piece movingPiece = piecesBoard[move.getOldRow()][move.getOldColumn()];
      if (movingPiece != null) {
        piecesBoard[move.getRow()][move.getColumn()]=movingPiece;
          piecesBoard[move.getOldRow()][move.getOldColumn()]=null;
           
        
   
      }



}
}