package com.usoft.suntg.algorithm.patterns.event;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public class GameStartEvent extends Event {

    private String gameName;

    public GameStartEvent(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
