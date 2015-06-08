package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class ShrapnelShell implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		dam -= dam * 0.75;
		Viloes.get(trgt).hp -= dam;
		if(trgt < Viloes.size() - 1)
			Viloes.get(trgt + 1).hp -= dam;
		// TODO: arrumar a chance de bleed
		return false;
	}

}
