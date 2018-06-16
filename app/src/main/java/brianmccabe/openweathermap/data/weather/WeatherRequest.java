package brianmccabe.openweathermap.data.weather;

import brianmccabe.openweathermap.BuildConfig;
import brianmccabe.openweathermap.data.RestServiceProvider;
import brianmccabe.openweathermap.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by brian on 06/05/2017.
 */

public class WeatherRequest {
    private static final String HEADER_CONTENT_TYPE = "Content-type: text/plain;charset=ISO-8859-1";
    private static final String GET_WEATHER_ENDPOINT = "find";
    private static final String LAT = "lat";
    private static final String LON = "lon";
    private static final String CNT = "cnt";
    private static final String UNITS = "units";
    private static final String APPID = "appid";
    private static final String COUNT_VALUE = "10";
    private static final String UNIT_VALUE = "metric";

    public interface WeatherRestService {
        @Headers({HEADER_CONTENT_TYPE})
        @GET(GET_WEATHER_ENDPOINT)
        Call<WeatherResponse> getWeather(@Query(LAT) String lat, @Query(LON) String lon,
                                         @Query(CNT) String cnt, @Query(UNITS) String units,
                                         @Query(APPID) String token);
    }

    private final WeatherRestService weatherRestService;

    public WeatherRequest() {
        weatherRestService = RestServiceProvider.createService(WeatherRestService.class);
    }

    public void getWeatherResponse(Callback<WeatherResponse> callback, String lat, String lon) {
        String token = BuildConfig.TOKEN;
        Call<WeatherResponse> call = weatherRestService.getWeather(lat, lon, COUNT_VALUE,
                UNIT_VALUE, token);
        call.enqueue(callback);
    }
}
