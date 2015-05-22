package implementations.combate;

/**
 * @author - Otávio Vansetti Miranda e Lucca Maia Bollani
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
	
	public static void CombatEngine (ArrayList<AbsPersonagem> Herois, ArrayList<AbsPersonagem> Viloes) { // recebe um ArrayList com herois e outro com viloes
		ArrayList<AbsPersonagem> listaH = new ArrayList<AbsPersonagem> (); // lista que vai conter os herois ordenados
		ArrayList<AbsPersonagem> listaV = new ArrayList<AbsPersonagem> (); // lista que vai conter os viloes ordenados
		Random random = new Random(); // gerador de numeros randomicos
		int contL; // Contador do vetor da Lista
		boolean flag; // Flag para parar o While abaixo
		
		try {
			for (AbsPersonagem H: Herois) { // percorre o AL de herois
				H.iniciativa = (H.agilidade + H.sorte) / 20 * random.nextInt(10); // calcula a iniciativa de cada um
				flag = true;
				contL = 0;
				
				// se a lista esta vazia, adiciona na primeira posicao
				if(listaH.isEmpty()) {
					
					listaH.add(contL, H);
					flag = false;
				}
				 
				while (flag && contL < listaH.size()) {	// roda ate o fim da lista ou uma modificacao			
					// se a iniciativa do personagem atual for maior que alguma ja na lista, insere em sua posicao
					if (H.iniciativa > listaH.get(contL).iniciativa) {
						listaH.add(contL, H);
						flag = false; // e sai do loop
					}
					else contL++; // ou passa pro proximo
					
					// se chegar ao fim da lista, adiciona ao fim
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
		
		// faz o mesmo para os viloes
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
		
		// roda Jogada de CRodada
		CRodada.Jogada(listaH, listaV);
	}
}

