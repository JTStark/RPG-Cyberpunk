package implementations.combate;

import implementations.personagens.AbsPersonagem;
import implementations.personagens.herois.*;


import java.util.ArrayList;

public class TESTEDOR {

	public static void main(String[] args) {
		ArrayList<AbsPersonagem> list = new ArrayList<AbsPersonagem> ();
		AbsPersonagem fake = HDurden.getInstancia();
		fake.level = 20;
		list = RetornaArrayInimigos.GetArray();
		for(AbsPersonagem i : list){
			System.out.println("nome "+i.nome);
			System.out.println("STR "+i.forca);
			System.out.println("DA "+i.danoArma);
			System.out.println("Res "+i.resistencia);
			System.out.println("MHP "+i.maxHP);
			System.out.println();
		}
	}
}
