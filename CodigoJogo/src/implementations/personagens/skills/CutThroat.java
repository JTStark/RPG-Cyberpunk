package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class CutThroat implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		Viloes.get(trgt).buffBleedRounds = 3;
		Viloes.get(trgt).hp -= 0.10 * Viloes.get(trgt).hp;
		dam -= dam * 0.80;
		return true;
	}

}
