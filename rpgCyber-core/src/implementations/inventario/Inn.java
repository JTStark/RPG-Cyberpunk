package implementations.inventario;

import implementations.personagens.AbsPersonagem;

import java.util.ArrayList;

public class Inn {

	public void enterInn (ArrayList <AbsPersonagem> personagens){
		
		for (int i = 0; i < personagens.size(); i++){
			
			personagens.get(i).hp = personagens.get(i).maxHP;
		}
	}
}
