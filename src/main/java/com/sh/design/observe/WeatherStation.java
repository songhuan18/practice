package com.sh.design.observe;

/**
 * Author sh
 * Date 2019-08-13 22:00
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        CurrentConditionDisplay2 currentConditionDisplay2 = new CurrentConditionDisplay2(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
