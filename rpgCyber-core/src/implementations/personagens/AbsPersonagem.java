package implementations.personagens;

import implementations.personagens.skills.Skill;

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
	public transient int buffForcaRounds, buffPercepcaoRounds, buffResistenciaRounds, buffCarismaRounds, buffInteligenciaRounds, buffAgilidadeRounds, buffSorteRounds, buffArmaduraRounds, buffEsquivaRounds, buffCriticoRounds, buffBleedRounds, buffPoisonRounds, buffStunRounds;
	public transient double buffForcaValor=1, buffPercepcaoValor=1, buffCarismaValor=1, buffResistenciaValor=1, buffInteligenciaValor=1, buffAgilidadeValor=1, buffSorteValor=1, buffArmaduraValor=1, buffEsquivaValor=1, buffCriticoValor;
	public double esquiva = 0, critico = 0;
	public double hp = 100, maxHP = 100, xp = 0, level = 1, danoArma, armadura = 0, iniciativa, pos, tipo; /*1 = melee, 3 = ranged, 5 = support*/
	public boolean vilao = false, boss = false;
	public String nome, nSkill1, nSkill2, nSkill3;
	public transient Skill skill0, skill1, skill2, skill3;
	
	/*
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
	}*/
	 
	/*m�todo que renderiza o personagem*/
	/*public void Render (){
		
	}*/


	
	/*m�todo que altera a vida do personagem*/
	public void Damage_Heal (int modHP){
		this.hp += modHP;
		
		if (this.hp > this.maxHP)
			this.hp = this.maxHP;
		
		else if (this.hp <= 0)
			System.out.println("Game Over"); /*chamar fun��o de game over; isso provis�rio*/
	}
	
	/*m�todo que altera o xp do personagem*/
	public void CountXP (int modXP){
		this.xp += modXP;
		
		while (this.xp >= this.level*10) {	
			this.LevelUp();
		}
	}
	
	/*m�todo que upa o personagem*/
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
				if (this.agilidade <= 100){
					this.agilidade++;
					
					this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
					this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
				} else {
					System.out.println("Agilidade ja esta no nivel 100!");
					i++;
				}
			}
			
			else if (atributo.equalsIgnoreCase("sorte") || atributo.equalsIgnoreCase("s")) {
				if (this.sorte <= 100){
					this.sorte++;
					
					this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
					this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
				} else {
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

	public void setForca(int forca) {
		this.forca = forca;
	}

	public void setPercepcao(int percepcao) {
		this.percepcao = percepcao;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}
	
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	
	public void setSorte(int sorte) {
		this.sorte = sorte;
	}

	public int getBuffForcaRounds() {
		return buffForcaRounds;
	}

	public void setBuffForcaRounds(int buffForcaRounds) {
		this.buffForcaRounds = buffForcaRounds;
	}

	public int getBuffPercepcaoRounds() {
		return buffPercepcaoRounds;
	}

	public void setBuffPercepcaoRounds(int buffPercepcaoRounds) {
		this.buffPercepcaoRounds = buffPercepcaoRounds;
	}

	public int getBuffResistenciaRounds() {
		return buffResistenciaRounds;
	}

	public void setBuffResistenciaRounds(int buffResistenciaRounds) {
		this.buffResistenciaRounds = buffResistenciaRounds;
	}

	public int getBuffCarismaRounds() {
		return buffCarismaRounds;
	}

	public void setBuffCarismaRounds(int buffCarismaRounds) {
		this.buffCarismaRounds = buffCarismaRounds;
	}

	public int getBuffInteligenciaRounds() {
		return buffInteligenciaRounds;
	}

	public void setBuffInteligenciaRounds(int buffInteligenciaRounds) {
		this.buffInteligenciaRounds = buffInteligenciaRounds;
	}

	public int getBuffAgilidadeRounds() {
		return buffAgilidadeRounds;
	}

	public void setBuffAgilidadeRounds(int buffAgilidadeRounds) {
		this.buffAgilidadeRounds = buffAgilidadeRounds;
	}

	public int getBuffSorteRounds() {
		return buffSorteRounds;
	}

	public void setBuffSorteRounds(int buffSorteRounds) {
		this.buffSorteRounds = buffSorteRounds;
	}

	public int getBuffArmaduraRounds() {
		return buffArmaduraRounds;
	}

	public void setBuffArmaduraRounds(int buffArmaduraRounds) {
		this.buffArmaduraRounds = buffArmaduraRounds;
	}

	public int getBuffEsquivaRounds() {
		return buffEsquivaRounds;
	}

	public void setBuffEsquivaRounds(int buffEsquivaRounds) {
		this.buffEsquivaRounds = buffEsquivaRounds;
	}

	public int getBuffCriticoRounds() {
		return buffCriticoRounds;
	}

	public void setBuffCriticoRounds(int buffCriticoRounds) {
		this.buffCriticoRounds = buffCriticoRounds;
	}

	public int getBuffBleedRounds() {
		return buffBleedRounds;
	}

	public void setBuffBleedRounds(int buffBleedRounds) {
		this.buffBleedRounds = buffBleedRounds;
	}

	public int getBuffPoisonRounds() {
		return buffPoisonRounds;
	}

	public void setBuffPoisonRounds(int buffPoisonRounds) {
		this.buffPoisonRounds = buffPoisonRounds;
	}

	public int getBuffStunRounds() {
		return buffStunRounds;
	}

	public void setBuffStunRounds(int buffStunRounds) {
		this.buffStunRounds = buffStunRounds;
	}

	public double getBuffForcaValor() {
		return buffForcaValor;
	}

	public void setBuffForcaValor(double buffForcaValor) {
		this.buffForcaValor = buffForcaValor;
	}

	public double getBuffPercepcaoValor() {
		return buffPercepcaoValor;
	}

	public void setBuffPercepcaoValor(double buffPercepcaoValor) {
		this.buffPercepcaoValor = buffPercepcaoValor;
	}

	public double getBuffCarismaValor() {
		return buffCarismaValor;
	}

	public void setBuffCarismaValor(double buffCarismaValor) {
		this.buffCarismaValor = buffCarismaValor;
	}

	public double getBuffResistenciaValor() {
		return buffResistenciaValor;
	}

	public void setBuffResistenciaValor(double buffResistenciaValor) {
		this.buffResistenciaValor = buffResistenciaValor;
	}

	public double getBuffInteligenciaValor() {
		return buffInteligenciaValor;
	}

	public void setBuffInteligenciaValor(double buffInteligenciaValor) {
		this.buffInteligenciaValor = buffInteligenciaValor;
	}

	public double getBuffAgilidadeValor() {
		return buffAgilidadeValor;
	}

	public void setBuffAgilidadeValor(double buffAgilidadeValor) {
		this.buffAgilidadeValor = buffAgilidadeValor;
	}

	public double getBuffSorteValor() {
		return buffSorteValor;
	}

	public void setBuffSorteValor(double buffSorteValor) {
		this.buffSorteValor = buffSorteValor;
	}

	public double getBuffArmaduraValor() {
		return buffArmaduraValor;
	}

	public void setBuffArmaduraValor(double buffArmaduraValor) {
		this.buffArmaduraValor = buffArmaduraValor;
	}

	public double getBuffEsquivaValor() {
		return buffEsquivaValor;
	}

	public void setBuffEsquivaValor(double buffEsquivaValor) {
		this.buffEsquivaValor = buffEsquivaValor;
	}

	public double getBuffCriticoValor() {
		return buffCriticoValor;
	}

	public void setBuffCriticoValor(double buffCriticoValor) {
		this.buffCriticoValor = buffCriticoValor;
	}

	public void setEsquiva(double esquiva) {
		this.esquiva = esquiva;
	}

	public void setCritico(double critico) {
		this.critico = critico;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public void setMaxHP(double maxHP) {
		this.maxHP = maxHP;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public void setDanoArma(double danoArma) {
		this.danoArma = danoArma;
	}

	public void setArmadura(double armadura) {
		this.armadura = armadura;
	}

	public void setIniciativa(double iniciativa) {
		this.iniciativa = iniciativa;
	}

	public void setPos(double pos) {
		this.pos = pos;
	}

	public void setTipo(double tipo) {
		this.tipo = tipo;
	}

	public void setVilao(boolean vilao) {
		this.vilao = vilao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setnSkill1(String nSkill1) {
		this.nSkill1 = nSkill1;
	}

	public void setnSkill2(String nSkill2) {
		this.nSkill2 = nSkill2;
	}

	public void setnSkill3(String nSkill3) {
		this.nSkill3 = nSkill3;
	}

}
