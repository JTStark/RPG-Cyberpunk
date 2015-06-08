package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class PoisonDart implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		dam -= dam * 0.90;
		Viloes.get(trgt).hp -= Viloes.get(trgt).hp * 0.10;
		Viloes.get(trgt).buffPoisonRounds = 1 + heroiAtacante.inteligencia/20;
		return true;
	}

}
