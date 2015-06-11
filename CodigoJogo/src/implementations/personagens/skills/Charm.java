package implementations.personagens.skills;

import implementations.combate.PersonGenerico;
import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Charm implements Skill {

	public static int tipoAlvo = 1;	
	public static int tipoSkill = 5;
	
	@Override
	public String execute(ArrayList<AbsPersonagem> Viloes, ArrayList<AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante) {
		AbsPersonagem temp = new PersonGenerico();
		
		temp = Viloes.get(trgt-1);
		Viloes.remove(trgt-1);
		Viloes.add(0, temp);
		
		
		return (Viloes.get(trgt-1).nome + "foi Seduzido! s2");
	}

}
