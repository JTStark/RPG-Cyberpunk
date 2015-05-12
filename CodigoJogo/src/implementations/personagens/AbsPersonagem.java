package implementations.personagens;

import java.util.Scanner;

/**
 * Classe abstrata para os personagens
 * 
 * @author Johnny Stark
 *
 */

public abstract class AbsPersonagem {
	public int forca, percepcao, resistencia, carisma, inteligencia, agilidade, sorte;
	public int hp, maxHP, xp, level, armadura, tipo /*1 = melee, 2 = ranged, 3 = support*/;
	public String nome;
	/*Inventario inventario;*/
	
	/*m�todo que define os valores iniciais dos atributos do personagem*/
	public void SetAtributos (){
		
	}
	
	/*m�todo que renderiza o personagem*/
	public void Render (){
		
	}
	
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
		
		/*daqui pra baixo tamb�m � provis�rio*/
		if (this.xp >= 1000){
			this.xp = this.xp % 1000;
			
			this.LevelUp();
		}
	}
	
	/*m�todo que upa o personagem*/
	public void LevelUp (){
		this.level++;
		String atributo;
		
		/*De novo, provis�rio*/
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
