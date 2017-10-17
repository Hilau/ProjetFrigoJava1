package View;

import Controler.AbstractControler;

import javax.swing.*;

public class FridgeView extends JFrame implements Observer {

	public JPanel componentContainer ;
	public JPanel componentInternalTemperature;
	public JPanel componentExternalTemperature;
	public JPanel componentHygrometry;
	public JPanel componentUpdateTemperature;
	public JPanel componentStateDoor;
	public Button componentBtnOnOff;
	public JButton componentBtnOpenDoor;

	private AbstractControler controler;

	public FridgeView(AbstractControler controler)
	{
        this.setTitle("Graphic Interface");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.initComponent();
        this.controler = controler;
        this.setLayout(null);
        this.setVisible(true);
	}

	private void initComponent()
    {
        this.componentInternalTemperature = new Text("Internal temperature : 20°C", 20, 40);
        this.componentExternalTemperature = new Text("External temperature : 25°C", 20,70);
        this.componentHygrometry = new Text("Hygrometry : 30%", 20, 100);
        this.componentBtnOnOff = new Button("On / Off", 425, 20);
        this.componentBtnOpenDoor = new Button("<html>Open / close <br /> the door</html>", 425, 75);
        //this.componentStateDoor = new Led();

        // LED ne s'affiche pas

        this.componentContainer = new JPanel();
        this.componentContainer.setLayout(null);
        this.componentContainer.add(this.componentInternalTemperature);
        this.componentContainer.add(this.componentExternalTemperature);
        this.componentContainer.add(this.componentHygrometry);
        this.componentContainer.add(this.componentBtnOnOff);
        this.componentContainer.add(this.componentBtnOpenDoor);
        //this.componentContainer.add(this.componentStateDoor);
        this.setContentPane(this.componentContainer);
    }

	/**
	 * 
	 * @param typeComponent
	 */
	private void addComponent(String typeComponent)
	{

	}

    public void update(String str)
    {

    }
}