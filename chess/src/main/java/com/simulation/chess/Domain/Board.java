  package com.simulation.chess.Domain;

  import com.simulation.chess.Domain.enums.ChessMove;
  import com.simulation.chess.Domain.enums.PieceName;
import com.simulation.chess.Domain.pieces.Bishop;
import com.simulation.chess.Domain.pieces.King;
import com.simulation.chess.Domain.pieces.Knight;
import com.simulation.chess.Domain.pieces.Pawn;
import com.simulation.chess.Domain.pieces.Piece;
import com.simulation.chess.Domain.pieces.Queen;
import com.simulation.chess.Domain.pieces.Rook;

  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.HashSet;
  import java.util.List;
  import java.util.Map;
  import java.util.Set;

  import org.springframework.stereotype.Component;


  @Component
  public class Board {

    Map<PieceName, ChessPosition> pieceMapper = new HashMap<>();  
    Piece[][] piecesBoard = new Piece[63][63]; 
  

    Board(){
        piecesBoard[0][0] = new Rook(true);  
        piecesBoard[0][7] = new Rook(true);  
        piecesBoard[7][0] = new Rook(false);  
        piecesBoard[7][7] = new Rook(false);  

    
        for (int i = 0; i < 8; i++) {
            piecesBoard[1][i] = new Pawn(true);  
            piecesBoard[6][i] = new Pawn(false);  
        }

         
        piecesBoard[0][1] = new Knight(true); 
        piecesBoard[0][6] = new Knight(true);  
        piecesBoard[7][1] = new Knight(false);  
        piecesBoard[7][6] = new Knight(false);  

        piecesBoard[0][2] = new Bishop(true);  
        piecesBoard[0][5] = new Bishop(true);  
        piecesBoard[7][2] = new Bishop(false);  
        piecesBoard[7][5] = new Bishop(false);  

        piecesBoard[0][3] = new Queen(true);  
        piecesBoard[7][3] = new Queen(false);  

        piecesBoard[0][4] = new King(true);  
        piecesBoard[7][4] = new King(false);  

 
pieceMapper.put(PieceName.R, new ChessPosition(0, 0));   
pieceMapper.put(PieceName.R, new ChessPosition(0, 7));   
pieceMapper.put(PieceName.r, new ChessPosition(7, 0));  
pieceMapper.put(PieceName.r, new ChessPosition(7, 7));   

 
pieceMapper.put(PieceName.N, new ChessPosition(0, 1));   
pieceMapper.put(PieceName.N, new ChessPosition(0, 6));   
pieceMapper.put(PieceName.n, new ChessPosition(7, 1));   
pieceMapper.put(PieceName.n, new ChessPosition(7, 6));  

 
pieceMapper.put(PieceName.B, new ChessPosition(0, 2));   
pieceMapper.put(PieceName.B, new ChessPosition(0, 5));   
pieceMapper.put(PieceName.b, new ChessPosition(7, 2));  
pieceMapper.put(PieceName.b, new ChessPosition(7, 5));   

 
pieceMapper.put(PieceName.Q, new ChessPosition(0, 3));   
pieceMapper.put(PieceName.q, new ChessPosition(7, 3));   

 
pieceMapper.put(PieceName.K, new ChessPosition(0, 4));   
pieceMapper.put(PieceName.k, new ChessPosition(7, 4));   
 
for (int i = 0; i < 8; i++) {
    pieceMapper.put(PieceName.P, new ChessPosition(1, i));   
    pieceMapper.put(PieceName.p, new ChessPosition(6, i));   
}
      
    }

      
      public Piece getFromPosition(int row,int column) { 
              if(!this.isWithinBounds(row, column)){ throw new IllegalArgumentException("Invalid position: " + row+" "+column);}
           
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
          this.pieceMapper.put(movingPiece.getSymbol(),new ChessPosition(move.getRow(),move.getColumn() ));
        }
  }
        public boolean isWithinBounds(int row, int col) {
          return row < 8 && col < 8 && row >= 0 && col>=0;
    }   
        public boolean  isWhiteKingChecked(){ 
           
          Set<ChessPosition> attackingPositions = new HashSet<>();   
          ChessPosition kingPosition=this.pieceMapper.get(PieceName.K);
          pieceMapper.forEach((pieceName, chessPosition) -> {
                 if (pieceName.name().equals(pieceName.name().toUpperCase())) {
            int row = chessPosition.getRow();
            int col = chessPosition.getColumn();
            Piece piece = piecesBoard[row][col];
            attackingPositions.addAll(piece.Threads(this, row, col));
      
        } 
 
    });
    for (ChessPosition position : attackingPositions) {
          if(position==kingPosition){
            return true;
          }
  }
          return false;
            
        } 
          public boolean  isBlackKingChecked(){
          Set<ChessPosition> attackingPositions = new HashSet<>();   
          ChessPosition kingPosition=this.pieceMapper.get(PieceName.K);
          pieceMapper.forEach((pieceName, chessPosition) -> {
                 if (pieceName.name().equals(pieceName.name().toLowerCase())) {
            int row = chessPosition.getRow();
            int col = chessPosition.getColumn();
            Piece piece = piecesBoard[row][col];
            attackingPositions.addAll(piece.Threads(this, row, col));
        }
    });
    for (ChessPosition position : attackingPositions) {
          if(position==kingPosition){
            return true;
          }
  }
          return false;
            
        }    



        public boolean isStillInCheckAfterMove(ChessMove chessMove) {
   
          Piece movingPiece = this.getFromPosition(chessMove.getOldRow(), chessMove.getOldColumn());
          Piece originalTarget = this.getFromPosition(chessMove.getRow(), chessMove.getColumn());
          this.update(chessMove);
  
         
          boolean stillInCheck;
          if (movingPiece.getColor()) {
              stillInCheck = this.isWhiteKingChecked();
          } else {
              stillInCheck = this.isBlackKingChecked();
          }
  
           
          this.update(new ChessMove(chessMove.getRow(), chessMove.getColumn(), chessMove.getOldRow(), chessMove.getOldColumn()));
          this.piecesBoard[chessMove.getRow()][chessMove.getColumn()] = originalTarget;
  
          return stillInCheck;
      } 
      @Override
public String toString() {
    StringBuilder boardRepresentation = new StringBuilder();

    for (int row = 7; row >= 0; row--) {
        boardRepresentation.append(row + 1).append(" ");  
        for (int col = 0; col < 8; col++) {
            Piece piece = piecesBoard[row][col];
            if (piece != null) {
 
                boardRepresentation.append(piece.getSymbol()).append(" ");
            } else {
                boardRepresentation.append(". ");  
            }
        }
        boardRepresentation.append("\n");
    }

    
    boardRepresentation.append("  a b c d e f g h\n");

    return boardRepresentation.toString();
}

    }
          

      
 