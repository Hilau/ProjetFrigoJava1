package Controler;

import Model.AbstractModel;

public abstract class AbstractControler {

	protected AbstractModel model;

	public abstract void toggleDoor();

	public abstract void updateTemperature();

}