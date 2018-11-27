package com.ten.air.room.protocol;

/**
 * TCP Protocol
 */
public class Protocol {

    public static final String IP = "127.0.0.1";
    public static final int PORT = 2759;

    private static final int LENGTH = 39;

    public static boolean isValid(byte[] protocol) {
        if (protocol.length != LENGTH) {
            return false;
        }
        return true;
    }

}
