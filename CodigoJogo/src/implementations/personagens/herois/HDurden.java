package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do Steven T. Durden que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HDurden extends AbsPersonagem {
	public static HDurden instancia = new HDurden();   

	private HDurden (){
		this.forca = 35; 
		this.percepcao = 25; 
		this.resistencia = 45; 
		this.carisma = 15; 
		this.inteligencia = 15; 
		this.agilidade = 15; 
		this.sorte = 25;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;

		this.nome = "Durden";
		
		this.nSkill1 = "Stuning Blow";
		this.nSkill2 = "Shields Up";
		this.nSkill3 = "Charge!";
		
		this.skill1 = new StunnigBlow();
		this.skill2 = new ShieldsUp();
		this.skill3 = new Charge1();
	}
	
	public static HDurden getInstancia(){
		if(instancia == null)
			instancia = new HDurden();
		return instancia;
	}
}
