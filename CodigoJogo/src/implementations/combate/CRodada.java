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
import java.util.Random;
import java.lang.reflect.Field;

public class CRodada {
static int numRodada=0; //variavel global para que BUFFS possam acompanhar a passagem de rodadas
static Scanner scanner = new Scanner(System.in); //scanner para pegar a escolha

	public static void Jogada (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes,  ArrayList <AbsPersonagem> Lista) { //recebe ArrayList de herois e viloes ordenados
		int contP, contI; // contador para vetor de Personagens e Iniciativa
		int HInit = 0, VInit = 0; // ints para usar em flee
		boolean flag, endFlag = true; // flag para parar o loop de escolha e o combate
		String chc; // string de que guarda a escolha
		
		// roda enquanto houverem herois ou viloes e ninguem quiser fugir
		while (endFlag == true && Herois.isEmpty() == false && Viloes.isEmpty() == false) {
			// uma rodada para cada personagem, enquanto houverem herois ou viloes e ninguem quiser fugir
			for (contI = 0; contI < Lista.size() && endFlag == true && Lista.isEmpty() == false && Viloes.isEmpty() == false; contI++) {
				
				System.out.println(Lista.get(contI).nome + " " + Lista.get(contI).iniciativa);
	
				if (!Lista.get(contI).stun) { //pula a jogada de um jogador se desorientado
					
					// If para os Viloes (AI)
					if (Lista.get(contI).vilao) {
						for (contP = 0; !(Viloes.get(contP).equals(Lista.get(contI))) && (contP < Viloes.size()); contP++); // Acha a posicao contP do vilao da jogada atual na sua lista de posicao 	
						//AI(Herois, Viloes, Lista, contP, contI);
					} else {
						
						// Tudo nesse else eh para Herois (players) only
						for (contP = 0; Herois.get(contP) != Lista.get(contI); contP++); // Acha a posicao contP do heroi da jogada atual na sua lista de posicao 
						
						// imprime as escolhas
						flag = true;			
						while (flag) {
							System.out.println("SELECIONE SUA ACAO:");
							System.out.println("Reposicionar");
							System.out.println("Atacar");
							System.out.println("usar Item");
							System.out.println("fazer Nada");
							System.out.println("Fugir");
							
							// recebe a escolha do jogador
							if (contI != 0)
								scanner.nextLine();
							chc = scanner.nextLine();
							
							// compara se a escolha eh compativel com alguma opcao vailda e roda a funcao apropriada
							if ((chc.equalsIgnoreCase("reposicionar")) || (chc.equalsIgnoreCase("r"))) {
								
								Reposition(Herois, contP);
								flag = false;
							}
							
							else if ((chc.equalsIgnoreCase("atacar")) || (chc.equalsIgnoreCase("a"))) {
								
								attack(Herois.get(contP), Viloes, contP);
								
								flag = false;
							}
				
							else if ((chc.equalsIgnoreCase("usar item")) || (chc.equalsIgnoreCase("i")) || (chc.equalsIgnoreCase("item"))) {
			
								flag = false;
							}
							
							else if ((chc.equalsIgnoreCase("fazer nada")) || (chc.equalsIgnoreCase("n")) || chc.equalsIgnoreCase("nothing")) {
								flag = false; // soh sai
							}
				
							else if ((chc.equalsIgnoreCase("fugir")) || (chc.equalsIgnoreCase("f"))) {
								// Somatorio das iniciativas de cada time
								for (AbsPersonagem h: Herois)
									HInit += h.iniciativa;
								for (AbsPersonagem v: Herois)
									VInit += v.iniciativa;
								
								//Se os herois tiverem mais iniciativa que os viloes, eles podem fugir
								if (HInit >= VInit) {
									endFlag = false;
									System.out.println("Voce conseguiu fugir!");
								}
								else
									System.out.println("Impossivel escapar!");
								
								flag = false;
							}
						
							// se o texto inserido for invalido, deixa tentar denovo
							else System.out.println("Texto errado: tente denovo");
						}
					}
					

				}
				
				// subtrai danos por sangramento ou veneno
				if (Lista.get(contI).bleed) {
					Lista.get(contI).hp -= Lista.get(contI).hp * 0.1;
				}
				if (Lista.get(contI).poison) {
					Lista.get(contI).hp -= Lista.get(contI).maxHP * 0.1;
				}
				
				// Remove duracao de 1 round dos buffs
				if (Lista.get(contI).buffforcarounds > 0) Lista.get(contI).buffforcarounds--;
				if (Lista.get(contI).buffpercepcaorounds > 0) Lista.get(contI).buffpercepcaorounds--;
				if (Lista.get(contI).buffcarismarounds > 0) Lista.get(contI).buffcarismarounds--;
				if (Lista.get(contI).buffinteligenciarounds > 0) Lista.get(contI).buffinteligenciarounds--;
				if (Lista.get(contI).buffagilidaderounds > 0) Lista.get(contI).buffagilidaderounds--;
				if (Lista.get(contI).buffsorterounds > 0) Lista.get(contI).buffsorterounds--;
				
				// Remove os buff cujos rounds acabaram
				if (Lista.get(contI).buffforcarounds == 0) Lista.get(contI).buffforcavalor=1;
				if (Lista.get(contI).buffpercepcaorounds == 0) Lista.get(contI).buffpercepcaovalor=1;
				if (Lista.get(contI).buffcarismarounds == 0) Lista.get(contI).buffcarismavalor=1;
				if (Lista.get(contI).buffinteligenciarounds == 0) Lista.get(contI).buffinteligenciavalor=1;
				if (Lista.get(contI).buffagilidaderounds == 0) Lista.get(contI).buffagilidadevalor=1;
				if (Lista.get(contI).buffsorterounds == 0) Lista.get(contI).buffsortevalor=1;
				
			/* Se os buffs vao ser porcentagens, precisamos soh multiplicar um atributo por seu buff toda vez q ele for usado, e deixar NAO BUFF = 1
			 * Mas entao precisaremos dar tipecast (int) em alguns lugares.... 
			 */
				
			}
			numRodada++;
			
		}
		endBattle(Herois, Viloes);
		
		scanner.close();
	}
	
	public static void Reposition (ArrayList <AbsPersonagem> Jogadores, int contP) { // recebe o vetor de jogadores apropriado e a posicao do jogador atual
		String choice; // string para guardar escolha
		int mov = 0, dist; // int para guardar escolha de movimento e para guardar distancia ponderada
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
		if (((choice.equalsIgnoreCase("esquerda")) || (choice.equalsIgnoreCase("E"))) && contP < Jogadores.size()) {
			dist = (int)(Jogadores.get(contP).agilidade * Jogadores.get(contP).buffagilidadevalor / 25) + 1;
			if (dist >= Jogadores.size() - 1 - contP)
				dist = Jogadores.size() - 1 - contP;
				
			System.out.println("Voce pode se mover " + dist + " posicoes para a  esquerda");
			System.out.println("Quao longe quer se mover?");
			
			
			// capta a escolha de distancia de movimento 
			while (mov > dist || mov <= 0) {
				mov = scanner.nextInt();
				if (mov > dist) // imprime e tenta denovo se a entrada for invalida 
					System.out.println("Voce inseriu uma distancia invalida. Tente denovo");
			}
			
			// reposiciona o jogador para a posicao escolhida
			temp = Jogadores.get(contP);
			Jogadores.remove(contP);
			Jogadores.add(contP+mov, temp);
		}
		
		// Se o jogador escolher direita, verifica quanto pode se mecher para a esquerda e pergunta ao jogador
		if (((choice.equalsIgnoreCase("direita")) || (choice.equalsIgnoreCase("d"))) && contP > 0) {
			dist = (int)(Jogadores.get(contP).agilidade * Jogadores.get(contP).buffagilidadevalor / 25) + 1;
			if (contP - dist < 0)
				dist = dist + (contP - dist);
				
			System.out.println("Voce pode se mover " + dist + " posicoes para a  esquerda");
			System.out.println("Quao longe quer se mover?");
			
			// capta a escolha de distancia de movimento 
			while (mov > dist || mov <= 0) {
				mov = scanner.nextInt();
				if (mov > dist) // imprime e tenta denovo se a entrada for invalida 
					System.out.println("Voce inseriu uma distancia invalida. Tente denovo");
			}
			
			// reposiciona o jogador para a posicao escolhida
			temp = Jogadores.get(contP);
			Jogadores.remove(contP);
			Jogadores.add(contP-mov, temp);
		}
			
		System.out.println("");
		for(int contPrint = 0; contPrint < Jogadores.size(); contPrint++) {
			System.out.print(Jogadores.get(contPrint).nome + " ");
			System.out.println(Jogadores.get(contPrint).iniciativa);
		}
		System.out.println("");
	}
	
	public static void attack (AbsPersonagem Heroi, ArrayList <AbsPersonagem> Viloes, int posHeroi) {
		Random random = new Random(); // gerador de numeros randomicos
		String chc;
		int trgt, dano;
		double weaponDam;
		boolean choiceFlag1, choiceFlag2;
		
		if (Heroi.tipo == 1)
			weaponDam = /*dano arma*/10*(1 + (Heroi.forca*Heroi.buffforcavalor)/50)+(0.8+(Heroi.level/25))*0.5; //com melhor arma 100 dano, 100 força/percep, lvl 50: 250/3 (min) - 250 (medio) - 500 (max) - 1000 (crit)
		else																									//com pior arma 4 dano, 15 força/percep, lvl 1: 1 (min) - 4 (medio) - 8 max - 16 (crit)
			weaponDam = /*dano arma*/10*(1 + (Heroi.percepcao*Heroi.buffpercepcaovalor)/50)+(0.8+(Heroi.level/25))*0.5;
		
		System.out.println("Selecione seu ataque: ");
		System.out.println("ataque Basico (B)");
		System.out.println("Habilidade (1): " + Heroi.nSkill1);
		System.out.println("Habilidade (2)" + Heroi.nSkill2);
		System.out.println("Habilidade (3): " + Heroi.nSkill3);
		
		chc = scanner.nextLine();
		
		choiceFlag1 = true;
		while (choiceFlag1) {
			if ((chc.equalsIgnoreCase("B"))) {
				if(Heroi.tipo==1 || posHeroi<=2) {
					choiceFlag2 = true;
					while (choiceFlag2) {
						System.out.println("Selecione seu alvo (1-6)");
						trgt = scanner.nextInt();
						if(Heroi.tipo==1 || trgt<=2)
						if (trgt >= 1 && trgt <= 6) {
							// dano vai de 1/3*esperado a 2*esperado. Maximo de redução eh (dano/5 - 80)
							dano = ((int)weaponDam * ((1/3) * (random.nextInt(5)+1))) * (1 - Viloes.get(trgt-1).armadura) - ((Viloes.get(trgt-1).resistencia/5)*(1 + (Viloes.get(trgt-1).level/15)));
							if (dano <=0)
								dano = 1;
							if ((int)Heroi.critico*random.nextInt(99)+1 >= 100) {
								dano *= 2;
								Viloes.get(trgt-1).hp -= dano;
								System.out.println("Voce atingiu " + Viloes.get(trgt-1).nome + " com um golpe critico! " + dano + "de dano!");
							}
							else if ((int)Viloes.get(trgt-1).esquiva*random.nextInt(99)+1 < 100) {
								Viloes.get(trgt-1).hp -= dano;
								System.out.println(Viloes.get(trgt-1).nome + " atingido! " + dano + "de dano!");
							}
							else
								System.out.println(Viloes.get(trgt-1).nome + " desviou!");
							choiceFlag2 = false;
						}
						else
							System.out.println("Invalid Target! Try Again");
					}
					choiceFlag1 = false;
				}
			}
			
			else if ((chc.equalsIgnoreCase("1")))
				Heroi.Skill1(Viloes, weaponDam);
			else if ((chc.equalsIgnoreCase("2")))
				Heroi.Skill2(Viloes, weaponDam);
			else if ((chc.equalsIgnoreCase("3")))
				Heroi.Skill3(Viloes, weaponDam);
			else
				System.out.println("Ataque invalido: Tente denovo");
		}
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
				H.CountXP(EXP);
			}
		}
		
	}
	
	// O buff correto devera incrementar apenas .Buff___Rounds
	@Deprecated
	public static void BUFF (AbsPersonagem alvo, String atributo, int stat, int time) {
		Class<AbsPersonagem> classe = AbsPersonagem.class;
		Field att = null;
		
		try {
			
			att = classe.getDeclaredField(atributo); // Pega o atributo certo da classe
			
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		if (!atributo.equalsIgnoreCase("bleed") && !atributo.equalsIgnoreCase("poison") && !atributo.equalsIgnoreCase("stun")) {
			try {
				
				att.set(alvo, (att.getInt(alvo) + stat)); // Aumenta o atributo
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		while(numRodada < numRodada+time); // Passa o numero de turnos necessário
		
		if (!atributo.equalsIgnoreCase("bleed") && !atributo.equalsIgnoreCase("poison") && !atributo.equalsIgnoreCase("stun")) {
			try {
				
				att.set(alvo, (att.getInt(alvo) - stat)); // Diminui o atributo
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void AI (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes,  ArrayList <AbsPersonagem> Lista, int contP, int contI) {
		int atk, trgt, dano;
		double weaponDam;
		boolean flag = true;
		Random random = new Random(); // gerador de numeros randomicos
		AbsPersonagem temp = new PersonGenerico();
		
		System.out.println(Lista.get(contI).nome + " " + Lista.get(contI).iniciativa);
			
		// compara se a escolha eh compativel com alguma opcao vailda e roda a funcao apropriada
		if ((Lista.get(contI).tipo != 1) && (contP < 2)) {
			
			if (Viloes.size() > contP) {
				temp = Viloes.get(contP);
				Viloes.remove(contP);
				Viloes.add(contP+1, temp);
				flag = false;
			}				
		}
		
		if ((Lista.get(contI).tipo == 1) && (contP > 1)) {
			
			temp = Viloes.get(contP);
			Viloes.remove(contP);
			Viloes.add(contP-1, temp);
			flag = false;
		}
		
		else if (flag) {
			atk = random.nextInt(99) + 1;
			
			if (Viloes.get(contP).tipo == 1)
				weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).forca*Viloes.get(contP).buffforcavalor)/50)+(0.8+(Viloes.get(contP).level/25))*0.5;
			else
				weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).percepcao*Viloes.get(contP).buffpercepcaovalor)/50)+(0.8+(Viloes.get(contP).level/25))*0.5;
			
			if (atk <= 50) {
				trgt = random.nextInt(5) + 1;
				dano = ((int)weaponDam * ((1/3) * (random.nextInt(5)+1))) * (1 - Herois.get(trgt-1).armadura) - ((Herois.get(trgt-1).resistencia/5)*(1 + (Herois.get(trgt-1).level/15)));
				if (dano <=0)
					dano = 1;if ((int)Viloes.get(contP).critico*random.nextInt(99)+1 >= 100) {
						dano *= 2;
						Herois.get(trgt-1).hp -= dano;
						System.out.println("Inimigo atingiu " + Herois.get(trgt-1).nome + "com um golpe critico!" + dano + "de dano!");
					}
					else if ((int)Herois.get(trgt-1).esquiva*random.nextInt(99)+1 < 100) {
						Herois.get(trgt-1).hp -= dano;
						System.out.println(Herois.get(trgt-1).nome + " atingido! " + dano + "de dano!");
					}
					else
						System.out.println(Herois.get(trgt-1).nome + " desviou do ataque!");
			}
			
			/*else if ((atk > 50) && (atk <= 75))
				Viloes.get(contP).Skill1(Herois, trgt, weaponDam);
			else if ((atk > 75) && (atk <= 90))
				Viloes.get(contP).Skill2(Herois, trgt, weaponDam);
			else if ((atk > 90) && (atk <= 100))
				Viloes.get(contP).Skill3(Herois, trgt, weaponDam);*/
				
		}
		
	}
}