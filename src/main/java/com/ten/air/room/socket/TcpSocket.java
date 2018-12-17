package com.ten.air.room.socket;

import com.ten.air.room.protocol.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TCP Socket
 */
public class TcpSocket {
    private static final TcpSocket INSTANCE = new TcpSocket();

    public static TcpSocket getInstance() {
        return INSTANCE;
    }

    private ConcurrentHashMap<String, Socket> socketConnection;

    private TcpSocket() {
        socketConnection = new ConcurrentHashMap<>();
    }

    /**
     * 发送TCP数据包到AIO服务器
     */
    public boolean sendTcp(String imei, String protocol) {
        // 获取Socket连接
        Socket socket = socketConnection.get(imei);
        if (socket == null) {
            try {
                socket = new Socket(Protocol.IP, Protocol.PORT);
                socketConnection.put(imei, socket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("TCP连接建立失败");
                return false;
            }
        }

        byte[] bytes = toBytes(protocol);

        // 发送TCP数据
        if (bytes.length > 0) {
            try {
                OutputStream out = socket.getOutputStream();
                out.write(bytes);
                return true;
            } catch (Exception ignored) {
                System.out.println("TCP数据发送失败");
                return false;
            }
        }

        return false;
    }

    /**
     * 将16进制字符串转换为byte[]
     */
    private static byte[] toBytes(String str) {
        if (str == null || "".equals(str.trim())) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

}
