package com.robert.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet 
{
	public final int SIZE;
	public int[] pixels;
	private String path;
	
	public static SpriteSheet sheet = new SpriteSheet("/sheet1.png", 480);
	public static SpriteSheet alphabet = new SpriteSheet("/alphabet.png", 120);
	public static SpriteSheet map = new SpriteSheet("/level.png", 230);
	public static SpriteSheet dead = new SpriteSheet("/deadlol.png", 1280);
	public static SpriteSheet won = new SpriteSheet("/won.png", 1280);
	
	public SpriteSheet(String path, int size)
	{
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	private void load()
	{
		try
		{
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
