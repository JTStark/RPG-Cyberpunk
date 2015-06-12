package com.mygdx.game.androidkeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class AndroidInput {
	static public Rectangle leftButton = new Rectangle(0,0,100,100)
	,rightButton= new Rectangle(200,0,100,100)
	,upButton=new Rectangle(100,100,100,100)
	,downButton =new Rectangle(100,0,100,100);
	public  AndroidInput(){
	}
	public static boolean getLeftB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera2.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(leftButton))
				flag = true;
			}
		}
		return flag;
	}
	public static boolean getRightB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera2.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(rightButton))
				flag = true;
			}
		}
		return flag;
	}
	public static boolean getUpB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera2.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(upButton))
				flag = true;
			}
		}
		return flag;
	}
	public static boolean getDownB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
				Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
				camera2.unproject(touchPos);
				Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(downButton))
				flag = true;
			}
		}return flag;
	}	
	
}
