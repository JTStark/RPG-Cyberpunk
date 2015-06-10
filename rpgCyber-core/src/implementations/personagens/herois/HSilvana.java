package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do Dr. Angus Silvana que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HSilvana extends AbsPersonagem {
	public static HSilvana instancia = new HSilvana();   
	
	private HSilvana (){
		this.forca = 15;
		this.percepcao = 25; 
		this.resistencia = 15; 
		this.carisma = 15; 
		this.inteligencia = 65; 
		this.agilidade = 25; 
		this.sorte = 15;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.nome = "Silvana";
				
		this.nSkill1 = "Acid bomb";
		this.nSkill2 = "Poison Dart";
		this.nSkill3 = "Invisibility-Cloak";

		this.skill0 = new AtaqueBasico();
		this.skill1 = new AcidBomb();
		this.skill2 = new PoisonDart();
		this.skill3 = new InvisibilityCloak();
		
		this.tipo = 5;
	}
	
	public static HSilvana getInstancia(){
		if(instancia == null)
			instancia = new HSilvana();
		return instancia;
	}
}
