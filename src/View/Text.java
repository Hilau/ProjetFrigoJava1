package View;

import javax.swing.*;
import java.awt.*;

public class Text extends JPanel implements Component {

	private String text;

	private int x;

	private int y;

	private boolean makeCircle = false;

	private Color color = Color.white;

	private Boolean isDoorOpened = false;

	private Boolean isFilled = true;

	/**
	 * @param text
	 * @param x
	 * @param y
	 */
	public Text(String text, int x, int y)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.setSize(275, 600);
    }

    /**
     * @param x
     * @param y
     */
    public Text(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.makeCircle = true;
        this.setSize(275, 600);
    }

    /**
     * @param text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @param isDoorOpened
     */
    public void setIsDoorOpened(boolean isDoorOpened)
    {
        this.isDoorOpened = isDoorOpened;
    }

    /**
     * This method is called when an instance of this class is created (as a constructor)
     * @param g
     */
    public void paintComponent(Graphics g)
    {
    	if(this.makeCircle)
		{
			if(this.isDoorOpened)
			{
				g.setColor(Color.red);
				g.drawOval(15, 150, 75, 75);

				if(this.isFilled)
				{
					color = Color.white;
					g.setColor(color);
					this.isFilled = false;
				}

				else if(!this.isFilled)
				{
					color = Color.red;
					g.setColor(color);
					this.isFilled = true;
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