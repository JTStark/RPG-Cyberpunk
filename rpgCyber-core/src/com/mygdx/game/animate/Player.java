package com.mygdx.game.animate;
import java.util.ArrayList;

import implementations.inventario.Inventario;
import implementations.personagens.*;
import implementations.personagens.herois.*;

public class Player {
	public static boolean state  = true;
	public static Animator ani1 = new Animator("palhaco.png");
	public static Animator ani2 = new Animator("link.png");
	public static Animator ani = ani1;
	public static int v = 5;
	public static ArrayList<AbsPersonagem> lista = new ArrayList<AbsPersonagem>();
	public static AbsPersonagem Durden = HDurden.getInstancia();
	public static AbsPersonagem MDR = HMDR.getInstancia();
	public static AbsPersonagem Oleg = HOleg.getInstancia();
	public static AbsPersonagem Ozob= HOzob.getInstancia();
	public static AbsPersonagem Rexus = HRexus.getInstancia();
	public static AbsPersonagem Silvana = HSilvana.getInstancia();
	public static Inventario inv = Inventario.getInstancia();
	public static ArrayList<AbsPersonagem> getP(){
		lista.add(Durden);
		lista.add(MDR);
		lista.add(Oleg);
		lista.add(Ozob);
		lista.add(Rexus);
		lista.add(Silvana);
		return lista;
	}
	public static void change(){
		if(ani == ani1){
			ani = ani2;
		}else{
			ani = ani1;
		}
	}
	public static void speed(){
		if(v == 5){
			v = v*2;
		}else{
			v = v/2;
		}
	}
}
