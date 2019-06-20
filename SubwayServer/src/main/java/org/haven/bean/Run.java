package org.haven.bean;

/**
 * @Author HavenTong
 * @Date 2019/6/12 1:37
 */

public class Run {
    private int runId;
    private String lineName;
    private String origin;
    private String morningRushInterval;
    private String normalInterval;
    private String nightRushInterval;
    private String otherTimeInterval;

    public Run() {
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
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

    public String getMorningRushInterval() {
        return morningRushInterval;
    }

    public void setMorningRushInterval(String morningRushInterval) {
        this.morningRushInterval = morningRushInterval;
    }

    public String getNormalInterval() {
        return normalInterval;
    }

    public void setNormalInterval(String normalInterval) {
        this.normalInterval = normalInterval;
    }

    public String getNightRushInterval() {
        return nightRushInterval;
    }

    public void setNightRushInterval(String nightRushInterval) {
        this.nightRushInterval = nightRushInterval;
    }

    public String getOtherTimeInterval() {
        return otherTimeInterval;
    }

    public void setOtherTimeInterval(String otherTimeInterval) {
        this.otherTimeInterval = otherTimeInterval;
    }
}
