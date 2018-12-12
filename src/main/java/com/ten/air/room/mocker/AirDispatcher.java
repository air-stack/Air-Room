package com.ten.air.room.mocker;

/**
 * Air Dispatcher For Room and Sensor
 */
public class AirDispatcher {

    private AirRoom airRoom;
    private Integer sensorSize;

    private static final int MAX = 8;

    public AirDispatcher() {
        airRoom = new AirRoom();
        sensorSize = 0;
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

            new Thread(() -> airRoom.putAirInfo()).start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
