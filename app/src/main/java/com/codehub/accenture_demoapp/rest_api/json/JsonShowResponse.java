package com.codehub.accenture_demoapp.rest_api.json;

public class JsonShowResponse {
    private String title;
    private int endTime;
    private int startTile;
    private String endTimeCaption;
    private String startTimeCaption;

    public JsonShowResponse() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStartTile() {
        return startTile;
    }

    public void setStartTile(int startTile) {
        this.startTile = startTile;
    }

    public String getEndTimeCaption() {
        return endTimeCaption;
    }

    public void setEndTimeCaption(String endTimeCaption) {
        this.endTimeCaption = endTimeCaption;
    }

    public String getStartTimeCaption() {
        return startTimeCaption;
    }

    public void setStartTimeCaption(String startTimeCaption) {
        this.startTimeCaption = startTimeCaption;
    }

    @Override
    public String toString() {
        return "JsonShowResponse{" +
                "title='" + title + '\'' +
                ", endTime=" + endTime +
                ", startTile=" + startTile +
                ", endTimeCaption='" + endTimeCaption + '\'' +
                ", startTimeCaption='" + startTimeCaption + '\'' +
                '}';
    }
}