package com.example.camila.weatherviewer;

/**
 * Created by moises on 26-07-16.
 */

import java.util.TimeZone;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;


public class Weather {

    public final String dayOfWeek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconUrl;


    public Weather(long timeStamp, double minTemp, double maxTemp, double humidity, String description, String iconName) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        this.dayOfWeek = getConvertTimeStampToDay(timeStamp);
        this.minTemp = numberFormat.format(minTemp) + "\u00B0F" ;
        this.maxTemp = numberFormat.format(maxTemp) + "\u00B0F";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
        this.iconUrl = "http://openweathermap.org/img/w/" + iconName + ".png";
        this.description = description;

    }

    private String getConvertTimeStampToDay(long timeStamp) {
        //return convertTimeStampToDay(timeStamp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp * 1000);
        TimeZone tz = TimeZone.getDefault();

        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");

        return dateFormatter.format(calendar.getTime());
    }
}
