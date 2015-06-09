package implementations.inventario;

public interface ILoja {
	public void addItem(Item mercadoria);
	public void printLoja();
	public Item compraItem(String mercadoria, Inventario mochila);
	public void vendeItem(String nomeMercadoria, Inventario mochila);
}
