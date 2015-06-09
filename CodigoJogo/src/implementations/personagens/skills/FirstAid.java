package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class FirstAid implements Skill {

	@Override
	public void execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		//violoes eh tratado como herois
		int modHP;
		modHP = (int) (((10 + (heroiAtacante.carisma/10))/100) * Viloes.get(trgt).maxHP);
		Herois.get(trgt).Damage_Heal(modHP);
	}

}
