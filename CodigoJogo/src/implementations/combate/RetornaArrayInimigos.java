package implementations.combate;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.herois.HDurden;
import implementations.personagens.EnemyFactory;

import java.util.ArrayList;
import java.util.Random;

public class RetornaArrayInimigos {

	public ArrayList<AbsPersonagem> GetArray(){
		ArrayList<AbsPersonagem> vetorVil = new ArrayList<AbsPersonagem> ();
		EnemyFactory fabrica = new EnemyFactory();
		Random random = new Random();
		
		int i, level = HDurden.getInstancia().level; // level do durden
		for(i=0; i<6 ; i++){
			vetorVil.add(fabrica.getVillain(random.nextInt(2), level*2, level, level));
		}
	}
}
