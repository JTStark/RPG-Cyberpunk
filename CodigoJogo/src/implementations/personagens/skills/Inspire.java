package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Inspire implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		int constante = heroiAtacante.carisma;
			Viloes.get(trgt).buffAgilidadeValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffAgilidadeRounds = 1;
			Viloes.get(trgt).buffCarismaValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffCarismaRounds = 1;
			Viloes.get(trgt).buffForcaValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffForcaRounds = 1;
			Viloes.get(trgt).buffInteligenciaValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffInteligenciaRounds = 1;
			Viloes.get(trgt).buffPercepcaoValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffPercepcaoRounds = 1;
			Viloes.get(trgt).buffResistenciaValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffResistenciaRounds = 1;
			Viloes.get(trgt).buffSorteValor = 1 + ((5 + constante/20)/100);
			Viloes.get(trgt).buffSorteRounds = 1;
		
		return true;
	}

}
