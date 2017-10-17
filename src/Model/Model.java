package Model;

import View.Observer;

public interface Model
{
    /**
     * Return internal temperature
     */
    public int getInternalTemperature();

    /**
     * Set internal temperature
     * @param internalTemperature
     */
    public void setInternalTemperature(int internalTemperature);

    /**
     * Return external temperature
     */
    public int getExternalTemperature();

    /**
     * Set external temperature
     * @param externalTemperature
     */
    public void setExternalTemperature(int externalTemperature);

    /**
     * Return hygrometry
     */
    public int getHygrometry();

    /**
     * Set hygrometry
     * @param hygrometry
     */
    public void setHygrometry(int hygrometry);

    /**
     * Return state door (opened / closed)
     */
    public boolean getStateDoor();

    /**
     * Set state door (opened / closed)
     * @param stateDoor
     */
    public void setStateDoor(boolean stateDoor);

    /**
     * Return temperature
     */
    public int getTemperature();

    /**
     * Set temperature
     * @param temperature
     */
    public void setTemperature(int temperature);

    /**
     * Design pattern observer, this method is used to add an observer to the list
     * @param obs
     */
    public void addObserver(Observer obs);

    /**
     * Design pattern observer, this method is used to notify observers when an update occurs
     * @param str
     */
    public void notifyObserver(String str);

    /**
     * Design pattern observer, this method is used to reset the list
     */
    public void removeObserver();
}