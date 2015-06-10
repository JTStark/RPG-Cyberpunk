package implementations.combate;

/**
 * @author - Ot�vio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe de teste
 * 
 */

import java.util.ArrayList;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.herois.*;
import implementations.personagens.skills.AtaqueBasico;

public class AuxTemp {
	
	public int auxiliarIniciativa=0;
	
	public static void comeca(){
		AbsPersonagem Durden = HDurden.getInstancia();
		AbsPersonagem MDR = HMDR.getInstancia();
		AbsPersonagem Oleg = HOleg.getInstancia();
		AbsPersonagem Ozob = HOzob.getInstancia();
		AbsPersonagem Rexus = HRexus.getInstancia();
		AbsPersonagem Silvana = HSilvana.getInstancia();
		
		PersonGenerico vFirst = new PersonGenerico();
		PersonGenerico vSecond = new PersonGenerico();
		PersonGenerico vThird = new PersonGenerico();
		PersonGenerico vFourth = new PersonGenerico();
		PersonGenerico vFifth = new PersonGenerico();
		PersonGenerico vSixth = new PersonGenerico();
		
		ArrayList<AbsPersonagem> vetorHer = new ArrayList<AbsPersonagem> ();
		Durden.agilidade = 100;
		Durden.sorte = 100;
		Durden.nome = "hFirst";
		Durden.tipo = 1;
		
		MDR.agilidade = 90;
		MDR.sorte = 90;
		MDR.nome = "hSecond";
		MDR.tipo = 1;
		
		Oleg.agilidade = 80;
		Oleg.sorte = 80;
		Oleg.nome = "hThird";
		Oleg.tipo = 3;
		
		Ozob.agilidade = 70;
		Ozob.sorte = 70;
		Ozob.nome = "hFourth";
		Ozob.tipo = 3;
		
		Rexus.agilidade = 5;
		Rexus.sorte = 5;
		Rexus.nome = "hFifth";
		Rexus.tipo = 5;
		
		Silvana.agilidade = 0;
		Silvana.sorte = 0;
		Silvana.nome = "hSixth";
		Silvana.tipo = 5;
		
		vetorHer.add(0, Durden);
		vetorHer.add(1, MDR);
		vetorHer.add(2, Oleg);
		vetorHer.add(3, Ozob);
		vetorHer.add(4, Rexus);
		vetorHer.add(5, Silvana);
		
		ArrayList<AbsPersonagem> vetorVil = new ArrayList<AbsPersonagem> ();
		vFirst.agilidade = 60;
		vFirst.sorte = 60;
		vFirst.nome = "melee";
		vFirst.tipo = 1;
		vFirst.vilao = true;
		vFirst.skill0 = new AtaqueBasico();
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
