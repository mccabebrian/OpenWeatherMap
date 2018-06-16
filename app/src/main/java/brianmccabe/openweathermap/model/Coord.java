package brianmccabe.openweathermap.model;

/**
 * Created by brian on 16/06/2018.
 */

public class Coord {
    private String lon;

    private String lat;

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }
}
