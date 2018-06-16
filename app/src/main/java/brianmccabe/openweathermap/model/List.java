package brianmccabe.openweathermap.model;

/**
 * Created by brian on 16/06/2018.
 */

public class List {
    private Clouds clouds;

    private String dt;

    private Coord coord;

    private String id;

    private Wind wind;

    private Sys sys;

    private String snow;

    private String name;

    private Weather[] weather;

    private String rain;

    private Main main;

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public String getSnow ()
    {
        return snow;
    }

    public void setSnow (String snow)
    {
        this.snow = snow;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public String getRain ()
    {
        return rain;
    }

    public void setRain (String rain)
    {
        this.rain = rain;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }
}
