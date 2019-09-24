package com.haneet.horizontalswipecalendar.model.calendar;

public class HourModel {

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    private String hour;

    public boolean isSetSelected() {
        return setSelected;
    }

    public void setSetSelected(boolean setSelected) {
        this.setSelected = setSelected;
    }

    private boolean setSelected=true;
}
