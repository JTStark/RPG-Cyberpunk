package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do Oleg Korolenko que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HOleg extends AbsPersonagem {
	public int forca = 25, percepcao = 45, resistencia = 15, carisma = 15, inteligencia = 15, agilidade = 35, sorte = 25;
	public String nome = "Oleg";
	
	public static HOleg instancia = new HOleg();   
	
	public HOleg (){
		this.nSkill1 = "Headshot";
		this.nSkill2 = "Piercing Bullet";
		this.nSkill3 = "Power-Shot";
	}
	
	public static HOleg getInstancia(){
		if(instancia == null)
			instancia = new HOleg();
		return instancia;
	}
}
