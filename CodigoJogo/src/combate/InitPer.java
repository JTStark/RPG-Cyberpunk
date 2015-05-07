package combate;

/*
 * Autores: Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe que guarda infos basicas dos jogadores, para organizar no vetor
 * 
 */

public class InitPer {
	String time;
	PersonGenerico esse;
	int iniciativa;

	public InitPer (String team, PersonGenerico actual, int init){
		this.time = team;
		this.esse = actual;
		this.iniciativa = init;
	}
}
