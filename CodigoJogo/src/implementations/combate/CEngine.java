package implementations.combate;

/*
 * Autores: Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe inicial/organizadora de jogadores
 * 
 */

import java.util.ArrayList;
import java.util.Random;

public class CEngine {
	
	public static void CombatEngine (ArrayList<PersonGenerico> Herois, ArrayList<PersonGenerico> Viloes) {
		ArrayList<PersonGenerico> listaH = new ArrayList<PersonGenerico> ();
		ArrayList<PersonGenerico> listaV = new ArrayList<PersonGenerico> ();
		Random random = new Random();
		int contP; //Contador de (vetor de) Personagens
		int contL; //Contador do vetor da Lista
		boolean flag; // Flag para parar o While abaixo
		
		try {
			for (contP = 0; contP < Herois.size(); contP++) {
				Herois.get(contP).iniciativa = (Herois.get(contP).agilidade + Herois.get(contP).sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;
				
				if(listaH.isEmpty()) {
					
					listaH.add(contL, Herois.get(contP));
					flag = false;
				}
				
				while (flag && contL < listaH.size()) {					
					if (Herois.get(contP).iniciativa > listaH.get(contL).iniciativa) {
						listaH.add(contL, Herois.get(contP));
						flag = false;
					}
					else contL++;
					
					if(contL == listaH.size()) {
						listaH.add(contL, Herois.get(contP));
						flag = false;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("erro: " + e);   
		}
		
		try {
			for (contP = 0; contP < Viloes.size(); contP++) {
				Viloes.get(contP).iniciativa = (Viloes.get(contP).agilidade + Viloes.get(contP).sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;
				
				if(listaV.isEmpty()) {
					
					listaV.add(contL, Viloes.get(contP));
					flag = false;
				}
				
				while (flag && contL < Viloes.size()) {					
					if (Herois.get(contP).iniciativa > listaV.get(contL).iniciativa) {
						listaV.add(contL, Viloes.get(contP));
						flag = false;
					}
					else contL++;
					
					if(contL == listaV.size()) {
						listaV.add(contL, Viloes.get(contP));
						flag = false;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("erro: " + e);   
		}
		
		/*
		for(int contPrint = 0; contPrint < lista.size(); contPrint++) {
			System.out.println(lista.get(contPrint).iniciativa);
		}
		*/
		
		CRodada.Jogada(listaH, listaV);
	}
}

