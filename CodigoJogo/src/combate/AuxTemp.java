package combate;

/*
 * Autores: Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe de teste
 * 
 */

public class AuxTemp {
	
	public static void main(String[] args){
		PersonGenerico[] vetorHer = new PersonGenerico[2];
		vetorHer[0].agilidade = 99;
		vetorHer[0].sorte = 99;
		vetorHer[1].agilidade = 1;
		vetorHer[1].sorte = 1;
		
		PersonGenerico[] vetorVil = new PersonGenerico[2];
		vetorVil[0].agilidade = 50;
		vetorVil[0].sorte = 50;
		vetorVil[1].agilidade = 1;
		vetorVil[1].sorte = 1;
		
		CEngine arrayOrdenado = new CEngine(vetorHer, vetorVil);	
	}
	
}
