package implementations.personagens;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public abstract class AbsPersonagem {
	public int forca = 15, percepcao = 15, resistencia = 15, carisma = 15, inteligencia = 15, agilidade = 15, sorte = 15;
	public int buffForcaRounds, buffPercepcaoRounds, buffResistenciaRounds, buffCarismaRounds, buffInteligenciaRounds, buffAgilidadeRounds, buffSorteRounds, buffArmaduraRounds, buffEsquivaRounds, buffCriticoRounds, buffBleedRounds, buffPoisonRounds, buffStunRounds;
	public double buffForcaValor=1, buffPercepcaoValor=1, buffCarismaValor=1, buffResistenciaValor=1, buffInteligenciaValor=1, buffAgilidadeValor=1, buffSorteValor=1, buffArmaduraValor=1, buffEsquivaValor=1, buffCriticoValor;
	public double esquiva = 0, critico = 0;
	public int hp = 100, maxHP = 100, xp = 0, level = 1, armadura = 0, iniciativa, pos, tipo ; /*1 = melee, 3 = ranged, 5 = support*/;
	public boolean vilao = false;
	public String nome, nSkill1, nSkill2, nSkill3;
	
	
	public boolean Skill1 (ArrayList <AbsPersonagem> Viloes, double dam, int trgt) {
		boolean noAtk = false;
		return noAtk;
	}
	
	public boolean Skill2 (ArrayList <AbsPersonagem> Viloes, double dam, int trgt) {
		boolean noAtk = false;
		return noAtk;
	}
	
	public boolean Skill3 (ArrayList <AbsPersonagem> Viloes, double dam, int trgt) {
		boolean noAtk = false;
		return noAtk;
	}

	/*método que renderiza o personagem*/
	public void Render (){
		
	}
	
	/*método que altera a vida do personagem*/
	public void Damage_Heal (int modHP){
		this.hp += modHP;
		
		if (this.hp > this.maxHP)
			this.hp = this.maxHP;
		
		else if (this.hp <= 0)
			System.out.println("Game Over"); /*chamar função de game over; isso provisório*/
	}
	
	/*método que altera o xp do personagem*/
	public void CountXP (int modXP){
		this.xp += modXP;
		
		while (this.xp >= this.level*10) {	
			this.LevelUp();
		}
	}
	
	/*método que upa o personagem*/
	public void LevelUp (){
		String atributo;
		
		this.xp -= this.level*10;
		this.level++;
		
		// vida vai de 100 a 500 (min)/3433(max)
		this.maxHP += this.resistencia*2/3;
		this.hp += this.resistencia*2/3;
				
		// 105 pontos de atributo no nivel 1 (15 em cada) + 5 atributos por nivel (49 niveis) = 350 no total ao nivel 50
		System.out.println(this.nome + " passou de nivel! Ganhou " + (int)this.resistencia*2/3 + " pontos de vida e 5 atributos a sua escolha: ");
		for(int i = 5; i > 0; i--){
			System.out.println(this.nome);
			System.out.println("Forca: " + this.forca);
			System.out.println("Percepcao: " + this.percepcao);
			System.out.println("Resistencia: " + this.resistencia);
			System.out.println("Carisma: " + this.carisma);
			System.out.println("Inteligencia: " + this.inteligencia);
			System.out.println("Agilidade: " + this.agilidade);
			System.out.println("Sorte: " + this.sorte);
			System.out.println("Escolha um atributo: " + i + " pontos restantes");
			
			atributo = new Scanner(System.in).nextLine();
			
			if (atributo.equalsIgnoreCase("forca") || atributo.equalsIgnoreCase("f")) {
				if (this.forca <= 100)
					this.forca++;
				else {
					System.out.println("Forca ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("percepcao") || atributo.equalsIgnoreCase("p")) {
				if (this.percepcao <= 100)
					this.percepcao++;
				else {
					System.out.println("Percepcao ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("resistencia") || atributo.equalsIgnoreCase("r")) {
				if (this.resistencia <= 100)
					this.resistencia++;
				else {
					System.out.println("Resistencia ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("carisma") || atributo.equalsIgnoreCase("c")) {
				if (this.carisma <= 100)
					this.carisma++;
				else {
					System.out.println("Carisma ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("inteligencia") || atributo.equalsIgnoreCase("i")) {
				if (this.inteligencia <= 100)
					this.inteligencia++;
				else {
					System.out.println("Inteligencia ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("agilidade") || atributo.equalsIgnoreCase("a")) {
				if (this.agilidade <= 100)
					this.agilidade++;
				else {
					System.out.println("Agilidade ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("sorte") || atributo.equalsIgnoreCase("s")) {
				if (this.sorte <= 100)
					this.sorte++;
				else {
					System.out.println("Sorte ja esta no nivel 100!");
					i++;
				}
			}
			
			else {
				System.out.println("Entrada Invalida");
				i++;
			}
		}
	}
}
