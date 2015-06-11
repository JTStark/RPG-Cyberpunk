package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.skills.*;

/**
 * Classe do Androide MDR que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HMDR extends AbsPersonagem {
	public static HMDR instancia = new HMDR();
	
	private HMDR (){
		this.forca = 35; 
		this.percepcao = 25; 
		this.resistencia = 25; 
		this.carisma = 15; 
		this.inteligencia = 55; 
		this.agilidade = 35; 
		this.sorte = 15;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.nome = "MDR";
		
		this.nSkill1 = "Crtical Slash";
		this.nSkill2 = "Cutthroat";
		this.nSkill3 = "Double-Dash";

		this.skill0 = new AtaqueBasico();
		this.skill1 = new CriticalSlash();
		this.skill2 = new CutThroat();
		this.skill3 = new DoubleDash();
	}
	
	public static HMDR getInstancia(){
		if(instancia == null)
			instancia = new HMDR();
		return instancia;
	}
}
