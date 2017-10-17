package Controler;

import Model.Model;

public abstract class AbstractControler {

	public Model model;

	public abstract void toggleDoor();

	public abstract void updateTemperature();

}