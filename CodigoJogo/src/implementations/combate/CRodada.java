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
	Inventario inventario = new Inventario();

	public static void Jogada (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes,  ArrayList <AbsPersonagem> Lista) { //recebe ArrayList de herois e viloes ordenados
		int contP, contI; // contador para vetor de Personagens e Iniciativa
		int HInit = 0, VInit = 0; // ints para usar em flee
		boolean flag, endFlag = true; // flag para parar o loop de escolha e o combate
		String chc; // string de que guarda a escolha
		
		
		// roda enquanto houverem herois ou viloes e ninguem quiser fugir
		while (endFlag && Herois.isEmpty() == false && Viloes.isEmpty() == false) {
			// uma rodada para cada personagem, enquanto houverem herois ou viloes e ninguem quiser fugir
			for (contI = 0; contI < Lista.size() && endFlag == true && Herois.isEmpty() == false && Viloes.isEmpty() == false; contI++) {
				
				System.out.println();
				System.out.println(Lista.get(contI).nome + " " + Lista.get(contI).iniciativa);
	
				if ((Lista.get(contI).buffStunRounds == 0) && Lista.get(contI).hp > 0) { //pula a jogada de um jogador se desorientado
					
					// If para os Viloes (AI)
					if (Lista.get(contI).vilao) {
						for (contP = 0; !(Viloes.get(contP).equals(Lista.get(contI))) && (contP < Viloes.size()); contP++); // Acha a posicao contP do vilao da jogada atual na sua lista de posicao 	
						AI(Herois, Viloes, Lista, contP, contI);
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
								
								flag = attack(Herois.get(contP), Viloes, contP);
								
							}
				
							else if ((chc.equalsIgnoreCase("usar item")) || (chc.equalsIgnoreCase("i")) || (chc.equalsIgnoreCase("item"))) {
								useItem(contI, Lista);
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
				if (Lista.get(contI).buffBleedRounds > 0) {
					Lista.get(contI).hp -= Lista.get(contI).hp * 0.1;
					Lista.get(contI).buffBleedRounds--;
				}
				if (Lista.get(contI).buffPoisonRounds > 0) {
					Lista.get(contI).hp -= Lista.get(contI).maxHP * 0.1;
					Lista.get(contI).buffPoisonRounds--;
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
				if (Lista.get(contI).buffStunRounds > 0) Lista.get(contI).buffStunRounds--;
				
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
				if (Lista.get(contI).buffCriticoRounds == 0) Lista.get(contI).buffCriticoValor=1;
				
			/* Se os buffs vao ser porcentagens, precisamos soh multiplicar um atributo por seu buff toda vez q ele for usado, e deixar NAO BUFF = 1
			 * Mas entao precisaremos dar tipecast (int) em alguns lugares.... 
			 */
			}
			numRodada++;
			
		}
		endBattle(Herois, Viloes);
		
		System.out.println("Fim de Combate");
		
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
	
	public static boolean attack (AbsPersonagem Heroi, ArrayList <AbsPersonagem> Viloes, int posHeroi) {
		Random random = new Random(); // Gerador de numeros randomicos
		String chc; // String guarda escolha do jogador
		int trgt = 1, dano, resistencia; // Guardam respectivamente: alvo do jogador, dano final, resistencia final
		double weaponDam, armadura, fator; // Guardam respectivamente: dano da arma ponderado, armadura ponderada, fator randomico ponderado
		boolean choiceFlag1, choiceFlag2, noAtk = false; // Flags para parar os loops de escolha de ação. noAtk permite voltar ao menu de "Jogada" sem perder a vez
		
		//Melee usa força, ranged usa percepção. dano = (dano arma * (1+(força/50)+(fator de nivel)) /2 ). Fator nivel é 1 no nivel 1 e sobe pra 2 no nivel 50
		if (Heroi.tipo == 1) weaponDam = /*dano arma*/30*(1 + (Heroi.forca*Heroi.buffForcaValor)/50)+(0.96+(Heroi.level/25))*0.5; //com melhor arma 100 dano, 100 força/percep, lvl 50: 250/3 (min) - 250 (medio) - 500 (max) - 1000 (crit)
		else weaponDam = /*dano arma*/30*(1 + (Heroi.percepcao*Heroi.buffPercepcaoValor)/50)+(0.96+(Heroi.level/25))*0.5; //com pior arma 4 dano, 15 força/percep, lvl 1: 1 (min) - 4 (medio) - 8 max - 16 (crit)
		
		choiceFlag1 = true;
		while (choiceFlag1) {
			System.out.println("Selecione seu ataque: ");
			System.out.println("ataque Basico (B)");
			System.out.println("Habilidade (1): " + Heroi.nSkill1);
			System.out.println("Habilidade (2): " + Heroi.nSkill2);
			System.out.println("Habilidade (3): " + Heroi.nSkill3);
			System.out.println("Cancelar (C)");
			
			chc = scanner.nextLine();
			
			if ((chc.equalsIgnoreCase("B"))) {

				if((Heroi.tipo==1 && posHeroi < 2) || Heroi.tipo!=1) { // Se heroi for melee, fora da frente (1ª e 2ª posições), nao pode usar ataque basico
					
					choiceFlag2 = true;
					
					while (choiceFlag2) {
						
						System.out.println("Selecione seu alvo (1-6)");
						trgt = scanner.nextInt();
						
						if((Heroi.tipo == 1 && trgt <=2) || Heroi.tipo != 1) { // Se heroi for melee, nao pode acertar alvos fora da frente (1ª e 2ª posições)
							if (trgt >= 1 && trgt <= 6) {
								
								// dano vai de 1/3*esperado a 2*esperado. Maximo de redução eh (dano/2,5 - 80), com 60 armadura, lvl 50 e 100 de resistencia
								armadura = (1 - ((Viloes.get(trgt-1).armadura*Viloes.get(trgt-1).buffArmaduraValor)/100));
								if (armadura < 0.1) armadura = 0.1; // evita armadura acima de 90% por buffs
								
								// Resistencia(com buffs)/5 * fator de nivel
								resistencia = (int)(((Viloes.get(trgt-1).resistencia*Viloes.get(trgt-1).buffResistenciaValor)/5)*(0.96 + (Viloes.get(trgt-1).level/15)));
								
								fator = random.nextInt(6)+1; //o fator é dividido por 3, assim 1 = 1/3 dano, 2 = 2/3 dano, 3 = dano, 4 = 4/3 dano, 5 = 5/3 dano e 6 = 2 dano. A media é o dano esperado da arma

								dano = ((int)((weaponDam * (fator/3)) * armadura)) - resistencia; // Dano final
								if (dano <= 0) dano = 1; // Dano minimo é 1
								
								if ((int)(Heroi.critico * Heroi.buffCriticoValor)+random.nextInt(100)+1 >= 100) { // Soma a chance de critico com random 1-100. Se passar de 100 crita
									dano *= 2;
									Viloes.get(trgt-1).hp -= dano;
									System.out.println("Voce atingiu " + Viloes.get(trgt-1).nome + " com um golpe critico! " + dano + " de dano!");
								}
								else if ((int)(Viloes.get(trgt-1).esquiva*Viloes.get(trgt-1).buffEsquivaValor)+random.nextInt(100)+1 < 100) { // Igual ao critico
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
							System.out.println("Alvo muito distante para combate a curta distancia! Escolha um alvo mais proximo.");
							choiceFlag2 = false;
						}
					}
			
				}
				else {
					System.out.println("Alvo muito distante para combate a curta distancia! Aproxime-se antes de atacar ou escolha outra habilidade.");
					choiceFlag2 = false;
				}				
					
			}
			
			// Usa as skills
			else if ((chc.equalsIgnoreCase("1")))
				noAtk = Heroi.Skill1(Viloes, weaponDam, trgt);
			else if ((chc.equalsIgnoreCase("2")))
				noAtk = Heroi.Skill2(Viloes, weaponDam, trgt);
			else if ((chc.equalsIgnoreCase("3")))
				noAtk = Heroi.Skill3(Viloes, weaponDam, trgt);
			else if ((chc.equalsIgnoreCase("c")))
				noAtk = true;
			else
				System.out.println("Ataque invalido: Tente denovo");
		}
		
		// Se morrer, tira do vetor de posição (e por tabela do view/GUI
		if (Viloes.get(trgt-1).hp <= 0) {
			System.out.println(Viloes.get(trgt-1).nome + " foi morto!");
			Viloes.remove(trgt-1);
		}
		
		// Retorna essa flag positiva caso o ataque tenha sido cancelado, permitindo outra ação no turno
		return noAtk;
	}
	
	public static void endBattle (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Lista) {
		int EXP = 0;
		if (Herois.isEmpty()) { // Se todo mundo morreu, fudeu
			//n sei o que fazer pra rodar um gameover
			System.out.println("GAME OVER, MWAHAHAHAHA");
		}
		
		else {
			// Roda o vetor de jogada. Adiciona XP equivalente ao nivel de cada vilao morto à pilha de XP
			for (AbsPersonagem P: Lista) {
				if ((P.vilao) && (P.hp <= 0))
					EXP += P.level;
			}
			
			// Todo mundo vivo ganha XP
			for (AbsPersonagem H: Herois) {
				H.CountXP(EXP);
				System.out.println(H.nome + " ganhou " + EXP + " pontos de experiencia!");
			}
		}
		
	}
	
	public static boolean useItem (int contI, ArrayList <AbsPersonagem> Lista) {
		//Colocar essas paradas dentro de um metodo
		Inventario inventario = new Inventario();
		String nome_item;
		String tipo_item;
		int bonus_item;
		Item usable;
		int itemselecionado;
		String chc;
		
		
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
			else if(chc.equalsIgnoreCase("cancela")) {
				itemselecionado = 2;
				System.out.println("Operacao cancelada");
			}
			else System.out.println("Este item nao existe, escolha outro ou digite 'cancela' ");
		}
		if(itemselecionado == 1){
			switch (tipo_item) {
			case "HP":
				Lista.get(contI).hp += (int)(Lista.get(contI).hp * (bonus_item*0.01));
				inventario.remover_item(nome_item);
				return false;
			case "STR":
				Lista.get(contI).buffForcaRounds += 3;
				Lista.get(contI).buffForcaValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "PER":
				Lista.get(contI).buffPercepcaoRounds += 3;
				Lista.get(contI).buffPercepcaoValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "END":
				Lista.get(contI).buffResistenciaRounds += 3;
				Lista.get(contI).buffResistenciaValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "CHA":
				Lista.get(contI).buffCarismaRounds += 3;
				Lista.get(contI).buffCarismaValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "INT":
				Lista.get(contI).buffInteligenciaRounds += 3;
				Lista.get(contI).buffInteligenciaValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "AGI":
				Lista.get(contI).buffAgilidadeRounds += 3;
				Lista.get(contI).buffAgilidadeValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			case "LCK":
				Lista.get(contI).buffSorteRounds += 3;
				Lista.get(contI).buffSorteValor = 1 + bonus_item*0.01;
				inventario.remover_item(nome_item);
				return false;
			default:
				System.out.println("Este item nao pode ser usado");
			}
		}
	return true;
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
		int atk, trgt = 1, dano, resistencia, fator;
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
			atk = random.nextInt(100) + 1;
			
			if (Viloes.get(contP).tipo == 1) weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).forca*Viloes.get(contP).buffForcaValor)/50)+(0.96+(Viloes.get(contP).level/25))*0.5;
			else weaponDam = /*dano arma*/10*(1 + (Viloes.get(contP).percepcao*Viloes.get(contP).buffPercepcaoValor)/50)+(0.96+(Viloes.get(contP).level/25))*0.5;
			
			if (atk <= 50) {
				
				// esse bloco aumenta a chance de um bot acertar a primeira posicao em 2x
				trgt = random.nextInt(12) + 1;
				trgt -= 6;
				if (trgt - 6 < 0) trgt = 1;
				
				// dano vai de 1/3*esperado a 2*esperado. Maximo de redução eh (dano/2,5 - 80), com 60 armadura, lvl 50 e 100 de resistencia
				armadura = (1 - (Herois.get(trgt-1).armadura*Herois.get(trgt-1).buffArmaduraValor));
				if (armadura < 0.1) armadura = 0.1; // evita armadura acima de 90% por buffs
				
				// Resistencia(com buffs)/5 * fator de nivel
				resistencia = (int)(((Herois.get(trgt-1).resistencia*Herois.get(trgt-1).buffResistenciaValor)/5)*(0.96 + (Herois.get(trgt-1).level/15)));
				
				fator = random.nextInt(6)+1; //o fator é dividido por 3, assim 1 = 1/3 dano, 2 = 2/3 dano, 3 = dano, 4 = 4/3 dano, 5 = 5/3 dano e 6 = 2 dano. A media é o dano esperado da arma

				dano = ((int)((weaponDam * (fator/3)) * armadura)) - resistencia; // Dano final
				if (dano <= 0) dano = 1; // Dano minimo é 1
				
				if ((int)(Viloes.get(contP).critico*Viloes.get(contP).buffCriticoValor)+random.nextInt(100)+1 >= 100) {
						dano *= 2;
						Herois.get(trgt-1).hp -= dano;
						System.out.println("Inimigo atingiu " + Herois.get(trgt-1).nome + " com um golpe critico! " + dano + " de dano!");
					}
					else if ((int)(Herois.get(trgt-1).esquiva*Herois.get(trgt-1).buffEsquivaValor)+random.nextInt(100)+1 < 100) {
						Herois.get(trgt-1).hp -= dano;
						System.out.println(Herois.get(trgt-1).nome + " atingido! " + dano + " de dano!");
					}
					else
						System.out.println(Herois.get(trgt-1).nome + " desviou do ataque!");
			}
			
			else if ((atk > 50) && (atk <= 75))
				//Viloes.get(contP).Skill1(Herois, weaponDam, trgt);
				System.out.println("SKILL 1 YAY");
			else if ((atk > 75) && (atk <= 90))
				//Viloes.get(contP).Skill2(Herois, weaponDam, trgt);
				System.out.println("SKILL 2 UHUL");
			else if ((atk > 90) && (atk <= 100))
				//Viloes.get(contP).Skill3(Herois, weaponDam, trgt);
				System.out.println("SKILL 3 YUPI");
				
		}
		
		if (Herois.get(trgt-1).hp <= 0) {
			System.out.println(Herois.get(trgt-1).nome + " foi nocauteado!");
			Herois.remove(trgt-1);
		}
		
	}
}