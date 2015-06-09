package com.mygdx.game.animate;

public class Player {
	public static boolean state  = true;
	public static Animator ani1 = new Animator("palhaco.png");
	public static Animator ani2 = new Animator("link.png");
	public static Animator ani = ani1;
	public static int v = 5;
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
