package com.robert.game.tile;

import com.robert.game.Game;
import com.robert.game.entity.mob.Player;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;
import com.robert.game.level.Level;

public class RaduOutTile extends Tile
{
	public RaduOutTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.render(x, y, sprite);
	}
	
	public void Event(Player p)
	{
		if (p.getB())
		{
			Game.current_level = 0;
			p.level = Level.level0;
			p.x = 48 * 34;
			p.y = 48 * 79;
		}
	}
}
