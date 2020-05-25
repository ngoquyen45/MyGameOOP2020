package com.ngoquyen.game.player.interfaces;

public interface GameCharacter {
    String participated = "⚡ Tôi đã tham gia vào game";
    String leave = "\uD83D\uDC4B Tôi đã thoát khỏi game";
    void joinGame();

    void leaveGame();
}
