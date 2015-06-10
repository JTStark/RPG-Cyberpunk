package implementations.personagens;


import java.util.Random;

import implementations.personagens.skills.AtaqueBasico;

public class VilaoBoss extends AbsPersonagem{
	int Arma, Armadura;
	
	public VilaoBoss(int Arma, int Armadura, int level, int indice){
		Random random = new Random(); 
		
		this.danoArma = Arma;
		this.tipo = 1;
		this.vilao = true;
		this.boss = true;
		this.armadura = 10;
		this.level = level;
		this.nome = ("Boss"+indice);
		this.forca = (int)(25 + 3 * (this.level / 2));
		this.percepcao = (int)(15 + 3 * (this.level / 5));
		this.resistencia = (int)(40 + 3 * (this.level/2));
		this.carisma = 0;
		this.inteligencia = (int)(25 + 3 * (this.level / 5));
		this.agilidade = (int)(10 + 3 * (this.level / 5));
		this.sorte = random.nextInt(100) + 1;
		
		this.esquiva = (this.agilidade)/2.5 + (this.sorte)/5;
		this.critico = (this.agilidade)/5 + (this.sorte)/2.5;
		
		this.skill0 = new AtaqueBasico();
		
		this.maxHP += (this.level * (this.resistencia * (2/3))+100)*5;
		this.hp = this.maxHP;
	}
}
