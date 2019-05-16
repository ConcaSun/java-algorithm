package com.usoft.suntg.algorithm.patterns.event;

/**
 * Created by ConcaSun on 2019/5/16.
 */
public class ScreenGameStartListener implements EventListener<GameStartEvent> {

    @Override
    public void listen(GameStartEvent event) {
        System.out.println("屏幕显示模块监听到游戏开始，正在显示游戏名...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("屏幕显示完成：" + event.getGameName());
    }
}
