package implementations.combate;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.herois.HDurden;
import implementations.personagens.EnemyFactory;

import java.util.ArrayList;
import java.util.Random;

public class RetornaArrayInimigos {

	public static ArrayList<AbsPersonagem> GetArray(){
		ArrayList<AbsPersonagem> listaVil = new ArrayList<AbsPersonagem> ();
		EnemyFactory fabrica = new EnemyFactory();
		Random random = new Random();
		
		int i, level = (int)HDurden.getInstancia().level; // level do durden
		for(i=0; i<6 ; i++){
			listaVil.add(fabrica.getVillain(random.nextInt(2), level*2, level, level));
		}
		return listaVil;
	}
}


/*Quando Entrar em contato com o Inimigo, voce deve usar

CEngine.CombatEngine(vetor de herois, vetor de viloes);

*/