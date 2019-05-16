package com.usoft.suntg.algorithm.patterns.event;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public class LightGameStartListener implements EventListener<GameStartEvent> {

    @Override
    public void listen(GameStartEvent event) {
        System.out.println("灯光模块监听到游戏开始，打开灯光效果");
    }
}
