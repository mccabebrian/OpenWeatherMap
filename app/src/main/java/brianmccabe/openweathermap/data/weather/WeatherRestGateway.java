package brianmccabe.openweathermap.data.weather;

import brianmccabe.openweathermap.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by brian on 06/05/2017.
 */

public class WeatherRestGateway implements WeatherGateway{

    private final WeatherRequest weatherRequest;

    public WeatherRestGateway() {
        weatherRequest = new WeatherRequest();
    }

    @Override
    public void loadWeather(final WeatherGatewayCallback.OnGetWeather cb, String lat, String lon) {
        weatherRequest.getWeatherResponse(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if(response.isSuccessful()) {
                    cb.onSuccess(response.body());
                } else {
                    cb.onError();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                cb.onError();
            }
        }, lat, lon);
    }
}
