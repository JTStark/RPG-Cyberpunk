package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import implementations.combate.PersonGenerico;
import java.util.ArrayList;

public class Charge1 implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		AbsPersonagem temp = new PersonGenerico();
		if (heroiAtacante.pos > 1) {
			// reposiciona o jogador para a posicao escolhida
			temp = heroiAtacante;
			Jogadores.remove(contP);
			Jogadores.add(contP-mov, temp);
			
			for (int cont = 0; cont < Jogadores.size(); cont++){
				Jogadores.get(cont).pos = cont;
			}
			Viloes.get(trgt).hp -= dam * 1.25;
			return false;
		}
		else {
			System.out.println("Voce está muito perto de seu alvo para Charge!");
			return true;
		}
	}

}
