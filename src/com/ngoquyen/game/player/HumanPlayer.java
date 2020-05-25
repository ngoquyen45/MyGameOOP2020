package com.ngoquyen.game.player;

import com.ngoquyen.game.player.abstracts.Player;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        super();
        name = "HumanPlayer";
        preString = name + id + ": ";
        joinGame();
    }

    @Override
    public void joinGame() {
        System.out.println(preString + participated);
    }

    @Override
    public void leaveGame() {
        System.out.println(preString + leave);
    }
}
