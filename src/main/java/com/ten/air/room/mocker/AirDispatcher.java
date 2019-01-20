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
     * Add Sensor. Max volume is 8.
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
                // TODO 防止数据量过大，为模拟30天数据，预计数据量30000，则每天1000条，时间设为一分钟一条
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
