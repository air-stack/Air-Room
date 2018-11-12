package com.ten.air.room;

/**
 * 大气质量指标
 *
 * @author wshten
 * @date 2018/11/11
 */
public class AirIndex {

    private String temperature;
    private String co2;

    private static final Integer BASE_TEMPERATURE = 25;
    private static final Integer BASE_CO2 = 350;

    /**
     * 获取一个新的空气指标记录，将随机生成相关参数
     */
    public static AirIndex getNewAir() {
        AirIndex airIndex = new AirIndex();

        String temperature = String.valueOf(BASE_TEMPERATURE + Math.random() * 10) + "℃";
        String co2 = String.valueOf(BASE_CO2 + Math.random() * 100) + "ppm";

        airIndex.setTemperature(temperature);
        airIndex.setCo2(co2);

        return airIndex;
    }

    private AirIndex() {
    }

    @Override
    public String toString() {
        return "AirRecord@{" +
                "temperature:" + temperature + "," +
                "co2:" + co2 + "," +
                "}";
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }
}
