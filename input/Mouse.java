package com.robert.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	public static boolean click = false;
	
	public static int getX()
	{
		return mouseX;
	}
	
	public static int getY()
	{
		return mouseY;
	}
	
	public static int getB()
	{
		return mouseB;
	}
	
	public void mouseDragged(MouseEvent arg0) 
	{		
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	public void mouseMoved(MouseEvent arg0) 
	{
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	public void mouseClicked(MouseEvent arg0) 
	{
	}

	public void mouseEntered(MouseEvent arg0) 
	{
	}

	public void mouseExited(MouseEvent arg0) 
	{
	}

	public void mousePressed(MouseEvent arg0) 
	{
		int c = arg0.getButton();
		if (c == 1 && mouseB != 1)
			click = true;
		mouseB = c;
	}

	public void mouseReleased(MouseEvent arg0) 
	{
		mouseB = -1;
	}

}
