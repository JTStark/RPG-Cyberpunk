package implementations.combate;

/**
 * @author - Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe de teste
 * 
 */

import java.util.ArrayList;
import implementations.personagens.AbsPersonagem;

public class AuxTemp {
	
	public int auxiliarIniciativa=0;
	
	public static void main(String[] args){
		PersonGenerico hFirst = new PersonGenerico();
		PersonGenerico hSecond = new PersonGenerico();
		//PersonGenerico hThird = new PersonGenerico();
		//PersonGenerico hFourth = new PersonGenerico();
		//PersonGenerico hFifth = new PersonGenerico();
		//PersonGenerico hSixth = new PersonGenerico();
		
		PersonGenerico vFirst = new PersonGenerico();
		PersonGenerico vSecond = new PersonGenerico();
		//PersonGenerico vThird = new PersonGenerico();
		//PersonGenerico vFourth = new PersonGenerico();
		//PersonGenerico vFifth = new PersonGenerico();
		//PersonGenerico vSixth = new PersonGenerico();
		
		
		ArrayList<AbsPersonagem> vetorHer = new ArrayList<AbsPersonagem> ();
		hFirst.agilidade = 50;
		hFirst.sorte = 50;
		hFirst.nome = "hFirst";
		hFirst.tipo = 1;
		hSecond.agilidade = 50;
		hSecond.sorte = 50;
		hSecond.nome = "hSecond";
		hSecond.tipo = 1;
		vetorHer.add(0, hFirst);
		vetorHer.add(1, hSecond);
		
		ArrayList<AbsPersonagem> vetorVil = new ArrayList<AbsPersonagem> ();
		vFirst.agilidade = 50;
		vFirst.sorte = 50;
		vFirst.nome = "vFirst";
		vFirst.tipo = 1;
		vSecond.agilidade = 1;
		vSecond.sorte = 1;
		vSecond.nome = "vSecond";
		vSecond.tipo = 2;
		vetorVil.add(0, hFirst);
		vetorVil.add(1, hSecond);
		
		CEngine.CombatEngine(vetorHer, vetorVil);
	}
	
}
