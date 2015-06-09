package com.mygdx.game.androidkeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class AndroidInput {
	static public Rectangle leftButton = new Rectangle(20,100,64,64)
	,rightButton= new Rectangle(120,20,64,64)
	,upButton=new Rectangle(220,100,64,64)
	,downButton =new Rectangle(120,120,64,64);
	static public int i =0;
	public  AndroidInput(){
	}
	public static boolean getLeftB(OrthographicCamera camera){
		boolean flag =  false;
		if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(leftButton));
				flag = true;
		}
		return flag;
	}
	public static boolean getRightB(OrthographicCamera camera){
		boolean flag =  false;
		if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(rightButton));
				flag = true;
		}
		return flag;
	}
	public static boolean getUpB(OrthographicCamera camera){
		boolean flag =  false;
		if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(upButton));
				flag = true;
		}
		return flag;
	}
	public static boolean getDownB(OrthographicCamera camera){
		boolean flag =  false;
		if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(downButton));
				flag = true;
		}
		return flag;
	}
}
