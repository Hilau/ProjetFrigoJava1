import Controler.FridgeControler;
import View.FridgeView;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
        FridgeControler ctrl = new FridgeControler();
		FridgeView view = new FridgeView(ctrl);
		ctrl.model.addObserver(view);
	}
}