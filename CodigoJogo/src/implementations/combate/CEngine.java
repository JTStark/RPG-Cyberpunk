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
import implementations.personagens.AbsPersonagem;

public class CEngine {
	
	public static void CombatEngine (ArrayList<AbsPersonagem> Herois, ArrayList<AbsPersonagem> Viloes) {
		ArrayList<AbsPersonagem> listaH = new ArrayList<AbsPersonagem> ();
		ArrayList<AbsPersonagem> listaV = new ArrayList<AbsPersonagem> ();
		Random random = new Random();
		int contL; //Contador do vetor da Lista
		boolean flag; // Flag para parar o While abaixo
		
		try {
			for (AbsPersonagem H: Herois) {
				H.iniciativa = (H.agilidade + H.sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;
				
				if(listaH.isEmpty()) {
					
					listaH.add(contL, H);
					flag = false;
				}
				
				while (flag && contL < listaH.size()) {					
					if (H.iniciativa > listaH.get(contL).iniciativa) {
						listaH.add(contL, H);
						flag = false;
					}
					else contL++;
					
					if(contL == listaH.size()) {
						listaH.add(contL, H);
						flag = false;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("erro: " + e);   
		}
		
		try {
			for (AbsPersonagem V: Viloes) {
				V.iniciativa = (V.agilidade + V.sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;
				
				if(listaV.isEmpty()) {
					
					listaV.add(contL, V);
					flag = false;
				}
				
				while (flag && contL < listaV.size()) {					
					if (V.iniciativa > listaV.get(contL).iniciativa) {
						listaV.add(contL, V);
						flag = false;
					}
					else contL++;
					
					if(contL == listaV.size()) {
						listaV.add(contL, V);
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

