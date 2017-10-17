package View;

import javax.swing.*;
import java.awt.*;

public class Text extends JPanel implements Component {

	private String text;

	private int x;

	private int y;

	private boolean makeCircle = false;

	private Color color = Color.white;

	private boolean isFilled = true;

	/**
	 * 
	 * @param text
	 * @param x
	 * @param y
	 */
	public Text(String text, int x, int y, boolean makeCircle)
	{
        this.text = text;
        this.x = x;
        this.y = y;
        this.makeCircle = makeCircle;
        this.setSize(275, 600);
	}

	/**
	 *
	 * @param makeCircle
	 * @param x
	 * @param y
	 */
	public Text(boolean makeCircle, int x, int y)
	{
		this.makeCircle = makeCircle;
		this.x = x;
		this.y = y;
	}

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g)
    {
    	if(this.makeCircle)
		{
			Boolean isDoorOpened = true;

			if(isDoorOpened)
			{
				g.setColor(Color.red);
				g.drawOval(15, 150, 75, 75);

				if(color.equals(Color.red))
				{
					color = Color.white;
					g.setColor(color);
				}

				else if(color.equals(Color.white))
				{
					color = Color.red;
					g.setColor(color);
				}

				g.fillOval(15, 150, 75, 75);
			}

			else
			{
				color = Color.green;
				g.setColor(color);
				g.fillOval(15, 150, 75, 75);
			}
		}

		else
		{
			Font font = new Font("Arial", Font.BOLD, 18);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString(this.text, this.x, this.y);
		}
    }

	public void render()
	{

	}

}