package com.ten.air.room.mocker;

import java.util.concurrent.*;

/**
 * Air Dispatcher For Room and Sensor
 */
public class AirDispatcher {

    private AirRoom airRoom;
    private Integer sensorSize;

    private static final int MAX = 8;

    private ScheduledThreadPoolExecutor executor;

    public AirDispatcher() {
        airRoom = new AirRoom();
        sensorSize = 0;
        ThreadFactory threadFactory = Thread::new;
        executor = new ScheduledThreadPoolExecutor(8, threadFactory);
    }

    /**
     * Add Sensor
     */
    public void registerSensor() {
        if (sensorSize < MAX) {
            AirSensor sensor = new AirSensor();
            airRoom.addListener(sensor);
            sensorSize++;
        } else {
            System.out.println("Failure to add sensor");
        }
    }

    /**
     * Run Schedule Dispatcher
     */
    public void run() {
        while (true) {
            Runnable r = () -> airRoom.putAirInfo();
            executor.schedule(r, 3000, TimeUnit.MILLISECONDS);
        }
    }

}
