package com.mygdx.game.inventary;

import snake.engine.creators.WorldSettings;
import snake.visuals.enhanced.VisualGameWorld;
import com.badlogic.gdx.Gdx;
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

public class InventaryMenu extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Sprite temple;
	
	public InventaryMenu (String LevelData/* Add other parameters of choice*/) {
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("inventario.jpg")); 
		temple = new Sprite(texture);
		temple.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		temple.draw(batch);
		super.draw(batch, parentAlpha);
	}

	public void createLights() {
	}
	
	@Override
	public void dispose() {
		temple.getTexture().dispose();
	
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