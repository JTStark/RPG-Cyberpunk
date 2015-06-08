package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class StunBomb implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		for (AbsPersonagem vilao : Viloes){
			vilao.buffPercepcaoValor = (5 + vilao.percepcao/4)/100;
			vilao.buffPercepcaoRounds = 1;
		}
		return true;
	}

}
