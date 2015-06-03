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
	public int forca, percepcao, resistencia, carisma, inteligencia, agilidade, sorte;
	public int buffForcaRounds, buffPercepcaoRounds, buffResistenciaRounds, buffCarismaRounds, buffInteligenciaRounds, buffAgilidadeRounds, buffSorteRounds, buffArmaduraRounds, buffEsquivaRounds, buffCriticoRounds;
	public double buffForcaValor=1, buffPercepcaoValor=1, buffCarismaValor=1, buffResistenciaValor=1, buffInteligenciaValor=1, buffAgilidadeValor=1, buffSorteValor=1, buffArmaduraValor=1, buffEsquivaValor=1, buffCriticoValor;
	public double esquiva, critico;
	public int hp, maxHP, xp, level, armadura, iniciativa, tipo /*1 = melee, 3 = ranged, 5 = support*/;
	public boolean bleed = false, poison = false, stun = false, vilao = false;
	public String nome, nSkill1, nSkill2, nSkill3;
	/*Inventario inventario;*/
		
	public int Skill1 (ArrayList <AbsPersonagem> Viloes, double dam) { // nos viloes tem que adicionar tambem o alvo ja escolhido
		int trgt = 1;
		return trgt;
	}
	
	public int Skill2 (ArrayList <AbsPersonagem> Viloes, double dam) {
		int trgt = 1;
		return trgt;
	}
	
	public int Skill3 (ArrayList <AbsPersonagem> Viloes, double dam) {
		int trgt = 1;
		return trgt;
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
		
		System.out.println("oi");
		
		/*daqui pra baixo também é provisório*/
		while (this.xp >= this.level*10) {	
			System.out.println("wtf");
			this.LevelUp();
		}
		System.out.println("oii");
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
		for(int i = 5; i > 0; i--){
			atributo = new Scanner(System.in).nextLine();
			
			if (atributo.equalsIgnoreCase("forca"))
				this.forca++;
			
			else if (atributo.equalsIgnoreCase("percepcao"))
				this.percepcao++;
			
			else if (atributo.equalsIgnoreCase("resistencia"))
				this.resistencia++;
			
			else if (atributo.equalsIgnoreCase("carisma"))
				this.carisma++;
			
			else if (atributo.equalsIgnoreCase("inteligencia"))
				this.inteligencia++;
			
			else if (atributo.equalsIgnoreCase("agilidade"))
				this.agilidade++;
			
			else if (atributo.equalsIgnoreCase("sorte"))
				this.sorte++;
			
			else {
				System.out.println("Entrada Invalida");
				i++;
			}
		}
		
	}


}
