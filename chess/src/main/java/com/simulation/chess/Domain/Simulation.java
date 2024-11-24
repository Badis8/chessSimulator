package com.simulation.chess.Domain;

import com.simulation.chess.Domain.Player.BasePlayer;
import com.simulation.chess.Domain.Player.KrikorSevagMekhitarian;
import com.simulation.chess.Domain.Player.StevenZierk;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.pieces.Piece; 
import java.util.LinkedList;

    public class Simulation {

        private Board board;
        private BasePlayer black; 
        private BasePlayer white;  

        public Simulation(Board board,BasePlayer white,BasePlayer black){

            this.board=board;
            this.white=white;
            this.black=black;
        } 

        private boolean checkWhiteLegal(ChessMove chessMove){

            Piece pieceToMove= this.board.getFromPosition(chessMove.getOldRow(),chessMove.getOldColumn());  
            if (pieceToMove==null){return false;}
            if (!pieceToMove.getColor()){
                return false;}
            if(this.board.isWhiteKingChecked()){return this.board.isStillInCheckAfterMove(chessMove) && pieceToMove.isValid(chessMove, board);} 
                
            return pieceToMove.isValid(chessMove, board);
        } 
        private boolean checkBlackLegal(ChessMove chessMove){

            Piece pieceToMove= this.board.getFromPosition(chessMove.getOldRow(),chessMove.getOldColumn());  
            if (pieceToMove==null){return false;}
            if (pieceToMove.getColor()){return false;}
            if(this.board.isBlackKingChecked()){return this.board.isStillInCheckAfterMove(chessMove) && pieceToMove.isValid(chessMove, board);} 

            return pieceToMove.isValid(chessMove, board);
        }
        public LinkedList<ChessMove> simulate(){ 

 
        LinkedList<ChessMove> moves = new LinkedList<>();
 
        int movesCounter=1;
        while(movesCounter<=10){  
        ChessMove chessMove=this.white.Move();  
        while(this.checkWhiteLegal(chessMove)==false){
            System.out.println("changing move white ");  
            System.out.println(chessMove);
            System.out.println(this.board);
   
            chessMove=this.white.Move();
        }    
        moves.add(chessMove);
        this.board.update(chessMove); 
        System.out.println(this.board);
        chessMove=this.black.Move();  
      
        while(this.checkBlackLegal(chessMove)==false){
            System.out.println("changint the move "); 
            System.out.println(chessMove); 
            System.out.println(this.board);
            chessMove=this.black.Move();    
        }
        moves.add(chessMove); 
        movesCounter++; 
        this.board.update(chessMove); 
        System.out.println(this.board);
    }   
        return moves;

            
        }



    }
