package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import java.util.ArrayList;
import java.util.Random;

public class ShrapnelShell implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		Random random = new Random();
		
		dam -= dam * 0.75;
		Viloes.get(trgt).hp -= dam;
		if ((15 + random.nextInt(100) + (heroiAtacante.percepcao/4)) > 100)
			Viloes.get(trgt).buffBleedRounds = 3;
		
		if(trgt < Viloes.size() - 1){
			Viloes.get(trgt + 1).hp -= dam;
			if ((15 + random.nextInt(100) + (heroiAtacante.percepcao/4)) > 100)
				Viloes.get(trgt + 1).buffBleedRounds = 3;
		}
		
		
		return false;
	}

}
