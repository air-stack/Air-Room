package com.ten.air.room.frame;

import com.ten.air.room.AirRoomApplication;

import javax.swing.*;
import java.awt.*;

/**
 * Content Panel
 */
public class AirPanel extends JPanel {

    private JPanel paintPanel;
    private JButton add;
    private JButton run;

    public AirPanel() {
        setPaintPanel();
        setAddButton();
        setRunButton();
        initFrame();
    }

    private void setPaintPanel() {
        paintPanel = new JPanel();
    }

    private void setAddButton() {
        add = new JButton("添加传感器");
        add.addActionListener(event -> new Thread(AirRoomApplication::addListener).start());
    }

    private void setRunButton() {
        run = new JButton("运行");
        run.addActionListener(event -> new Thread(AirRoomApplication::run).start());
    }

    private void initFrame() {
        // 添加布局
        setLayout(new GridBagLayout());
        add(paintPanel, setConstraints(0, 0, 2, 4, 1, 1));
        add(add, setConstraints(0, 1, 1, 2, 1, 1));
        add(run, setConstraints(2, 1, 1, 2, 1, 1));
    }

    /**
     * 设置布局管理器
     */
    private GridBagConstraints setConstraints(int gx, int gy, int gh, int gw, int wx, int wy) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gx;
        constraints.gridy = gy;
        constraints.gridheight = gh;
        constraints.gridwidth = gw;
        constraints.weightx = wx;
        constraints.weighty = wy;
        constraints.fill = GridBagConstraints.BOTH;
        return constraints;
    }
}
