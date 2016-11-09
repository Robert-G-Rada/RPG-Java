package com.robert.game.entity.mob;

import com.robert.game.entity.Entity;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;

public abstract class Mob extends Entity
{
	protected Sprite sprite;
	protected int health;
	protected final int max_health;
	protected int damage, attack_speed, range, speed;
	protected int damaged;
	
	public Mob(Sprite sprite, int health, int damage, int attack_speed, int range, int speed)
	{
		this.sprite = sprite;
		this.health = health;
		this.max_health = health;
		this.damage = damage;
		this.attack_speed = attack_speed;
		this.range = range;
		this.speed = speed;
	}
	
	public void render(Screen screen)
	{
		if (damaged > 0)
			screen.renderDamaged(x - sprite.xSIZE + 24, y - sprite.ySIZE/2, sprite);
		else
			screen.render(x - sprite.xSIZE + 24, y - sprite.ySIZE/2, sprite);
		screen.renderHealthBar(x - sprite.xSIZE, y - sprite.ySIZE/2, (double)health/max_health, sprite.ySIZE);
	}
	
	public void update()
	{
		
	}
	
	protected void move(int xa, int ya)
	{
		if (!Xcollision(xa))
			x += xa;
		if (!Ycollision(ya))
			y += ya;
	}

	public void changeHealth(int x)
	{
		health += x;
		if (health <= 0)
			removed = true;
	}
	
	/*
	private boolean Xcollision(int xa)
	{
		boolean collide = false;
		while (xa != 0 && !collide)
		{
			if (xa > 0)
			{
				collide = level.getTile((x + 28) / 48, (y + 23) / 48).isSolid() 
						|| level.getTile((x + 28) / 48, (y - 23) / 48).isSolid();	
				xa--;	
			}
			else
				if (xa < 0)
				{
					collide = level.getTile((x - 28) / 48, (y + 23) / 48).isSolid() 
							|| level.getTile((x - 28) / 48, (y - 23) / 48).isSolid();
					xa++;		
				}	
		}
		
		return collide;
	}
	
	private boolean Ycollision(int ya)
	{
		boolean collide = false;
		while (ya != 0 && !collide)
		{
			if (ya > 0)
			{
				collide = level.getTile((x + 23) / 48, (y + 28) / 48).isSolid() 
						|| level.getTile((x - 23) / 48, (y + 28) / 48).isSolid();
				ya--;	
			}
			else
				if (ya < 0)
				{
					collide = level.getTile((x + 23) / 48, (y - 28) / 48).isSolid() 
							|| level.getTile((x - 23) / 48, (y - 28) / 48).isSolid();
					ya++;	
				}
		}
		return collide;
	}
	
	*/
	
	
	private boolean Xcollision(int xa)
	{
		boolean collide = false;
		if (xa > 0)
			collide = level.getTile((x + xa + 20) / 48, (y + 20) / 48).isSolid() 
			|| level.getTile((x + xa + 20) / 48, (y - 20) / 48).isSolid();	
		else
			if (xa < 0)
				collide = level.getTile((x + xa - 20) / 48, (y + 20) / 48).isSolid() 
				|| level.getTile((x + xa - 20) / 48, (y - 20) / 48).isSolid();
		
		return collide;
	}
	
	private boolean Ycollision(int ya)
	{
		boolean collide = false;
		if (ya > 0)
			collide = level.getTile((x + 20) / 48, (y + ya + 20) / 48).isSolid() 
			|| level.getTile((x - 20) / 48, (y + ya + 20) / 48).isSolid();
		else
			if (ya < 0)
				collide = level.getTile((x + 20) / 48, (y + ya - 20) / 48).isSolid() 
				|| level.getTile((x - 20) / 48, (y + ya - 20) / 48).isSolid();
		return collide;
	}
	
}
