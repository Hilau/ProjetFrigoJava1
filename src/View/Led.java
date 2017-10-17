package View;

import javax.swing.*;
import java.awt.*;

public class Led extends JPanel implements Component {

	/**
	 *
	 * @param g
	 */
	public void paintComponent(Graphics g)
	{
        g.setColor(Color.green);
        g.fillOval(150, 250, 75, 75);
	}

	public void render()
	{

	}

}