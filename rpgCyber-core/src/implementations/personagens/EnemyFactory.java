package implementations.personagens;

public class EnemyFactory {
	
	public AbsPersonagem getVillain(int type, String nome_arma, String nome_armadura, int level){
		
		if(type == 1)
			return new VilaoMelee(nome_arma, nome_armadura, level);
		
		else if(type == 2)
			return new VilaoRanged(nome_arma, nome_armadura, level);
		
		System.out.println("Tipo de vilao invalido");
		return null;
	}
}
