package implementations.personagens;

import java.util.ArrayList;

public class EnemyFactory { 
	public static ArrayList<AbsPersonagem> lista = new ArrayList<AbsPersonagem>();
	public static AbsPersonagem getVillain(int type, int Arma, int Armadura, int level){
		
		if(type == 1)
			return new VilaoMelee(Arma, Armadura, level);
		
		else if(type == 2)
			return new VilaoRanged(Arma, Armadura, level);
		
		System.out.println("Tipo de vilao invalido");
		return null;
	}
	public static ArrayList<AbsPersonagem> getV(int Arma, int Armadura, int level){
		for(int i = 0; i<2;i++){
			lista.add(getVillain(1,Arma,Armadura,level));
		}
		for(int i = 0; i<4;i++){
			lista.add(getVillain(2,Arma,Armadura,level));
		}
		return lista;
	}
}
