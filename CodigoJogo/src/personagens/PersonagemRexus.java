package personagens;
/**
 * Classe do James Rexus
 * 
 * @author Johnny Stark
 *
 */
import java.util.Scanner;

public class PersonagemRexus implements IPersonagens{
	int forca, percepcao, resistencia, carisma, inteligencia, agilidade, sorte;
	int hp, maxHP, xp, level, armadura;
	/*Inventario inventario;*/
	
	/*método que define os valores iniciais dos atributos do personagem*/
	public void SetAtributos (){
		
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
		if (this.xp >= 1000){
			this.xp = this.xp % 1000;
			
			this.LevelUp();
		}
	}
	
	/*método que upa o personagem*/
	public void LevelUp (){
		this.level++;
		String atributo;
		
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