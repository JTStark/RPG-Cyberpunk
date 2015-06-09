package implementations.personagens;

import implementations.inventario.Item;

import java.util.Random;

public class VilaoRanged extends AbsPersonagem{
Item item_arma, item_armadura;
	
	public VilaoRanged(String nome_arma, String nome_armadura, int level){
		Random random = new Random(); 
		
		this.item_arma = new Item(nome_arma);
		this.item_armadura = new Item(nome_armadura);
		this.tipo = 3;
		this.vilao = true;
		this.armadura = item_armadura.getBonus();
		this.level = level;
		
		this.forca = 10 + 3 * (this.level / 5);
		this.percepcao = 20 + 3*this.level;
		this.resistencia = 10 + 3 * (this.level/5);
		this.carisma = 0;
		this.inteligencia = 30 + 3 * (this.level / 5);
		this.agilidade = 30 + 3 * (this.level / 3);
		this.sorte = random.nextInt(100) + 1;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.maxHP += this.level * (this.resistencia * (2/3));
		this.hp = this.maxHP;
	}

}
