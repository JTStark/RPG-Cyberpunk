package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do James Rexus que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HRexus extends AbsPersonagem {
	public static HRexus instancia = new HRexus();   
	
	private HRexus (){
		this.forca = 15; 
		this.percepcao = 15; 
		this.resistencia = 15; 
		this.carisma = 55; 
		this.inteligencia = 15; 
		this.agilidade = 15; 
		this.sorte = 45;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.nome = "Rexus";
		
		this.nSkill1 = "Charm";
		this.nSkill2 = "First-Aid";
		this.nSkill3 = "Inspire";

		this.skill0 = new AtaqueBasico();
		this.skill1 = new Charm();
		this.skill2 = new FirstAid();
		this.skill3 = new Inspire();
	}
	
	public static HRexus getInstancia(){
		if(instancia == null)
			instancia = new HRexus();
		return instancia;
	}
}
