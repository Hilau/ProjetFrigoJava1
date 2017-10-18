package Controler;

import Model.Model;

public abstract class AbstractControler {

	public Model model;

	public abstract void toggleDoor() throws InterruptedException;

	public abstract void updateTemperature();

}