package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class PiercingBullet implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		float n;
		n = 1 + heroiAtacante.percepcao/25;
		dam -= dam * 0.65;
		if(n >= Viloes.size())
			n = Viloes.size() - 1;
		for(int i = trgt; i <= trgt + n; i++)
			Viloes.get(i).hp -= dam;
		return true;
	}

}
