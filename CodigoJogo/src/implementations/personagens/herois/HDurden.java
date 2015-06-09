package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do Steven T. Durden que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HDurden extends AbsPersonagem {
	public int forca = 35, percepcao = 25, resistencia = 45, carisma = 15, inteligencia = 15, agilidade = 15, sorte = 25;
	public String nome = "Durden";
	
	public static HDurden instancia = new HDurden();   
	
	public HDurden (){
		this.nSkill1 = "Stuning Blow";
		this.nSkill2 = "Shields Up";
		this.nSkill3 = "Charge!";
	}
	
	public static HDurden getInstancia(){
		if(instancia == null)
			instancia = new HDurden();
		return instancia;
	}
}
