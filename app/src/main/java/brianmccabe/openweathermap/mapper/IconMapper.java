package brianmccabe.openweathermap.mapper;

import brianmccabe.openweathermap.R;

/**
 * Created by brian on 16/06/2018.
 */

public class IconMapper {
    public static int getImageFromIcon(String icon) {
        int image;
        switch (icon) {
            case "01d": image = R.drawable.clear_sky;
                break;
            case "01n": image = R.drawable.clear_sky_night;
                break;
            case "02d": image = R.drawable.few_clouds;
                break;
            case "02n": image = R.drawable.few_clouds_night;
                break;
            case "03d": image = R.drawable.scattered_clouds;
                break;
            case "03n": image = R.drawable.scattered_clouds_night;
                break;
            case "04d": image = R.drawable.broken_clouds;
                break;
            case "04n": image = R.drawable.broken_clouds_night;
                break;
            case "09d": image = R.drawable.shower_rain;
                break;
            case "09n": image = R.drawable.shower_rain_night;
                break;
            case "10d": image = R.drawable.rain;
                break;
            case "10n": image = R.drawable.rain_night;
                break;
            case "11d": image = R.drawable.thunderstorm;
                break;
            case "11n": image = R.drawable.thunderstorm_night;
                break;
            case "13d": image = R.drawable.snow;
                break;
            case "13n": image = R.drawable.snow_night;
                break;
            case "50d": image = R.drawable.mist;
                break;
            case "50n": image = R.drawable.mist;
                break;
            default: image = R.drawable.clear_sky;
                break;
        }
        return image;
    }
}
