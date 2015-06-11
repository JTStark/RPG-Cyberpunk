package implementations.save;

import java.util.ArrayList;

import implementations.inventario.Inventario;
import implementations.personagens.*;
import implementations.personagens.herois.HDurden;
import implementations.personagens.herois.HMDR;
import implementations.personagens.herois.HOleg;
import implementations.personagens.herois.HOzob;
import implementations.personagens.herois.HRexus;
import implementations.personagens.herois.HSilvana;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Classe de elementos XML para a serializacao
@XmlRootElement(name = "Save")
public class TSave {

	// Elementos a serem serializados: Inventario e os Herois
	@XmlElement(name = "inventario")
	private static ArrayList<String> mochila = Inventario.getMochila();
	@XmlElement(name = "heroi")
	private static HDurden hDurden = HDurden.getInstancia();
	@XmlElement(name = "heroi")
	private static HMDR hMDR = HMDR.getInstancia();
	@XmlElement(name = "heroi")
	private static HOleg hOleg = HOleg.getInstancia();
	@XmlElement(name = "heroi")
	private static HOzob hOzob = HOzob.getInstancia();
	@XmlElement(name = "heroi")
	private static HRexus hRexus = HRexus.getInstancia();
	@XmlElement(name = "heroi")
	private static HSilvana hSilvana = HSilvana.getInstancia();
	
	// Metodos getters
	public static AbsPersonagem getHDurden() {
		return hDurden;
	}

	public static AbsPersonagem getHMDR() {
		return hMDR;
	}

	public static AbsPersonagem getHOleg() {
		return hOleg;
	}

	public static AbsPersonagem getHOzob() {
		return hOzob;
	}

	public static AbsPersonagem getHRexus() {
		return hRexus;
	}

	public static AbsPersonagem getHSilvana() {
		return hSilvana;
	}
	
	public static ArrayList<String> getInventario(){
		return mochila;
	}
}