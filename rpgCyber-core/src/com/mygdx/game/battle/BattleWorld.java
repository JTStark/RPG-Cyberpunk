package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.visuals.enhanced.VisualGameWorld;

public class BattleWorld  extends VisualGameWorld {
	
	private Sprite batalha;
	
	public static BattleChar palhaco, barbudo, durden, mdr, rexus, cientista;
	public static BattleChar inimigo1, inimigo2, inimigo3, inimigo4;
	
	
	
	public BattleWorld (String LevelData/* Add other parameters of choice*/) {
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("batalha.png")); 
		batalha = new Sprite(texture);
		batalha.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		palhaco = new BattleChar("ozob");
		barbudo = new BattleChar("oleg");
		cientista = new BattleChar("silvana");

		
	}
	
	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
			try {
				ScreenCreator.backToPrevious();
			} catch (Exception e) {
				String[] param = {"SnakeLevel", "MainMenu", "LevelDataID"};
				try {
					ScreenCreator.switchAndGo(param);
				} catch (Exception excp) {
					System.out.println("Couldn't switch screens.");
				}
			}
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batalha.draw(batch);
		super.draw(batch, parentAlpha);
		palhaco.act();
		barbudo.act();
		cientista.act();
	}

	@Override
	public void createLights() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		WorldSettings.setAmbientColor(Color.WHITE);
		
	}
	
	

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batalha.getTexture().dispose();
	}

}
