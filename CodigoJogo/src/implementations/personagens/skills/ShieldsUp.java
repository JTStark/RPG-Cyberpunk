package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class ShieldsUp implements Skill {

	public static int tipoAlvo = 3;	
	public static int tipoSkill = 1;
	
	@Override
	public String execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
	
		//SKILL
		heroiAtacante.buffArmaduraRounds = 3;
		heroiAtacante.buffArmaduraValor += (25 + heroiAtacante.resistencia/2)/100;
		//ENDSKILL
		return ("Voce Fortaleceu seu Escudo");
	}

}
