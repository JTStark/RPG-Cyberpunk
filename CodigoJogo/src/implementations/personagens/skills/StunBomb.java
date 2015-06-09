package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import java.util.Random;
import java.util.ArrayList;

public class StunBomb implements Skill {

	@Override
	public void execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		Random random = new Random();
		
		for (AbsPersonagem vilao : Viloes){
			if ((5 + vilao.percepcao/4) + random.nextInt(100)+1 > 100) {
				vilao.buffStunRounds += 1;
			}			
		}
	}

}
