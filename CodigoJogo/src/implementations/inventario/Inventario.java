package implementations.inventario;

import java.util.Enumeration;
import java.util.Vector;


public class Inventario {

	private Vector<String> equipamentos = new Vector<String>(2);
	private Vector<String> mochila = new Vector<String>(20);
	
	public Inventario(){
		/* Construtor que inicializa o vector equipamentos. É feito isso pois vectors por definição 
		 * não são inicializados como null, e é necessários quando equipar um item verificar se a 
		 * posicao do vector é null */
		equipamentos.add("Vazio");
		equipamentos.add("Vazio");
	}
	
	/* Equipar um item consiste em verificar se o item existe no bd, se existe na mochila, qual o
	 * tipo do item e se o equipamento é vazio, logo se for vazio eu equipo-o e removo da mochila, 
	 * se não eu troco-o com o item já equipado */
	public void equipa_item(String nome_item){
		Item item = new Item(nome_item);
		if(item.getName() != null){
			if(mochila.contains(item.getName())){
				if(item.getType().equalsIgnoreCase("Armor")){
					if(equipamentos.get(0).equalsIgnoreCase("Vazio")){
						equipamentos.setElementAt(item.getName(), 0);
						mochila.removeElement(item.getName());

					}else{
						String item_troca = equipamentos.get(0);
						int aux_posicao = mochila.indexOf(item.getName());
						equipamentos.remove(0);
						equipamentos.add(0, item.getName());
						mochila.remove(aux_posicao);
						mochila.add(aux_posicao, item_troca);
					}
					
				}
				if(item.getType().equalsIgnoreCase("Dam")){
					if(equipamentos.get(1).equalsIgnoreCase("Vazio")){
						equipamentos.setElementAt(item.getName(), 1);
						mochila.removeElement(item.getName());
					}else{
						String item_troca = equipamentos.get(1);
						int aux_posicao = mochila.indexOf(item.getName());
						equipamentos.remove(1);
						equipamentos.add(1, item.getName());
						mochila.remove(aux_posicao);
						mochila.add(aux_posicao, item_troca);
					}
				}
				System.out.println("O item " + item.getName() + " foi equipado");
			}else{
				System.out.println("O item " + item.getName() + " não está na mochila");
			}
		}else{
			System.out.println("O item " + nome_item + " não existe");
		}
	}
	/* Adiciona um item na mochila, verificando se o mesmo existe no bd e a capacidade da mochila */
	public void adicionar_item(String nome_item){
		Item item = new Item(nome_item);
		if(item.getName() != null){
			if(mochila.size() >= mochila.capacity()){
				System.out.println("Capacidade limite atingida, remova um item do inventario para poder adicionar outro");
			}
			else{
				mochila.addElement(item.getName());
				System.out.println("O item " + item.getName() + " foi adicionado à mochila");
			}
		}else{
			System.out.println("O item " + nome_item + " não existe");
		}
	}
	/* Remove um item da mochila se o mesmo existir no bd e na mochila */
	public void remover_item(String nome_item){
		Item item = new Item(nome_item);
		if(item.getName() != null){
			if(mochila.contains(item.getName())){
				mochila.removeElement(item.getName());
				System.out.println("O item " + item.getName() + " foi removido com sucesso");
			}else{
				System.out.println("Não foi possível encontrar o item " + item.getName() + " na mochila");
			}
		}else{
			System.out.println("O item " + nome_item + " não existe");
		}
	}
	
	/* Imprime os equipamentos equipados */
	public void getEquipamentos(){
		for (Enumeration<String> e = equipamentos.elements(); e.hasMoreElements();){
			String item_equipado = (String) e.nextElement();
			if(!item_equipado.equalsIgnoreCase("vazio")){
				Item item = new Item(item_equipado);
				System.out.println("Nome: " + item.getName() + 
									" | Tipo: " + item.getType() + 
									" | Bônus:" + item.getBonus());
			}
		}
	}
	/* Imprime os equipamentos na mochila */
	public void getMochila(){
		for (Enumeration<String> e = mochila.elements(); e.hasMoreElements();){
			String item_mochila = (String) e.nextElement();
			Item item = new Item(item_mochila);
			System.out.println("Nome: " + item.getName() + 
								" | Tipo: " + item.getType() + 
								" | Bônus:" + item.getBonus());
		}
	}
}

