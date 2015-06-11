package implementations.inventario;

import java.util.ArrayList;

public interface InterfaceInventario {
	public void adicionar_item(String nome_item);
	public void remover_item(String nome_item);
	public boolean verificar_item (String nome_item);
	public static ArrayList<String> getMochila() {
		return null;
	}
	public static ArrayList<Item> getMochila(int tamanho_inicial, int tamanho_final) {
		return null;
	}
	public void setMochila(ArrayList<String> bag);
}