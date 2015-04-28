package Combate;

import Combate.CEngine;
import Combate.Personagem;

public class AuxTemp {
	
	public static void main(String[] args){
		Personagem[] vetorHer = new Personagem[2];
		vetorHer[0].AGI = 99;
		vetorHer[0].LCK = 99;
		vetorHer[1].AGI = 1;
		vetorHer[1].LCK = 1;
		
		Personagem[] vetorVil = new Personagem[2];
		vetorVil[0].AGI = 50;
		vetorVil[0].LCK = 50;
		vetorVil[1].AGI = 1;
		vetorVil[1].LCK = 1;
		
		CEngine arrayOrdenado = new CEngine(vetorHer, vetorVil);
	}
	
}
