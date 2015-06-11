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
		Durden.nome = "Durden";
		Durden.tipo = 1;
		
		MDR.agilidade = 90;
		MDR.sorte = 90;
		MDR.nome = "MDR";
		MDR.tipo = 1;
		
		Oleg.agilidade = 80;
		Oleg.sorte = 80;
		Oleg.nome = "Oleg";
		Oleg.tipo = 3;
		
		Ozob.agilidade = 70;
		Ozob.sorte = 70;
		Ozob.nome = "Ozob";
		Ozob.tipo = 3;
		
		Rexus.agilidade = 5;
		Rexus.sorte = 5;
		Rexus.nome = "Rexus";
		Rexus.tipo = 5;
		
		Silvana.agilidade = 0;
		Silvana.sorte = 0;
		Silvana.nome = "Silvana";
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
		vFirst.nome = "melee1";
		vFirst.tipo = 1;
		vFirst.vilao = true;
		vFirst.skill0 = new AtaqueBasico();
		vFirst.skill1 = new AtaqueBasico();
		vFirst.skill2 = new AtaqueBasico();
		vFirst.skill3 = new AtaqueBasico();
		
		vSecond.agilidade = 50;
		vSecond.sorte = 50;
		vSecond.nome = "melee2";
		vSecond.tipo = 1;
		vSecond.vilao = true;
		vSecond.skill0 = new AtaqueBasico();
		vSecond.skill1 = new AtaqueBasico();
		vSecond.skill2 = new AtaqueBasico();
		vSecond.skill3 = new AtaqueBasico();
		
		vThird.agilidade = 40;
		vThird.sorte = 40;
		vThird.nome = "melee3";
		vThird.tipo = 3;
		vThird.vilao = true;
		vThird.skill0 = new AtaqueBasico();
		vThird.skill1 = new AtaqueBasico();
		vThird.skill2 = new AtaqueBasico();
		vThird.skill3 = new AtaqueBasico();
		
		vFourth.agilidade = 30;
		vFourth.sorte = 30;
		vFourth.nome = "melee4";
		vFourth.tipo = 3;
		vFourth.vilao = true;
		vFourth.skill0 = new AtaqueBasico();
		vFourth.skill1 = new AtaqueBasico();
		vFourth.skill2 = new AtaqueBasico();
		vFourth.skill3 = new AtaqueBasico();
		
		vFifth.agilidade = 20;
		vFifth.sorte = 20;
		vFifth.nome = "melee5";
		vFifth.tipo = 5;
		vFifth.vilao = true;
		vFifth.skill0 = new AtaqueBasico();
		vFifth.skill1 = new AtaqueBasico();
		vFifth.skill2 = new AtaqueBasico();
		vFifth.skill3 = new AtaqueBasico();
		
		vSixth.agilidade = 10;
		vSixth.sorte = 10;
		vSixth.nome = "melee6";
		vSixth.tipo = 5;
		vSixth.vilao = true;
		vSixth.skill0 = new AtaqueBasico();
		vSixth.skill1 = new AtaqueBasico();
		vSixth.skill2 = new AtaqueBasico();
		vSixth.skill3 = new AtaqueBasico();
		
		vetorVil.add(0, vSecond);
		vetorVil.add(1, vFirst);
		vetorVil.add(2, vFourth);
		vetorVil.add(3, vThird);
		vetorVil.add(4, vSixth);
		vetorVil.add(5, vFifth);
		
		CEngine.CombatEngine(vetorHer, vetorVil);
	}
	
}
