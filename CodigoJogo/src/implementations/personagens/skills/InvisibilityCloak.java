package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class InvisibilityCloak implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//viloes nesse caso sao os herois
		Viloes.get(trgt).buffEsquivaValor += Viloes.get(trgt).buffEsquivaValor * 0.50;
		Viloes.get(trgt).buffEsquivaRounds = 1;
		return true;
	}

}
