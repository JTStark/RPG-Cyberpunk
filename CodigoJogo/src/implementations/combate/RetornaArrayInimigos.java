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
		int nMelee = 1, nRanged = 1, geradoRandom;
		
		int i, level = (int)HDurden.getInstancia().level; // level do durden
		for(i=0; i<6 ; i++){
			geradoRandom = 1 + random.nextInt(2);
			if(geradoRandom == 1){
				listaVil.add(fabrica.getVillain(geradoRandom, level*2, level, level, nMelee));
				nMelee++;
			}
			else{
				listaVil.add(fabrica.getVillain(geradoRandom, level*2, level, level, nRanged));
				nRanged++;
			}
		}
		return listaVil;
	}
}


/*Quando Entrar em contato com o Inimigo, voce deve usar

CEngine.CombatEngine(vetor de herois, vetor de viloes);

*/