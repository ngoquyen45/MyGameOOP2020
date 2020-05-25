package com.ngoquyen.game.player.abstracts;

import com.ngoquyen.game.items.Dice;
import com.ngoquyen.game.player.interfaces.GameCharacter;

public abstract class Player implements GameCharacter {

    protected int id;
    protected String name;
    protected int score;

    protected String preString;

    public String getPreString() {
        return preString;
    }

    private static int count = 1;

    public Player() {
            id = count++;
    }

    public int rollDice() {
        // Xoay xúc sắc
        Dice dice = new Dice();
        try {
            score += dice.roll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }
}
