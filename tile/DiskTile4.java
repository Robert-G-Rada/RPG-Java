package com.robert.game.tile;

import com.robert.game.Game;
import com.robert.game.entity.mob.Player;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;
import com.robert.game.sound.PlayList;
import com.robert.game.sound.Sound;

public class DiskTile4 extends Tile
{
	private boolean disk;
	
	public DiskTile4(Sprite sprite) 
	{
		super(sprite);
		disk = true;
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.render(x, y, sprite);
		if (disk)
			screen.render(x, y, Sprite.disk);
	}
	
	public void Event(Player p)
	{
		if (disk)
		{
			Game.disk_count++;
			Game.disks[3] = true;
			disk = false;
			
			PlayList.playlist.add(Sound.song5);
		}
	}
}
