package View;

import Controler.AbstractControler;

import Model.Model;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FridgeView extends JFrame implements Observer
{
	public JPanel componentContainer ;
	public Text componentInternalTemperature;
	public Text componentExternalTemperature;
	public Text componentHygrometry;
	public JPanel componentUpdateTemperature;
	public Text componentStateDoor;
	public JButton componentBtnOnOff;
	public JButton componentBtnOpenDoor;

	private AbstractControler controler;

    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    private static final int MINIMUM = 0;

    private static final int MAXIMUM = 100;

    /**
     * Constructor of the class which initialize and create a new frame
     * @param controler
     */
	public FridgeView(AbstractControler controler)
	{
        this.setTitle("Graphic Interface");
        this.setSize(600,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.initComponent();
        this.controler = controler;
        this.setVisible(true);
        service.scheduleAtFixedRate(new Runnable()
        {
            public void run()
            {
                componentContainer.repaint();
            }
        }, 0, 1, TimeUnit.SECONDS);
	}

    /**
     * This method is used to initialize component on the frame
     */
	private void initComponent()
    {
        this.componentInternalTemperature = new Text("Internal temperature : 20°C", 20, 40);
        this.componentExternalTemperature = new Text("External temperature : 25°C", 20,70);
        this.componentHygrometry = new Text("Hygrometry : 30%", 20, 100);
        this.componentBtnOnOff = new Button("On / Off", 425, 20);
        this.componentBtnOpenDoor = new Button("<html>Open / close <br /> the door</html>", 425, 75);
        this.componentStateDoor = new Text(20, 150);

        this.componentContainer = new JPanel();
        this.componentContainer.setLayout(null);
        this.componentContainer.add(this.componentInternalTemperature);
        this.componentContainer.add(this.componentExternalTemperature);
        this.componentContainer.add(this.componentHygrometry);
        this.componentContainer.add(this.componentBtnOnOff);
        this.componentContainer.add(this.componentBtnOpenDoor);
        this.componentContainer.add(this.componentStateDoor);
        this.setContentPane(this.componentContainer);
    }


    /**
     * This method is used with the design pattern observer and will be call each time a value is updated
     * @param str
     * @param model
     */
    public void update(String str, Model model)
    {
        switch(str)
        {
            case "internalTemperature":
                this.componentInternalTemperature.setText("Internal temperature : " + model.getInternalTemperature() + " °C");
                break;

            case "externalTemperature":
                this.componentExternalTemperature.setText("External temperature : " + model.getExternalTemperature() + " °C");
                break;

            case "hygrometry":
                this.componentHygrometry.setText("Hygrometry : " + model.getHygrometry() + "%");
                break;

            case "stateDoor":
                this.componentStateDoor.setIsDoorOpened(model.getStateDoor());
                break;
        }
    }
}