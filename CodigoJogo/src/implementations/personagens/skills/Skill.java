package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;
import java.util.ArrayList;

public interface Skill {

	public static int tipoAlvo = 1;	
	
	public String execute(ArrayList <AbsPersonagem> Viloes, ArrayList <AbsPersonagem> Herois, double dam, int trgt, AbsPersonagem heroiAtacante);
	
}
