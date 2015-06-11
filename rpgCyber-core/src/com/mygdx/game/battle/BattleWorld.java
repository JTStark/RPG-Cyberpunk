package com.mygdx.game.battle;

import implementations.combate.AuxTemp;
import implementations.combate.CEngine;
import implementations.combate.RetornaArrayInimigos;
import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.animate.Player;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.visuals.enhanced.VisualGameWorld;

public class BattleWorld  extends VisualGameWorld {
	
	private Sprite batalha;
	
	public static BattleChar palhaco, barbudo, durden, mdr, rexus, cientista;
	public static BattleChar inimigo1, inimigo2, inimigo3, inimigo4, inimigo5, inimigo6;
	
	public static ArrayList<BattleChar> listaHerois = new ArrayList<BattleChar>();
	public static ArrayList<BattleChar> listaViloes = new ArrayList<BattleChar>();
	
	public static int n_herois = 6;
	public static int n_viloes = 0;
	
	public static Music musica;
	
	
	
	
	public BattleWorld (String LevelData/* Add other parameters of choice*/) {
		//AuxTemp.comeca();
		CEngine.CombatEngine(Player.listaP, RetornaArrayInimigos.GetArray());
		 musica = Gdx.audio.newMusic(Gdx.files.internal("musicas/batalha.mp3"));
		 
		 
		
		
		
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("batalha.png")); 
		batalha = new Sprite(texture);
		batalha.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		
		
		/* Herois */
		
		
		palhaco = new BattleChar("ozob");	
		palhaco.setAmigo(true);
		listaHerois.add(palhaco);
		
		barbudo = new BattleChar("oleg");
		barbudo.setAmigo(true);
		listaHerois.add(barbudo);
		
		cientista = new BattleChar("silvana");
		cientista.setAmigo(true);
		listaHerois.add(cientista);
		
		rexus = new BattleChar("rexus");
		rexus.setAmigo(true);
		listaHerois.add(rexus);
		
		durden = new BattleChar("durden");
		durden.setAmigo(true);
		listaHerois.add(durden);
		
		mdr = new BattleChar("mdr"); 
		mdr.setAmigo(true);
		listaHerois.add(mdr);
		
		/* Inimigos */
		inimigo1 = new BattleChar("melee1");
		inimigo1.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo1);
		
		inimigo2 = new BattleChar("melee2");		
		inimigo2.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo2);
		
		inimigo3 = new BattleChar("melee3");		
		inimigo3.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo3);
		
		inimigo4 = new BattleChar("melee4");
		inimigo4.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo4);
		
		inimigo5 = new BattleChar("melee5");		
		inimigo5.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo5);
		
		inimigo6 = new BattleChar("melee6");
		inimigo6.setAmigo(false);
		n_viloes++;
		listaViloes.add(inimigo6);
		
		musica.play();
		musica.setLooping(true);
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
		
		if(palhaco.getVivo())
			palhaco.act();
		if(barbudo.getVivo())
			barbudo.act();
		if(cientista.getVivo())
			cientista.act();
		if(rexus.getVivo())
			rexus.act();
		if(durden.getVivo())
			durden.act();
		if(mdr.getVivo())
			mdr.act();
		if(inimigo1.getVivo())
			inimigo1.act();
		if(inimigo2.getVivo())
			inimigo2.act();
		if(inimigo3.getVivo())
			inimigo3.act();
		if(inimigo4.getVivo())
			inimigo4.act();
		if(inimigo5.getVivo())
			inimigo5.act();
		if(inimigo6.getVivo())
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
