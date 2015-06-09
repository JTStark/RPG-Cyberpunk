package com.mygdx.game;

import implementations.combate.AuxTemp;
import implementations.combate.CEngine;
import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

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
	public static BattleChar inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6;
	
	
	
	
	
	public BattleWorld (String LevelData/* Add other parameters of choice*/) {
		AuxTemp.comeca();
		
		
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("batalha.png")); 
		batalha = new Sprite(texture);
		batalha.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		
		/* Herois */
		palhaco = new BattleChar("ozob");	
		palhaco.setAmigo(true);
		barbudo = new BattleChar("oleg");
		barbudo.setAmigo(true);
		cientista = new BattleChar("silvana");
		cientista.setAmigo(true);
		rexus = new BattleChar("rexus");
		rexus.setAmigo(true);
		durden = new BattleChar("durden");
		durden.setAmigo(true);
		mdr = new BattleChar("rexus"); // mudar
		mdr.setAmigo(true);
		
		/* Inimigos */
		inimigo1 = new BattleChar("ozob");
		inimigo1.setAmigo(false);
		inimigo2 = new BattleChar("ozob");
		inimigo2.setAmigo(false);
		inimigo3 = new BattleChar("ozob");
		inimigo3.setAmigo(false);
		inimigo4 = new BattleChar("ozob");
		inimigo4.setAmigo(false);
		inimigo5 = new BattleChar("ozob");
		inimigo5.setAmigo(false);
		inimigo6 = new BattleChar("ozob");
		inimigo6.setAmigo(false);
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
		rexus.act();
		durden.act();
		mdr.act();
		inimigo1.act();
		inimigo2.act();
		inimigo3.act();
		inimigo4.act();
		inimigo5.act();
		inimigo6.act();

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
