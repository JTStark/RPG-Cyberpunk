package implementations.inventario;

import java.util.ArrayList;
import java.util.Vector;

/* Implementa a interface*/
public class Inventario implements InterfaceInventario{
	
	/* Atributos
	 * 			instancia é uma instancia nula da classe inventario
	 * 			mochila é um vector para armazenar itens
	 */
	
	public static Inventario instancia = new Inventario();
	private Vector<String> mochila = new Vector<String>(40);
	
	/* Construtor */
	private Inventario(){
	}
	
	/* Metodo que pega a instancia da classe e retorna-a; se for nula cria uma nao nula */
	public static Inventario getInstancia(){
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
	/* Verifica se o item contém na mochila */
	public boolean verificar_item (String nome_item){
		Item item = new Item(nome_item);
		if(mochila.contains(item.getName()))
			return true;
		else
			return false;
	}
	/* Retorna um vector com todos os equipamentos na mochila */
	public ArrayList<String> getMochila(){
		ArrayList<String> itens = new ArrayList<String>();
		for (int i = 0; i < mochila.size(); i++){
				String item_mochila = mochila.elementAt(i);	
				Item item = new Item(item_mochila);
				itens.add(item.getName());
		}
		return itens;
	}
	/* Retorna uma Array com os itens desejados de determinado intervalo de posicoes */
	public ArrayList<Item> getMochila(int tamanho_inicial, int tamanho_final){
		ArrayList<Item> itens = new ArrayList<Item>();
		for (int i = tamanho_inicial; i <= tamanho_final; i++){
			if(mochila.size() > i){
				String item_mochila = mochila.elementAt(i);	
				Item item = new Item(item_mochila);
				itens.add(item);
			}
		}
		return itens;
	}
	/* Setter para o save */
	public void setMochila(ArrayList<String> bag){
		for (int i = 0; i < bag.size(); i++){
			String item_mochila = bag.get(i);	
			Item item = new Item(item_mochila);
			this.mochila.add(item.getName());
		}
	}
}
