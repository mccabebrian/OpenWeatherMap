package brianmccabe.openweathermap.model;

/**
 * Created by brian on 16/06/2018.
 */

public class WeatherResponse {
    private String message;

    private String count;

    private String cod;

    private List[] list;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public List[] getList ()
    {
        return list;
    }

    public void setList (List[] list)
    {
        this.list = list;
    }
}
