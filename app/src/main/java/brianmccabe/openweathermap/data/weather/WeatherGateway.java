package brianmccabe.openweathermap.data.weather;

/**
 * Created by brian on 16/06/2018.
 */

public interface WeatherGateway {
    void loadWeather(WeatherGatewayCallback.OnGetWeather weather, String lat, String lon);

}
