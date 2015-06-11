package implementations.save;

import implementations.inventario.Inventario;
import implementations.personagens.*;
import implementations.personagens.herois.HDurden;
import implementations.personagens.herois.HMDR;
import implementations.personagens.herois.HOleg;
import implementations.personagens.herois.HOzob;
import implementations.personagens.herois.HRexus;
import implementations.personagens.herois.HSilvana;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Save")
public class TSave {

	private  Inventario inventario;
	private  HDurden HDurden;
	private  HMDR HMDR;
	private  HOleg HOleg;
	private  HOzob HOzob;
	private  HRexus HRexus;
	private  HSilvana HSilvana;
	
	@XmlElement(name = "heroi")
	public  AbsPersonagem getHDurden() {
		return HDurden;
	}

	public  void setHDurden(HDurden hDurden) {
		HDurden = hDurden;
	}

	@XmlElement(name = "heroi")
	public  AbsPersonagem getHMDR() {
		return HMDR;
	}

	public  void setHMDR(HMDR hMDR) {
		HMDR = hMDR;
	}

	@XmlElement(name = "heroi")
	public  AbsPersonagem getHOleg() {
		return HOleg;
	}

	public  void setHOleg(HOleg hOleg) {
		HOleg = hOleg;
	}

	@XmlElement(name = "heroi")
	public  AbsPersonagem getHOzob() {
		return HOzob;
	}

	public  void setHOzob(HOzob hOzob) {
		HOzob = hOzob;
	}

	@XmlElement(name = "heroi")
	public  AbsPersonagem getHRexus() {
		return HRexus;
	}

	
	public  void setHRexus(HRexus hRexus) {
		HRexus = hRexus;
	}

	@XmlElement(name = "heroi")
	public  AbsPersonagem getHSilvana() {
		return HSilvana;
	}

	public  void setHSilvana(HSilvana hSilvana) {
		HSilvana = hSilvana;
	}
	
	@XmlElement(name = "inventario")
	public  Inventario getInventario(){
		return inventario;
	}
	
	public  void setInventario(){
		inventario = Inventario.getInstancia();
	}
}