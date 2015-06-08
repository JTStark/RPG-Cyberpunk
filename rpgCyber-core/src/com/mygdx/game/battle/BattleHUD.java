package com.mygdx.game.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

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
	private int turno = 0;
	private int vez = 0;
	
	private static int POS_PALHACO, POS_BARBUDO, POS_3, POS_4, POS_5, POS_6;
	private static int POS1, POS2, POS3, POS4, POS5, POS6;
	
	public BattleHUD (String levelData) {
		super();
		
		infos = new SnakeInfosHUD();
		dialog  = new SnakeDialogHUD();
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		
		BattleWorld.palhaco.setPositionX(-200);
		BattleWorld.barbudo.setPositionX(-270);
		
		POS_PALHACO = -180; 
		POS_BARBUDO = -300; 
		POS3 = -400; 
		POS4 = -40; 
		POS5 = 80;
		POS6 = 150;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		font.setColor(Color.RED);
		
		font.getData().setScale(1f);
		
	    /* Seleciona o personagem */
		if(vez == 0)
			font.draw(batch, "Turno", 400 + POS_PALHACO, 500); 
		if(vez == 1)
			font.draw(batch, "Turno", 400 + POS_BARBUDO, 500);
		
		/* Atributos*/
		font.getData().setScale(0.5f);	
		
		/* Parte1 - Substituir pelos valores numericos do  personagem */
		font.draw(batch, "forca", 190, 169);
		font.draw(batch, "persepcao", 190, 146);
		font.draw(batch, "resistencia", 190, 123);
		font.draw(batch, "carisma", 190, 100);
		font.draw(batch, "inteligencia", 190, 77);
		font.draw(batch, "agilidade", 190, 54);
		font.draw(batch, "sorte", 190, 31);
		
		/* Parte2 */
		font.draw(batch, "arma", 440, 169);
		font.draw(batch, "armadura", 440, 146);
		font.draw(batch, "critico", 440, 123);
		font.draw(batch, "esquiva", 440, 100);
		font.draw(batch, "xp", 440, 31);
		
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
			
			if(acao == 0) {
				font.draw(batch, "Ataque1", 800, 174);
				font.draw(batch, "Opcao2 da acao1", 800, 139);
				font.draw(batch, "Opcao3 da acao1", 800, 104);
				font.draw(batch, "Opcao4 da acao1", 800, 69);
				font.draw(batch, "Opcao5 da acao1", 800, 34);
				
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
				case 4:
					font.draw(batch, "Opcao5 da acao1", 800, 34);
					break;			
				}		
			}
			
			if(acao == 1) {
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
			
			if(acao == 2) {
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
			
			if(acao == 3) {
				
				font.draw(batch, "Opcao 1 da acao4", 800, 174);
				font.draw(batch, "Opcao2 da acao4", 800, 139);
				font.draw(batch, "Opcao3 da acao4", 800, 104);
				font.draw(batch, "Opcao4 da acao4", 800, 69);
				font.draw(batch, "Opcao5 da acao4", 800, 34);
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				case 0:
					font.draw(batch, "Opcao 1 da acao4", 800, 174);
					break;
				case 1:
					font.draw(batch, "Opcao2 da acao4", 800, 139);
					break;
				case 2:
					font.draw(batch, "Opcao3 da acao4", 800, 104);
					break;
				case 3:
					font.draw(batch, "Opcao4 da acao4", 800, 69);
					break;
				case 4:
					font.draw(batch, "Opcao5 da acao4", 800, 34);
					break;			
				}		
			}
			
			if(acao == 4) {
								
				font.draw(batch, "Opcao 1 da acao5", 800, 174);
				font.draw(batch, "Opcao2 da acao5", 800, 139);
				font.draw(batch, "Opcao3 da acao5", 800, 104);
				font.draw(batch, "Opcao4 da acao5", 800, 69);
				font.draw(batch, "Opcao5 da acao5", 800, 34);
				
				font.setColor(Color.RED);
				
				switch (acaoOpcao)
				{
				case 0:
					font.draw(batch, "Opcao 1 da acao5", 800, 174);
					break;
				case 1:
					font.draw(batch, "Opcao2 da acao5", 800, 139);
					break;
				case 2:
					font.draw(batch, "Opcao3 da acao5", 800, 104);
					break;
				case 3:
					font.draw(batch, "Opcao4 da acao5", 800, 69);
					break;
				case 4:
					font.draw(batch, "Opcao5 da acao5", 800, 34);
					break;			
				}		
			}
			
				
		}
	}
	
	@Override
	public void act(float delta) {
		
		if(opcoes == false) {
			
			if(vez == 0) 
				BattleWorld.palhaco.setAtacando(false);
			if(vez == 1)
				BattleWorld.barbudo.setAtacando(false);			
		
			
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
			
			if(acao == 0) { //animacao de ataque
				if(vez == 0)
					BattleWorld.palhaco.setAtacando(true);
				if(vez == 1)
					BattleWorld.barbudo.setAtacando(true);
			}
			
			if(acao == 1) {
				
				if(vez == 0) {
					if(acaoOpcao == 0) {
						POS_PALHACO = 175;
						BattleWorld.palhaco.setPositionX(-20);					
					}
					else if(acaoOpcao == 1) {
						POS_PALHACO = 80;
						BattleWorld.palhaco.setPositionX(-70);					
					}
					else if(acaoOpcao == 2) {
						POS_PALHACO = -40;
						BattleWorld.palhaco.setPositionX(-130);				
					}
					else if(acaoOpcao == 3) {
						POS_PALHACO = -180;
						BattleWorld.palhaco.setPositionX(-200);					
					}
					else if(acaoOpcao == 4) {
						POS_PALHACO = -300;
						BattleWorld.palhaco.setPositionX(-270);				
					}
					else if(acaoOpcao == 5) {
						POS_PALHACO = -400;
						BattleWorld.palhaco.setPositionX(-320);	
					}
				}
				if(vez == 1) {
					if(acaoOpcao == 0) {
						POS_BARBUDO = 175;
						BattleWorld.barbudo.setPositionX(-20);					
					}
					else if(acaoOpcao == 1) {
						POS_BARBUDO = 80;
						BattleWorld.barbudo.setPositionX(-70);				
					}
					else if(acaoOpcao == 2) {
						POS_BARBUDO = -40;
						BattleWorld.barbudo.setPositionX(-130);				
					}
					else if(acaoOpcao == 3) {
						POS_BARBUDO = -180;
						BattleWorld.barbudo.setPositionX(-200);				
					}
					else if(acaoOpcao == 4) {
						POS_BARBUDO = -300;
						BattleWorld.barbudo.setPositionX(-270);			
					}
					else if(acaoOpcao == 5) {
						POS_BARBUDO = -400;
						BattleWorld.barbudo.setPositionX(-320);	
					}
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
				else
					acaoOpcao--;
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
				if((acaoOpcao > 3 && acao != 1) || acaoOpcao == 5)
					acaoOpcao = 0;
				else
					acaoOpcao++;
			}
		}
		

		if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			acaoOpcao = 0;
			acao = 0;
			opcoes = false;
			
			if(vez == 0) {
				vez = 1;
				BattleWorld.palhaco.setAtacando(false);
			}
			else {
				vez = 0;
				BattleWorld.barbudo.setAtacando(false);
			}
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
