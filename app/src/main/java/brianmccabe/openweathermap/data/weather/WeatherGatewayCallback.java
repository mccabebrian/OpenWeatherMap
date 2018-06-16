package brianmccabe.openweathermap.data.weather;

import brianmccabe.openweathermap.model.WeatherResponse;

/**
 * Created by brian on 16/06/2018.
 */

public interface WeatherGatewayCallback {
    interface OnGetWeather {
        void onSuccess(WeatherResponse weatherResponse);
        void onError();
    }
}
