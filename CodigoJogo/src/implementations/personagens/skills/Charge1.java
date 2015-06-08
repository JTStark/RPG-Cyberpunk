package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import implementations.combate.PersonGenerico;
import java.util.ArrayList;

public class Charge1 implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		AbsPersonagem temp = new PersonGenerico();
		if (heroiAtacante.pos > 1) {
			// reposiciona o jogador para a primeira posicao
			temp = heroiAtacante;
			Herois.remove(heroiAtacante);
			Herois.add(0, temp);
			
			for (int cont = 0; cont < Herois.size(); cont++){
				Herois.get(cont).pos = cont;
			}
			
			dam = dam * 1.25;
			return false;
		}
		else {
			System.out.println("Voce está muito perto de seu alvo para Charge!");
			return true;
		}
	}

}
