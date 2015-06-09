package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do Ozob que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HOzob extends AbsPersonagem {
	public static HOzob instancia = new HOzob();   
	
	private HOzob (){
		this.forca = 25; 
		this.percepcao = 35; 
		this.resistencia = 35; 
		this.carisma = 15; 
		this.inteligencia = 15; 
		this.agilidade = 15; 
		this.sorte = 35;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.nome = "Ozob";
		
		this.nSkill1 = "Grenade Throw";
		this.nSkill2 = "Shrapnel-Shell";
		this.nSkill3 = "Stun-Bomb";
		
		this.skill1 = new GranadeThrow();
		this.skill2 = new ShrapnelShell();
		this.skill3 = new StunBomb();
	}
	
	public static HOzob getInstancia(){
		if(instancia == null)
			instancia = new HOzob();
		return instancia;
	}
}
