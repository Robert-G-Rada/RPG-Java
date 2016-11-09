package com.robert.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.robert.game.entity.NPC;
import com.robert.game.entity.mob.Player;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;
import com.robert.game.input.Keyboard;
import com.robert.game.input.Mouse;
import com.robert.game.level.Level;
import com.robert.game.sound.PlayList;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static int current_level;
	public static String title = "Game";
	private static int width = 1280;
	private static int height = 720;
	public static Player player;
	public static int disk_count;
	public static boolean[] disks;
	public static boolean paused;
	public static boolean dead;
	public static boolean won;
	
	private JFrame frame;
	private Thread thread;
	private Screen screen;
	private Keyboard key;
	private Level[] level;
	public boolean running = false;
    
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private BufferedImage map_image = new BufferedImage(230, 180, BufferedImage.TYPE_INT_RGB);
	private int[] map_pixels = ((DataBufferInt)map_image.getRaster().getDataBuffer()).getData();

	private BufferedImage dead_image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
	private int[] dead_pixels = ((DataBufferInt)dead_image.getRaster().getDataBuffer()).getData();
	
	private BufferedImage won_image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
	private int[] won_pixels = ((DataBufferInt)won_image.getRaster().getDataBuffer()).getData();
	
	public Game()
	{
		Dimension size = new Dimension(1280, 720);
		setPreferredSize(size);
		
		dead = false;
		won = false;
		disk_count = 0;
		disks = new boolean[5];
		disks[0] = disks[1] = disks[2] = disks[3] = disks[4] = false;
		
		for (int i = 0; i < dead_pixels.length; i++)
			dead_pixels[i] = Sprite.dead.pixels[i];
		
		for (int i = 0; i < won_pixels.length; i++)
			won_pixels[i] = Sprite.won.pixels[i];
		
		key = new Keyboard();
		frame = new JFrame();
		screen = new Screen(width, height);
		
		levelInit();
		player.init(level[current_level]);
		addKeyListener(key);
		
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	private void levelInit()
	{
		level = new Level[5];
		current_level = 3;
		level[0] = Level.level0;
		level[1] = Level.level1;
		level[2] = Level.level2;
		level[3] = Level.level3;
		player = new Player(18 * Level.zoom, 15 * Level.zoom, key, Sprite.player, 1000, 50, 20, 150, 5);
		
		level[3].npc = new NPC("KAPPA", 1, 5);
		level[3].npc.x = 5;
		level[3].npc.y = 9;
		
		level[0].npc = new NPC("KAPPA", 1, 5);
		level[0].npc.x = -6;
		level[0].npc.y = -6;
		
		level[1].npc = new NPC("KAPPA", 1, 5);
		level[1].npc.x = 2;
		level[1].npc.y = 15;
		
		level[2].npc = new NPC("KAPPA", 1, 5);
		level[2].npc.x = 5;
		level[2].npc.y = 4;
	}
	
	public static int getWindowWidth()
	{
		return width;
	}
	
	public static int getWindowHeight()
	{
		return height;
	}
	
	public void run()
	{
		long updateTime = 0;
		long renderTime = 0;
		
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		final double ns = 1000000000.0 / 60.0;
		int updates = 0, frames = 0;
		
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			while (delta >= 1)
			{
				delta--;
				update();
				updates++;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer >= 1000)
			{
				frame.setTitle(title + "    ups: " + updates + ", fps: " + frames);
				
				System.out.println("update: " + updateTime + " ns   render: " + renderTime / frames + " ns");
				
				updates = frames = 0;
				timer = System.currentTimeMillis();
				
				updateTime = 0;
				renderTime = 0;
			}
			lastTime = now;
		}
	}
	
	public void update()
	{
		key.update();
		if (paused == false && dead == false && won == false)
		{
			player.update();
			level[current_level].update();
			PlayList.update();
		}
	}

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}   
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(getImage(), 0, 0, width, height, null);
		g.dispose();
		
		
		bs.show();
	}
	

	public BufferedImage getImage()
	{
		if (dead == true)
		{
			return dead_image;
		}
		else
			if (won == true)
			{
				return won_image;
			}
			else
			{
				if (paused == false)
				{
					screen.clear();
					level[current_level].render(player.x - height/2, player.y - width/2, screen);
					player.render(screen);
			        level[current_level].npcUpdate(screen);
					for (int i = 0; i < pixels.length; i++)
						pixels[i] = screen.pixels[i];
					
					return image;
				}
				else
				{
					int x = 0;
					int y = 0;
					if (current_level == 0) {x = player.x / 48; y = player.y / 48;}
					else if (current_level == 1){x = 155; y = 73;}
					else if (current_level == 2){x = 80; y = 190;}
					else if (current_level == 3){x = 33; y = 79;}
					for (int i = 0; i < map_pixels.length; i++)
						map_pixels[i] = Sprite.map.pixels[i];
					map_pixels[x * 230 + y] = 0xff0000;
					map_pixels[x * 230 + y+1] = 0xff0000;
					x++;
					map_pixels[x * 230 + y] = 0xff0000;
					map_pixels[x * 230 + y+1] = 0xff0000;
					
					return map_image;
				}
			}
	}
	
	public BufferedImage getConvertedImage()
	{
		if (dead == true)
		{
			return dead_image;
		}
		else
			if (won == true)
			{
				return won_image;
			}
			else
			{
				if (paused == false)
				{
					screen.clear();
					level[current_level].render(player.x - height/2, player.y - width/2, screen);
					player.render(screen);
			        level[current_level].npcUpdate(screen);
					for (int i = 0; i < pixels.length; i++)
						pixels[i] = screen.pixels[i];
					
					return image;
				}
				else
				{
					int x = 0;
					int y = 0;
					if (current_level == 0) {x = player.x / 48; y = player.y / 48;}
					else if (current_level == 1){x = 155; y = 73;}
					else if (current_level == 2){x = 80; y = 190;}
					else if (current_level == 3){x = 33; y = 79;}
					for (int i = 0; i < map_pixels.length; i++)
						map_pixels[i] = Sprite.map.pixels[i];
					map_pixels[x * 230 + y] = 0xff0000;
					map_pixels[x * 230 + y+1] = 0xff0000;
					x++;
					map_pixels[x * 230 + y] = 0xff0000;
					map_pixels[x * 230 + y+1] = 0xff0000;
					
					return map_image;
				}
			}
	}
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop()
	{
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		
		game.frame.setResizable(false);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
}
