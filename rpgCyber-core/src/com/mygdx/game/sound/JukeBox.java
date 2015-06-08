// Global audio player class.

package com.mygdx.game.sound;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class JukeBox {
	
	private static HashMap<String, Clip> traks;
	private static int gap;
	
	// Cria um novo HashMap
	public static void init() {
		traks = new HashMap<String, Clip>();
		gap = 0;
	}
	
	// Carrega e guarda o audio do diretorio "s" 
	// Salva na key do HashMap "n".
	public static void load(String s, String n) {
		if(traks.get(n) != null) return;
		Clip clip;
		try {
			InputStream in = JukeBox.class.getResourceAsStream(s);
			InputStream bin = new BufferedInputStream(in);
			AudioInputStream ais =
				AudioSystem.getAudioInputStream(bin);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			traks.put(n, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void play(String s) {
		play(s, gap);
	}
	
	public static void play(String s, int i) {
		Clip c = traks.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setFramePosition(i);
		while(!c.isRunning()) c.start();
	}
	
	public static void stop(String s) {
		if(traks.get(s) == null) return;
		if(traks.get(s).isRunning()) traks.get(s).stop();
	}
	
	public static void resume(String s) {
		if(traks.get(s).isRunning()) return;
		traks.get(s).start();
	}
	
	public static void resumeLoop(String s) {
		Clip c = traks.get(s);
		if(c == null) return;
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void loop(String s) {
		loop(s, gap, gap, traks.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int frame) {
		loop(s, frame, gap, traks.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int start, int end) {
		loop(s, gap, start, end);
	}
	
	public static void loop(String s, int frame, int start, int end) {
		Clip c = traks.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setLoopPoints(start, end);
		c.setFramePosition(frame);
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void setPosition(String s, int frame) {
		traks.get(s).setFramePosition(frame);
	}
	
	public static int getFrames(String s) { return traks.get(s).getFrameLength(); }
	public static int getPosition(String s) { return traks.get(s).getFramePosition(); }
	
	public static void close(String s) {
		stop(s);
		traks.get(s).close();
	}
	
	public static void setVolume(String s, float f) {
		Clip c = traks.get(s);
		if(c == null) return;
		FloatControl vol = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
		vol.setValue(f);
	}
	
	public static boolean isPlaying(String s) {
		Clip c = traks.get(s);
		if(c == null) return false;
		return c.isRunning();
	}
	
}