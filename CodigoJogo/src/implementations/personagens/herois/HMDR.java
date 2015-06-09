package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do Androide MDR que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HMDR extends AbsPersonagem {
	public int forca = 35, percepcao = 25, resistencia = 25, carisma = 15, inteligencia = 55, agilidade = 35, sorte = 15;
	public String nome = "MDR";
	
	public static HMDR instancia = new HMDR();   
	
	public HMDR (){
		this.nSkill1 = "Crtical Slash";
		this.nSkill2 = "Cutthroat";
		this.nSkill3 = "Double-Dash";
	}
	
	public static HMDR getInstancia(){
		if(instancia == null)
			instancia = new HMDR();
		return instancia;
	}
}
