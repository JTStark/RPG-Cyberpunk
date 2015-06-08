package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Charge1 implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//nessa skill, parto da premissa que o heroiAtcante esta na primeira ou segunda posicoes
		return false;
	}

}
