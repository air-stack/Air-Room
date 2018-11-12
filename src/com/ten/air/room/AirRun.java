package com.ten.air.room;

import com.ten.air.room.frame.AirFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Main
 *
 * @author wshten
 * @date 2018/11/12
 */
public class AirRun {
    private static AirDispatcher air = new AirDispatcher();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new AirFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("大气质量检测模拟区域");
            frame.setVisible(true);
        });
    }

    public static void run(){
        air.run();
    }

    public static void addListener(){
        AirSensor sensor = new AirSensor();
        air.registerSensor(sensor);
    }
}
