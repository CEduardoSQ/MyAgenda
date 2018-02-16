package com.myagenda.myagenda;


public class ItemCard {

    private String TimeClass, StartTime, EndTime;

    public ItemCard() {
    }

    public ItemCard(String timeClass, String startTime, String endTime) {
        TimeClass = timeClass;
        StartTime = startTime;
        EndTime = endTime;
    }

    public String getTimeClass() {
        return TimeClass;
    }

    public void setTimeClass(String timeClass) {
        TimeClass = timeClass;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
