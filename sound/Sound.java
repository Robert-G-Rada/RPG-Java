package com.robert.game.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound 
{
	public static Sound hit = new Sound("/hit.wav", 21);
	public static Sound song1 = new Sound("/song1.wav", 13260);
	public static Sound song2 = new Sound("/song2.wav", 11879);
	public static Sound song3 = new Sound("/song3.wav", 13691);
	public static Sound song4 = new Sound("/song4.wav", 17313);
	public static Sound song5 = new Sound("/song5.wav", 13691);
	public static Sound songlm = new Sound("/songlm.wav", 9998);
	
	public int lenght;
	private AudioClip clip;

	private Sound(String name, int lenght) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(name));
			this.lenght = lenght;
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() {
				public void run() {
					clip.play();
				}
			}.start();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void stop()
	{
		clip.stop();
	}
}
