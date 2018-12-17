package com.ten.air.room.mocker;

import java.util.LinkedList;
import java.util.List;

/**
 * 模拟大气环境
 */
public class AirRoom implements AirObserver {

    private List<AirListener> listeners;

    AirRoom() {
        listeners = new LinkedList<>();
    }

    void addListener(AirListener listener) {
        listeners.add(listener);
    }

    /**
     * 注册Sensor为大气指标监听者
     */
    @Override
    public void putAirInfo() {
        // 监听指标
        listeners.forEach(AirListener::getAirInfo);
    }

}
