package Model;

import View.Observer;
import java.util.ArrayList;

public class FridgeModel implements Model, Observable
{
    protected int internalTemperature = 0;
    protected int externalTemperature = 20;
    protected int hygrometry = 30;
    protected boolean stateDoor = false;
    protected int temperature = 20;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    /**
     * Return internal temperature
     */
    public int getInternalTemperature()
    {
        return this.internalTemperature;
    }

    /**
     * Set internal temperature
     * @param internalTemperature
     */
    public void setInternalTemperature(int internalTemperature)
    {
        this.internalTemperature = internalTemperature;
        this.notifyObserver("internalTemperature");
    }

    /**
     * Return external temperature
     */
    public int getExternalTemperature()
    {
        return this.externalTemperature;
    }

    /**
     * Set external temperature
     * @param externalTemperature
     */
    public void setExternalTemperature(int externalTemperature)
    {
        this.externalTemperature = externalTemperature;
        this.notifyObserver("externalTemperature");
    }

    /**
     * Return hygrometry
     */
    public int getHygrometry()
    {
        return this.hygrometry;
    }

    /**
     * Set hygrometry
     * @param hygrometry
     */
    public void setHygrometry(int hygrometry)
    {
        this.hygrometry = hygrometry;
        this.notifyObserver("hygrometry");
    }

    /**
     * Return state door (opened / closed)
     */
    public boolean getStateDoor()
    {
        return this.stateDoor;
    }

    /**
     * Set state door (opened / closed)
     * @param stateDoor
     */
    public void setStateDoor(boolean stateDoor)
    {
        this.stateDoor = stateDoor;
        this.notifyObserver("stateDoor");
    }

    /**
     * Return temperature
     */
    public int getTemperature()
    {
        return this.temperature;
    }

    /**
     * Set temperature
     * @param temperature
     */
    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
        this.notifyObserver("temperature");
    }

    /**
     * Design pattern observer, this method is used to add an observer to the list
     * @param obs
     */
    public void addObserver(Observer obs)
    {
        this.listObserver.add(obs);
    }

    /**
     * Design pattern observer, this method is used to notify observers when an update occurs
     * @param str
     */
    public void notifyObserver(String str)
    {
        for(Observer obs : this.listObserver)
        {
            obs.update(str, this);
        }
    }

    /**
     * Design pattern observer, this method is used to reset the list
     */
    public void removeObserver()
    {
        this.listObserver = new ArrayList<Observer>();
    }
}