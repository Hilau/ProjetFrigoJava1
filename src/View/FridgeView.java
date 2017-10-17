package View;

import Controler.AbstractControler;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

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

	private void initComponent()
    {
        this.componentInternalTemperature = new Text("Internal temperature : 20°C", 20, 40, false);
        this.componentExternalTemperature = new Text("External temperature : 25°C", 20,70, false);
        this.componentHygrometry = new Text("Hygrometry : 30%", 20, 100, false);
        this.componentBtnOnOff = new Button("On / Off", 425, 20);
        this.componentBtnOpenDoor = new Button("<html>Open / close <br /> the door</html>", 425, 75);
        this.componentStateDoor = new Text("", 20, 150, true);

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