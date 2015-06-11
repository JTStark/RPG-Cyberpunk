package implementations.save; 
import implementations.inventario.Inventario;
import implementations.personagens.AbsPersonagem; 
import implementations.save.TSave;

import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; 
 

import javax.xml.bind.JAXBContext; 
import javax.xml.bind.JAXBException; 
import javax.xml.bind.Marshaller; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
 

import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException; 
 
// Classe que serializa os personagens e o inventario 
public class SerializeXML { 
    
	// Metodo de salvar o jogo
    public static void saveGame () throws JAXBException, IOException{ 
        
    	// Cria nova classe TSave
        TSave save = new TSave();
        
        // Cria o arquivo XML a partir de um Marshaller usando a classe JAXBContext
        JAXBContext context = JAXBContext.newInstance(TSave.class); 
        Marshaller marshal = context.createMarshaller();  
        FileWriter writer = new FileWriter("save.xml"); 
        
        marshal.marshal(save, writer); 
    } 
    
    // Metodo de carregar o jogo
    public static ArrayList<AbsPersonagem> loadGame () throws SAXException, IOException, ParserConfigurationException{ 

    	// Le o arquivo XML---------------------------------------------------------------- 

    	
        // Cria a factory que vai ler o documento XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder builder = factory.newDocumentBuilder(); 
         
        // Le o documento de acordo com seu nome 
        Document doc = builder.parse("save.xml"); 
        
        // Pega o nome de todos os herois com tag de elemento XML heroi
        NodeList listaDeItems = doc.getElementsByTagName("inventario"); 
       
        // Conta a quantidade de items salvos
        int totalItems = listaDeItems.getLength(); 
        
        // Loop para a quantidade de items
        for (int i = 0; i < totalItems; i ++){ 
            
        	// Pega o noh de cada item e o transforma em um elemento
            Node noItem = listaDeItems.item(i); 
            Element elementoItem = (Element) noItem; 
            
            // Adiciona no inventario todos os items que estavam salvos
        	Inventario inventario = Inventario.getInstancia();
    		inventario.adicionar_item(elementoItem.getTextContent());
        }
 
        // Recupera ArrayList de herois
        ArrayList<AbsPersonagem> herois = new ArrayList<AbsPersonagem>(); 
        
        // Pega instancias de cada heroi
        herois.add(TSave.getHMDR());
        herois.add(TSave.getHDurden());  
        herois.add(TSave.getHOleg()); 
        herois.add(TSave.getHOzob()); 
        herois.add(TSave.getHRexus()); 
        herois.add(TSave.getHSilvana()); 
     
        // Pega o nome de todos os herois com tag de elemento XML heroi
        NodeList listaDePersonagem = doc.getElementsByTagName("heroi"); 
        
        // Conta a quantidade de herois salvos
        int totalPersonagens = listaDePersonagem.getLength(); 
         
        // Loop para a quantidade de herois
        for (int i = 0; i < totalPersonagens; i ++){ 
            
        	// Pega o noh de cada heroi e o transforma em um elemento
            Node noHeroi = listaDePersonagem.item(i); 
            Element elementoHeroi = (Element) noHeroi; 
            
            // Pega os filhos do elemento heroi, que sao seus atributos
            NodeList atributosHeroi = elementoHeroi.getChildNodes(); 
            
            // Conta a quantidade de atributos salvos
            int tamanhoAtributos = atributosHeroi.getLength(); 
            
            // Loop para a quantidade de atributos
            for (int j = 0; j < tamanhoAtributos; j++){ 
                
            	// Pega o noh de cada atributo e o transforma em um elemento
                Node noAtributo = atributosHeroi.item(j); 
                Element elementoAtributo = (Element) noAtributo; 
                
                // Switch para cada elemento
                switch(elementoAtributo.getTagName()){ 
                
                // Adiciona no personagem cada atributo de acordo com qual eh lido 
                case "forca": herois.get(i).forca = Integer.parseInt(elementoAtributo.getTextContent()); 
                case "percepcao": herois.get(i).percepcao = (Integer.parseInt(elementoAtributo.getTextContent()));; 
                case "resistencia": herois.get(i).resistencia = (Integer.parseInt(elementoAtributo.getTextContent())); 
                case "carisma": herois.get(i).carisma = (Integer.parseInt(elementoAtributo.getTextContent())); 
                case "inteligencia": herois.get(i).inteligencia = (Integer.parseInt(elementoAtributo.getTextContent())); 
                case "agilidade": herois.get(i).agilidade = (Integer.parseInt(elementoAtributo.getTextContent())); 
                case "sorte": herois.get(i).sorte = (Integer.parseInt(elementoAtributo.getTextContent())); 
                case "esquiva": herois.get(i).esquiva = (Double.parseDouble((elementoAtributo.getTextContent()))); 
                case "critico": herois.get(i).critico = (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "hp": herois.get(i).hp = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "maxHP": herois.get(i).maxHP = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "xp": herois.get(i).xp = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "level": herois.get(i).level = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "danoArma": herois.get(i).danoArma = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "armadura": herois.get(i).armadura = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "iniciativa": herois.get(i).iniciativa = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
               // case "pos": herois.get(i).pos = (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "tipo": herois.get(i).tipo = (int) (Double.parseDouble(elementoAtributo.getTextContent())); 
                case "vilao": herois.get(i).vilao = (Boolean.parseBoolean(elementoAtributo.getTextContent())); 
                case "nome": herois.get(i).nome = (elementoAtributo.getTextContent()); 
                
                } 
            } 
        }
        
        // Arruma ordem para outros modulos
        AbsPersonagem aux = herois.get(1);
        herois.set(1, herois.get(0));
        herois.set(0, aux);
        
        // Retorna string de herois
        return herois; 
    } 
}