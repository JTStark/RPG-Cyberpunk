package com.mygdx.game.battle;

import implementations.combate.CEngine;
import implementations.personagens.AbsPersonagem;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.animate.*;

public class BattleChar extends Animator {
	
	private Animax wait, attack;	
	private boolean atacando = false;
	private int x = -200;
	private String name;
	private boolean amigo;
	
	private AbsPersonagem person; 

	public BattleChar(String personagem) {
		super("characters/" + personagem + "Battle.png");
		
		String file = "characters/" + personagem + "Battle.png";
		
		width = Gdx.app.getGraphics().getWidth()/13;
    	height = Gdx.app.getGraphics().getHeight()/8;
		
		/* Animacao de parado */
		wait = new Animax();
		
		wait.setTexture(file); 
        wait.setTextureRegions(FRAME_ROWS,FRAME_COLS,1,1,1,3);
        wait.setAnimation(1/3f);      
        wait.setSpriteBatch();                
        wait.setStateTime(0f);
        
        /* Animacao de atacando */
        attack = new Animax();
        
        attack.setTexture(file); 
        attack.setTextureRegions(FRAME_ROWS,FRAME_COLS,4,1,4,3);
        attack.setAnimation(1/3f);      
        attack.setSpriteBatch();                
        attack.setStateTime(0f);
        
        name = personagem;
        
        
       // System.out.println("O tamanhho::::" + CEngine.listaI.size());
        for(int i = 0; i < CEngine.listaI.size(); i++ ) {
        	if(name.equalsIgnoreCase(CEngine.listaI.get(i).nome)) {
        		person = CEngine.listaI.get(i);
        		//System.out.println("Achei:  " + person.nome);
        	}
        	
        	//System.out.println("na lista: " + CEngine.listaI.get(i).nome);
        	
        	//System.out.println("O meu i �: " + i);
        }
        
        if(CEngine.listaH == null)
        	System.out.println("deu merda, listaI vazia");
        
        
        
		
	}
	
	@Override
	public void act () {
		if(atacando) {
			attack = animate(attack);
		}
		else
			wait = animate(wait);
	}
	
	@Override
	public Animax animate(Animax play){
    	play.addStateTime( Gdx.graphics.getDeltaTime());           // #15
        play.setTextureRegion( play.getAnimation().getKeyFrame(play.getStateTime(), true));  // #16
        play.getSpriteBatch().begin(); 
        play.getSpriteBatch().draw(play.getTextureRegion(), x+Gdx.app.getGraphics().getWidth()/2, Gdx.app.getGraphics().getHeight()/2, width, height);// #17
        play.getSpriteBatch().end();
        return play;
    }
	
	public void setPositionX(int x) {
		this.x = x;
	}
	
	public int getPositionX() {
		return this.x;
	}
	
	public int getPositionTurno() {
		int retorno = 0;
		
		switch (this.x) {
		case 280:
			retorno = 780;
			break;
		case 230:
			retorno = 680;
			break;
		case 180:
			retorno = 580;
			break;
		case 130:
			retorno = 480;
			break;
		case 80:
			retorno = 380;
			break;
		case 30:
			retorno = 290;
			break;
		case -20:
			retorno = 175;
			break;
		case -70:
			retorno = 80;
			break;
		case -130:
			retorno = -40;
			break;
		case -200:
			retorno = -180;
			break;
		case -270:
			retorno = -300;
			break;
		case -320:
			retorno = -400;
			break;
		}
		
		return retorno;
	}
	
	public void setAtacando(boolean atacando) {
		this.atacando = atacando;
	}
	
	public String getName() {
		return this.name;
	}
	
	public AbsPersonagem getPersonagem() {
		return this.person;
	}
	
	public boolean getAmigo() {
		return this.amigo;
	}
	
	public void setAmigo(boolean amigo) {
		this.amigo = amigo;
	}

}
