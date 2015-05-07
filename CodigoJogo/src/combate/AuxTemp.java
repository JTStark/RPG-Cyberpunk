package combate;

/*
 * Autores: Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe de teste
 * 
 */
import java.util.ArrayList;

public class AuxTemp {
	
	public static void main(String[] args){
		PersonGenerico hFirst = new PersonGenerico();
		PersonGenerico hSecond = new PersonGenerico();
		PersonGenerico vFirst = new PersonGenerico();
		PersonGenerico vSecond = new PersonGenerico();
		
		ArrayList<PersonGenerico> vetorHer = new ArrayList<PersonGenerico> ();
		hFirst.agilidade = 99;
		hFirst.sorte = 99;
		hSecond.agilidade = 1;
		hSecond.sorte = 1;
		vetorHer.add(0, hFirst);
		vetorHer.add(1, hSecond);
		
		ArrayList<PersonGenerico> vetorVil = new ArrayList<PersonGenerico> ();
		vFirst.agilidade = 50;
		vFirst.sorte = 50;
		vSecond.agilidade = 1;
		vSecond.sorte = 1;
		vetorVil.add(0, hFirst);
		vetorVil.add(1, hSecond);
		
		CEngine arrayOrdenado = new CEngine(vetorHer, vetorVil);
	}
	
}
