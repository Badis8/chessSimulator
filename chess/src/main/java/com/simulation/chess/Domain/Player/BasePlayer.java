package com.simulation.chess.Domain.Player;

import com.simulation.chess.Domain.Board;
import com.simulation.chess.Domain.enums.ChessMove;
import com.simulation.chess.Domain.enums.ChessPosition;

import ch.qos.logback.core.joran.sanity.Pair;

public abstract class BasePlayer {

    protected final Board board;


    public BasePlayer(Board board) {
        this.board = board;
    }

    public abstract ChessMove Move();
}
