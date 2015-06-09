package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do Ozob que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HOzob extends AbsPersonagem {
	public int forca = 25, percepcao = 35, resistencia = 35, carisma = 15, inteligencia = 15, agilidade = 15, sorte = 35;
	public String nome = "Ozob";
	
	public static HOzob instancia = new HOzob();   
	
	public HOzob (){
		
	}
	
	public static HOzob getInstancia(){
		if(instancia == null)
			instancia = new HOzob();
		return instancia;
	}
}
