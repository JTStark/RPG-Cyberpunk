package implementations.combate;

/**
 * @author - Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe de personagem genérico, para teste
 * 
 */

import implementations.personagens.AbsPersonagem;

public class PersonGenerico extends AbsPersonagem {

	public void SetAtributos (){
		this.forca = 15;
		this.percepcao = 15;
		this.resistencia = 15;
		this.carisma = 15;
		this.inteligencia = 15;
		this.agilidade = 15;
		this.sorte = 15;
		
	}
}
