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


public class TestaSave {

	public static void main(String[] args) throws JAXBException, IOException, ParserConfigurationException, SAXException {
		
		HDurden durden = HDurden.getInstancia();
		HMDR mdr = HMDR.getInstancia();
		HOleg oleg = HOleg.getInstancia();
		HOzob ozob = HOzob.getInstancia();
		HRexus rexus = HRexus.getInstancia();
		HSilvana silvana = HSilvana.getInstancia();
		
		
		// Cria o save e seus valores
		TSave save = new TSave();
		save.setInventario();
		save.setHDurden(durden);
		save.setHMDR(mdr);
		save.setHOleg(oleg);
		save.setHOzob(ozob);
		save.setHRexus(rexus);
		save.setHSilvana(silvana);
		
		// Cria o arquivo XML
		JAXBContext context = JAXBContext.newInstance(TSave.class);
		Marshaller marshal = context.createMarshaller();
		
		marshal.marshal(save, System.out);
		
		FileWriter writer = new FileWriter("save.xml");
		
		marshal.marshal(save, writer);
		
		// L� o arquivo XML ---------------------------------------------------------
		/*
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Pode ser o nome ou o caminho!
		Document doc = builder.parse("save.xml");
	
		NodeList listaDePersonagem = doc.getElementsByTagName("nome");
		Node personagem = listaDePersonagem.item(0);
		
		if (personagem.getNodeType() == Node.ELEMENT_NODE){
			
			Element elementoPersonagem = (Element) personagem;
			String nomePersonagem = elementoPersonagem.getTextContent();
			System.out.println(nomePersonagem);
		}
		*/	
	}

}