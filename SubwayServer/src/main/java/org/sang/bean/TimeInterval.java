package org.sang.bean;

/**
 * @Author HavenTong
 * @Date 2019/6/14 21:32
 */

public class TimeInterval {

    private String date;
    private String startTime;
    private String endTime;

    public TimeInterval() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
