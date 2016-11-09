package com.robert.game.tile;

import com.robert.game.Game;
import com.robert.game.entity.mob.Player;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;
import com.robert.game.sound.PlayList;
import com.robert.game.sound.Sound;

public class LastDiskTile extends Tile
{
	public LastDiskTile(Sprite sprite) 
	{
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen)
	{
		screen.render(x, y, sprite);
		if (Game.disk_count == 4)
			screen.render(x, y, Sprite.disk);
	}
	
	public void Event(Player p)
	{
		if (Game.disk_count == 4)
		{
			Game.won = true;
			PlayList.stop = true;
			PlayList.current_song.stop();
			Sound.songlm.play();
		}
	}
}
