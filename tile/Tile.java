package com.robert.game.tile;

import com.robert.game.entity.mob.Player;
import com.robert.game.graphics.Screen;
import com.robert.game.graphics.Sprite;

public class Tile 
{
	public static Tile wall = new SolidTile(Sprite.wall);
	public static Tile grass = new NonSolidTile(Sprite.grass);
	public static Tile voidTile = new SolidTile(Sprite.voidSprite);
	
	public static Tile disk1 = new DiskTile1(Sprite.floor);
	public static Tile disk2 = new DiskTile2(Sprite.idk);
	public static Tile disk3 = new DiskTile3(Sprite.road);
	public static Tile disk4 = new DiskTile4(Sprite.idk);
	public static Tile lastdisk = new LastDiskTile(Sprite.idk);
	
	public static Tile robert1 = new NPCTile(Sprite.robert1);
	public static Tile robert2 = new NPCTile(Sprite.robert2);
	public static Tile andrei1 = new NPCTile(Sprite.andrei1);
	public static Tile andrei2 = new NPCTile(Sprite.andrei2);
	
	public static int col_robert1 = 0xffff1000;
	public static int col_robert2 = 0xffff2000;
	public static int col_andrei1 = 0xffff3000;
	public static int col_andrei2 = 0xffff4000;
	
	public static Tile loc_1 = new NonSolidTile(Sprite.idk);
	public static Tile loc_2 = new SolidTile(Sprite.block);
	public static Tile loc_3 = new SolidTile(Sprite.block_wall);
	
	public static int col_loc_1 = 0xffFFD801;
	public static int col_loc_2 = 0xffFFD802;
	public static int col_loc_3 = 0xffFFD803;
	
	public static int col_disk1 = 0xff000001;
	public static int col_disk2 = 0xff000002;
	public static int col_disk3 = 0xff000003;
	public static int col_disk4 = 0xff000004;
	public static int col_lastdisk = 0xff000005;

	public static Tile guta1 = new NPCTile(Sprite.guta1);
	public static Tile guta2 = new NPCTile(Sprite.guta2);
	public static Tile guta3 = new NPCTile(Sprite.guta3);
	public static Tile guta4 = new NPCTile(Sprite.guta4);
	public static Tile guta5 = new NPCTile(Sprite.guta5);
	public static Tile guta6 = new NPCTile(Sprite.guta6);
	public static Tile guta7 = new NPCTile(Sprite.guta7);
	public static Tile guta8 = new NPCTile(Sprite.guta8);
	
	public static Tile block_wall = new SolidTile(Sprite.block_wall);
	public static Tile door = new SolidTile(Sprite.door);
	public static Tile floor = new NonSolidTile(Sprite.floor);
	public static Tile sidewalk = new NonSolidTile(Sprite.sidewalk);
	public static Tile road = new NonSolidTile(Sprite.road);
	public static Tile border = new NonSolidTile(Sprite.border);
	public static Tile building = new NonSolidTile(Sprite.building);
	public static Tile house = new SolidTile(Sprite.house);
	public static Tile block = new SolidTile(Sprite.block);
	public static Tile idk = new NonSolidTile(Sprite.idk);
	public static Tile outWall = new SolidTile(Sprite.outsideWall);
	public static Tile house_wall = new SolidTile(Sprite.house_wall);
	
	public static Tile RoInTile = new RobertTile(Sprite.sidewalk);
	public static Tile RoOutTile = new RobertOutTile(Sprite.floor);
	public static Tile RaInTile = new RaduTile(Sprite.sidewalk);
	public static Tile RaOutTile = new RaduOutTile(Sprite.floor);
	public static Tile AInTile = new AndreiTile(Sprite.sidewalk);
	public static Tile AOutTile = new AndreiOutTile(Sprite.floor);
	
	public static int col_RoInTile = 0xffFF00DC;
	public static int col_RoOutTile = 0xffFF00DB;
	public static int col_RaInTile = 0xffFF0003;
	public static int col_RaOutTile = 0xffff0001;
	public static int col_AInTile = 0xff7F0037;
	public static int col_AOutTile = 0xff7F0038;
	
	public static int col_door = 0xff004A8F;
	public static int col_outWall = 0xffFF6A00;
	public static int col_sidewalk = 0xff00FFFF;
	public static int col_road = 0xff000000;
	public static int col_border = 0xffFE006E;
	public static int col_building = 0xffFFD800;
	public static int col_house = 0xff004A7F;
	public static int col_block = 0xff808080;
	public static int col_idk = 0xffB6FF00;
	public static int col_floor = 0xff000010;
	public static int col_house_wall = 0xff808081;
	public static int col_block_wall = 0xff808082;
	
	public static int col_guta1 = 0xff1000ff;
	public static int col_guta2 = 0xff2000ff;
	public static int col_guta3 = 0xff3000ff;
	public static int col_guta4 = 0xff4000ff;
	public static int col_guta5 = 0xff5000ff;
	public static int col_guta6 = 0xff6000ff;
	public static int col_guta7 = 0xff7000ff;
	public static int col_guta8 = 0xff8000ff;
	
	
	public Sprite sprite;
	public int x, y;
	
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen)
	{
	}
	
	public boolean isSolid()
	{
		return false;
	}
	
	public void Event(Player p)
	{
		
	}
	
}
