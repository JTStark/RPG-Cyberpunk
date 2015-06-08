package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class FirstAid implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//violoes eh tratado como herois
		int modHP;
		modHP = (int) (((10 + dam/10)/100) * Viloes.get(trgt).maxHP);
		Viloes.get(trgt).Damage_Heal(modHP);
		return true;
	}

}
