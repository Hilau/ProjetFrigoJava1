package View;

import javax.swing.*;
import java.awt.*;

public class Text extends JPanel implements Component {

	private String text;

	private int x;

	private int y;

	/**
	 * 
	 * @param text
	 */
	public Text(String text, int x, int y)
	{
        this.text = text;
        this.x = x;
        this.y = y;
        this.setSize(275, 600);
	}

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        Font font = new Font("Arial", Font.BOLD, 18);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString(this.text, this.x, this.y);
    }

	public void render()
	{

	}

}