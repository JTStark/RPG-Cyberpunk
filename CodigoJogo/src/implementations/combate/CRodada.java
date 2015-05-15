package implementations.combate;

import java.util.ArrayList;
import implementations.personagens.AbsPersonagem;
import java.util.Scanner;
import java.util.Collections;

public class CRodada {

	public static void Jogada (ArrayList <AbsPersonagem> Herois, ArrayList <AbsPersonagem> Viloes) {
		int contP;
		boolean flag;
		String chc;
		Scanner scanner = new Scanner(System.in);
		
		
		
		for (contP = 0; contP < Herois.size(); contP++) {

			System.out.println(Herois.get(contP).nome + " " + Herois.get(contP).iniciativa);
			flag = true;			
			while (flag) {
				System.out.println("CHOOSE YOUR ACTION:");
				System.out.println("Reposition");
				System.out.println("Attack");
				System.out.println("use Item");
				System.out.println("do Nothing");
				System.out.println("Flee");
				
				chc = scanner.nextLine();
				
				if ((chc.equalsIgnoreCase("reposition")) || (chc.equalsIgnoreCase("r"))) {
					
					Reposition(Herois, contP);
					flag = false;
				}
				
				else if ((chc.equalsIgnoreCase("attack")) || (chc.equalsIgnoreCase("a"))) {

					flag = false;
				}
	
				else if ((chc.equalsIgnoreCase("use item")) || (chc.equalsIgnoreCase("i")) || (chc.equalsIgnoreCase("item"))) {

					flag = false;
				}
				
				else if ((chc.equalsIgnoreCase("do nothing")) || (chc.equalsIgnoreCase("n")) || chc.equalsIgnoreCase("nothing")) {
					flag = false; // soh sai
				}
	
				else if ((chc.equalsIgnoreCase("flee")) || (chc.equalsIgnoreCase("f"))) {

					flag = false;
				}
			
				else System.out.println("Wrong Text: try again");
			}
		}
		
		scanner.close();
	}
	
	public static void Reposition (ArrayList <AbsPersonagem> Jogadores, int contP) {
		String choice;
		int mov;
		Scanner scanner = new Scanner(System.in);
		int dist;
		
		if (contP < Jogadores.size())
			System.out.print("Esquerda");
		if ((Jogadores.size() > contP) && (contP > 0))
			System.out.print(" ou ");
		if (contP > 0)
			System.out.print("Direita");
		System.out.println("?");
		
		choice = scanner.nextLine();
		
		if (((choice.equalsIgnoreCase("esquerda")) || (choice.equalsIgnoreCase("e"))) && contP < Jogadores.size()) {
			dist = (Jogadores.get(contP).agilidade / 25) + 1;
			if (dist >= Jogadores.size() - 1 - contP)
				dist = Jogadores.size() - 1 - contP;
				
			System.out.println("Voce pode se mover " + dist + " para a esquerda");
			System.out.println("Quanto quer se mover?");
			
			mov = scanner.nextInt();
			
			while (mov > dist)
				System.out.println("Voce escolheu uma distancia invalida");
			
			Collections.swap(Jogadores, contP, contP+dist);
		}
		
		if (((choice.equalsIgnoreCase("direita")) || (choice.equalsIgnoreCase("d"))) && contP > 0) {
			dist = (Jogadores.get(contP).agilidade / 25) + 1;
			if (contP - dist < 0)
				dist = dist + (contP - dist);
				
			System.out.println("Voce pode se mover " + dist + " para a esquerda");
			System.out.println("Quanto quer se mover?");
			
			mov = scanner.nextInt();
			
			while (mov > dist)
				System.out.println("Voce escolheu uma distancia invalida");
			
			Collections.swap(Jogadores, contP, contP-dist);
		}
			
		scanner.close();
	}
}
