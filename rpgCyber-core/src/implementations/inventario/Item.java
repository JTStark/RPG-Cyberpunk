package implementations.inventario;

/*pacotes para trabalhar com o BD, que está armazenado em um arquivo texto*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Item implements InterfaceItem {
	private String name;
	private String type;
	public boolean nomeEncontrado; //tive que adicionar esse bool para verificar quando um item foi encontrado
	private int bonus;
	public String diretorio = "BD.txt";
	
	public Item(String identificador) {
		
		/*metodo construtor para procurar no BD a partir do nome dado pelo usuario*/
		FileReader arquivo;
		BufferedReader tratado = null;
		this.nomeEncontrado = false;
		
		/*esses try catch ficam feios, mas as coisas funcionam*/
		try {
			arquivo = new FileReader(diretorio);
			tratado = new BufferedReader(arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			String linha = tratado.readLine();
			while (linha != null) {
				/*usa método de 'fatiamento para usar as informacoes do txt*/
				/*não é o jeito mais bonito a ser feito, mas funciona bem*/
				String nome = linha.substring(0,linha.indexOf(','));
				String tipo = linha.substring(linha.indexOf(',') + 1, linha.lastIndexOf(','));
				String numero = linha.substring(linha.lastIndexOf(',') + 1, linha.length());
			
				/*caso encontre o item que está procurando*/
				if (nome.equalsIgnoreCase(identificador)) {
					this.nomeEncontrado = true;
					this.name = nome;
					this.type = tipo;
					/*como a quantidade de bonus é obtida como texto, é
					 * preciso converter para inteiro*/
					this.bonus = Integer.parseInt(numero);
				}
				linha = tratado.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*metodo que retorna o nome*/
	public String getName() {
		return this.name;
	}
	
	/*metodo para retornar o tipo do item*/
	public String getType() {
		return this.type;
	}
	
	/*metodo para retornar o quanto o item aumentará*/
	public int getBonus() {
		return this.bonus;
	}
	
	/*metodo para gerar um item aleatorio, para ser colocado nos baus encontrados no meio do jogo*/
	@SuppressWarnings("resource")
	public static Item geraAleatorio() { 
		int procurado = 2 + (int)(Math.random() * 80);
		String diretorio = "BD.txt";
		FileReader arquivo;
		BufferedReader tratado = null;
		String nome = null;
		
		/*tenta abrir o arquivo, e caso não consiga entra na exception*/
		try {
			arquivo = new FileReader(diretorio);
			tratado = new BufferedReader(arquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/*roda o loop até encontrar o aleatorio*/
		for (int i = 1; i < procurado; i++) {
			try {
				String linha = tratado.readLine();
				/*não é o jeito mais bonito a ser feito, mas funciona bem*/
				if (linha != null)
					nome = linha.substring(0,linha.indexOf(','));
				linha = tratado.readLine();
					
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return new Item(nome);
	}
		
}
