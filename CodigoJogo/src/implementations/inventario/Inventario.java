package implementations.inventario;

import java.util.Enumeration;
import java.util.Vector;


public class Inventario implements InterfaceInventario{
	
	public static Inventario instancia = null;
	private Vector<String> mochila = new Vector<String>(40);
	
	protected Inventario(){
	}
	
	public static Inventario getIntancia(){
		if(instancia == null)
			instancia = new Inventario();
		return instancia;
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
	public boolean verificar_item (String nome_item){
		Item item = new Item(nome_item);
		if(mochila.contains(item.getName()))
			return true;
		else
			return false;
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

