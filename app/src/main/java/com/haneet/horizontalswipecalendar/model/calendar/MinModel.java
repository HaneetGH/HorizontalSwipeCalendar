package com.haneet.horizontalswipecalendar.model.calendar;

public class MinModel {

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    private String minute;

    public boolean isSetSelected() {
        return setSelected;
    }

    public void setSetSelected(boolean setSelected) {
        this.setSelected = setSelected;
    }

    private boolean setSelected=true;

}
