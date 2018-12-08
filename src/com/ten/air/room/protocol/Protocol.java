package com.ten.air.room.protocol;

import com.ten.air.room.mocker.AirIndex;

import java.util.logging.Logger;

/**
 * TCP Protocol
 */
public class Protocol {
    private static final Logger logger = Logger.getLogger("protocol");

    public static final String IP = "127.0.0.1";

    public static final int PORT = 2759;

    private static final int LENGTH = 72;

    // 数据帧头码 2
    private static final String HEAD = "A00F";
    // 数据帧字节数 1
    private static final String SIZE = "24";
    // 功能码 1
    private static final String FUNC = "01";
    // 数据来源 1
    private static final String SOURCE = "01";
    // 和校验 2
    private static final String CHECK = "00";

    public static String newProtocol(String imei, AirIndex airIndex) {
        String protocol = ""
                + HEAD
                + SIZE
                + parseTime()
                + FUNC
                + parseImei(imei)
                + SOURCE
                + parseData(airIndex.getTemperature())
                + parseData(airIndex.getPm25())
                + parseData(airIndex.getCo2())
                + parseData(airIndex.getSo2())
                + CHECK;

        if (protocol.length() != LENGTH) {
            logger.warning("Protocol is not valid :" + protocol.length() + "," + protocol);
        }

        return protocol;
    }

    /**
     * 时间戳 6Byte
     */
    private static String parseTime() {
        return String.valueOf(System.currentTimeMillis()).substring(0, 12);
    }

    /**
     * 地址码 15Byte
     */
    private static String parseImei(String imei) {
        if (imei.length() != 30) {
            imei = fillData(imei, 30);
        }
        return imei;
    }

    /**
     * 数据 2Byte
     */
    private static String parseData(String data) {
        String[] number = data.split("\\.");

        if (number.length < 1) {
            return "0000";
        }

        // 有小数部分
        if (number.length > 1) {
            Integer integer = Integer.parseInt(number[0]);

            // 小数部分精确到2位
            if (number[1].length() > 2) {
                number[1] = number[1].substring(0, 2);
            }
            Integer decimal = Integer.parseInt(number[1]);

            String hexInteger = Integer.toHexString(integer);
            String hexDecimal = Integer.toHexString(decimal);

            // 字节填充
            hexInteger = fillData(hexInteger, 2);
            hexDecimal = fillData(hexDecimal, 2);

            return hexInteger + hexDecimal;
        }
        // 无小数部分
        else {
            Integer integer = Integer.parseInt(number[0]);

            String hexInteger = Integer.toHexString(integer);

            return fillData(hexInteger, 4);
        }
    }

    /**
     * 字节填充 补零
     */
    private static String fillData(String data, int expect) {
        int lack = expect - data.length();
        String result = "";
        // 超出范围
        if (lack < 0) {
            while (expect-- > 0) {
                result += "F";
            }
            return String.valueOf(result);
        }
        // 前缀补零
        else {
            result = data;
            while (lack-- > 0) {
                result = "0" + result;
            }
            return String.valueOf(result);
        }
    }

}
