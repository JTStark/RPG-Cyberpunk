package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class StunnigBlow implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//ataca as 1 e 2 posicoes
		if(trgt == 0|| trgt == 1){
			Viloes.get(trgt).hp -= 0.25 * dam;
			Viloes.get(trgt).buffStunRounds = 1 + (heroiAtacante.forca/50);
			return true;
		}
		return false;
	}

}
