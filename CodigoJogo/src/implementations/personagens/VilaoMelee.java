package implementations.personagens;

import java.util.Random;

import implementations.inventario.Item;

public class VilaoMelee extends AbsPersonagem{
	Item item_arma, item_armadura;
	
	public VilaoMelee(String nome_arma, String nome_armadura, int level){
		Random random = new Random(); 
		
		this.item_arma = new Item(nome_arma);
		this.item_armadura = new Item(nome_armadura);
		this.tipo = 1;
		this.vilao = true;
		this.armadura = item_armadura.getBonus();
		this.level = level;
		
		this.forca = 25 + 3 * (this.level / 2);
		this.percepcao = 15 + 3 * (this.level / 5);
		this.resistencia = 40 + 3 * (this.level/2);
		this.carisma = 0;
		this.inteligencia = 25 + 3 * (this.level / 5);
		this.agilidade = 10 + 3 * (this.level / 5);
		this.sorte = random.nextInt(100) + 1;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.maxHP += this.level * (this.resistencia * (2/3));
		this.hp = this.maxHP;
	}

}
