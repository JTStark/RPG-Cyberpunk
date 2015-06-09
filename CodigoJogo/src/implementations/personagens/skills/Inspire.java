package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Inspire implements Skill {

	@Override
	public void execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		int constante = heroiAtacante.carisma;
			Herois.get(trgt).buffAgilidadeValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffAgilidadeRounds = 1;
			Herois.get(trgt).buffCarismaValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffCarismaRounds = 1;
			Herois.get(trgt).buffForcaValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffForcaRounds = 1;
			Herois.get(trgt).buffInteligenciaValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffInteligenciaRounds = 1;
			Herois.get(trgt).buffPercepcaoValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffPercepcaoRounds = 1;
			Herois.get(trgt).buffResistenciaValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffResistenciaRounds = 1;
			Herois.get(trgt).buffSorteValor = 1 + ((5 + constante/20)/100);
			Herois.get(trgt).buffSorteRounds = 1;
		
	}

}
