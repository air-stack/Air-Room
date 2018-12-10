package com.ten.air.room.frame;

import javax.swing.*;

/**
 * Frame
 */
public class AirFrame extends JFrame {

    public AirFrame() {
        init();
    }

    private void init() {
        // 设置外观
        setUI();

        // 设置内容面板
        AirPanel airPanel = new AirPanel();
        setContentPane(airPanel);
        setLocation(200, 200);
        pack();
    }

    /**
     * 设置外观 :获取当前系统的默认外观
     */
    private void setUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
