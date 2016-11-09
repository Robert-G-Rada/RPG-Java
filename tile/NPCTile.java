package com.robert.game.tile;

import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;

public class NPCTile extends Tile
{
	public NPCTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.renderNPC(x, y, sprite);
	}
	
	public boolean isSolid()
	{
		return true;
	}
}
