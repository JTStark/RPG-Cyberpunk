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
import implementations.inventario.*;

import java.util.Scanner;
import java.util.Random;
import java.lang.reflect.Field;

public class CRodada {

	static int numRodada=0; //variavel global para que o antigo, deprecated BUFFS possa acompanhar a passagem de rodadas
	static Scanner scanner = new Scanner(System.in); //scanner para pegar a escolha

	public static void Jogada (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes,  ArrayList <AbsPersonagem> Lista) { //recebe ArrayList de herois e viloes ordenados
		int contP, contI; // contador para vetor de Personagens e Iniciativa
		int HInit = 0, VInit = 0; // ints para usar em flee
		boolean flag, endFlag = true; // flag para parar o loop de escolha e o combate
		String chc; // string de que guarda a escolha
		Inventario inventario = new Inventario();
		String nome_item;
		String tipo_item;
		int bonus_item;
		Item usable;
		int itemselecionado;
		
		// roda enquanto houverem herois ou viloes e ninguem quiser fugir
		while (endFlag && Herois.isEmpty() == false && Viloes.isEmpty() == false) {
			// uma rodada para cada personagem, enquanto houverem herois ou viloes e ninguem quiser fugir
			for (contI = 0; contI < Lista.size() && endFlag == true && Herois.isEmpty() == false && Viloes.isEmpty() == false; contI++) {
				
				System.out.println(Lista.get(contI).nome + " " + Lista.get(contI).iniciativa);
	
				if (!Lista.get(contI).stun && Lista.get(contI).hp > 0) { //pula a jogada de um jogador se desorientado
					
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
							if(scanner.hasNextInt()) scanner.nextInt();
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
								//Colocar essas paradas dentro de um metodo
								System.out.println("Escolha o item da mochila, ou escreva cancela para sair");
								inventario.getMochila();
								nome_item = "";
								tipo_item = ""; //so foi declarado valor para essas variaveis pq o java eh uma putinha reclamona
								bonus_item = 1;
								itemselecionado = 0;
								while(itemselecionado==0){
									chc = scanner.nextLine();
									usable = new Item(chc);
									if(usable.nomeEncontrado){
										usable.nomeEncontrado = false; // sera q dara erro de depois q encontrar uma vez, sempre encontrar mesmo q nao exista ?
										itemselecionado = 1;
										nome_item = usable.getName();
										tipo_item = usable.getType();
										bonus_item = usable.getBonus();
									}
									else if(chc.equalsIgnoreCase("cancela")) itemselecionado = 2;
									else System.out.println("Este item nao existe, escolha outro ou digite 'cancela' ");
								}
								if(itemselecionado == 1){
									switch (tipo_item) {
									case "HP":
										Lista.get(contI).hp += (int)(Lista.get(contI).hp * (bonus_item*0.01));
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "STR":
										Lista.get(contI).buffForcaRounds += 3;
										Lista.get(contI).buffForcaValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "PER":
										Lista.get(contI).buffPercepcaoRounds += 3;
										Lista.get(contI).buffPercepcaoValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "END":
										Lista.get(contI).buffResistenciaRounds += 3;
										Lista.get(contI).buffResistenciaValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "CHA":
										Lista.get(contI).buffCarismaRounds += 3;
										Lista.get(contI).buffCarismaValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "INT":
										Lista.get(contI).buffInteligenciaRounds += 3;
										Lista.get(contI).buffInteligenciaValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "AGI":
										Lista.get(contI).buffAgilidadeRounds += 3;
										Lista.get(contI).buffAgilidadeValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									case "LCK":
										Lista.get(contI).buffSorteRounds += 3;
										Lista.get(contI).buffSorteValor = 1 + bonus_item*0.01;
										inventario.remover_item(nome_item);
										flag = false;
										break;
									default:
										System.out.println("Este item nao pode ser usado");	
									}
								}								
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
				if (Lista.get(contI).buffForcaRounds > 0) Lista.get(contI).buffForcaRounds--;
				if (Lista.get(contI).buffPercepcaoRounds > 0) Lista.get(contI).buffPercepcaoRounds--;
				if (Lista.get(contI).buffResistenciaRounds > 0) Lista.get(contI).buffResistenciaRounds--;
				if (Lista.get(contI).buffCarismaRounds > 0) Lista.get(contI).buffCarismaRounds--;
				if (Lista.get(contI).buffInteligenciaRounds > 0) Lista.get(contI).buffInteligenciaRounds--;
				if (Lista.get(contI).buffAgilidadeRounds > 0) Lista.get(contI).buffAgilidadeRounds--;
				if (Lista.get(contI).buffSorteRounds > 0) Lista.get(contI).buffSorteRounds--;
				if (Lista.get(contI).buffArmaduraRounds > 0) Lista.get(contI).buffArmaduraRounds--;
				if (Lista.get(contI).buffEsquivaRounds > 0) Lista.get(contI).buffEsquivaRounds--;
				if (Lista.get(contI).buffCriticoRounds > 0) Lista.get(contI).buffCriticoRounds--;
				
				// Remove os buff cujos rounds acabaram
				if (Lista.get(contI).buffForcaRounds == 0) Lista.get(contI).buffForcaValor=1;
				if (Lista.get(contI).buffPercepcaoRounds == 0) Lista.get(contI).buffPercepcaoValor=1;
				if (Lista.get(contI).buffResistenciaRounds == 0) Lista.get(contI).buffResistenciaValor=1;
				if (Lista.get(contI).buffCarismaRounds == 0) Lista.get(contI).buffCarismaValor=1;
				if (Lista.get(contI).buffInteligenciaRounds == 0) Lista.get(contI).buffInteligenciaValor=1;
				if (Lista.get(contI).buffAgilidadeRounds == 0) Lista.get(contI).buffAgilidadeValor=1;
				if (Lista.get(contI).buffSorteRounds == 0) Lista.get(contI).buffSorteValor=1;
				if (Lista.get(contI).buffArmaduraRounds == 0) Lista.get(contI).buffArmaduraValor=1;
				if (Lista.get(contI).buffEsquivaRounds == 0) Lista.get(contI).buffArmaduraValor=1;
				if (Lista.get(contI).buffArmaduraRounds == 0) Lista.get(contI).buffArmaduraValor=1;
				
			/* Se os buffs vao ser porcentagens, precisamos soh multiplicar um atributo por seu buff toda vez q ele for usado, e deixar NAO BUFF = 1
			 * Mas entao precisaremos dar tipecast (int) em alguns lugares.... 
			 */
				System.out.println("hu3");
			}
			numRodada++;
			System.out.println("hu3hu3");
			
		}
		System.out.println("hu3hu3hu3");
		endBattle(Herois, Viloes);
		System.out.println("hu3hu3hu3hu3");
		
		scanner.close();
		System.out.println("hu3hu3hu3hu3hu3hu3hu3");
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
			dist = (int)(Jogadores.get(contP).agilidade * Jogadores.get(contP).buffAgilidadeValor / 25) + 1;
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
			dist = (int)(Jogadores.get(contP).agilidade * Jogadores.get(contP).buffAgilidadeValor / 25) + 1;
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
		int trgt = 1, dano, resistencia;
		double weaponDam, armadura, fator;
		boolean choiceFlag1, choiceFlag2;
		
		if (Heroi.tipo == 1)
			weaponDam = /*dano arma*/30*(1 + (Heroi.forca*Heroi.buffForcaValor)/50)+(0.96+(Heroi.level/25))*0.5; //com melhor arma 100 dano, 100 força/percep, lvl 50: 250/3 (min) - 250 (medio) - 500 (max) - 1000 (crit)
		else																									//com pior arma 4 dano, 15 força/percep, lvl 1: 1 (min) - 4 (medio) - 8 max - 16 (crit)
			weaponDam = /*dano arma*/30*(1 + (Heroi.percepcao*Heroi.buffPercepcaoValor)/50)+(0.96+(Heroi.level/25))*0.5;
		
		System.out.println("Selecione seu ataque: ");
		System.out.println("ataque Basico (B)");
		System.out.println("Habilidade (1): " + Heroi.nSkill1);
		System.out.println("Habilidade (2): " + Heroi.nSkill2);
		System.out.println("Habilidade (3): " + Heroi.nSkill3);
		
		choiceFlag1 = true;
		while (choiceFlag1) {
			chc = scanner.nextLine();
			if ((chc.equalsIgnoreCase("B"))) {
				if(Heroi.tipo==1 || posHeroi<=2) {
					choiceFlag2 = true;
					while (choiceFlag2) {
						System.out.println("Selecione seu alvo (1-6)");
						trgt = scanner.nextInt();
						if((Heroi.tipo == 1 && trgt <=2) || Heroi.tipo != 1) {							
							if (trgt >= 1 && trgt <= 6) {
								
								// dano vai de 1/3*esperado a 2*esperado. Maximo de redução eh (dano/2,5 - 80), com 60 armadura, lvl 50 e 100 de resistencia 31,125
								armadura = (1 - (Viloes.get(trgt-1).armadura*Viloes.get(trgt-1).buffArmaduraValor));
								if (armadura < 0) armadura = 0;
								
								resistencia = (int)(((Viloes.get(trgt-1).resistencia*Viloes.get(trgt-1).buffResistenciaValor)/5)*(0.96 + (Viloes.get(trgt-1).level/15)));
								System.out.println(weaponDam + " " + armadura + " " + resistencia);
								fator = random.nextInt(6)+1;
								System.out.println(fator);
								dano = ((int)((weaponDam * (fator/3)) * armadura)) - resistencia;
								System.out.println(dano);
								if (dano <= 0) dano = 1;
								System.out.println(dano);
								
								if ((int)(Heroi.critico * Heroi.buffCriticoValor)+random.nextInt(99)+1 >= 100) {
									dano *= 2;
									Viloes.get(trgt-1).hp -= dano;
									System.out.println("Voce atingiu " + Viloes.get(trgt-1).nome + " com um golpe critico! " + dano + " de dano!");
								}
								else if ((int)(Viloes.get(trgt-1).esquiva*Viloes.get(trgt-1).buffEsquivaValor)+random.nextInt(99)+1 < 100) {
									Viloes.get(trgt-1).hp -= dano;
									System.out.println(Viloes.get(trgt-1).nome + " atingido! " + dano + " de dano!");
								}
								else
									System.out.println(Viloes.get(trgt-1).nome + " desviou!");
								choiceFlag2 = false;
								choiceFlag1 = false;
							}
							else
								System.out.println("Alvo invalido! Tente novamente");
						}
						else {
							System.out.println("Alvo muito distante para combate a curta distancia! Aproxime-se ou escolha um alvo mais proximo.");
							choiceFlag2 = false;
						}
					}
				}
			}
			
			else if ((chc.equalsIgnoreCase("1")))
				trgt = Heroi.Skill1(Viloes, weaponDam);
			else if ((chc.equalsIgnoreCase("2")))
				trgt = Heroi.Skill2(Viloes, weaponDam);
			else if ((chc.equalsIgnoreCase("3")))
				trgt = Heroi.Skill3(Viloes, weaponDam);
			else
				System.out.println("Ataque invalido: Tente denovo");
		}
		
		if (Viloes.get(trgt-1).hp <= 0) {
			System.out.println(Viloes.get(trgt-1).nome + " foi morto!");
			Viloes.remove(trgt-1);
		}
		
	}
	
	public static void endBattle (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes) {
		int EXP = 0;
		System.out.println("1");
		if (Herois.isEmpty()) {
			//n sei o que fazer pra rodar um gameover
			System.out.println("GAME OVER, MWAHAHAHAHA");
		}
		
		else {
			System.out.println("2");
			for (AbsPersonagem V: Viloes) {
				if (V.hp <= 0)
					EXP += V.level;
			}
			System.out.println("3");
			
			for (AbsPersonagem H: Herois) {
				System.out.println("eita");
				H.CountXP(EXP);
				System.out.println("ops");
			}
			System.out.println("4");
		}
		System.out.println("5");
		
	}
	
	@Deprecated
	public static void useItem () {
		
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
		int atk, trgt = 1, dano, resistencia;
		double weaponDam, armadura;
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
				weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).forca*Viloes.get(contP).buffForcaValor)/50)+(0.96+(Viloes.get(contP).level/25))*0.5;
			else
				weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).percepcao*Viloes.get(contP).buffPercepcaoValor)/50)+(0.96+(Viloes.get(contP).level/25))*0.5;
			
			if (atk <= 50) {
				
				// esse bloco aumenta a chance de um bot acertar a primeira posicao em 2x
				trgt = random.nextInt(11) + 1;
				trgt -= 6;
				if (trgt - 6 < 0) trgt = 1;
				
				armadura = (1 - (Herois.get(trgt-1).armadura*Herois.get(trgt-1).buffArmaduraValor));
				if (armadura < 0) armadura = 0;
				
				resistencia = (int)(((Herois.get(trgt-1).resistencia*Herois.get(trgt-1).buffResistenciaValor)/5)*(0.96 + (Herois.get(trgt-1).level/15)));
				
				dano = (int)((weaponDam * ((1/3) * (random.nextInt(5)+1))) * armadura) - resistencia;
				if (dano <=0) dano = 1;
				
				if ((int)(Viloes.get(contP).critico*Viloes.get(contP).buffCriticoValor)+random.nextInt(99)+1 >= 100) {
						dano *= 2;
						Herois.get(trgt-1).hp -= dano;
						System.out.println("Inimigo atingiu " + Herois.get(trgt-1).nome + "com um golpe critico! " + dano + " de dano!");
					}
					else if ((int)(Herois.get(trgt-1).esquiva*Herois.get(trgt-1).buffEsquivaValor)+random.nextInt(99)+1 < 100) {
						Herois.get(trgt-1).hp -= dano;
						System.out.println(Herois.get(trgt-1).nome + " atingido! " + dano + " de dano!");
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
		
		if (Herois.get(trgt-1).hp <= 0) {
			System.out.println(Herois.get(trgt-1).nome + " foi nocauteado!");
			Herois.remove(trgt-1);
		}
		
	}
}