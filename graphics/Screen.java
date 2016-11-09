package com.robert.game.graphics;

public class Screen 
{
	public int width, height;
	private int xOffset, yOffset;
	public int[] pixels;
	
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear()
	{
		for (int i = 0; i < pixels.length; ++i)
			pixels[i] = 0x000000;
	}

	public void render(int x, int y, Sprite sprite)
	{
		x -= xOffset;
		y -= yOffset;
		for (int i = 0; i < sprite.xSIZE; i++)
		{
			int xa = i + x;
			for (int j = 0; j < sprite.ySIZE; j++)
			{
				int ya = j + y;
				if (xa < 0 || xa >= height || ya >= width || ya < -sprite.ySIZE)
					break;
				if (ya < 0)
					ya = 0;
				int col = sprite.pixels[i * sprite.ySIZE + j];
				if (col != 0xffff00ff)
					pixels[xa * width + ya] = col;
			}
		}
	}
	
	public void renderDamaged(int x, int y, Sprite sprite)
	{
		x -= xOffset;
		y -= yOffset;
		for (int i = 0; i < sprite.xSIZE; i++)
		{
			int xa = i + x;
			for (int j = 0; j < sprite.ySIZE; j++)
			{
				int ya = j + y;
				if (xa < 0 || xa >= height || ya >= width || ya < -sprite.ySIZE)
					break;
				if (ya < 0)
					ya = 0;
				int col = sprite.pixels[i * sprite.ySIZE + j];
				if (col != 0xffff00ff)
					pixels[xa * width + ya] = 0xffff0000;
			}
		}
	}
	
	public void renderNPC(int x, int y, Sprite sprite)
	{
		x -= xOffset;
		y -= yOffset;
		for (int i = 0; i < sprite.xSIZE; i++)
		{
			int xa = i + x;
			for (int j = 0; j < sprite.ySIZE; j++)
			{
				int ya = j + y;
				if (xa < 0 || xa >= height || ya >= width || ya < -sprite.ySIZE)
					break;
				if (ya < 0)
					ya = 0;
				int col = sprite.pixels[i * sprite.ySIZE + j];
				if (col != 0xffff00ff)
					pixels[xa * width + ya] = col;
				else
					pixels[xa * width + ya] = Sprite.floor.pixels[i * sprite.ySIZE + j];
			}
		}
	}
	
	public void renderHealthBar(int x, int y, double hpp, int spriteWidth)
	{
		int col;
		x -= xOffset;
		y -= yOffset;
		if (hpp > 0.75)
			col = getColor(0, 144, SpriteSheet.sheet);
		else if (hpp > 0.5)
			col = getColor(1, 144, SpriteSheet.sheet);
		else if (hpp > 0.25)
			col = getColor(2, 144, SpriteSheet.sheet);
		else
			col = getColor(3, 144, SpriteSheet.sheet);
		for (int i = 0; i < 10; ++i)
		{
			int xa = x + i;
			for (int j = 0; j < (int)48 * hpp; j++)
			{
				int ya = y + j;
				if (xa < 0 || xa >= height || ya < -spriteWidth || ya >= width)
					break;
				if (ya < 0)
					ya = 0;
				pixels[xa * width + ya] = col;
			}
		}
		
		int xa = x - 1;
		for (int j = -1; j <= spriteWidth; j++)
		{
			int ya = y + j;
			if (xa < 0 || xa >= height || ya < -spriteWidth || ya >= width)
				break;
			if (ya < 0)
				ya = 0;
			pixels[xa * width + ya] = 0xff000000;
		}
		
		xa = x + 10;
		for (int j = -1; j <= spriteWidth; j++)
		{
			int ya = y + j;
			if (xa < 0 || xa >= height || ya < -spriteWidth || ya >= width)
				break;
			if (ya < 0)
				ya = 0;
			pixels[xa * width + ya] = 0xff000000;
		}
		
		int ya1 = y-1;
		int ya2 = y + spriteWidth / 4;
		int ya3 = y + spriteWidth / 2;
		int ya4 = y + (3 * spriteWidth / 4);
		int ya5 = y + spriteWidth;
		for (int i = -1; i <= 10; i++)
		{
			xa = x + i;
			if (xa < 0 || xa >= height || ya1 < -spriteWidth || ya1 >= width)
				break;
			if (ya1 < 0)
				ya1 = 0;
			pixels[xa * width + ya1] = 0xff000000;
			
			if (xa < 0 || xa >= height || ya2 < -spriteWidth || ya2 >= width)
				break;
			if (ya2 < 0)
				ya2 = 0;
			pixels[xa * width + ya2] = 0xff000000;
			
			if (xa < 0 || xa >= height || ya3 < -spriteWidth || ya3 >= width)
				break;
			if (ya3 < 0)
				ya3 = 0;
			pixels[xa * width + ya3] = 0xff000000;
			
			if (xa < 0 || xa >= height || ya4 < -spriteWidth || ya4 >= width)
				break;
			if (ya4 < 0)
				ya4 = 0;
			pixels[xa * width + ya4] = 0xff000000;
			
			if (xa < 0 || xa >= height || ya5 < -spriteWidth || ya5 >= width)
				break;
			if (ya5 < 0)
				ya5 = 0;
			pixels[xa * width + ya5] = 0xff000000;
		}
		
	}
	
	public void renderText(int x, int y, int xSize, int ySize, String text)
	{
		for (int i = 0; i < xSize; i++)
		{
			int xa = x + i * 24;
			for (int j = 0; j < ySize; j++)
			{
				int ya = y + j * 24;			
				render(xa, ya, getLetter(text.charAt(i * ySize + j)));
			}
		}
	}
	
	private Sprite getLetter(char c)
	{
		if (c == 'A') return Sprite.A;
		if (c == 'B') return Sprite.B;
		if (c == 'C') return Sprite.C;
		if (c == 'D') return Sprite.D;
		if (c == 'E') return Sprite.E;
		if (c == 'F') return Sprite.F;
		if (c == 'G') return Sprite.G;
		if (c == 'H') return Sprite.H;
		if (c == 'I') return Sprite.I;
		if (c == 'J') return Sprite.J;
		if (c == 'K') return Sprite.K;
		if (c == 'L') return Sprite.L;
		if (c == 'M') return Sprite.M;
		if (c == 'N') return Sprite.N;
		if (c == 'O') return Sprite.O;
		if (c == 'P') return Sprite.P;
		if (c == 'R') return Sprite.R;
		if (c == 'S') return Sprite.S;
		if (c == 'T') return Sprite.T;
		if (c == 'U') return Sprite.U;
		if (c == 'V') return Sprite.V;
		if (c == 'W') return Sprite.W;
		if (c == 'X') return Sprite.X;
		if (c == ' ') return Sprite.Y;
		return Sprite.Z;
	}
	
	public void setOffset(int x, int y)
	{
		xOffset = x;
		yOffset = y;
	}
	
	public int getColor(int x, int y, SpriteSheet sheet)
	{
		return sheet.pixels[x * sheet.SIZE + y];
	}
	
	public void renderMap()
	{
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = Sprite.map.pixels[i];
		//pixels = Sprite.map.pixels;
	}
}
