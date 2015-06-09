package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do Dr. Angus Silvana que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HSilvana extends AbsPersonagem {
	public int forca = 15, percepcao = 25, resistencia = 15, carisma = 15, inteligencia = 65, agilidade = 25, sorte = 15;
	public String nome = "Silvana";
	
	public static HSilvana instancia = new HSilvana();   
	
	public HSilvana (){
		this.nSkill1 = "Acid bomb";
		this.nSkill2 = "Poison Dart";
		this.nSkill3 = "Invisibility-Cloak";
	}
	
	public static HSilvana getInstancia(){
		if(instancia == null)
			instancia = new HSilvana();
		return instancia;
	}
}
