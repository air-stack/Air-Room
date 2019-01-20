package com.ten.air.room;

import com.ten.air.room.frame.AirFrame;
import com.ten.air.room.mocker.AirDispatcher;

import javax.swing.*;
import java.awt.*;

public class AirRoomApplication {
    private static AirDispatcher air = new AirDispatcher();

    public static void main(String[] args) {
//        Linux下的命令行界面
        addListener();
        run();

//        Windows下的可视化界面
//        EventQueue.invokeLater(() -> {
//            JFrame frame = new AirFrame();
//            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            frame.setTitle("大气质量检测模拟区域");
//            frame.setVisible(true);
//        });
    }

    /**
     * 执行模拟调度
     */
    public static void run() {
        air.run();
    }

    /**
     * 添加传感器到模拟池
     */
    public static void addListener() {
        air.registerSensor();
    }
}
