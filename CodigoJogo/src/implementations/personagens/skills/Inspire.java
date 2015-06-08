package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Inspire implements Skill {

	@Override
	public boolean execute(ArrayList<AbsPersonagem> Viloes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		int constante = heroiAtacante.carisma;
		for(AbsPersonagem a : Viloes){
			a.buffAgilidadeValor = 1 + ((5 + constante/20)/100);
			a.buffAgilidadeRounds = 1;
			a.buffArmaduraValor = 1 + ((5 + constante/20)/100);
			a.buffArmaduraRounds = 1;
			a.buffCarismaValor = 1 + ((5 + constante/20)/100);
			a.buffCarismaRounds = 1;
			a.buffCriticoValor = 1 + ((5 + constante/20)/100);
			a.buffCriticoRounds = 1;
			a.buffEsquivaValor = 1 + ((5 + constante/20)/100);
			a.buffEsquivaRounds = 1;
			a.buffForcaValor = 1 + ((5 + constante/20)/100);
			a.buffForcaRounds = 1;
			a.buffInteligenciaValor = 1 + ((5 + constante/20)/100);
			a.buffInteligenciaRounds = 1;
			a.buffPercepcaoValor = 1 + ((5 + constante/20)/100);
			a.buffPercepcaoRounds = 1;
			a.buffResistenciaValor = 1 + ((5 + constante/20)/100);
			a.buffResistenciaRounds = 1;
			a.buffSorteValor = 1 + ((5 + constante/20)/100);
			a.buffSorteRounds = 1;
		}
		return true;
	}

}
