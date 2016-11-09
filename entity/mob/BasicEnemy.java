package com.robert.game.entity.mob;

import com.robert.game.Game;
import com.robert.game.graphics.Sprite;

public class BasicEnemy extends Mob
{
	private double xt, yt;
	private double nx, ny, anx, any;
	private int update = 0;
	private int attack_timer = 0;
	private int steps = 0;
	private double d;
	
	public BasicEnemy(int x, int y, Sprite sprite, int health, int damage, 
			int attack_speed, int range, int speed) 
	{
		super(sprite, health, damage, attack_speed, range, speed);
		xt = x;
		yt = y;
		this.x = x;
		this.y = y;
	}

	public void update()
	{
		update++;
		if (update > 60)
			update = 20;
		if (damaged > 0)
			damaged--;
		
		d = distanceToPlayer();
		checkAttack();
		
		if (attack_timer != 0)
			attack_timer--;
		if (d <= range)
		{
			if (attack_timer == 0)
				attack();
		}
		else
		{
			if (update > 19)
				if (d < 700)
					lookForPlayer();
			if (steps > 0)
			{
				xt += nx;
				yt += ny;
				--steps;
				x = (int)xt;
				y = (int)yt;
			}
		}
	}
	
	public void checkAttack()
	{
		double angle = Math.atan2(x - Game.player.x, y - Game.player.y);
		if (Game.player.attacking && d <= Game.player.range)
		{
			if (Game.player.spec == true)
			{
				if (angle >= 0 && angle >= Game.player.hitangle1)
					hit();
				else
					if (angle <= Game.player.hitangle2)
						hit();
			}
			else
				if (angle >= Game.player.hitangle1 && angle <= Game.player.hitangle2)
					hit();
		}
	}
	
	private void lookForPlayer()
	{
		double angle = Math.atan2(Game.player.x - x, Game.player.y - y);
		anx = Math.sin(angle) * speed;
		any = Math.cos(angle) * speed;
		if (checkPath())
		{
			int st = (int)((Game.player.x - x) / nx);
			if (st == 0)
				st = (int)((Game.player.y - y) / ny);
			steps = st;
			ny = any;
			nx = anx;
		}
	}
	
	public void hit()
	{
		health -= Game.player.damage;
		damaged = 5;
		if (health <= 0)
			level.remove(this);
	}
	
	private boolean checkPath()
	{
		double dirX = anx / speed;
		double dirY = any / speed;
		dirX *= 4;
		dirY *= 4;
		//check direct path with speed 4
	
		double xa = x, ya = y;
		int n = (int)((Game.player.x - x) / dirX);
		for (int i = 0; i < n; i++)
		{
			xa += dirX;
			ya += dirY;
			if (level.getTile((int)((xa - 24) / 48), (int)((ya - 24) / 48)).isSolid())
				return false;
			else if (level.getTile((int)((xa - 24) / 48), (int)((ya + 24) / 48)).isSolid())
				     return false;
			else if (level.getTile((int)((xa + 24) / 48), (int)((ya - 24) / 48)).isSolid())
					 return false;
			else if (level.getTile((int)((xa + 24) / 48), (int)((ya + 24) / 48)).isSolid())
				     return false;
		}
		return true;
	}
	
	private double distanceToPlayer()
	{
		double d;
		double x = Game.player.x - this.x;
		double y = Game.player.y - this.y;
		d = Math.sqrt(x * x + y * y);
		return d;
	}
	
	public void attack()
	{
		Game.player.changeHealth(-damage);
		attack_timer = attack_speed;
	}
}
