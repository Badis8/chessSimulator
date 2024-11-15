package com.simulation.chess.Controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.Simulation;
import com.simulation.chess.Domain.Player.RandomRookMovePlayer;
import com.simulation.chess.Domain.Player.randomRookMoverPlayer;
import com.simulation.chess.Domain.enums.ChessMove;

@RestController
@RequestMapping("/api/chess")
public class ChessController {

    private final Board board;
    private final Simulation simulation;
   
    public ChessController(Board board) {
        this.board = board; 
        this.simulation=new Simulation(board,new RandomRookMovePlayer(board),new randomRookMoverPlayer(board));
    } 
    @GetMapping("/move")
    public LinkedList<ChessMove>  simulate(){
            
            return this.simulation.simulate();
    }

}