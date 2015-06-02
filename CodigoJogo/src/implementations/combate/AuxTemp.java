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
		PersonGenerico hThird = new PersonGenerico();
		PersonGenerico hFourth = new PersonGenerico();
		PersonGenerico hFifth = new PersonGenerico();
		PersonGenerico hSixth = new PersonGenerico();
		
		PersonGenerico vFirst = new PersonGenerico();
		PersonGenerico vSecond = new PersonGenerico();
		PersonGenerico vThird = new PersonGenerico();
		PersonGenerico vFourth = new PersonGenerico();
		PersonGenerico vFifth = new PersonGenerico();
		PersonGenerico vSixth = new PersonGenerico();
		
		ArrayList<AbsPersonagem> vetorHer = new ArrayList<AbsPersonagem> ();
		hFirst.agilidade = 100;
		hFirst.sorte = 100;
		hFirst.nome = "hFirst";
		hFirst.tipo = 1;
		hSecond.agilidade = 90;
		hSecond.sorte = 90;
		hSecond.nome = "hSecond";
		hSecond.tipo = 1;
		hThird.agilidade = 80;
		hThird.sorte = 80;
		hThird.nome = "hThird";
		hThird.tipo = 3;
		hFourth.agilidade = 70;
		hFourth.sorte = 70;
		hFourth.nome = "hFourth";
		hFourth.tipo = 3;
		hFifth.agilidade = 5;
		hFifth.sorte = 5;
		hFifth.nome = "hFifth";
		hFifth.tipo = 5;
		hSixth.agilidade = 0;
		hSixth.sorte = 0;
		hSixth.nome = "hSixth";
		hSixth.tipo = 5;
		vetorHer.add(0, hFirst);
		vetorHer.add(1, hSecond);
		vetorHer.add(2, hThird);
		vetorHer.add(3, hFourth);
		vetorHer.add(4, hFifth);
		vetorHer.add(5, hSixth);
		
		ArrayList<AbsPersonagem> vetorVil = new ArrayList<AbsPersonagem> ();
		vFirst.agilidade = 60;
		vFirst.sorte = 60;
		vFirst.nome = "vFirst";
		vFirst.tipo = 1;
		vFirst.vilao = true;
		vSecond.agilidade = 50;
		vSecond.sorte = 50;
		vSecond.nome = "vSecond";
		vSecond.tipo = 1;
		vSecond.vilao = true;
		vThird.agilidade = 40;
		vThird.sorte = 40;
		vThird.nome = "vThird";
		vThird.tipo = 3;
		vThird.vilao = true;
		vFourth.agilidade = 30;
		vFourth.sorte = 30;
		vFourth.nome = "vFourth";
		vFourth.tipo = 3;
		vFourth.vilao = true;
		vFifth.agilidade = 20;
		vFifth.sorte = 20;
		vFifth.nome = "vFifth";
		vFifth.tipo = 5;
		vFifth.vilao = true;
		vSixth.agilidade = 10;
		vSixth.sorte = 10;
		vSixth.nome = "vSixth";
		vSixth.tipo = 5;
		vSixth.vilao = true;
		vetorVil.add(0, vFirst);
		vetorVil.add(1, vSecond);
		vetorVil.add(2, vThird);
		vetorVil.add(3, vFourth);
		vetorVil.add(4, vFifth);
		vetorVil.add(5, vSixth);
		
		CEngine.CombatEngine(vetorHer, vetorVil);
	}
	
}
