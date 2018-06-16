package brianmccabe.openweathermap.ui;

import brianmccabe.openweathermap.model.WeatherResponse;

/**
 * Created by brian on 16/06/2018.
 */

public interface MainActivityView {
    void receivedWeather(WeatherResponse weatherResponse);
    void failedRetrievingLocation();
}
