package implementations.personagens.skills;

import implementations.combate.PersonGenerico;
import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Charm implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		AbsPersonagem temp = new PersonGenerico();
		
		temp = Viloes.get(trgt);
		Viloes.remove(trgt);
		Viloes.add(0, temp);
		
		for (int cont = 0; cont < Viloes.size(); cont++){
			Viloes.get(cont).pos = cont;
		}
		
		return false;
	}

}
