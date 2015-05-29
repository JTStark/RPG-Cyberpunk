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
	public double esquiva, critico;
	public int hp, maxHP, xp, level, armadura, iniciativa, tipo /*1 = melee, 2 = ranged, 3 = support*/;
	public boolean bleed = false, poison = false, stun = false, vilao = false;
	public String nome, nSkill1, nSkill2, nSkill3;
	/*Inventario inventario;*/
	
	/*método que define os valores iniciais dos atributos do personagem*/
	public void SetAtributos (){
		
	}
	
	public void Skill1 (ArrayList <AbsPersonagem> Viloes, double dam) { // nos viloes tem que adicionar tambem o alvo ja escolhido
		
	}
	
	public void Skill2 (ArrayList <AbsPersonagem> Viloes, double dam) {
		
	}
	
	public void Skill3 (ArrayList <AbsPersonagem> Viloes, double dam) {
		
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
		
		/*daqui pra baixo também é provisório*/
		if (this.xp >= this.level*10)		
			this.LevelUp();
	}
	
	/*método que upa o personagem*/
	public void LevelUp (){
		String atributo;
		
		this.xp -= this.level*10;
		this.level++;
				
		/*De novo, provisório*/
		for(int i = 15; i > 0; i--){
			atributo = new Scanner(System.in).nextLine();
			
			if (atributo.equalsIgnoreCase("forca"))
				this.forca++;
			
			else if (atributo.equalsIgnoreCase("percepcao"))
				this.percepcao++;
			
			else if (atributo.equalsIgnoreCase("resistencia"))
				this.resistencia++;
			
			else if (atributo.equalsIgnoreCase("carisma")){
				System.out.println("Carisma eh um atributo inalteravel, ou voce eh gato ou vc nao eh");
				i++;
			}
			
			else if (atributo.equalsIgnoreCase("inteligencia"))
				this.inteligencia++;
			
			else if (atributo.equalsIgnoreCase("agilidade"))
				this.agilidade++;
			
			else if (atributo.equalsIgnoreCase("sorte"))
				this.sorte++;
		}
		
	}


}
