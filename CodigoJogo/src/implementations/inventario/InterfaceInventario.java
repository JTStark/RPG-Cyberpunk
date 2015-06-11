package implementations.inventario;

import java.util.ArrayList;

public interface InterfaceInventario {
	public void adicionar_item(String nome_item);
	public void remover_item(String nome_item);
	public boolean verificar_item (String nome_item);
	public ArrayList<String> getMochila();
	public ArrayList<Item> getMochila(int tamanho_inicial, int tamanho_final);
	public void setMochila(ArrayList<String> bag);
}