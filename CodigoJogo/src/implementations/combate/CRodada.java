package implementations.combate;

/**
 * @author - Otávio Vansetti Miranda e Lucca Maia Bollani
 * 
 * Sistema de Combate para RPG Cyberpunk, DeltaNexus
 * 
 * Classe principal/controladora do combate
 * 
 */

import java.util.ArrayList;
import implementations.personagens.AbsPersonagem;
import java.util.Scanner;

public class CRodada {

	public static void Jogada (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes) { //recebe ArrayList de herois e viloes ordenados
		int contP; // contador para vetor de personagens
		int HInit = 0, VInit = 0; // ints para usar em flee
		boolean flag, endFlag = true; // flag para parar o loop de escolha e o combate
		String chc; // string de que guarda a escolha
		Scanner scanner = new Scanner(System.in); //scanner para pegar a escolha
		
		// roda enquanto houverem herois ou viloes e ninguem quiser fugir
		while (endFlag == true && Herois.isEmpty() == false && Viloes.isEmpty() == false) {
			// uma rodada para cada personagem, enquanto houverem herois ou viloes e ninguem quiser fugir
			for (contP = 0; contP < Herois.size() && endFlag == true && Herois.isEmpty() == false && Viloes.isEmpty() == false; contP++) {
	
				// imprime as escolhas
				System.out.println(Herois.get(contP).nome + " " + Herois.get(contP).iniciativa);
				flag = true;			
				while (flag) {
					System.out.println("CHOOSE YOUR ACTION:");
					System.out.println("Reposition");
					System.out.println("Attack");
					System.out.println("use Item");
					System.out.println("do Nothing");
					System.out.println("Flee");
					
					// recebe a escolha do jogador
					chc = scanner.nextLine();
					
					// compara se a escolha eh compativel com alguma opcao vailda e roda a funcao apropriada
					if ((chc.equalsIgnoreCase("reposition")) || (chc.equalsIgnoreCase("r"))) {
						
						Reposition(Herois, contP);
						flag = false;
					}
					
					else if ((chc.equalsIgnoreCase("attack")) || (chc.equalsIgnoreCase("a"))) {
	
						flag = false;
					}
		
					else if ((chc.equalsIgnoreCase("use item")) || (chc.equalsIgnoreCase("i")) || (chc.equalsIgnoreCase("item"))) {
	
						flag = false;
					}
					
					else if ((chc.equalsIgnoreCase("do nothing")) || (chc.equalsIgnoreCase("n")) || chc.equalsIgnoreCase("nothing")) {
						flag = false; // soh sai
					}
		
					else if ((chc.equalsIgnoreCase("flee")) || (chc.equalsIgnoreCase("f"))) {
						// Somatorio das iniciativas de cada time
						for (AbsPersonagem h: Herois)
							HInit += h.iniciativa;
						for (AbsPersonagem v: Herois)
							VInit += v.iniciativa;
						
						//Se os herois tiverem mais iniciativa que os viloes, eles podem fugir
						if (HInit >= VInit) {
							endFlag = false;
							System.out.println("Voces conseguem fugir!");
						}
						else
							System.out.println("Impossivel fugir!");
						
						flag = false;
					}
				
					// se o texto inserido for invalido, deixa tentar denovo
					else System.out.println("Wrong Text: try again");
				}
			}
		}
		endBattle(Herois, Viloes);
		
		scanner.close();
	}
	
	public static void Reposition (ArrayList <AbsPersonagem> Jogadores, int contP) { // recebe o vetor de jogadores apropriado e a posicao do jogador atual
		String choice; // string para guardar escolha
		int mov = 0, dist; // int para guardar escolha de movimento e para guardar distancia ponderada
		Scanner scanner = new Scanner(System.in);
		AbsPersonagem temp = new PersonGenerico();
		
		// verifica para quais direcoes o jogador pode se mover
		if (contP < Jogadores.size())
			System.out.print("Esquerda");
		if ((Jogadores.size() > contP) && (contP > 0))
			System.out.print(" ou ");
		if (contP > 0)
			System.out.print("Direita");
		System.out.println("?");
		
		// capta a escolha de direcoes
		choice = scanner.nextLine();
		
		// Se o jogador escolher esquerda, verifica quanto pode se mecher para a esquerda e pergunta ao jogador
		if (((choice.equalsIgnoreCase("esquerda")) || (choice.equalsIgnoreCase("e"))) && contP < Jogadores.size()) {
			dist = (Jogadores.get(contP).agilidade / 25) + 1;
			if (dist >= Jogadores.size() - 1 - contP)
				dist = Jogadores.size() - 1 - contP;
				
			System.out.println("Voce pode se mover " + dist + " para a esquerda");
			System.out.println("Quanto quer se mover?");
			
			
			// capta a escolha de distancia de movimento 
			while (mov > dist) {
				mov = scanner.nextInt();
				if (mov > dist) // imprime e tenta denovo se a entrada for invalida 
					System.out.println("Voce escolheu uma distancia invalida");
			}
			
			// reposiciona o jogador para a posicao escolhida
			temp = Jogadores.get(contP);
			Jogadores.remove(contP);
			Jogadores.add(contP+dist, temp);
		}
		
		// Se o jogador escolher direita, verifica quanto pode se mecher para a esquerda e pergunta ao jogador
		if (((choice.equalsIgnoreCase("direita")) || (choice.equalsIgnoreCase("d"))) && contP > 0) {
			dist = (Jogadores.get(contP).agilidade / 25) + 1;
			if (contP - dist < 0)
				dist = dist + (contP - dist);
				
			System.out.println("Voce pode se mover " + dist + " para a direita");
			System.out.println("Quanto quer se mover?");
			
			// capta a escolha de distancia de movimento 
			while (mov > dist) {
				mov = scanner.nextInt();
				if (mov > dist) // imprime e tenta denovo se a entrada for invalida 
					System.out.println("Voce escolheu uma distancia invalida");
			}
			
			// reposiciona o jogador para a posicao escolhida
			temp = Jogadores.get(contP);
			Jogadores.remove(contP);
			Jogadores.add(contP-dist, temp);
		}
			
		scanner.close();
	}
	
	public static void endBattle (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes) {
		int EXP = 0;
		
		if (Herois.isEmpty()) {
			//n sei o que fazer pra rodar um gameover
			System.out.println("GAME OVER, MWAHAHAHAHA");
		}
		
		else {
			for (AbsPersonagem V: Viloes) {
				if (V.hp <= 0)
					EXP += V.level;
			}
			
			for (AbsPersonagem H: Herois) {
				H.xp += EXP;
				if (H.xp >= H.level*10) {
					H.LevelUp();
				}
			}
		}
		
	}
}
