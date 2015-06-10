package implementations.save; 
import implementations.personagens.AbsPersonagem; 
import implementations.personagens.herois.HDurden; 
import implementations.personagens.herois.HMDR; 
import implementations.personagens.herois.HOleg; 
import implementations.personagens.herois.HOzob; 
import implementations.personagens.herois.HRexus; 
import implementations.personagens.herois.HSilvana; 
 
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
 
 
public class Save { 
         
    public static void saveGame (ArrayList<AbsPersonagem> herois) throws JAXBException, IOException{ 
         
        TSave save = new TSave(); 
        save.setInventario(); 
        save.setHMDR((HMDR)herois.get(0)); 
        save.setHDurden((HDurden)herois.get(1)); 
        save.setHOleg((HOleg)herois.get(2)); 
        save.setHOzob((HOzob)herois.get(3)); 
        save.setHRexus((HRexus)herois.get(4)); 
        save.setHSilvana((HSilvana)herois.get(5)); 
         
        // Cria o arquivo XML 
        JAXBContext context = JAXBContext.newInstance(TSave.class); 
        Marshaller marshal = context.createMarshaller(); 
         
        //marshal.marshal(save, System.out); 
         
        FileWriter writer = new FileWriter("save.xml"); 
         
        marshal.marshal(save, writer); 
    } 
     
    public static ArrayList<AbsPersonagem> loadGame () throws SAXException, IOException, ParserConfigurationException{ 
        // Le o arquivo XML --------------------------------------------------------- 
         
        ArrayList<AbsPersonagem> herois = new ArrayList<AbsPersonagem>(); 
         
        herois.add(HMDR.getInstancia()); 
        herois.add(HDurden.getInstancia()); 
        herois.add(HOleg.getInstancia()); 
        herois.add(HOzob.getInstancia()); 
        herois.add(HRexus.getInstancia()); 
        herois.add(HSilvana.getInstancia()); 
         
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder builder = factory.newDocumentBuilder(); 
         
        // Pode ser o nome ou o caminho! 
        Document doc = builder.parse("save.xml"); 
     
        NodeList listaDePersonagem = doc.getElementsByTagName("heroi"); 
         
        int totalPersonagens = listaDePersonagem.getLength(); 
         
        for (int i = 0; i < totalPersonagens; i ++){ 
             
            Node noHeroi = listaDePersonagem.item(i); 
            Element elementoHeroi = (Element) noHeroi; 
             
            NodeList atributosHeroi = elementoHeroi.getChildNodes(); 
             
            int tamanhoAtributos = atributosHeroi.getLength(); 
             
            for (int j = 0; j < tamanhoAtributos; j++){ 
                 
                Node noAtributo = atributosHeroi.item(j); 
                Element elementoAtributo = (Element) noAtributo; 
                 
                switch(elementoAtributo.getTagName()){ 
                 
                case "forca": herois.get(i).setForca(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "percepcao": herois.get(i).setPercepcao(Integer.parseInt(elementoAtributo.getTextContent()));; 
                case "resistencia": herois.get(i).setResistencia(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "carisma": herois.get(i).setCarisma(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "inteligencia": herois.get(i).setInteligencia(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "agilidade": herois.get(i).setAgilidade(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "sorte": herois.get(i).setSorte(Integer.parseInt(elementoAtributo.getTextContent())); 
                case "esquiva": herois.get(i).setEsquiva(Double.parseDouble((elementoAtributo.getTextContent()))); 
                case "critico": herois.get(i).setCritico(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "hp": herois.get(i).setHp(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "maxHP": herois.get(i).setMaxHP(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "xp": herois.get(i).setXp(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "level": herois.get(i).setLevel(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "danoArma": herois.get(i).setDanoArma(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "armadura": herois.get(i).setArmadura(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "iniciativa": herois.get(i).setIniciativa(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "pos": herois.get(i).setPos(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "tipo": herois.get(i).setTipo(Double.parseDouble(elementoAtributo.getTextContent())); 
                case "vilao": herois.get(i).setVilao(Boolean.parseBoolean(elementoAtributo.getTextContent())); 
                case "nome": herois.get(i).setNome(elementoAtributo.getTextContent()); 
                 
                } 
            } 
             
        } 
        return herois; 
    } 
}