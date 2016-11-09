package com.robert.game.sound;

import java.util.ArrayList;
import java.util.List;

public class PlayList 
{
	private static int updates = 0;
	public static Sound current_song;
	public static boolean stop = false;
	
	public static int song_nr;
	public static List<Sound> playlist = new ArrayList<Sound>();
	
	public static void add(Sound s)
	{
		playlist.add(s);
	}
	
	public static void update()
	{
		if (!stop)
		{
			if (current_song != null)
			{
				updates++;	
				if (updates > current_song.lenght)
					next();
			}
			else
				if (playlist.size() > 0)
				{
					current_song = playlist.get(0);
					current_song.play();
					song_nr = 0;
				}
		}
	}
	
	public static void next()
	{
		if (current_song != null)
		{
			current_song.stop();
			song_nr++;
			if (song_nr == playlist.size())
				song_nr= 0;
			current_song = playlist.get(song_nr);
			current_song.play();
			updates = 0;	
		}
	}
	
	public static void prev()
	{
		if (current_song != null)
		{
			current_song.stop();
			song_nr--;
			if (song_nr == 0)
				song_nr = playlist.size() - 1;
			current_song = playlist.get(song_nr);
			current_song.play();
			updates = 0;	
		}
	}
}
