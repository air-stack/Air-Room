package com.ten.air.room;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟传感器
 *
 * @author wshten
 * @date 2018/11/11
 */
public class AirSensor implements AirListener {
    private Integer id;
    private static AtomicInteger count = new AtomicInteger(0);

    public AirSensor() {
        Integer id = count.addAndGet(1);
        System.out.println("新设备的ID:" + id);
        this.id = id;
    }

    @Override
    public void getAirInfo(AirIndex airIndex) {
        System.out.println(airIndex);
    }

    public Integer getId() {
        return id;
    }
}
