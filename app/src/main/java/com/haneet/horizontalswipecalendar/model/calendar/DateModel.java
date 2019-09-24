package com.haneet.horizontalswipecalendar.model.calendar;

public class DateModel {

    private String daynum;
    private String day;
    private String date;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int year;
    private boolean setSelected = true;

    public String getDayNum() {
        return daynum;
    }

    public void setDayname(String dayName) {
        this.daynum = dayName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isSetSelected() {
        return setSelected;
    }

    public void setSetSelected(boolean setSelected) {
        this.setSelected = setSelected;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
