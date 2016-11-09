package com.robert.game.tile;

import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;

public class NonSolidTile extends Tile
{

	public NonSolidTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.render(x, y, sprite);
	}

}
