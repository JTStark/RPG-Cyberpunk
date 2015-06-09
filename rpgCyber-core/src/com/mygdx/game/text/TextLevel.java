package com.mygdx.game.text;

import snake.engine.creators.WorldSettings;
import snake.visuals.enhanced.VisualGameWorld;
import umbra.TextComunicator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * Map for testing purposes only.
 * @author Mr.Strings
 */

public class TextLevel extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private TextComunicator text;
	public TextLevel (String LevelData/* Add other parameters of choice*/) {
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		text = new TextComunicator();
		text.newText("Bananas nao sao sjdnasjkdnjsakndjksandjnsajkdnajskndnakjdn"
				+ "dsjahjdsadsadjhsjkahdjshakjdhsajkdjkasd"
				+ "sjdhajkhdkjahsdjshakdhjsakhdkjshdkjahdsjhd"
				+ "adjhksahdjkashdjkhasjkdhjksadjkhasjdhsjakhdjksh", WorldSettings.getWorldWidth() - 50, WorldSettings.getWorldHeight() , 200, true);
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		text.update(delta);
		
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		text.draw();
		super.draw(batch, parentAlpha);
	}

	public void createLights() {
	}
	
	@Override
	public void dispose() {
		text.dispose();
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

}