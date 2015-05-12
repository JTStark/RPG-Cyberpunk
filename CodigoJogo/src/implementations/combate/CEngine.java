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

	ArrayList<InitPer> lista = new ArrayList<InitPer> ();
	
	public CEngine (ArrayList<PersonGenerico> Herois, ArrayList<PersonGenerico> Viloes) {
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
				
				if(lista.isEmpty()) {
					InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
					lista.add(contL, temp);
					flag = false;
				}
				
				while (flag && contL < lista.size()) {					
					if (init > lista.get(contL).iniciativa) {
						InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
						lista.add(contL, temp);
						flag = false;
					}
					else contL++;
					
					if(contL == lista.size()) {
						InitPer temp = new InitPer("Heroi", Herois.get(contP), init);
						lista.add(contL, temp);
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
				
				while (flag && contL < lista.size()) {
					if (init > lista.get(contL).iniciativa) {
						InitPer temp = new InitPer("Vilao", Viloes.get(contP), init);
						lista.add(contL, temp);
						flag = false;
					}
					else contL++;
					
					if(contL == lista.size()) {
						InitPer temp = new InitPer("Vilao", Herois.get(contP), init);
						lista.add(contL, temp);
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
		
	}
}

