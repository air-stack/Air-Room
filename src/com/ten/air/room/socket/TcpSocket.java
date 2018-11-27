package com.ten.air.room.socket;

import com.ten.air.room.protocol.Protocol;

import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP Socket
 */
public class TcpSocket {


    private TcpSocket() {
    }

    /**
     * 发送TCP数据包到AIO服务器
     */
    public static boolean sendTcp(byte[] protocol) {
        if (Protocol.isValid(protocol)) {
            try {
                Socket socket = new Socket(Protocol.IP, Protocol.PORT);
                OutputStream out = socket.getOutputStream();
                out.write(protocol);
                socket.close();
                return true;
            } catch (Exception ignored) {
                System.out.println("TCP数据发送失败");
                return false;
            }
        }
        return false;
    }
}
