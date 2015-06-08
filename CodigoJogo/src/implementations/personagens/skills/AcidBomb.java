package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class AcidBomb implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		dam -= dam * 0.80;
		Viloes.get(trgt).buffArmaduraValor -= (50 + (heroiAtacante.inteligencia/2))/100;
		Viloes.get(trgt).buffArmaduraRounds = 2;
		return true;
	}

}
