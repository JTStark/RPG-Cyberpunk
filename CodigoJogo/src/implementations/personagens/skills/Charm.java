package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Charm implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		AbsPersonagem temp;
		temp = Viloes.get(trgt);
		Viloes.remove(trgt);
		Viloes.add(Viloes.size() - 1, temp);
		return true;
	}

}
