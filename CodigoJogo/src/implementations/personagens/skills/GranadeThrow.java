package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class GranadeThrow implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		dam -= dam * 0.65;
		Viloes.get(trgt).hp -= dam;
		/* acerta os adjacentes */
		if(trgt != 0)
			Viloes.get(trgt - 1).hp -= dam;
		if(trgt != Viloes.size() - 1)
			Viloes.get(trgt + 1).hp -= dam;
		return true;
	}

}
