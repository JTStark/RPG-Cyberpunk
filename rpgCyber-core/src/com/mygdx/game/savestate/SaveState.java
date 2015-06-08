package com.mygdx.game.savestate;

import java.io.FileWriter;
import java.io.IOException;

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

import com.mygdx.game.levels.MyLevel;

import snake.visuals.enhanced.VisualGameWorld;

public class SaveState {
	// Cria o arquivo XML

	private  JAXBContext context;
	private  Marshaller marshal;

		public SaveState(Object lolo) throws JAXBException, IOException{
			context = JAXBContext.newInstance(MyLevel.class);
			marshal = context.createMarshaller();
			
			//marshal.marshal(save, System.out);
			
			FileWriter writer = new FileWriter("save.xml");
			
			marshal.marshal(lolo, writer);
		}	
			// L� o arquivo XML ---------------------------------------------------------
		public  void ler() throws ParserConfigurationException, SAXException, IOException{	
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
		}
}
