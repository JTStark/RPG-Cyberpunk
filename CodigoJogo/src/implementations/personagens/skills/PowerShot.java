package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class PowerShot implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//parto da premissa que o atacante ja esta na primeira posicao
		dam += dam * 0.50;
		Viloes.get(trgt).hp -= dam;
		//TODO: jogar pra ultima posicao
		
		return false;
	}

}
