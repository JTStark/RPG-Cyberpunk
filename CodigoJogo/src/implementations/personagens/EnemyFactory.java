package implementations.personagens;

public class EnemyFactory {
	
	public AbsPersonagem getVillain(int type, int Arma, int Armadura, int level, int nGerador){
		
		if(type == 1)
			return new VilaoMelee(Arma, Armadura, level, nGerador);
		
		else if(type == 2)
			return new VilaoRanged(Arma, Armadura, level, nGerador);
		
		System.out.println("Tipo de vilao invalido");
		return null;
	}
}
