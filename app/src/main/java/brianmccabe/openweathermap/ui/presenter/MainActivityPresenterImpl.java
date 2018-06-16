package brianmccabe.openweathermap.ui.presenter;

import android.location.Location;
import brianmccabe.openweathermap.data.weather.WeatherGatewayCallback;
import brianmccabe.openweathermap.data.weather.WeatherRestGateway;
import brianmccabe.openweathermap.model.WeatherResponse;
import brianmccabe.openweathermap.ui.MainActivity;
import brianmccabe.openweathermap.ui.MainActivityView;

/**
 * Created by brian on 16/06/2018.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView mainActivityView;


    @Override
    public void init(MainActivity mainActivity) {
        mainActivityView = mainActivity;
    }

    @Override
    public void retrieveWeather(Location location) {
        WeatherRestGateway ticketRestGateway = new WeatherRestGateway();

        ticketRestGateway.loadWeather(new WeatherGatewayCallback.OnGetWeather() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                mainActivityView.receivedWeather(weatherResponse);
            }

            @Override
            public void onError() {
                mainActivityView.failedRetrievingLocation();
            }
        }, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
    }
}
