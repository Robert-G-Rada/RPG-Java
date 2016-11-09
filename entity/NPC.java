package com.robert.game.entity;

import com.robert.game.graphics.Screen;

public class NPC extends Entity
{
	private	int show_text;
	private String text;
	private int tx, ty;
    
    public NPC(String text, int tx, int ty)
    {
		this.text = text = "KAPPA";
		this.tx = tx;
		this.ty = ty;
		show_text = 0;
    }
    
	public void mouseEvent()
	{
		show_text = 180;
	}
	
	public void update(Screen screen)
	{
		if (show_text > 0)
		{
			show_text--;
			screen.renderText((x-tx) * 48, y * 48, tx, ty, text);
		}
	}
}
