package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;
import java.util.Random;

public class CriticalSlash implements Skill {

	public static int tipoAlvo = 1;	
	
	@Override
	public void execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> heroiAtacantes, double dam, int trgt, AbsPersonagem heroiAtacante) {
		
		int danoFinal, resistencia;
		double armadura, fator;
		Random random = new Random();
		
		armadura = (1 - ((Viloes.get(trgt-1).armadura*Viloes.get(trgt-1).buffArmaduraValor)/100));
		if (armadura < 0.1) armadura = 0.1; // evita armadura acima de 90% por buffs
		
		// Resistencia(com buffs)/5 * fator de nivel
		resistencia = (int)(((Viloes.get(trgt-1).resistencia*Viloes.get(trgt-1).buffResistenciaValor)/5)*(0.96 + (Viloes.get(trgt-1).level/15)));
		
		fator = random.nextInt(6)+1; //o fator é dividido por 3, assim 1 = 1/3 danoFinal, 2 = 2/3 danoFinal, 3 = danoFinal, 4 = 4/3 danoFinal, 5 = 5/3 danoFinal e 6 = 2 danoFinal. A media é o danoFinal esperado da arma

		danoFinal = ((int)((dam * (fator/3)) * armadura)) - resistencia; // danoFinal final
		
		//SKILL
		heroiAtacante.buffCriticoValor += ((35 + heroiAtacante.agilidade/3)/100);
		heroiAtacante.buffCriticoRounds += 1;
		danoFinal = (int)( danoFinal * 0.80);
		//ENDSKILL
		
		if (danoFinal <= 0) danoFinal = 1; // danoFinal minimo é 1
		
		if ((int)(heroiAtacante.critico * heroiAtacante.buffCriticoValor)+random.nextInt(100)+1 >= 100) { // Soma a chance de critico com random 1-100. Se passar de 100 crita
			danoFinal *= 2;
			Viloes.get(trgt-1).hp -= danoFinal;
			System.out.println("Voce atingiu " + Viloes.get(trgt-1).nome + " com um golpe critico! " + danoFinal + " de danoFinal!");
		}
		else if ((int)(Viloes.get(trgt-1).esquiva*Viloes.get(trgt-1).buffEsquivaValor)+random.nextInt(100)+1 < 100) { // Igual ao critico
			Viloes.get(trgt-1).hp -= danoFinal;
			System.out.println(Viloes.get(trgt-1).nome + " atingido! " + danoFinal + " de danoFinal!");
		}
		else
			System.out.println(Viloes.get(trgt-1).nome + " desviou!");
		
	}

}
