package combate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CEngine {

	ArrayList<InitPer> lista = new ArrayList<InitPer> ();
	
	public CEngine (PersonGenerico Herois[], PersonGenerico Viloes[]) {
		Random random = new Random();
		int contP; //Contador de (vetor de) Personagens
		int contL; //Contador do vetor da Lista
		int init; // Iniciativa
		boolean flag; // Flag para parar o While abaixo
		
		for (contP = 0; Herois[contP] != null; contP++) {
			init = (Herois[contP].agilidade + Herois[contP].sorte) / 20 * random.nextInt(10);
			flag = true;
			contL = 0;
			
			while (flag && contL < lista.size()) {
				if (init > lista.get(contL).iniciativa) {
					InitPer temp = new InitPer("Heroi", Herois[contP], init);
					lista.add(contL, temp);
					flag = false;
				}
				else contL++;
			}
		}
		
		for (contP = 0; Viloes[contP] != null; contP++) {
			init = (Viloes[contP].AGI + Viloes[contP].LCK) / 20 * random.nextInt(10);
			flag = true;
			contL = 0;
			
			while (flag && contL < lista.size()) {
				if (init > lista.get(contL).iniciativa) {
					InitPer temp = new InitPer("Vilao", Viloes[contP], init);
					lista.add(contL, temp);
					flag = false;
				}
				else contL++;
			}
		}
		System.out.println(Arrays.toString(lista.toArray()));
		
	}
}

