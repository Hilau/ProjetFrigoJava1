package View;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JButton implements MouseListener, Component {

	private String label;

	/**
	 * 
	 * @param label
     * @param x
     * @param y
	 */
	public Button(String label, int x, int y)
	{
        this.label = label;
        this.setText(label);
        this.setBounds(x, y,150,45);
	}

    /**
	 * 
	 * @param event
	 */
	public void mouseClicked(MouseEvent event)
	{

	}

	/**
	 * 
	 * @param event
	 */
	public void mouseEntered(MouseEvent event)
	{

	}

	/**
	 * 
	 * @param event
	 */
	public void mouseExited(MouseEvent event)
	{

	}

	/**
	 * 
	 * @param event
	 */
	public void mousePressed(MouseEvent event)
	{

	}

	/**
	 * 
	 * @param event
	 */
	public void mouseReleased(MouseEvent event)
	{

	}

	public void render()
	{

	}

}