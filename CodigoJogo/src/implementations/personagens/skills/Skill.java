package implementations.personagens.skills;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public interface Skill {
	
	public boolean execute(ArrayList <AbsPersonagem> Viloes, double dam, int trgt);
	
}
