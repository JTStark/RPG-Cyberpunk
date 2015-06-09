package implementations.personagens.herois;

import implementations.personagens.AbsPersonagem;

/**
 * Classe do James Rexus que herda a abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public class HRexus extends AbsPersonagem {
	public int forca = 15, percepcao = 15, resistencia = 15, carisma = 55, inteligencia = 15, agilidade = 15, sorte = 45;
	public String nome = "Rexus";
	
	public static HRexus instancia = new HRexus();   
	
	public HRexus (){
		this.nSkill1 = "Charm";
		this.nSkill2 = "First-Aid";
		this.nSkill3 = "Inspire";
	}
	
	public static HRexus getInstancia(){
		if(instancia == null)
			instancia = new HRexus();
		return instancia;
	}
}
