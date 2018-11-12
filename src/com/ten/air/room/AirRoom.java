package com.ten.air.room;

import java.util.LinkedList;
import java.util.List;

/**
 * 模拟大气环境
 *
 * @author wshten
 * @date 2018/11/11
 */
public class AirRoom implements AirObserver {
    private List<AirListener> listeners;

    public AirRoom() {
        listeners = new LinkedList<>();
    }

    public void addListener(AirListener listener) {
        listeners.add(listener);
    }

    @Override
    public void putAirInfo() {
        for (AirListener listener : listeners) {
            AirIndex airIndex = AirIndex.getNewAir();

            listener.getAirInfo(airIndex);
        }
    }

}
