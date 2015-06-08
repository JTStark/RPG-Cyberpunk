package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class CriticalSlash implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		heroiAtacante.buffCriticoValor += heroiAtacante.critico * ((35 + heroiAtacante.agilidade/3)/100);
		heroiAtacante.buffCriticoRounds = 1;
		dam -= 0.20 * dam;
		return true;
	}

}
