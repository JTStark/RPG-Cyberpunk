package com.mygdx.game.androidkeys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class AndroidInput {
	static public float w =(float) (Gdx.graphics.getWidth()/640.0),h = (float) (Gdx.graphics.getHeight()/480.0);
	static public Rectangle leftButton = new Rectangle(0,0,100*w,200*h)
	,rightButton= new Rectangle(200*w,0,100*w,200*h)
	,upButton=new Rectangle(100*w,100*h,100*w,90*h)
	,downButton =new Rectangle(100*w,0,100*w,90*h)
	,exit = new Rectangle(0,Gdx.graphics.getHeight() - 100*h,100*w,100*h)
	,enter = new Rectangle(Gdx.graphics.getWidth()- 100*w,0,100*w,100*h)
	,action = new Rectangle(Gdx.graphics.getWidth() - 100*w,Gdx.graphics.getHeight() - 100*h,100*w,100*h)
	,hack = new Rectangle(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,w*100,h*100);
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
	public static boolean getExit(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
			Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
			camera2.unproject(touchPos);
			Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(exit))
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
	public static boolean getEnterB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
				Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
				camera2.unproject(touchPos);
				Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(enter))
				flag = true;
			}
		}return flag;
	}	
	public static boolean getActionB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
				Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
				camera2.unproject(touchPos);
				Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(action))
				flag = true;
			}
		}return flag;
	}	
	public static boolean getHackB(){
		OrthographicCamera camera2 = new OrthographicCamera();
		camera2.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		boolean flag =  false;
		for(int i = 0; i <5;i++){
			if(Gdx.input.isTouched(i)){
				Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
				camera2.unproject(touchPos);
				Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
			if(touch.overlaps(hack))
				flag = true;
			}
		}return flag;
	}	
	
}
