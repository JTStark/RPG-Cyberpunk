package com.mygdx.game.battle;

import implementations.combate.CEngine;
import implementations.combate.CRodada;
import implementations.personagens.AbsPersonagem;

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
	String posta =  "";
	
	private boolean ataque = false;
	private boolean inimigoAtacando = false;
	
	private int alvo = 0;
	
	private String var;
	
	private int escolha = 0;
	private boolean opcaoEscolha = false;
	
	
	private static final int POS1 = -20, POS2 = -70, POS3 = -130, POS4 = -200, POS5 = -270, POS6 = -320;
	private static final int POSM1 = 30, POSM2 = 80, POSM3 = 130, POSM4 = 180, POSM5 = 230, POSM6 = 280;  
	
	private BattleChar atual;
	
	public BattleHUD (String levelData) {
		super();
		
		infos = new SnakeInfosHUD();
		dialog  = new SnakeDialogHUD();
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		
		BattleWorld.palhaco.setPositionX(POS3);
		BattleWorld.barbudo.setPositionX(POS4);
		BattleWorld.cientista.setPositionX(POS5);
		BattleWorld.durden.setPositionX(POS1);
		BattleWorld.rexus.setPositionX(POS6);
		BattleWorld.mdr.setPositionX(POS2);
		
		BattleWorld.inimigo1.setPositionX(POSM1);
		BattleWorld.inimigo2.setPositionX(POSM2);
		BattleWorld.inimigo3.setPositionX(POSM3);
		BattleWorld.inimigo4.setPositionX(POSM4);
		BattleWorld.inimigo5.setPositionX(POSM5);
		BattleWorld.inimigo6.setPositionX(POSM6);
		
		/* MUDDAAAAARRRRRR*/
		
		try {
			AbsPersonagem personAtual = CRodada.getVez();
			
			
			
			if(personAtual.vilao == false) {
				if(personAtual.nome.equalsIgnoreCase("oleg"))
					atual = BattleWorld.barbudo;
				if(personAtual.nome.equalsIgnoreCase("silvana"))
					atual = BattleWorld.cientista;
				if(personAtual.nome.equalsIgnoreCase("ozob"))
					atual = BattleWorld.palhaco;
				if(personAtual.nome.equalsIgnoreCase("durden"))
					atual = BattleWorld.durden;
				if(personAtual.nome.equalsIgnoreCase("rexus"))
					atual = BattleWorld.rexus;
				if(personAtual.nome.equalsIgnoreCase("mdr"))
					atual = BattleWorld.mdr;		
			}
			else {
				if(personAtual.nome.equalsIgnoreCase("melee1"))
					atual = BattleWorld.inimigo1;
				if(personAtual.nome.equalsIgnoreCase("melee2"))
					atual = BattleWorld.inimigo2;
				if(personAtual.nome.equalsIgnoreCase("melee3"))
					atual = BattleWorld.inimigo3;
				if(personAtual.nome.equalsIgnoreCase("melee4"))
					atual = BattleWorld.inimigo4;
				if(personAtual.nome.equalsIgnoreCase("melee5"))
					atual = BattleWorld.inimigo5;
				if(personAtual.nome.equalsIgnoreCase("melee6"))
					atual = BattleWorld.inimigo6;		
				
				
				
				
			}
			System.out.println(personAtual.nome + "ALAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");
		
		}
		catch (Exception e) {
			System.out.println("atual merda");
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha){
		font.setColor(Color.RED);
		
		font.getData().setScale(1f);	    
		
		font.draw(batch, atual.getName(), 400 + atual.getPositionTurno(), 500); 
		
		/* Postar a vida */
		font.getData().setScale(0.8f);	
		font.draw(batch, "" + (int)BattleWorld.palhaco.getPersonagem().hp, 440 + BattleWorld.palhaco.getPositionTurno(), 350); 
		font.draw(batch, "" + (int)BattleWorld.durden.getPersonagem().hp, 440 + BattleWorld.durden.getPositionTurno(), 350); 
		font.draw(batch, "" + (int)BattleWorld.cientista.getPersonagem().hp, 440 + BattleWorld.cientista.getPositionTurno(), 350); 
		font.draw(batch, "" + (int)BattleWorld.mdr.getPersonagem().hp, 440 + BattleWorld.mdr.getPositionTurno(), 350); 
		font.draw(batch, "" + (int)BattleWorld.rexus.getPersonagem().hp, 440 + BattleWorld.rexus.getPositionTurno(), 350); 
		font.draw(batch, "" + (int)BattleWorld.barbudo.getPersonagem().hp, 440 + BattleWorld.barbudo.getPositionTurno(), 350); 
		
		font.draw(batch, "" + (int)BattleWorld.inimigo1.getPersonagem().hp, 440 + BattleWorld.inimigo1.getPositionTurno(), 350);
		font.draw(batch, "" + (int)BattleWorld.inimigo2.getPersonagem().hp, 440 + BattleWorld.inimigo2.getPositionTurno(), 350);
		font.draw(batch, "" + (int)BattleWorld.inimigo3.getPersonagem().hp, 440 + BattleWorld.inimigo3.getPositionTurno(), 350);
		font.draw(batch, "" + (int)BattleWorld.inimigo4.getPersonagem().hp, 440 + BattleWorld.inimigo4.getPositionTurno(), 350);
		font.draw(batch, "" + (int)BattleWorld.inimigo5.getPersonagem().hp, 440 + BattleWorld.inimigo5.getPositionTurno(), 350);
		font.draw(batch, "" + (int)BattleWorld.inimigo6.getPersonagem().hp, 440 + BattleWorld.inimigo6.getPositionTurno(), 350);
		
		if(atual.getAmigo() == true) {
			/* Atributos*/
			font.getData().setScale(0.5f);	
			
			try {
				/* Parte1 - Substituir pelos valores numericos do  personagem */
				font.draw(batch, "" + (int)atual.getPersonagem().forca, 190, 169);
				font.draw(batch, "" + (int)atual.getPersonagem().percepcao, 190, 146);
				font.draw(batch, "" + (int)atual.getPersonagem().resistencia, 190, 123);
				font.draw(batch, "" + (int)atual.getPersonagem().carisma, 190, 100);
				font.draw(batch, "" + (int)atual.getPersonagem().inteligencia, 190, 77);
				font.draw(batch, "" + (int)atual.getPersonagem().agilidade, 190, 54);
				font.draw(batch, "" + (int)atual.getPersonagem().sorte, 190, 31);
				
				/* Parte2 */
				font.draw(batch, "" + (int)atual.getPersonagem().danoArma, 440, 169);
				font.draw(batch, "" + (int)atual.getPersonagem().armadura, 440, 146);
				font.draw(batch, "" + (int)atual.getPersonagem().critico, 440, 123);
				font.draw(batch, "" + (int)atual.getPersonagem().esquiva, 440, 100);
				font.draw(batch, "" + (int)atual.getPersonagem().xp, 440, 31);
			}
			catch (Exception e) {
				System.out.println("Deu merda");
				e.printStackTrace();
			}
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
					
					try {
						font.draw(batch, "Basico", 800, 174);
						font.draw(batch, atual.getPersonagem().nSkill1, 800, 139);
						font.draw(batch, atual.getPersonagem().nSkill2, 800, 104);
						font.draw(batch, atual.getPersonagem().nSkill3, 800, 69);
					}
					catch(Exception e){
						System.out.println("Deu merda ataque");
						e.printStackTrace();
					}
					
					font.setColor(Color.RED);
					
					
					try {
						switch (acaoOpcao)
						{
						case 0:
							font.draw(batch, "Basico", 800, 174);
							break;
						case 1:
							font.draw(batch, atual.getPersonagem().nSkill1, 800, 139);
							break;
						case 2:
							font.draw(batch, atual.getPersonagem().nSkill2, 800, 104);
							break;
						case 3:
							font.draw(batch, atual.getPersonagem().nSkill3, 800, 69);
							break;
									
						}
					}
					catch(Exception e) {
						System.out.println("Deu merda ataque 2");
						e.printStackTrace();
					}
					
					if(ataque == true) {
						font.setColor(Color.WHITE);
						
						font.draw(batch, "Escolha o alvo\nUse UP e Down", 1050, 174);
						
						var = CRodada.getAlvos(acaoOpcao, atual.getPersonagem());
						
						if(var.equalsIgnoreCase("melee")) { //melee
							font.draw(batch, "Alvo", BattleWorld.inimigo1.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.inimigo2.getPositionTurno(), 550);							
						}
						if(var.equalsIgnoreCase("ranged")) {//Ranged
							font.draw(batch, "Alvo", BattleWorld.inimigo1.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.inimigo2.getPositionTurno(), 550);	
							font.draw(batch, "Alvo", BattleWorld.inimigo3.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.inimigo4.getPositionTurno(), 550);	
							font.draw(batch, "Alvo", BattleWorld.inimigo5.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.inimigo6.getPositionTurno(), 550);							
							
						}
						if(var.equalsIgnoreCase("amigo")) {//amigo
							font.draw(batch, "Alvo", BattleWorld.durden.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.palhaco.getPositionTurno(), 550);	
							font.draw(batch, "Alvo", BattleWorld.rexus.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.cientista.getPositionTurno(), 550);	
							font.draw(batch, "Alvo", BattleWorld.mdr.getPositionTurno(), 550);
							font.draw(batch, "Alvo", BattleWorld.barbudo.getPositionTurno(), 550);		
							
						}
						
						font.setColor(Color.RED);
						
						switch (alvo) {
						case 0:
							font.draw(batch, BattleWorld.palhaco.getName(), 1050, 69);
							break;
						case 1:
							font.draw(batch, BattleWorld.barbudo.getName(), 1050, 69);
							break;
						case 2:
							font.draw(batch, BattleWorld.cientista.getName(), 1050, 69);
							break;
						case 3:
							font.draw(batch, BattleWorld.rexus.getName(), 1050, 69);
							break;
						case 4:
							font.draw(batch, BattleWorld.durden.getName(), 1050, 69);
							break;
						case 5:
							font.draw(batch, BattleWorld.mdr.getName(), 1050, 69);
							break;
						case 6:
							font.draw(batch, BattleWorld.inimigo1.getName(), 1050, 69);
							break;
						case 7:
							font.draw(batch, BattleWorld.inimigo2.getName(), 1050, 69);
							break;
						case 8:
							font.draw(batch, BattleWorld.inimigo3.getName(), 1050, 69);
							break;
						case 9:
							font.draw(batch, BattleWorld.inimigo4.getName(), 1050, 69);
							break;
						case 10:						
							font.draw(batch, BattleWorld.inimigo5.getName(), 1050, 69);
							break;
						case 11:
							font.draw(batch, BattleWorld.inimigo6.getName(), 1050, 69);
							break;
							
						}
						
						
						
					}
						
				}
				
				if(acao == 1) { //deslocar
					
					
					
					if(atual.getPositionX() == POS1) {
						
						
						font.draw(batch, "Volta 1", 800, 174);
					
						font.draw(batch, "Volta 2", 800, 139);
					
						font.draw(batch, "Volta 3", 800, 104);
					
						font.draw(batch, "Volta 4", 800, 69);
					
						font.draw(batch, "Volta 5", 800, 34);	
						
					}
					
					if(atual.getPositionX() == POS2) {
						
						font.draw(batch, "Volta 1", 800, 174);
						font.draw(batch, "Avanca 1", 800, 139);
					
					
						font.draw(batch, "Volta 2", 800, 104);
					
					
						font.draw(batch, "Volta 3", 800, 69);
					
						font.draw(batch, "Volta 4", 800, 34);
					}
					
					
					if(atual.getPositionX() == POS3) {
						
						font.draw(batch, "Volta 1", 800, 174);
						font.draw(batch, "Avanca 1", 800, 139);
					
					
						font.draw(batch, "Volta 2", 800, 104);
						font.draw(batch, "Avanca 2", 800, 69);
					
					
						font.draw(batch, "Volta 3", 800, 34);
						
						
					}
					
					if(atual.getPositionX() == POS4) {
						
						font.draw(batch, "Volta 1", 800, 174);
						font.draw(batch, "Avanca 1", 800, 139);
					
					
						font.draw(batch, "Volta 2", 800, 104);
						font.draw(batch, "Avanca 2", 800, 69);
					
					
						font.draw(batch, "Avanca 3", 800, 34);
					
						
					}
					
					if(atual.getPositionX() == POS5) {
						
						font.draw(batch, "Volta 1", 800, 174);
						font.draw(batch, "Avanca 1", 800, 139);
					
											
						font.draw(batch, "Avanca 2", 800, 104);
					
					
						font.draw(batch, "Avanca 3", 800, 69);
					
						font.draw(batch, "Avanca 4", 800, 34);
						
					}
					
					if(atual.getPositionX() == POS6) {
											
						font.draw(batch, "Avanca 1", 800, 174);
										
						font.draw(batch, "Avanca 2", 800, 139);
					
						font.draw(batch, "Avanca 3", 800, 104);
					
						font.draw(batch, "Avanca 4", 800, 69);
					
						font.draw(batch, "Avanca 5", 800, 34);
						
					}				
					
					
					font.setColor(Color.RED);
					
					switch (acaoOpcao)
					{
					case 0:
						if(atual.getPositionX() != POS6) {
							
							
							font.draw(batch, "Volta 1", 800, 174);						
						}
						
						else {
							
							font.draw(batch, "Avanca 1", 800, 174);					
						}			
						break;
					case 1:
						if((atual.getPositionX() != POS1 && atual.getPositionX() != POS6)) {
							
							font.draw(batch, "Avanca 1", 800, 139);
						}
						else {
							if(atual.getPositionX() == POS1) {
								
								font.draw(batch, "Volta 2", 800, 139);
							}
							if(atual.getPositionX() == POS6)
								
								font.draw(batch, "Avanca 2", 800, 139);
						}					
								
						
						break;
					case 2:
						
						if(atual.getPositionX() > POS5 && atual.getPositionX() < POS1)
							font.draw(batch, "Volta 2", 800, 104);
						else
							if(atual.getPositionX() == POS5)
								font.draw(batch, "Avanca 2", 800, 104);
							else {
								
								if(atual.getPositionX() == POS6)
									font.draw(batch, "Avanca 3", 800, 104);
								if(atual.getPositionX() == POS1)
									font.draw(batch, "Volta 3", 800, 104);
							}
								
						
						
						break;
					case 3:
						
						if(atual.getPositionX() == POS6)
							font.draw(batch, "Avanca 4", 800, 69);
						if(atual.getPositionX() == POS5)
							font.draw(batch, "Avanca 3", 800, 69);
						if(atual.getPositionX() == POS4)
							font.draw(batch, "Avanca 2", 800, 69);
						if(atual.getPositionX() == POS3)
							font.draw(batch, "Avanca 2", 800, 69);
						if(atual.getPositionX() == POS2)
							font.draw(batch, "Volta 3", 800, 69);
						if(atual.getPositionX() == POS1)
							font.draw(batch, "Volta 4", 800, 69);
							
							
							
						
						
						break;
					case 4:
						
						if(atual.getPositionX() == POS6)
							font.draw(batch, "Avanca 5", 800, 34);
						if(atual.getPositionX() == POS5)
							font.draw(batch, "Avanca 4", 800, 34);
						if(atual.getPositionX() == POS4)
							font.draw(batch, "Avanca 3", 800, 34);
						if(atual.getPositionX() == POS3)
							font.draw(batch, "Volta 3", 800, 34);
						if(atual.getPositionX() == POS2)
							font.draw(batch, "Volta 4", 800, 34);
						if(atual.getPositionX() == POS1)
							font.draw(batch, "Volta 5", 800, 34);
						
						break;	
					
					}		
				}
				
				if(acao == 2) { //inventario
					font.draw(batch, "Abrir invaentario?", 800, 174);
					font.draw(batch, "Sim", 800, 139);
					
					
					font.setColor(Color.RED);
					
					
					font.draw(batch, "Sim", 800, 139);
						
							
							
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
		if(atual.getAmigo() == false) { // Se for turno do inimigo
			
			
			font.getData().setScale(0.7f);
			font.setColor(Color.WHITE);
			
	
			if(inimigoAtacando == false) {
				posta = ":  " + CRodada.AI(CEngine.listaH, CEngine.listaV, CEngine.listaI, atual.getPersonagem());
				inimigoAtacando = true;	
			}
			
			font.draw(batch, "inimigo:  " + atual.getName() + posta , 520, 139);
			System.out.println("ESTOU AQUIIIIIIII");
			font.setColor(Color.RED);
			font.draw(batch, "OK" , 520, 104);
		}
			
		
		
	}
	
	@Override
	public void act(float delta) {
		
		
		if(atual.getAmigo() == true) { //se for o player jogando
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
			else {	//opcoes = true		
				
				if(acao == 0) {
					atual.setAtacando(true); // animacao de ataque
					
					if(acaoOpcao == 4)
						acaoOpcao = 0;
				}
				
				
				
				if(acao == 4 || acao == 3) {
					acaoOpcao = 1;
						
				}
					
				if(acao != 0) { // Aqui devem estar as opcoes de verdade
					if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
						
							
						if(acao == 1) { //Deslocar
							
							
								
							switch (acaoOpcao)
							{
							case 0:
								if(atual.getPositionX() != POS6) {
									
									
									//VOLTA 1						
								}
								
								else {
									
									//AVANCA 1				
								}			
								break;
							case 1:
								if((atual.getPositionX() != POS1 && atual.getPositionX() != POS6)) {
									
									//AVANCA 1
								}
								else {
									if(atual.getPositionX() == POS1) {
										
										//VOLTA 2
									}
									if(atual.getPositionX() == POS6) {
										
										//AVANCA 2
									}
								}					
										
								
								break;
							case 2:
								
								if(atual.getPositionX() > POS5 && atual.getPositionX() < POS1) {
									//VOLTA 2
								}
								else
									if(atual.getPositionX() == POS5) {
										//AVANCA 2
									}
									else {
										
										if(atual.getPositionX() == POS6) {
											//AVANCA 3
										}
										if(atual.getPositionX() == POS1) {
											//VOLTA 3
										}
									}
										
								
								
								break;
							case 3:
								
								if(atual.getPositionX() == POS6)
									//AVANCA 4
								if(atual.getPositionX() == POS5)
									//AVANCA 3
								if(atual.getPositionX() == POS4)
									//AVANCA 2
								if(atual.getPositionX() == POS3)
									//AVANCA 2
								if(atual.getPositionX() == POS2)
									//VOLTA 3
								if(atual.getPositionX() == POS1)
									//VOLTA 4
									
									
									
								
								
								break;
							case 4:
								
								if(atual.getPositionX() == POS6)
									//AVANCA 5
								if(atual.getPositionX() == POS5)
									//AVANCA 4
								if(atual.getPositionX() == POS4)
									//AVANCA 3
								if(atual.getPositionX() == POS3)
									//VOLTA 3
								if(atual.getPositionX() == POS2)
									//VOLTA 4
								if(atual.getPositionX() == POS1)
									//VOLTA 5
								
								break;	
							
							}
						}
							
						if(acao == 2) { //Inventario
								
							
						
							//ABRIR INVENTARIO
								
							
						}
							
						if(acao == 3) { // nada
								
							
						}
							
						if(acao == 4) { // fugir
								
							
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
							
						acaoOpcao = 0;
						acao = 0;
						opcoes = false;
						
						atual.setAtacando(false);
						
						/* Trocar de personagem*/
						AbsPersonagem personAtual = CRodada.getVez();
						
						if(personAtual != null) {
							if(personAtual.vilao == false) {
								if(personAtual.nome.equalsIgnoreCase("oleg"))
									atual = BattleWorld.barbudo;
								if(personAtual.nome.equalsIgnoreCase("silvana"))
									atual = BattleWorld.cientista;
								if(personAtual.nome.equalsIgnoreCase("ozob"))
									atual = BattleWorld.palhaco;
								if(personAtual.nome.equalsIgnoreCase("durden"))
									atual = BattleWorld.durden;
								if(personAtual.nome.equalsIgnoreCase("rexus"))
									atual = BattleWorld.rexus;
								if(personAtual.nome.equalsIgnoreCase("mdr"))
									atual = BattleWorld.mdr;		
							}
							else {
								if(personAtual.nome.equalsIgnoreCase("melee1"))
									atual = BattleWorld.inimigo1;
								if(personAtual.nome.equalsIgnoreCase("melee2"))
									atual = BattleWorld.inimigo2;
								if(personAtual.nome.equalsIgnoreCase("melee3"))
									atual = BattleWorld.inimigo3;
								if(personAtual.nome.equalsIgnoreCase("melee4"))
									atual = BattleWorld.inimigo4;
								if(personAtual.nome.equalsIgnoreCase("melee5"))
									atual = BattleWorld.inimigo5;
								if(personAtual.nome.equalsIgnoreCase("melee6"))
									atual = BattleWorld.inimigo6;	
							}
						}
						else { //O jogo acabou
							
						}
						
					}
				}
				else
				if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && acao == 0) {
					
					if(ataque == false) {
						ataque = true;
						
						if(CRodada.getAlvos(acaoOpcao, atual.getPersonagem()).equalsIgnoreCase("melee")) {
							alvo = 6;
						}
						else if(CRodada.getAlvos(acaoOpcao, atual.getPersonagem()).equalsIgnoreCase("ranged")) {
							alvo = 6;						
						}
						else if(CRodada.getAlvos(acaoOpcao, atual.getPersonagem()).equalsIgnoreCase("amigo")) {
							alvo = 0;
						}
					
						
						
					}
					else {
						
						
						switch(alvo) {
						case 0:
							
							switch(BattleWorld.palhaco.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							
							break;
						case 1:
							//oleg
							switch(BattleWorld.barbudo.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 2:
							//silvana
							switch(BattleWorld.cientista.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 3:
							//rexus
							switch(BattleWorld.rexus.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							
							break;
						case 4:
							//durden
							switch(BattleWorld.durden.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 5:
							//mdr
							switch(BattleWorld.mdr.getPositionX()) {
							case POS1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POS2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POS3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POS4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POS5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POS6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 6:
							switch(BattleWorld.inimigo1.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							//1
							break;
						case 7:
							//2
							switch(BattleWorld.inimigo2.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 8:
							//3
							switch(BattleWorld.inimigo3.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 9:
							//4
							switch(BattleWorld.inimigo4.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 10:
							//5
							switch(BattleWorld.inimigo5.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;
						case 11:
							//6
							switch(BattleWorld.inimigo6.getPositionX()) {
							case POSM1:
								CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
								break;
							case POSM2:
								CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
								break;
							case POSM3:
								CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
								break;
							case POSM4:
								CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
								break;
							case POSM5:
								CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
								break;
							case POSM6:
								CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
								break;
							
							}
							break;

						
						
						}
						
						acaoOpcao = 0;
						acao = 0;
						opcoes = false;
						ataque = false;
						
						atual.setAtacando(false);
						/* Trocar de personagem*/
						AbsPersonagem personAtual = CRodada.getVez();
						
						if(personAtual != null) {
							if(personAtual.vilao == false) {
								if(personAtual.nome.equalsIgnoreCase("oleg"))
									atual = BattleWorld.barbudo;
								if(personAtual.nome.equalsIgnoreCase("silvana"))
									atual = BattleWorld.cientista;
								if(personAtual.nome.equalsIgnoreCase("ozob"))
									atual = BattleWorld.palhaco;
								if(personAtual.nome.equalsIgnoreCase("durden"))
									atual = BattleWorld.durden;
								if(personAtual.nome.equalsIgnoreCase("rexus"))
									atual = BattleWorld.rexus;
								if(personAtual.nome.equalsIgnoreCase("mdr"))
									atual = BattleWorld.mdr;		
							}
							else {
								if(personAtual.nome.equalsIgnoreCase("melee1"))
									atual = BattleWorld.inimigo1;
								if(personAtual.nome.equalsIgnoreCase("melee2"))
									atual = BattleWorld.inimigo2;
								if(personAtual.nome.equalsIgnoreCase("melee3"))
									atual = BattleWorld.inimigo3;
								if(personAtual.nome.equalsIgnoreCase("melee4"))
									atual = BattleWorld.inimigo4;
								if(personAtual.nome.equalsIgnoreCase("melee5"))
									atual = BattleWorld.inimigo5;
								if(personAtual.nome.equalsIgnoreCase("melee6"))
									atual = BattleWorld.inimigo6;	
							}
						}
						else { //O jogo acabou
							
						}
						
					
				
						
						
						
						
						
						
						
					}
				}
				
				
			}
			
			
				
				
				
				
				
			
				
			if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
				opcoes = false;
				acaoOpcao = 0;
			}
				
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
					
				if(ataque == false) {
					if(acaoOpcao == 0) {
						
						acaoOpcao = 4;
					}
					else if(acao < 2)
						acaoOpcao--;
				
				}
				else { // Escolhendo o alvo
					
				if(var.equalsIgnoreCase("melee")) {
					if(alvo == 6) {
						alvo = 7;
					}
					else {
						alvo = 6;
					}					
				}
				if(var.equalsIgnoreCase("ranged")) {
					if(alvo < 11)
						alvo++;
					else
						alvo = 6;
				}
				if(var.equalsIgnoreCase("amigo")) {
					if(alvo < 5)
						alvo++;
					else
						alvo = 0;
				}
				
					
				}
				
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
				
				if(ataque == false) {
					if((acaoOpcao > 3 && acao != 1) || acaoOpcao == 5)
						if(acao != 4)
							acaoOpcao = 0;
						else
							acaoOpcao = 1;
						else
							acaoOpcao++;				
				}
				else {
					if(var.equalsIgnoreCase("melee")) {
						if(alvo == 7)
							alvo--;
						else
							alvo = 7; 
					}
					if(var.equalsIgnoreCase("ranged"))  {
						if(alvo > 6)
							alvo--;
						else
							alvo = 11;
					}
					if(var.equalsIgnoreCase("amigo")) {
						if(alvo > 1)
							alvo--;
						else
							alvo = 5;
					}
					
				}
			}	
				
		}
		else { // Vez do inimigo
			
			
			atual.setAtacando(true);		
			
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
				
				atual.setAtacando(false);		
				inimigoAtacando = false;
				
				/* Trocar de personagem*/
				AbsPersonagem personAtual = CRodada.getVez();
				
				if(personAtual != null) {
					if(personAtual.vilao == false) {
						if(personAtual.nome.equalsIgnoreCase("oleg"))
							atual = BattleWorld.barbudo;
						if(personAtual.nome.equalsIgnoreCase("silvana"))
							atual = BattleWorld.cientista;
						if(personAtual.nome.equalsIgnoreCase("ozob"))
							atual = BattleWorld.palhaco;
						if(personAtual.nome.equalsIgnoreCase("durden"))
							atual = BattleWorld.durden;
						if(personAtual.nome.equalsIgnoreCase("rexus"))
							atual = BattleWorld.rexus;
						if(personAtual.nome.equalsIgnoreCase("mdr"))
							atual = BattleWorld.mdr;		
					}
					else {
						if(personAtual.nome.equalsIgnoreCase("melee1"))
							atual = BattleWorld.inimigo1;
						if(personAtual.nome.equalsIgnoreCase("melee2"))
							atual = BattleWorld.inimigo2;
						if(personAtual.nome.equalsIgnoreCase("melee3"))
							atual = BattleWorld.inimigo3;
						if(personAtual.nome.equalsIgnoreCase("melee4"))
							atual = BattleWorld.inimigo4;
						if(personAtual.nome.equalsIgnoreCase("melee5"))
							atual = BattleWorld.inimigo5;
						if(personAtual.nome.equalsIgnoreCase("melee6"))
							atual = BattleWorld.inimigo6;	
					}
				}
				else { //O jogo acabou
					
				}
				
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
