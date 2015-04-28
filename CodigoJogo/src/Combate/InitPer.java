package Combate;

import Combate.Personagem;

public class InitPer {
	String time;
	Personagem esse;
	int iniciativa;

	public InitPer (String team, Personagem actual, int init){
		this.time = team;
		this.esse = actual;
		this.iniciativa = init;
	}
}
