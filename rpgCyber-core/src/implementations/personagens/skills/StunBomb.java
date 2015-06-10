package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import java.util.Random;
import java.util.ArrayList;

public class StunBomb implements Skill {

	public static int tipoAlvo = 1;	
	public static int tipoSkill = 5;
	
	@Override
	public String execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		Random random = new Random();
		int countStuns=0;
		
		for (AbsPersonagem vilao : Viloes){
			if ((5 + vilao.percepcao/4) + random.nextInt(100)+1 > 100) {
				vilao.buffStunRounds += 1;
				countStuns++;
			}			
		}
		return ("Voce Atordoou " + countStuns + "inimigos");
	}

}
