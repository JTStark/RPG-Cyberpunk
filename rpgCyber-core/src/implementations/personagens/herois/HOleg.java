package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do Oleg Korolenko que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HOleg extends AbsPersonagem {
	public static HOleg instancia = new HOleg();   
	
	private HOleg (){
		this.forca = 25; 
		this.percepcao = 45; 
		this.resistencia = 15; 
		this.carisma = 15; 
		this.inteligencia = 15; 
		this.agilidade = 35; 
		this.sorte = 25;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.nome = "Oleg";
		
		this.nSkill1 = "Headshot";
		this.nSkill2 = "Piercing Bullet";
		this.nSkill3 = "Power-Shot";

		this.skill0 = new AtaqueBasico();
		this.skill1 = new Headshot();
		this.skill2 = new PiercingBullet();
		this.skill3 = new PowerShot();
		
		this.tipo = 3;
	}
	
	public static HOleg getInstancia(){
		if(instancia == null)
			instancia = new HOleg();
		return instancia;
	}
}
