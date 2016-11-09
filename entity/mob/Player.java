package com.robert.game.entity.mob;

import com.robert.game.Game;
import com.robert.game.graphics.Sprite;
import com.robert.game.input.Keyboard;
import com.robert.game.input.Mouse;
import com.robert.game.sound.Sound;

public class Player extends Mob
{
	private Keyboard input;
	private int attack_timer = 0;
	private int heal_timer = 0;
	public boolean attacking = false;
	public double angle = 0;
	public double hitangle1, hitangle2;
	public boolean spec;
	public boolean talk = false;
	
	public Player(int x, int y, Keyboard input, Sprite sprite, int health, 
			int damage, int attack_speed, int range, int speed) 
	{
		super(sprite, health, damage, attack_speed, range, speed);
		this.input = input;
		this.x = x;
		this.y = y;
	}
		
	public void update()
	{
		if (health <= 0)
		{
			Game.dead = true;
		}
		
		if (heal_timer > 0)
			heal_timer--;
		if (health < max_health && heal_timer == 0)
		{
			heal_timer = 5;
			health++;
		}
		
		int xa = 0, ya = 0;
		if (input.up)
			xa -= speed;
		if (input.down)
			xa += speed;
		if (input.left)
			ya -= speed;
		if (input.right)
			ya += speed;
		
		level.getTile(x/48, y/48).Event(this);
		
		talk = false;
		if (Mouse.click)
		{
			Mouse.click = false;
			int mx = Mouse.getY();
			int my = Mouse.getX();
			mx += x - Game.getWindowHeight() / 2;
			my += y - Game.getWindowWidth() / 2;
			int n = 1;
			if (Game.current_level == 3)
				n = 2;
			int lx = level.npc.x * 48;
			int ly = level.npc.y * 48;
			if (mx >= lx && mx <= lx + 96 * n 
					&& my >= ly && my <= ly + 48 * n)
			{
				talk = true;
				level.npc.mouseEvent();
			}
		}
		
		attacking = false;
		if (attack_timer == 0)
		{
			if (Mouse.getB() == 1)
			{
				int mx = Mouse.getY();
				int my = Mouse.getX();
				mx += x - Game.getWindowHeight() / 2;
				my += y - Game.getWindowWidth() / 2;
				int n = 1;
				if (Game.current_level == 3)
					n = 2;
				int lx = level.npc.x * 48;
				int ly = level.npc.y * 48;
				if (!(mx >= lx && mx <= lx + 96 * n 
					&& my >= ly && my <= ly + 48 * n))
					attack();
			}
		}
		else attack_timer--;

		move(xa, ya);
	}
	
	private void attack()
	{
		Sound.hit.play();
		attacking = true;
		attack_timer = attack_speed;
		angle = Math.atan2(Mouse.getY() - Game.getWindowHeight()/2, Mouse.getX() - Game.getWindowWidth()/2);
		
		hitangle1 = angle - Math.PI / 4;
		spec = false;
		if (hitangle1 < -Math.PI)
		{
			hitangle1 = 2 * Math.PI + hitangle1;
			spec = true;
		}
		hitangle2 = angle + Math.PI / 4;
		if (hitangle2 > Math.PI)
		{
			hitangle2 -= 2 * Math.PI;
			spec = true;
		}
		
	}
	
	public boolean getB()
	{
		return input.space;
	}
}
