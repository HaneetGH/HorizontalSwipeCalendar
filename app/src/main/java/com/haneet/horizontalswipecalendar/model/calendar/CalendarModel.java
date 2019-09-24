package com.haneet.horizontalswipecalendar.model.calendar;

import java.util.List;

public class CalendarModel {

    private List<DateModel> dateModelList;
    private List<TimeModel> timeModels;


    public List<DateModel> getDateModelList() {
        return dateModelList;
    }

    public void setDateModelList(List<DateModel> dateModelList) {
        this.dateModelList = dateModelList;
    }

    public List<TimeModel> getTimeModels() {
        return timeModels;
    }

    public void setTimeModels(List<TimeModel> timeModels) {
        this.timeModels = timeModels;
    }


}
