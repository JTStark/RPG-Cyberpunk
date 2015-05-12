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
		ArrayList<InitPer> listaH = new ArrayList<InitPer> ();
		ArrayList<InitPer> listaV = new ArrayList<InitPer> ();
		Random random = new Random();
		int contP; //Contador de (vetor de) Personagens
		int contL; //Contador do vetor da Lista
		int init; // Iniciativa
		boolean flag; // Flag para parar o While abaixo
		
		try {
			for (contP = 0; contP < Herois.size(); contP++) {
				init = (Herois.get(contP).agilidade + Herois.get(contP).sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;
				
				if(listaH.isEmpty()) {
					InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
					listaH.add(contL, temp);
					flag = false;
				}
				
				while (flag && contL < listaH.size()) {					
					if (init > listaH.get(contL).iniciativa) {
						InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
						listaH.add(contL, temp);
						flag = false;
					}
					else contL++;
					
					if(contL == listaH.size()) {
						InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
						listaH.add(contL, temp);
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
				init = (Viloes.get(contP).agilidade + Viloes.get(contP).sorte) / 20 * random.nextInt(10);
				flag = true;
				contL = 0;

				if(listaV.isEmpty()) {
					InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
					listaV.add(contL, temp);
					flag = false;
				}
				
				while (flag && contL < listaV.size()) {
					if (init > listaV.get(contL).iniciativa) {
						InitPer temp = new InitPer("Vilao", Viloes.get(contP), init);
						listaV.add(contL, temp);
						flag = false;
					}
					else contL++;
					
					if(contL == listaV.size()) {
						InitPer temp = new InitPer("Vilao", Viloes.get(contP), init);
						listaV.add(contL, temp);
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

