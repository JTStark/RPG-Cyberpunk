package com.mygdx.game.animate;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import implementations.combate.AuxTemp;
import implementations.inventario.Inventario;
import implementations.personagens.*;
import implementations.personagens.herois.*;

public class Player {
	public static boolean state  = true;
	public static Animator ani1 = new Animator("palhaco.png");
	public static Animator ani2 = new Animator("link.png");
	public static Animator ani = ani2;
	public static int v = 10;
	public static ArrayList<AbsPersonagem> listaP = new ArrayList<AbsPersonagem>();
	public static ArrayList<AbsPersonagem> listaV = new ArrayList<AbsPersonagem>();
	public static ArrayList<AbsPersonagem> listaN = new ArrayList<AbsPersonagem>();
	public static AbsPersonagem MDR = HMDR.getInstancia();
	public static AbsPersonagem Durden = HDurden.getInstancia();
	public static AbsPersonagem Oleg = HOleg.getInstancia();
	public static AbsPersonagem Ozob= HOzob.getInstancia();
	public static AbsPersonagem Rexus = HRexus.getInstancia();
	public static AbsPersonagem Silvana = HSilvana.getInstancia();
	public static Inventario inv = Inventario.getInstancia();
	public static SpriteBatch spritebatch=new SpriteBatch();
	public static boolean battle = false;
	public static ArrayList<AbsPersonagem> getP(){
		listaP.add(MDR);
		listaP.add(Durden);
		listaP.add(Oleg);
		listaP.add(Ozob);
		listaP.add(Rexus);
		listaP.add(Silvana);
		return listaP; //= AuxTemp.getHer();
	}
	
	public static void change(){
		if(ani == ani1){
			ani = ani2;
		}else{
			ani = ani1;
		}
	}
	public static void changeAll(){
		if(ani == ani1){
			ani = ani2;
		}else{
			ani = ani1;
		}
		if(v == 5){
			v = v*2;
		}else{
			v = v/2;
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
