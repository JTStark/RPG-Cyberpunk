package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class InvisibilityCloak implements Skill {

	@Override
	public void execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		Herois.get(trgt).buffEsquivaValor += 0.50;
		Herois.get(trgt).buffEsquivaRounds = 1;
	}

}
