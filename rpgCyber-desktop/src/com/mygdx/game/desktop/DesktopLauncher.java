package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.New;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Your game";
	    config.resizable = false;
		config.height = 720;
		config.width = 1200;
		//config.height = 480;
		//config.width =640;
		config.vSyncEnabled = true;
		new LwjglApplication((ApplicationListener) new New(), config);
	}
}
