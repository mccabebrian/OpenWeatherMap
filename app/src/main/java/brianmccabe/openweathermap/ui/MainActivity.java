package brianmccabe.openweathermap.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import brianmccabe.openweathermap.R;
import brianmccabe.openweathermap.mapper.IconMapper;
import brianmccabe.openweathermap.model.List;
import brianmccabe.openweathermap.model.Main;
import brianmccabe.openweathermap.model.Weather;
import brianmccabe.openweathermap.model.WeatherResponse;
import brianmccabe.openweathermap.ui.presenter.MainActivityPresenter;
import brianmccabe.openweathermap.ui.presenter.MainActivityPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private MainActivityPresenter mainActivityPresenter;
    private ProgressBar pgsBar;
    private TextView nameText, currentTempText, maxTempText, minTempText, humidityText, windSpeedText;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenterImpl();
        mainActivityPresenter.init(this);

        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        nameText = (TextView) findViewById(R.id.name);
        currentTempText = (TextView) findViewById(R.id.current_temp);
        maxTempText = (TextView) findViewById(R.id.max_temp);
        minTempText = (TextView) findViewById(R.id.min_temp);
        humidityText = (TextView) findViewById(R.id.huminity);
        windSpeedText = (TextView) findViewById(R.id.wind_speed);
        icon = (ImageView) findViewById(R.id.icon);

        showDialog();
        getLocation();
    }

    private void showDialog() {
        pgsBar.setVisibility(View.VISIBLE);
    }

    private void hideDialog() {
        pgsBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void receivedWeather(WeatherResponse weatherResponse) {
        hideDialog();
        List[] list = weatherResponse.getList();
        List currentList = list[0];
        Weather[] weather = currentList.getWeather();
        Weather currentWeather = weather[0];
        nameText.setText(currentList.getName());
        Main main = currentList.getMain();
        currentTempText.setText(String.format("%s%s", main.getTemp(), getString(R.string.celsius_symbol)));
        maxTempText.setText(String.format("%s%s", main.getTemp_min(), getString(R.string.celsius_symbol)));
        minTempText.setText(String.format("%s%s", main.getTemp_max(), getString(R.string.celsius_symbol)));
        humidityText.setText(main.getHumidity());
        windSpeedText.setText(currentList.getWind().getSpeed());
        icon.setImageResource(IconMapper.getImageFromIcon(currentWeather.getIcon()));
    }

    @Override
    public void failedRetrievingLocation() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show();
    }

    private boolean getLocation() {
        FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Toast.makeText(this, R.string.permission_rationale, Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
            return true;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            mainActivityPresenter.retrieveWeather(location);
                        }
                    }
                });
        return false;
    }

}
