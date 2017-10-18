package Model;

import java.sql.Timestamp;

public class Requests
{
    private int id;
    private int temperature;
    private int hygrometry;
    private int time;

    public int getId()
    {
        return this.id;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public int getHygrometry()
    {
        return this.hygrometry;
    }

    public void setHygrometry(int hygrometry)
    {
        this.hygrometry = hygrometry;
    }

    public int getTime()
    {
        return this.time;
    }

    public String selectAll()
    {
        return "SELECT * FROM fridgeinformations;";
    }

    public String selectLast()
    {
        return "SELECT * FROM fridgeinformations ORDER BY id DESC LIMIT 1;";
    }

    public String insert()
    {
        return "INSERT INTO fridgeinformations (temperature, hygrometry, time) " +
                "VALUES (" + this.temperature + ", " + this.hygrometry + ", " + new Timestamp(System.currentTimeMillis()).getTime() + ");";
    }
}
