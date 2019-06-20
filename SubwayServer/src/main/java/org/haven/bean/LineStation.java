package org.haven.bean;

/**
 * @Author HavenTong
 * @Date 2019/6/5 23:26
 */

public class LineStation {

    private String lineName;
    private String origin;
    private String stationName;

    public LineStation(){

    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
