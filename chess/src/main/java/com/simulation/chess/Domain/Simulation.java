package com.simulation.chess.Domain;


import com.simulation.chess.Domain.Player.BasePlayer;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.pieces.Piece; 
import java.util.LinkedList;

    public class Simulation {

        private Board board;
        private BasePlayer white; 
        private BasePlayer black;

        public Simulation(Board board,BasePlayer white,BasePlayer black){

            this.board=board;
            this.white=white;
            this.black=black;
        } 

        private boolean checkLegal(ChessMove chessMove){

            Piece pieceToMove=this.board.getFromPosition(chessMove.getFrom());  
            if (pieceToMove!=null){
                return pieceToMove.IsValid(chessMove.getFrom(),chessMove.getTo(),this.board);
            }
            return false;
        }
        public LinkedList<ChessMove> simulate(){ 

          
        LinkedList<ChessMove> moves = new LinkedList<>();
        ChessMove chessMove=this.white.Move(); 
        while(this.checkLegal(chessMove)==false){
            System.out.println("hello");
            chessMove=this.white.Move();
        }    
        moves.add(chessMove);

        chessMove=this.black.Move(); 
        while(this.checkLegal(chessMove)==false){
            chessMove=this.black.Move();
        }
        moves.add(chessMove);
        return moves;

            
        }



    }
