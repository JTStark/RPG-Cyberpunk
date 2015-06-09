package implementations.inventario;

import java.util.ArrayList;

public class Loja implements ILoja  {
	/*Arraylist para armazenar todos os item que estão na loja do momentoda requisicao*/
	private ArrayList<Item> comercio;
	
	/*construtor da classe loja, que somente inicializa o vetor*/
	public Loja() {
		comercio = new ArrayList<Item>();
	}
	
	/*adiciona algum item na loja*/
	public void addItem(Item mercadoria) {
		comercio.add(mercadoria);
	}
	
	/*printa todos os intens da loja para saber o que comprar, imprimindo todos os atributos possíveis*/
	public void printLoja() {
		for (int i = 0; i < comercio.size(); i++) {
			System.out.println("Nome: " + comercio.get(i).getName() + "Tipo: " + comercio.get(i).getType() + "Bonus: " + comercio.get(i).getBonus());
		}
	}
	
	/*procura pela loja o item, e o retona*/
	public Item compraItem(String nomeMercadoria, Inventario mochila) { 
		boolean achou = true;
		
		for (int i = 0; i < comercio.size() && achou; i++) {
			if (comercio.get(i).getName().equalsIgnoreCase(nomeMercadoria)) {
				achou = false;
				mochila.adicionar_item(nomeMercadoria);
				return comercio.get(i);
			}
		}
		
		/*caso não encontre o item, printa que não encontrou retorna null*/
		if (achou == true) {
			System.out.println("Não foi possível encontrar esse item");
		}
		
		return null;
	}
	
	/*vende o item, tirando do inventario*/
	public void vendeItem(String nomeMercadoria, Inventario mochila) {
		if (mochila.verificar_item(nomeMercadoria)) {
			mochila.remover_item(nomeMercadoria);
		}
		else {
			System.out.println("Você não possui esse item");
		}
		
	}

}
