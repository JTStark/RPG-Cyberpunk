package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;
import java.util.Random;

public class DoubleDash implements Skill {

	public static int tipoAlvo = 3;	
	
	@Override
	public String execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		int i, countHits=0;
		int danoFinal, resistencia;
		double armadura, fator;
		Random random = new Random();
			
		/* ataca varios */
		for(i = 0; i < 2 + heroiAtacante.agilidade/4; i++) {
			
			armadura = (1 - ((Viloes.get(i).armadura*Viloes.get(i).buffArmaduraValor)/100));
			if (armadura < 0.1) armadura = 0.1; // evita armadura acima de 90% por buffs
			
			// Resistencia(com buffs)/5 * fator de nivel
			resistencia = (int)(((Viloes.get(i).resistencia*Viloes.get(i).buffResistenciaValor)/5)*(0.96 + (Viloes.get(i).level/15)));
			
			fator = random.nextInt(6)+1; //o fator é dividido por 3, assim 1 = 1/3 danoFinal, 2 = 2/3 danoFinal, 3 = danoFinal, 4 = 4/3 danoFinal, 5 = 5/3 danoFinal e 6 = 2 danoFinal. A media é o danoFinal esperado da arma

			danoFinal = ((int)((dam * (fator/3)) * armadura)) - resistencia; // danoFinal final
			
			//SKILL
			danoFinal = (int)(danoFinal * 0.5);
			//ENDSKILL
			
			if (danoFinal <= 0) danoFinal = 1; // danoFinal minimo é 1
			
			if ((int)(heroiAtacante.critico * heroiAtacante.buffCriticoValor)+random.nextInt(100)+1 >= 100) { // Soma a chance de critico com random 1-100. Se passar de 100 crita
				danoFinal *= 2;
				Viloes.get(i).hp -= danoFinal;
				countHits++;
			}
			else if ((int)(Viloes.get(i).esquiva*Viloes.get(i).buffEsquivaValor)+random.nextInt(100)+1 < 100) { // Igual ao critico
				Viloes.get(i).hp -= danoFinal;
				countHits++;
			}
			
		}
		return ("Voce acertou "+ countHits+" inimigos");
	}

}
