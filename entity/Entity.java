package com.robert.game.entity;

import com.robert.game.graphics.Screen;
import com.robert.game.level.Level;

public class Entity 
{
	public int x, y;
	public Level level;
	protected boolean removed = false;
	
	public void render(Screen screen)
	{
	}
	
	public void update()
	{
	}
	
	public boolean isRemoved()
	{
		return removed;
	}
	
	public void remove()
	{
		removed = true;
	}
	
	public void init(Level level)
	{
		this.level = level;
	}
	
}
