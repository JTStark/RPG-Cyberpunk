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

	
	private Inventario inventario;
	private AbsPersonagem HDurden, HMDR, HOleg, HOzob, HRexus, HSilvana;
	
	@XmlElement(name = "HDurben")
	public AbsPersonagem getHDurden() {
		return HDurden;
	}

	public void setHDurden(AbsPersonagem hDurden) {
		HDurden = hDurden;
	}

	@XmlElement(name = "HMDR")
	public AbsPersonagem getHMDR() {
		return HMDR;
	}

	public void setHMDR(AbsPersonagem hMDR) {
		HMDR = hMDR;
	}

	@XmlElement(name = "HOleg")
	public AbsPersonagem getHOleg() {
		return HOleg;
	}

	public void setHOleg(AbsPersonagem hOleg) {
		HOleg = hOleg;
	}

	@XmlElement(name = "HOzob")
	public AbsPersonagem getHOzob() {
		return HOzob;
	}

	public void setHOzob(AbsPersonagem hOzob) {
		HOzob = hOzob;
	}

	@XmlElement(name = "HRexus")
	public AbsPersonagem getHRexus() {
		return HRexus;
	}

	
	public void setHRexus(AbsPersonagem hRexus) {
		HRexus = hRexus;
	}

	@XmlElement(name = "HSilvana")
	public AbsPersonagem getHSilvana() {
		return HSilvana;
	}

	public void setHSilvana(AbsPersonagem hSilvana) {
		HSilvana = hSilvana;
	}
	
	@XmlElement(name = "inventario")
	public Inventario getInventario(){
		return this.inventario;
	}
	
	public void setInventario(){
		this.inventario = Inventario.getInstancia();
	}
}