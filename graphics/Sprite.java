package com.robert.game.graphics;

public class Sprite 
{
	public int[] pixels;
	public final int xSIZE, ySIZE;
	private int x, y;
	private SpriteSheet sheet;
	
	public static Sprite map = new Sprite(SpriteSheet.map, 0, 0, 180, 230);
	public static Sprite dead = new Sprite(SpriteSheet.dead, 0, 0, 720, 1280);
	public static Sprite won = new Sprite(SpriteSheet.won, 0, 0, 720, 1280);
	
	public static Sprite grass = new Sprite(SpriteSheet.sheet, 48, 0, 48, 48);
	public static Sprite wall = new Sprite(SpriteSheet.sheet, 0, 0, 48, 48);
	public static Sprite floor = new Sprite(SpriteSheet.sheet, 96, 96, 48, 48);
	public static Sprite house_wall = new Sprite(SpriteSheet.sheet, 432, 48, 48, 48);
	public static Sprite door = new Sprite(SpriteSheet.sheet, 144, 96, 48, 48);
	public static Sprite block_wall = new Sprite(SpriteSheet.sheet, 432, 96, 48, 48);
	
	public static Sprite disk = new Sprite(SpriteSheet.sheet, 144, 48, 48, 48);
	
	public static Sprite point = new Sprite(SpriteSheet.sheet, 5, 240, 1, 1);
	public static Sprite voidSprite = new Sprite(SpriteSheet.sheet, 432, 0, 48, 48);
	
	public static Sprite guta1 = new Sprite(SpriteSheet.sheet, 240, 0, 48, 48);
	public static Sprite guta2 = new Sprite(SpriteSheet.sheet, 240, 48, 48, 48);
	public static Sprite guta3 = new Sprite(SpriteSheet.sheet, 288, 0, 48, 48);
	public static Sprite guta4 = new Sprite(SpriteSheet.sheet, 288, 48, 48, 48);
	public static Sprite guta5 = new Sprite(SpriteSheet.sheet, 336, 0, 48, 48);
	public static Sprite guta6 = new Sprite(SpriteSheet.sheet, 336, 48, 48, 48);
	public static Sprite guta7 = new Sprite(SpriteSheet.sheet, 384, 0, 48, 48);
	public static Sprite guta8 = new Sprite(SpriteSheet.sheet, 384, 48, 48, 48);
	
	public static Sprite sidewalk = new Sprite (SpriteSheet.sheet, 48, 48, 48, 48);
	public static Sprite road = new Sprite (SpriteSheet.sheet, 96, 0, 48, 48);
	public static Sprite border = new Sprite (SpriteSheet.sheet, 0, 48, 48, 48);
	public static Sprite building = new Sprite (SpriteSheet.sheet, 192, 0, 48, 48);
	public static Sprite house = new Sprite (SpriteSheet.sheet, 96, 48, 48, 48);
	public static Sprite block = new Sprite (SpriteSheet.sheet, 144, 0, 48, 48);
	public static Sprite idk = new Sprite (SpriteSheet.sheet, 192, 48, 48, 48);
	public static Sprite outsideWall = new Sprite(SpriteSheet.sheet, 192, 96, 48, 48);
	
	public static Sprite A = new Sprite(SpriteSheet.alphabet, 0, 0, 24, 24);
	public static Sprite B = new Sprite(SpriteSheet.alphabet, 0, 24, 24, 24);
	public static Sprite C = new Sprite(SpriteSheet.alphabet, 0, 48, 24, 24);
	public static Sprite D = new Sprite(SpriteSheet.alphabet, 0, 72, 24, 24);
	public static Sprite E = new Sprite(SpriteSheet.alphabet, 0, 96, 24, 24);
	public static Sprite F = new Sprite(SpriteSheet.alphabet, 24, 0, 24, 24);
	public static Sprite G = new Sprite(SpriteSheet.alphabet, 24, 24, 24, 24);
	public static Sprite H = new Sprite(SpriteSheet.alphabet, 24, 48, 24, 24);
	public static Sprite I = new Sprite(SpriteSheet.alphabet, 24, 72, 24, 24);
	public static Sprite J = new Sprite(SpriteSheet.alphabet, 24, 96, 24, 24);
	public static Sprite K = new Sprite(SpriteSheet.alphabet, 48, 0, 24, 24);
	public static Sprite L = new Sprite(SpriteSheet.alphabet, 48, 24, 24, 24);
	public static Sprite M = new Sprite(SpriteSheet.alphabet, 48, 48, 24, 24);
	public static Sprite N = new Sprite(SpriteSheet.alphabet, 48, 72, 24, 24);
	public static Sprite O = new Sprite(SpriteSheet.alphabet, 48, 96, 24, 24);
	public static Sprite P = new Sprite(SpriteSheet.alphabet, 72, 0, 24, 24);
	public static Sprite R = new Sprite(SpriteSheet.alphabet, 72, 24, 24, 24);
	public static Sprite S = new Sprite(SpriteSheet.alphabet, 72, 48, 24, 24);
	public static Sprite T = new Sprite(SpriteSheet.alphabet, 72, 72, 24, 24);
	public static Sprite U = new Sprite(SpriteSheet.alphabet, 72, 96, 24, 24);
	public static Sprite V = new Sprite(SpriteSheet.alphabet, 96, 0, 24, 24);
	public static Sprite W = new Sprite(SpriteSheet.alphabet, 96, 24, 24, 24);
	public static Sprite X = new Sprite(SpriteSheet.alphabet, 96, 48, 24, 24);
	public static Sprite Y = new Sprite(SpriteSheet.alphabet, 96, 72, 24, 24);
	public static Sprite Z = new Sprite(SpriteSheet.alphabet, 96, 96, 24, 24);
	
	public static Sprite player = new Sprite(SpriteSheet.sheet, 0, 96, 96, 48);
	public static Sprite enemy = new Sprite(SpriteSheet.sheet, 336, 96, 96, 48);
	public static Sprite robert1 = new Sprite(SpriteSheet.sheet, 240, 144, 48, 48);
	public static Sprite robert2 = new Sprite(SpriteSheet.sheet, 288, 144, 48, 48);
	public static Sprite andrei1 = new Sprite(SpriteSheet.sheet, 240, 96, 48, 48);
	public static Sprite andrei2 = new Sprite(SpriteSheet.sheet, 288, 96, 48, 48);
	
	public Sprite(SpriteSheet sheet, int x, int y, int xSize, int ySize)
	{
		xSIZE = xSize;
		ySIZE = ySize;
		pixels = new int[xSIZE * ySIZE];
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		load();
	}
	
	public void load()
	{
		for (int i = 0; i < xSIZE; ++i)
		{
			for (int j = 0; j < ySIZE; j++)
			{
				pixels[i * ySIZE + j] = sheet.pixels[(x+i) * sheet.SIZE + (y+j)];
			}
		}
	}
}
