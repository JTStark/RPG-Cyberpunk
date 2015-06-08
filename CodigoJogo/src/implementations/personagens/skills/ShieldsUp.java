package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class ShieldsUp implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		dam -= dam * ((25 + (Viloes.get(trgt).resistencia/2))/100);
		Viloes.get(trgt).hp -= dam;
		Viloes.get(trgt).buffArmaduraRounds = 3;
		return true;
	}

}
