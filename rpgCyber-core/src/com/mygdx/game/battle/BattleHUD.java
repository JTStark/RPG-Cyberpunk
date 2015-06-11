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
	
	private String xpPalhaco = "";
	private String xpDurden = "";
	private String xpMdr = "";
	private String xpCientista = "";
	private String xpBarbudo = "";
	private String xpRexus = "";
	

	
	private static boolean ganhou = false;
	private static boolean perdeu = false;
	
	private boolean ataque = false;
	private boolean inimigoAtacando = false;
	
	private boolean ataquei = false;
	
	private int alvo = 0;
	
	private String var;
	
	private int escolha = 0;
	private boolean opcaoEscolha = false;
	
	private String resultado = "";
	
	private boolean ok = false;
	
	
	private static final int POS1 = -20, POS2 = -70, POS3 = -130, POS4 = -200, POS5 = -270, POS6 = -320;
	private static final int POSM1 = 30, POSM2 = 80, POSM3 = 130, POSM4 = 180, POSM5 = 230, POSM6 = 280;
	private static final int DEAD = 1500;
	
	private BattleChar atual;
	
	public BattleHUD (String levelData) {
		super();
		
		ganhou = false;
		perdeu = false;
		
		infos = new SnakeInfosHUD();
		dialog  = new SnakeDialogHUD();
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		
		atualizaPosition();		
		
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
	
	private void atualizaPosition() {
		/* Vejo a posicao a partir das listas do CEngine */
		posicao(BattleWorld.palhaco);
		posicao(BattleWorld.barbudo);
		posicao(BattleWorld.cientista);
		posicao(BattleWorld.durden);
		posicao(BattleWorld.rexus);
		posicao(BattleWorld.mdr);
		
		/* inimigos */
		posicao(BattleWorld.inimigo1);
		posicao(BattleWorld.inimigo2);
		posicao(BattleWorld.inimigo3);
		posicao(BattleWorld.inimigo4);
		posicao(BattleWorld.inimigo5);
		posicao(BattleWorld.inimigo6);
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha){
		font.setColor(Color.RED);
		
		font.getData().setScale(1f);	
		
		if(!ganhou && !perdeu) {
		
			font.draw(batch, atual.getName(), 400 + atual.getPositionTurno(), 500); 
			
			/* Postar a vida */
			font.getData().setScale(0.8f);	
			
			/* Postar os amigos */
			if(BattleWorld.palhaco.getVivo()) {
				if(BattleWorld.palhaco.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.palhaco.getPersonagem().hp, 440 + BattleWorld.palhaco.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.palhaco.getPositionTurno(), 350);
				}
			}
			if(BattleWorld.durden.getVivo())
				if(BattleWorld.durden.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.durden.getPersonagem().hp, 440 + BattleWorld.durden.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.durden.getPositionTurno(), 350);
				}
			if(BattleWorld.cientista.getVivo())
				font.draw(batch, "" + (int)BattleWorld.cientista.getPersonagem().hp, 440 + BattleWorld.cientista.getPositionTurno(), 350);
			if(BattleWorld.mdr.getVivo())
				font.draw(batch, "" + (int)BattleWorld.mdr.getPersonagem().hp, 440 + BattleWorld.mdr.getPositionTurno(), 350); 
			if(BattleWorld.rexus.getVivo())
				font.draw(batch, "" + (int)BattleWorld.rexus.getPersonagem().hp, 440 + BattleWorld.rexus.getPositionTurno(), 350); 
			if(BattleWorld.barbudo.getVivo())
				font.draw(batch, "" + (int)BattleWorld.barbudo.getPersonagem().hp, 440 + BattleWorld.barbudo.getPositionTurno(), 350); 
			
			/* Postar os inimigos */
			if(BattleWorld.inimigo1.getVivo())
				if(BattleWorld.inimigo1.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo1.getPersonagem().hp, 440 + BattleWorld.inimigo1.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo1.getPositionTurno(), 350);
				}
			if(BattleWorld.inimigo2.getVivo())
				if(BattleWorld.inimigo2.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo2.getPersonagem().hp, 440 + BattleWorld.inimigo2.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo2.getPositionTurno(), 350);
				}
			if(BattleWorld.inimigo3.getVivo())
				if(BattleWorld.inimigo3.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo3.getPersonagem().hp, 440 + BattleWorld.inimigo3.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo3.getPositionTurno(), 350);
				}
			if(BattleWorld.inimigo4.getVivo())
				if(BattleWorld.inimigo4.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo4.getPersonagem().hp, 440 + BattleWorld.inimigo4.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo4.getPositionTurno(), 350);
				}
			if(BattleWorld.inimigo5.getVivo())
				if(BattleWorld.inimigo5.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo5.getPersonagem().hp, 440 + BattleWorld.inimigo5.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo5.getPositionTurno(), 350);
				}
			if(BattleWorld.inimigo6.getVivo())
				if(BattleWorld.inimigo6.getPersonagem().hp > 0) {
					font.draw(batch, "" + (int)BattleWorld.inimigo6.getPersonagem().hp, 440 + BattleWorld.inimigo6.getPositionTurno(), 350);
				}
				else {
					font.draw(batch, "Morreu", 440 + BattleWorld.inimigo6.getPositionTurno(), 350);
				}
			
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
				
				if(ataquei == false) {
					/* Acao */
					font.getData().setScale(0.7f);
					font.setColor(Color.WHITE);
					font.draw(batch, "Atacar", 650, 174);
					font.draw(batch, "Deslocar", 650, 139);
					font.draw(batch, "Inventario", 650, 104);
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
						font.draw(batch, "Inventario", 650, 104);
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
				else { // Se eu ataquei, mostra o meu ataque
					font.getData().setScale(0.7f);
					font.setColor(Color.WHITE);
					font.draw(batch, resultado, 520, 139);
					
					font.setColor(Color.RED);
					font.draw(batch, "OK" , 520, 104);
					
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
				
				font.setColor(Color.RED);
				font.draw(batch, "OK" , 520, 104);
			}
		}
		else {
			if(ganhou) {
				font.getData().setScale(2f);				
				font.setColor(Color.WHITE);
				
				font.draw(batch, "Aperte Enter" , 300, 700);
				
				font.getData().setScale(0.8f);	
				font.setColor(Color.WHITE);
				
				font.draw(batch, "Durden: " + xpDurden , 300, 600);
				font.draw(batch, "MDR: " + xpMdr , 300, 550);
				font.draw(batch, "Ozob: " + xpPalhaco , 300, 500);
				font.draw(batch, "Rexus: " + xpRexus , 300, 450);
				font.draw(batch, "Silvana: " + xpCientista , 300, 400);
				font.draw(batch, "Oleg: " + xpBarbudo ,300, 350);
				
				font.setColor(Color.RED);
				font.getData().setScale(3f);
				font.draw(batch, "ok" , 700,150);
				
			}
			if(perdeu) {
				font.getData().setScale(2f);				
				font.setColor(Color.WHITE);
				
				font.draw(batch, "Voce Perdeu!" , 300, 700);
				font.setColor(Color.RED);
				font.draw(batch, "ok" , 520, 69);
			}
		}
		
		
	}
	
	@Override
	public void act(float delta) {
		
		if(!ganhou && !perdeu) {
		
			if(atual.getAmigo() == true) { //se for o player jogando
				
				if(ataquei)
					if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
						ok = true;
				
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
										if(atual.getPositionX() == POS5)
											CRodada.Reposition(CEngine.listaH, 4, 5);
										else
											if(atual.getPositionX() == POS4)
												CRodada.Reposition(CEngine.listaH, 3, 4);
											else
												if(atual.getPositionX() == POS3)
													CRodada.Reposition(CEngine.listaH, 2, 3);
												else
													if(atual.getPositionX() == POS2)
														CRodada.Reposition(CEngine.listaH, 1, 2);
													else
														if(atual.getPositionX() == POS1)
															CRodada.Reposition(CEngine.listaH, 0, 1);
										//VOLTA 1						
									}
									
									else {
										if(atual.getPositionX() == POS6)
											CRodada.Reposition(CEngine.listaH, 5, 4);
										else
											if(atual.getPositionX() == POS5)
												CRodada.Reposition(CEngine.listaH, 4, 3);
											else
												if(atual.getPositionX() == POS4)
													CRodada.Reposition(CEngine.listaH, 3, 2);
												else
													if(atual.getPositionX() == POS3)
														CRodada.Reposition(CEngine.listaH, 2, 1);
													else
														if(atual.getPositionX() == POS2)
															CRodada.Reposition(CEngine.listaH, 1, 0);
										
										//AVANCA 1				
									}			
									break;
								case 1:
									if((atual.getPositionX() != POS1 && atual.getPositionX() != POS6)) {
										if(atual.getPositionX() == POS6)
											CRodada.Reposition(CEngine.listaH, 5, 4);
										else
											if(atual.getPositionX() == POS5)
												CRodada.Reposition(CEngine.listaH, 4, 3);
											else
												if(atual.getPositionX() == POS4)
													CRodada.Reposition(CEngine.listaH, 3, 2);
												else
													if(atual.getPositionX() == POS3)
														CRodada.Reposition(CEngine.listaH, 2, 1);
													else
														if(atual.getPositionX() == POS2)
															CRodada.Reposition(CEngine.listaH, 1, 0);
										//AVANCA 1
									}
									else {
										if(atual.getPositionX() == POS1) {
											CRodada.Reposition(CEngine.listaH, 0, 2);
											//VOLTA 2
										}
										if(atual.getPositionX() == POS6) {
											CRodada.Reposition(CEngine.listaH, 5, 3);
											//AVANCA 2
										}
									}					
											
									
									break;
								case 2:
									
									if(atual.getPositionX() > POS5 && atual.getPositionX() < POS1) {
										//VOLTA 2
										if(atual.getPositionX() == POS4) 
											CRodada.Reposition(CEngine.listaH, 3, 5);
										if(atual.getPositionX() == POS3) 
											CRodada.Reposition(CEngine.listaH, 2, 4);
										if(atual.getPositionX() == POS2) 
											CRodada.Reposition(CEngine.listaH, 1, 3);
										
									}
									else
										if(atual.getPositionX() == POS5) {
											//AVANCA 2
											CRodada.Reposition(CEngine.listaH, 4, 2);
										}
										else {
											
											if(atual.getPositionX() == POS6) {
												//AVANCA 3
												CRodada.Reposition(CEngine.listaH, 5, 2);
											}
											if(atual.getPositionX() == POS1) {
												//VOLTA 3
												CRodada.Reposition(CEngine.listaH, 0, 3);
											}
										}
											
									
									
									break;
								case 3:
									
									if(atual.getPositionX() == POS6)
										//AVANCA 4
										CRodada.Reposition(CEngine.listaH, 5, 1);
									if(atual.getPositionX() == POS5)
										//AVANCA 3
										CRodada.Reposition(CEngine.listaH, 4, 1);
									if(atual.getPositionX() == POS4)
										//AVANCA 2
										CRodada.Reposition(CEngine.listaH, 3, 1);
									if(atual.getPositionX() == POS3)
										//volta 2
										CRodada.Reposition(CEngine.listaH, 2, 4);
									if(atual.getPositionX() == POS2)
										//VOLTA 3
										CRodada.Reposition(CEngine.listaH, 1, 4);
									if(atual.getPositionX() == POS1)
										//VOLTA 4
										CRodada.Reposition(CEngine.listaH, 0, 4);
										
										
										
									
									
									break;
								case 4:
									
									if(atual.getPositionX() == POS6)
										//AVANCA 5
										CRodada.Reposition(CEngine.listaH, 5, 0);
									if(atual.getPositionX() == POS5)
										//AVANCA 4
										CRodada.Reposition(CEngine.listaH, 4, 0);
									if(atual.getPositionX() == POS4)
										//AVANCA 3
										CRodada.Reposition(CEngine.listaH, 3, 0);
									if(atual.getPositionX() == POS3)
										//VOLTA 3
										CRodada.Reposition(CEngine.listaH, 2, 5);
									if(atual.getPositionX() == POS2)
										//VOLTA 4
										CRodada.Reposition(CEngine.listaH, 1, 5);
									if(atual.getPositionX() == POS1)
										//VOLTA 5
										CRodada.Reposition(CEngine.listaH, 0, 5);
									
									break;	
								
								}
								
								atualizaPosition();
							}
								
							if(acao == 2) { //Inventario
									
								
							
								//ABRIR INVENTARIO
									
								
							}
								
							if(acao == 3) { // nada
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
								
									
								
							}
								
							if(acao == 4) { // fugir
									

								CEngine.listaV.clear();
									
								
									
								
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
							
							if(ataquei == false) {
								switch(alvo) {
								case 0:								
									resultado = CRodada.atacar(6, acaoOpcao, atual.getPersonagem());								
									break;
								case 1:									
									resultado = CRodada.atacar(5, acaoOpcao, atual.getPersonagem());					
									
									
									break;
								case 2:
									
									resultado = CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
										
									
									
									break;
								case 3:
									
										resultado = CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
										
									
									break;
								case 4:
									
									resultado = CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
										
									break;
								case 5:
									resultado = CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
										
									break;
								case 6:
									
									resultado = CRodada.atacar(1, acaoOpcao, atual.getPersonagem());
										
									//1
									break;
								case 7:
									resultado = CRodada.atacar(2, acaoOpcao, atual.getPersonagem());
										
									break;
								case 8:
									
									resultado = CRodada.atacar(3, acaoOpcao, atual.getPersonagem());
										
									break;
								case 9:
									
									resultado = CRodada.atacar(4, acaoOpcao, atual.getPersonagem());
										
									break;
								case 10:
									
									resultado = CRodada.atacar(5, acaoOpcao, atual.getPersonagem());
										
									break;
								case 11:
									//6
									
									resultado = CRodada.atacar(6, acaoOpcao, atual.getPersonagem());
										
									break;
		
								
								}
							}
							
							ataquei = true;
							
							
							
							if(ok) {
								
								ok = false;
								ataquei = false;
							
								if(BattleWorld.inimigo1.getPersonagem().hp <= 0 && BattleWorld.inimigo1.getVivo() == true) {
									BattleWorld.inimigo1.morreu();
									BattleWorld.n_viloes--;
									
								}
								if(BattleWorld.inimigo2.getPersonagem().hp <= 0)
									BattleWorld.inimigo2.morreu();
								if(BattleWorld.inimigo3.getPersonagem().hp <= 0)
									BattleWorld.inimigo3.morreu();
								if(BattleWorld.inimigo4.getPersonagem().hp <= 0)
									BattleWorld.inimigo4.morreu();
								if(BattleWorld.inimigo5.getPersonagem().hp <= 0)
									BattleWorld.inimigo5.morreu();
								if(BattleWorld.inimigo6.getPersonagem().hp <= 0)
									BattleWorld.inimigo6.morreu();
								
								acaoOpcao = 0;
								acao = 0;
								opcoes = false;
								ataque = false;
								atualizaPosition();
								
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
								
								
							}
							
							
						
					
							
							
							
							
							
							
							
						}
					}
					
					
				}
				
				if(CEngine.listaV.isEmpty()) {
					BattleWorld.musica.stop();
					BattleWorld.musica.dispose();
					
					ganhou = true;   
					System.out.println("ACABOU GANHAMOOOOO"); 
					
					CRodada.endBattle(CEngine.listaH, CEngine.listaI);
					xpPalhaco = CRodada.exp(CRodada.EXP, BattleWorld.palhaco.getPersonagem());
					xpDurden = CRodada.exp(CRodada.EXP, BattleWorld.durden.getPersonagem());
					xpCientista = CRodada.exp(CRodada.EXP, BattleWorld.cientista.getPersonagem());
					xpBarbudo = CRodada.exp(CRodada.EXP, BattleWorld.barbudo.getPersonagem());
					xpMdr = CRodada.exp(CRodada.EXP, BattleWorld.mdr.getPersonagem());
					xpRexus = CRodada.exp(CRodada.EXP, BattleWorld.rexus.getPersonagem());
					
					
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
						if(alvo == 6 && CEngine.listaV.size() > 1) {
							alvo = 7;
						}
						else {
							alvo = 6;
						}					
					}
					if(var.equalsIgnoreCase("ranged")) {
						if(alvo < CEngine.listaV.size() + 5)
							alvo++;
						else
							alvo = 6;
					}
					if(var.equalsIgnoreCase("amigo")) {
						if(alvo < CEngine.listaH.size())
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
								if(CEngine.listaV.size() > 1)
									alvo = 7; 
						}
						if(var.equalsIgnoreCase("ranged"))  {
							if(alvo > 6)
								alvo--;
							else
								alvo = CEngine.listaV.size() + 5;
						}
						if(var.equalsIgnoreCase("amigo")) {
							if(alvo > 1)
								alvo--;
							else
								alvo = CEngine.listaH.size();
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
						atualizaPosition();
					}
					else { //O jogo acabou e perdemos
						
						perdeu = true;
						BattleWorld.musica.stop();
						BattleWorld.musica.dispose();
					}
					
				}
			}
		}
		else { //acabou
			if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
				BattleWorld.barbudo = null;
				BattleWorld.palhaco = null;
				BattleWorld.cientista = null;
				BattleWorld.rexus = null;
				BattleWorld.mdr = null;
				BattleWorld.durden = null;
				
				BattleWorld.inimigo1 = null;
				BattleWorld.inimigo2 = null;
				BattleWorld.inimigo3 = null;
				BattleWorld.inimigo4 = null;
				BattleWorld.inimigo5 = null;
				BattleWorld.inimigo6 = null;
				
				BattleWorld.musica = null; 
				
				
				
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
		
		
	}	

	private void posicao(BattleChar per) {
		
		int pos = 0;
		
		if(per.getAmigo() == true) {
		
			for(int i = 0; i < CEngine.listaH.size(); i++) {
				if(CEngine.listaH.get(i) == per.getPersonagem())
					pos = i;
			}
			
			switch(pos) {
			case 0:
				per.setPositionX(POS1);
				break;
			case 1:
				per.setPositionX(POS2);
				break;
			case 2:
				per.setPositionX(POS3);
				break;
			case 3:
				per.setPositionX(POS4);
				break;
			case 4:
				per.setPositionX(POS5);
				break;
			case 5:
				per.setPositionX(POS6);
				break;	
			default: 
				per.setPositionX(DEAD);

			}
		}
		else { //se for vilao
			for(int i = 0; i < CEngine.listaV.size(); i++) {
				if(CEngine.listaV.get(i) == per.getPersonagem())
					pos = i;
			}
			
			switch(pos) {
			case 0:
				per.setPositionX(POSM1);
				break;
			case 1:
				per.setPositionX(POSM2);
				break;
			case 2:
				per.setPositionX(POSM3);
				break;
			case 3:
				per.setPositionX(POSM4);
				break;
			case 4:
				per.setPositionX(POSM5);
				break;
			case 5:
				per.setPositionX(POSM6);
				break;	
			default: 
				per.setPositionX(DEAD);
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
	
	public static boolean getAcabou() {
		return (ganhou || perdeu);
	}

}
