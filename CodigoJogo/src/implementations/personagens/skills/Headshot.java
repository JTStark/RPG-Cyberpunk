package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Headshot implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		// parti-se da premissa de que o heroiAtacante nao esta em uma posicao de frente
		if(trgt != 0 && trgt != 1){
			heroiAtacante.critico += (35 + heroiAtacante.percepcao/3);
			dam -= dam * 0.20;
			return true;
		}
		return false;
	}

}
