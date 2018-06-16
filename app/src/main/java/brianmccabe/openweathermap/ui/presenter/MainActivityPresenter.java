package brianmccabe.openweathermap.ui.presenter;

import android.location.Location;

import brianmccabe.openweathermap.ui.MainActivity;

/**
 * Created by brian on 16/06/2018.
 */

public interface MainActivityPresenter {
    void init(MainActivity mainActivity);
    void retrieveWeather(Location location);
}
