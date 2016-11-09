package com.robert.game.tile;

import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;

public class SolidTile extends Tile
{

	public SolidTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.render(x, y, sprite);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}
