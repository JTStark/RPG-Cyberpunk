package implementations.personagens;

import implementations.inventario.Item;
import implementations.personagens.skills.AtaqueBasico;

import java.util.Random;

public class VilaoRanged extends AbsPersonagem{
	Item Arma, Armadura;
	
	public VilaoRanged(int Arma, int Armadura, int level, int nGerador){
		Random random = new Random(); 
		
		this.danoArma = Arma;
		this.tipo = 3;
		this.vilao = true;
		this.armadura = Armadura;
		this.level = level;
		this.nome = ("Ranged"+nGerador);
		this.forca = (int)(10 + 3 * (this.level / 5));
		this.percepcao = (int)(20 + 3 * this.level);
		this.resistencia = (int)(10 + 3 * (this.level/5));
		this.carisma = 0;
		this.inteligencia = (int)(30 + 3 * (this.level / 5));
		this.agilidade = (int)(30 + 3 * (this.level / 3));
		this.sorte = random.nextInt(100) + 1;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.skill0 = new AtaqueBasico();
		
		this.maxHP += this.level * (this.resistencia * (2/3));
		this.hp = this.maxHP;
	}

}
