package com.ten.air.room;

import org.omg.IOP.TAG_JAVA_CODEBASE;

import java.util.LinkedList;
import java.util.List;

/**
 * Air Dispatcher For Room and Sensor
 *
 * @author wshten
 * @date 2018/11/12
 */
public class AirDispatcher {
    private AirRoom airRoom;

    public AirDispatcher() {
        airRoom = new AirRoom();
    }

    public void registerSensor(AirSensor sensor) {
        airRoom.addListener(sensor);
    }

    public void run() {
        while (true) {
            Runnable r = () -> airRoom.putAirInfo();
            Thread t = new Thread(r);
            t.start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
