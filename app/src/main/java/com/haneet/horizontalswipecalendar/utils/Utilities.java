package com.haneet.horizontalswipecalendar.utils;


import com.haneet.horizontalswipecalendar.model.calendar.DateModel;
import com.haneet.horizontalswipecalendar.model.calendar.HourModel;
import com.haneet.horizontalswipecalendar.model.calendar.MinModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utilities {

    public static List<DateModel> buildCustomCalender(Date fromDate, Date toDate) {

        DateModel mDateModelFake = new DateModel();
        mDateModelFake.setDayname("");
        mDateModelFake.setDay("");
        mDateModelFake.setDate("");

        List<DateModel> dateModels = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        dateModels.add(mDateModelFake);
        dateModels.add(mDateModelFake);
        dateModels.add(mDateModelFake);
        while (cal.getTime().before(toDate)) {
            DateModel mDateModel = new DateModel();
            mDateModel.setDate(new SimpleDateFormat("MMM").format(cal.getTime()));
            mDateModel.setDayname(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
            mDateModel.setDay(new SimpleDateFormat("EEE").format(cal.getTime()));
            mDateModel.setYear(Integer.parseInt(new SimpleDateFormat("yyyy").format(cal.getTime())));
            dateModels.add(mDateModel);
            cal.add(Calendar.DATE, 1);
        }
        dateModels.add(mDateModelFake);
        dateModels.add(mDateModelFake);
        dateModels.add(mDateModelFake);
        return dateModels;
    }

    public static String getCurrentDate() {


        Calendar cal = Calendar.getInstance();

        return new SimpleDateFormat("EEE").format(cal.get(Calendar.DAY_OF_WEEK)) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + new SimpleDateFormat("MMM").format(cal.getTime()) + "-" + new SimpleDateFormat("yyyy").format(cal.getTime());
    }

    public static List<HourModel> buildCustomHourCalender(int hour) {
        List<HourModel> dateModels = new ArrayList<>();
        HourModel hourModelFake = new HourModel();
        hourModelFake.setHour("");
        dateModels.add(hourModelFake);
        dateModels.add(hourModelFake);
        dateModels.add(hourModelFake);
        while (hour < 24) {
            HourModel hourModel = new HourModel();
            hourModel.setHour(hour + "");
            hour++;

            dateModels.add(hourModel);
        }
        dateModels.add(hourModelFake);
        dateModels.add(hourModelFake);
        dateModels.add(hourModelFake);
        return dateModels;
    }

    public static List<MinModel> buildCustomMinCalender(int min) {
        List<MinModel> minModels = new ArrayList<>();
        MinModel minModelFake = new MinModel();
        minModelFake.setMinute("");
        minModels.add(minModelFake);
        minModels.add(minModelFake);
        minModels.add(minModelFake);
        while (min < 60) {
            MinModel minModel = new MinModel();
            minModel.setMinute(min + "");
            min++;

            minModels.add(minModel);
        }
        minModels.add(minModelFake);
        minModels.add(minModelFake);
        minModels.add(minModelFake);
        return minModels;
    }

    public static boolean isDateIsInFuture(String selectedDate) {
        Calendar calC = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM-yyyy");
        Date date = null;
        try {
            date = format.parse(selectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(date);
        if (calC.getTime().before(cal.getTime())) {
            return true;
        } else return false;

    }

    public static boolean isYearIsInFuture(int year) {
        if (year > Calendar.getInstance().get(Calendar.YEAR))
            return true;
        else
            return false;
    }

    public static String getFinalDate(String selectedDate, int selectedHour, int selectedMin) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatNeedeeded = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm aa");
        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM-yyyy");

        Date date = null;

        try {
            date = format.parse(selectedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(date);
        cal.set(Calendar.HOUR, selectedHour);
        cal.set(Calendar.MINUTE, selectedMin);

        return formatNeedeeded.format(cal.getTime()).replace("am", "AM").replace("pm", "PM");


    }
}

