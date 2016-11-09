package com.robert.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.robert.game.Game;
import com.robert.game.sound.PlayList;

public class Keyboard implements KeyListener
{
	private boolean[] keys = new boolean[120];
	public boolean up, left, right, down, space, map;
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];
	}
	
	public void keyPressed(KeyEvent e)
	{
		int k = e.getKeyCode();
	    if (k == KeyEvent.VK_E && keys[KeyEvent.VK_E] == false)
	    	PlayList.next();
	    if (k == KeyEvent.VK_Q && keys[KeyEvent.VK_Q] == false)
	    	PlayList.prev();
	    if (k == KeyEvent.VK_M && keys[KeyEvent.VK_M] == false)
	    {
	    	if (Game.paused == true)
	    		Game.paused = false;
	    	else
	    		Game.paused = true;
	    }
		
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) 
	{
	}

}
