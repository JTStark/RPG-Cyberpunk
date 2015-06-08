package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import snake.engine.creators.ScreenCreator;
import snake.engine.models.HUD;
import snake.hud.SnakeDialogHUD;
import snake.hud.SnakeInfosHUD;

public class BattleHUD extends HUD {
	
	SnakeInfosHUD infos;
	SnakeDialogHUD dialog;
	BitmapFont font;
	
	private int acao = 0;
	private boolean opcoes = false;
	private int acaoOpcao = 0;
	
	
	private static final int POS1 = -20, POS2 = -70, POS3 = -130, POS4 = -200, POS5 = -270, POS6 = -320;
	
	private BattleChar atual;
	
	public BattleHUD (String levelData) {
		super();
		
		infos = new SnakeInfosHUD();
		dialog  = new SnakeDialogHUD();
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		
		BattleWorld.palhaco.setPositionX(POS3);
		BattleWorld.barbudo.setPositionX(POS4);
		BattleWorld.cientista.setPositionX(POS5);
		
		/* MUDDAAAAARRRRRR*/
		atual = BattleWorld.palhaco;
		
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		font.setColor(Color.RED);
		
		font.getData().setScale(1f);	    
		
		font.draw(batch, atual.getName(), 400 + atual.getPositionTurno(), 500); 
		
		/* Atributos*/
		font.getData().setScale(0.5f);	
		
		/* Parte1 - Substituir pelos valores numericos do  personagem */
		font.draw(batch, "" + atual.getPersonagem().forca, 190, 169);
		font.draw(batch, "" + atual.getPersonagem().persepcao, 190, 146);
		font.draw(batch, "" + atual.getPersonagem().resistencia, 190, 123);
		font.draw(batch, "" + atual.getPersonagem().carisma, 190, 100);
		font.draw(batch, "" + atual.getPersonagem().inteligencia, 190, 77);
		font.draw(batch, "" + atual.getPersonagem().agilidade, 190, 54);
		font.draw(batch, "" + atual.getPersonagem().sorte, 190, 31);
		
		/* Parte2 */
		font.draw(batch, "" + atual.getPersonagem().arma, 440, 169);
		font.draw(batch, "" + atual.getPersonagem().armadura, 440, 146);
		font.draw(batch, "" + atual.getPersonagem().critico, 440, 123);
		font.draw(batch, "" + atual.getPersonagem().esquiva, 440, 100);
		font.draw(batch, "" + atual.getPersonagem().xp, 440, 31);
		
		/* Acao */
		font.getData().setScale(0.7f);
		font.setColor(Color.WHITE);
		font.draw(batch, "Atacar", 650, 174);
		font.draw(batch, "Deslocar", 650, 139);
		font.draw(batch, "Invent�rio", 650, 104);
		font.draw(batch, "Nada", 650, 69);
		font.draw(batch, "Fugir", 650, 34);
		
		font.setColor(Color.RED);
		
		
		switch (acao)
		{
		case 0:
			font.draw(batch, "Atacar", 650, 174);
			break;
		case 1:
			font.draw(batch, "Deslocar", 650, 139);
			break;
		case 2:
			font.draw(batch, "Invent�rio", 650, 104);
			break;
		case 3:
			font.draw(batch, "Nada", 650, 69);
			break;
		case 4:
			font.draw(batch, "Fugir", 650, 34);
			break;
		
		}
		
		if(opcoes == true) {
			
			font.setColor(Color.WHITE);
			
			if(acao == 0) { //ataque
				font.draw(batch, "Ataque1", 800, 174);
				font.draw(batch, "Opcao2 da acao1", 800, 139);
				font.draw(batch, "Opcao3 da acao1", 800, 104);
				font.draw(batch, "Opcao4 da acao1", 800, 69);
				
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				case 0:
					font.draw(batch, "Ataque1", 800, 174);
					break;
				case 1:
					font.draw(batch, "Opcao2 da acao1", 800, 139);
					break;
				case 2:
					font.draw(batch, "Opcao3 da acao1", 800, 104);
					break;
				case 3:
					font.draw(batch, "Opcao4 da acao1", 800, 69);
					break;
							
				}		
			}
			
			if(acao == 1) { //deslocar
				font.draw(batch, "Para posi��o 1", 800, 174);
				font.draw(batch, "Para posi��o 2", 800, 139);
				font.draw(batch, "Para posi��o 3", 800, 104);
				font.draw(batch, "Para posi��o 4", 800, 69);
				font.draw(batch, "Para posi��o 5", 800, 34);
				font.draw(batch, "Para posi��o 6", 1000, 174);
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				case 0:
					font.draw(batch, "Para posi��o 1", 800, 174);
					break;
				case 1:
					font.draw(batch, "Para posi��o 2", 800, 139);
					break;
				case 2:
					font.draw(batch, "Para posi��o 3", 800, 104);
					break;
				case 3:
					font.draw(batch, "Para posi��o 4", 800, 69);
					break;
				case 4:
					font.draw(batch, "Para posi��o 5", 800, 34);
					break;	
				case 5:
					font.draw(batch, "Para posi��o 6", 1000, 174);
				}		
			}
			
			if(acao == 2) { //inventario
				font.draw(batch, "Opcao 1 da acao3", 800, 174);
				font.draw(batch, "Opcao2 da acao3", 800, 139);
				font.draw(batch, "Opcao3 da acao3", 800, 104);
				font.draw(batch, "Opcao4 da acao3", 800, 69);
				font.draw(batch, "Opcao5 da acao3", 800, 34);
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				case 0:
					font.draw(batch, "Opcao 1 da acao3", 800, 174);
					break;
				case 1:
					font.draw(batch, "Opcao2 da acao3", 800, 139);
					break;
				case 2:
					font.draw(batch, "Opcao3 da acao3", 800, 104);
					break;
				case 3:
					font.draw(batch, "Opcao4 da acao3", 800, 69);
					break;
				case 4:
					font.draw(batch, "Opcao5 da acao3", 800, 34);
					break;			
				}		
			}
			
			if(acao == 3) {//nada
				
				font.draw(batch, "Certeza?", 800, 174);
				font.draw(batch, "Sim", 800, 139);
				
				
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				
				case 1:
					font.draw(batch, "Sim", 800, 139);
					break;
				
				}
			}
			
			if(acao == 4) { // fugir
								
				font.draw(batch, "Certeza?", 800, 174);
				font.draw(batch, "Sim", 800, 139);
				
				
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{				
				case 1:
					font.draw(batch, "Sim", 800, 139);
					break;
				
					
				}		
			}
			
				
		}
	}
	
	@Override
	public void act(float delta) {
		
		if(opcoes == false) {			
			
			
			atual.setAtacando(false);		
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
				if(acao == 0)
					acao = 4;
				else
					acao--;
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
				if(acao == 4)
					acao = 0;
				else
					acao++;
			}
			
			
			if (Gdx.input.justTouched() || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				opcoes = true;
			}
		}
		else {			
			
			if(acao == 0) {
				atual.setAtacando(true); // animacao de ataque
				
				if(acaoOpcao == 4)
					acaoOpcao = 0;
			}
			
			
			
			if(acao == 4 || acao == 3) {
				acaoOpcao = 1;
					
			}
				
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) { // Aqui devem estar as opcoes de verdade
					
				if(acao == 0) { // ataque
						
					switch (acaoOpcao) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;					
						
					}
						
						
				}
					
				if(acao == 1) { //Deslocar
						
					switch (acaoOpcao) {
					case 0:
						atual.setPositionX(POS1);
						break;
					case 1:
						atual.setPositionX(POS2);
						break;
					case 2:
						atual.setPositionX(POS3);
						break;
					case 3:
						atual.setPositionX(POS4);
						break;						
					case 4:
						atual.setPositionX(POS5);
						break;		
					case 5:
						atual.setPositionX(POS6);
						break;
					
					}
				}
					
				if(acao == 2) { //Inventario
						
					switch (acaoOpcao) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;		
						
					}
				}
					
				if(acao == 3) { // nada
						
					
				}
					
				if(acao == 4) { // nada
						
					switch (acaoOpcao) {
					case 1:
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
						break;
					case 2:
						break;
					
						
					}
				}
					
				acaoOpcao = 0;
				acao = 0;
				opcoes = false;
				
				atual.setAtacando(false);
				
				/* Trocar de personagem*/
				if(atual == BattleWorld.palhaco)
					atual = BattleWorld.barbudo; //Mudar de acordo com a lista
				else if(atual == BattleWorld.barbudo)
					atual = BattleWorld.cientista;
				else if(atual == BattleWorld.cientista)
					atual = BattleWorld.palhaco;
				
			}
		}
			
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			opcoes = false;
			acaoOpcao = 0;
		}
			
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
				
			if(acaoOpcao == 0) {
				if(acao == 1)
					acaoOpcao = 5;
				else
					acaoOpcao = 4;
			}
			else if(acao != 4)
				acaoOpcao--;
			else if(acaoOpcao == 1)
					acaoOpcao = 2;
			else
				acaoOpcao = 1;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			if((acaoOpcao > 3 && acao != 1) || acaoOpcao == 5)
				if(acao != 4)
					acaoOpcao = 0;
				else
					acaoOpcao = 1;
				else
					acaoOpcao++;
		}	
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

}
