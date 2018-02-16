package com.myagenda.myagenda;

public class ClassObject {

    private String etClass;
    private String tvStartsTime;
    private String tvEndsTime;

    public ClassObject(String etClass, String tvStartsTime, String tvEndsTime) {
        this.etClass = etClass;
        this.tvStartsTime = tvStartsTime;
        this.tvEndsTime = tvEndsTime;
    }

    public String getEtClass() {
        return etClass;
    }

    public void setEtClass(String etClass) {
        this.etClass = etClass;
    }

    public String getTvStartsTime() {
        return tvStartsTime;
    }

    public void setTvStartsTime(String tvStartsTime) {
        this.tvStartsTime = tvStartsTime;
    }

    public String getTvEndsTime() {
        return tvEndsTime;
    }

    public void setTvEndsTime(String tvEndsTime) {
        this.tvEndsTime = tvEndsTime;
    }
}
