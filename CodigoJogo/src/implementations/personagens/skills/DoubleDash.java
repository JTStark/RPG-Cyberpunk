package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class DoubleDash implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		int i;
		if(trgt == 0 || trgt == 1){
			dam -= dam * 0.50;
			/* ataca varios */
			for(i = 0; i < 2 + heroiAtacante.agilidade/4; i++)
				Viloes.get(i).hp -= dam;
			return true;
		}
		return false;
	}

}
