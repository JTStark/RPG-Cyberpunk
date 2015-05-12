package implementations.combate;

import java.util.ArrayList;
import java.util.Scanner;

public class CRodada {

	public static void Jogada (ArrayList <InitPer> Herois, ArrayList <InitPer> Viloes) {
		int contP;
		String chc;
		Scanner scanner = new Scanner(System.in);
		
		
		
		for (contP = 0; contP < Herois.size(); contP++) {
			System.out.println(Herois.get(contP).esse.nome + " " + Herois.get(contP).iniciativa);
			System.out.println("CHOOSE YOUR ACTION:");
			System.out.println("Reposition");
			System.out.println("Attack");
			System.out.println("use Item");
			System.out.println("Flee");
			
			chc = scanner.nextLine();
			
			if ((chc.equalsIgnoreCase("reposition")) || (chc.equalsIgnoreCase("r"))) {
				if (contP != Herois.size())
					System.out.print("Esquerda");
				if ((Herois.size() > contP) && (contP > 0))
					System.out.println(" ou ");
				if (contP != 0)
					System.out.println("Direita");
				System.out.println("?");
			}
			
			if ((chc.equalsIgnoreCase("attack")) || (chc.equalsIgnoreCase("a"))) {
				
			}

			if ((chc.equalsIgnoreCase("use item")) || (chc.equalsIgnoreCase("i"))) {
				
			}

			if ((chc.equalsIgnoreCase("flee")) || (chc.equalsIgnoreCase("f"))) {
				
			}
		}
		
		scanner.close();
	}
}
