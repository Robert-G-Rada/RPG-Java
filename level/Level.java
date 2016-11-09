package com.robert.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.robert.game.entity.Entity;
import com.robert.game.entity.NPC;
import com.robert.game.entity.mob.BasicEnemy;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;
import com.robert.game.tile.Tile;

public class Level 
{
	protected int[] tiles;
	protected int width, height;
	public NPC npc;
	
	public static int zoom = 48;
	
	public static Level[] levels = new Level[5];
	public static Level level0 = new Level("/level.png");
	public static Level level1 = new Level("/level1.png");
	public static Level level2 = new Level("/level2.png");
	public static Level level3 = new Level("/level3.png");
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Level(String path)
	{
		loadLevel(path);
	}
	
	private void loadLevel(String path)
	{
		try 
		{
			BufferedImage image = ImageIO.read(Level.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
			spawn();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		for(int i = 0; i < entities.size(); i++)
		{
			entities.get(i).update();
		}
		if (npc != null)
			npc.update();
	}
	
	public void npcUpdate(Screen screen)
	{
		if (npc != null)
			npc.update(screen);
	}
	
	public void remove(Entity e)
	{
		entities.remove(e);
	}
	
	public void render(int xScroll, int yScroll, Screen screen)
	{
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll / zoom;
		int x1 = (xScroll + screen.height) / zoom;
		int y0 = yScroll / zoom;
		int y1 = (yScroll + screen.width) / zoom;
		++x1;
		++y1;
		
		for (int i = x0; i < x1; i++)
		{
			for (int j = y0; j < y1; j++)
			{
				getTile(i, j).render(i * zoom, j * zoom, screen);
			}
		}
		
		for (int i = 0; i < entities.size(); i++)
			entities.get(i).render(screen);
	}
	
	public Tile getTile(int x, int y)
	{
		if (x < 0 || x >= height || y < 0 || y >= width)
			return Tile.voidTile;
		if (tiles[x * width + y] == 0xff404040)
			return Tile.wall;
		if (tiles[x * width + y] == 0xff00ff00)
			return Tile.grass;
		
		if (tiles[x * width + y] == Tile.col_road)
			return Tile.road;
		if (tiles[x * width + y] == Tile.col_block)
			return Tile.block;
		if (tiles[x * width + y] == Tile.col_border)
			return Tile.border;
		if (tiles[x * width + y] == Tile.col_building)
			return Tile.building;
		if (tiles[x * width + y] == Tile.col_house)
			return Tile.house;
		if (tiles[x * width + y] == Tile.col_idk)
			return Tile.idk;
		if (tiles[x * width + y] == Tile.col_sidewalk)
			return Tile.sidewalk;
		if (tiles[x * width + y] == Tile.col_RoInTile)
			return Tile.RoInTile;
		if (tiles[x * width + y] == Tile.col_RoOutTile)
			return Tile.RoOutTile;
		if (tiles[x * width + y] == Tile.col_RaInTile)
			return Tile.RaInTile;
		if (tiles[x * width + y] == Tile.col_RaOutTile)
			return Tile.RaOutTile;
		if (tiles[x * width + y] == Tile.col_AInTile)
			return Tile.AInTile;
		if (tiles[x * width + y] == Tile.col_AOutTile)
			return Tile.AOutTile;
		if (tiles[x * width + y] == Tile.col_outWall)
			return Tile.outWall;
		if (tiles[x * width + y] == Tile.col_guta1)
			return Tile.guta1;
		if (tiles[x * width + y] == Tile.col_guta2)
			return Tile.guta2;
		if (tiles[x * width + y] == Tile.col_guta3)
			return Tile.guta3;
		if (tiles[x * width + y] == Tile.col_guta4)
			return Tile.guta4;
		if (tiles[x * width + y] == Tile.col_guta5)
			return Tile.guta5;
		if (tiles[x * width + y] == Tile.col_guta6)
			return Tile.guta6;
		if (tiles[x * width + y] == Tile.col_guta7)
			return Tile.guta7;
		if (tiles[x * width + y] == Tile.col_guta8)
			return Tile.guta8;
		if (tiles[x * width + y] == Tile.col_disk1)
			return Tile.disk1;
		if (tiles[x * width + y] == Tile.col_floor)
			return Tile.floor;
		if (tiles[x * width + y] == Tile.col_house_wall)
			return Tile.house_wall;
		if (tiles[x * width + y] == Tile.col_door)
			return Tile.door;
		if (tiles[x * width + y] == Tile.col_block_wall)
			return Tile.block_wall;
		if (tiles[x * width + y] == Tile.col_disk2)
			return Tile.disk2;
		if (tiles[x * width + y] == Tile.col_disk3)
			return Tile.disk3;
		if (tiles[x * width + y] == Tile.col_disk4)
			return Tile.disk4;
		if (tiles[x * width + y] == Tile.col_loc_1)
			return Tile.loc_1;
		if (tiles[x * width + y] == Tile.col_loc_2)
			return Tile.loc_2;
		if (tiles[x * width + y] == Tile.col_loc_3)
			return Tile.loc_3;
		if (tiles[x * width + y] == Tile.col_robert1)
			return Tile.robert1;
		if (tiles[x * width + y] == Tile.col_robert2)
			return Tile.robert2;
		if (tiles[x * width + y] == Tile.col_andrei1)
			return Tile.andrei1;
		if (tiles[x * width + y] == Tile.col_andrei2)
			return Tile.andrei2;
		if (tiles[x * width + y] == Tile.col_lastdisk)
			return Tile.lastdisk;
		
		
		return Tile.voidTile;
	}
	
	public void add(Entity e)
	{
		entities.add(e);
		e.level = this;
	}
	
	private void spawn()
	{
		spawnEnemy(40, 79);
		spawnEnemy(40, 81);
		
		spawnEnemy(104, 152);
		spawnEnemy(104, 155);
		spawnEnemy(104, 158);
		spawnEnemy(104, 161);
		spawnEnemy(106, 152);
		spawnEnemy(106, 155);
		spawnEnemy(106, 158);
		spawnEnemy(106, 161);
		spawnEnemy(108, 152);
		spawnEnemy(108, 155);
		spawnEnemy(108, 158);
		spawnEnemy(108, 161);
		spawnEnemy(110, 152);
		spawnEnemy(110, 155);
		spawnEnemy(110, 158);
		spawnEnemy(110, 161);
		
		spawnEnemy(18, 112);
		spawnEnemy(18, 115);
		spawnEnemy(18, 118);
		spawnEnemy(18, 121);
		spawnEnemy(20, 112);
		spawnEnemy(20, 115);
		spawnEnemy(20, 118);
		spawnEnemy(20, 121);
		
		spawnEnemy(79, 17);
		spawnEnemy(79, 20);
		spawnEnemy(79, 23);
		spawnEnemy(79, 26);
		spawnEnemy(82, 17);
		spawnEnemy(82, 20);
		spawnEnemy(82, 23);
		spawnEnemy(82, 26);
		spawnEnemy(85, 17);
		spawnEnemy(85, 20);
		spawnEnemy(85, 23);
		spawnEnemy(85, 26);
		
	}
	
	private void spawnEnemy(int x, int y)
	{
		add(new BasicEnemy(x*48, y*48, Sprite.enemy, 100, 50, 60, 100, 5));
	}
	
}
