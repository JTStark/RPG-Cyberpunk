package implementations.inventario;


public interface InterfaceInventario {
	public boolean adicionar_item(String nome_item);
	public void remover_item(String nome_item);
	public boolean verificar_item (String nome_item);
}