package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animax {
	private float            stateTime;
	private SpriteBatch    spriteBatch;
	private Animation    walkAnimation;
	private TextureRegion currentFrame;
	private TextureRegion[] walkFrames;
	private Texture          walkSheet;
	TextureRegion[][] tmp;
	public Animax(){}
	
	public Animax(float stateTime, SpriteBatch spriteBatch
				 ,Animation walkAnimation, TextureRegion currentFrame
				 ,TextureRegion[] walkFrames,Texture walkSheet){
		this.stateTime = stateTime;
		this.spriteBatch = spriteBatch;
		this.walkAnimation = walkAnimation;
		this.currentFrame =currentFrame;
		this.walkFrames = walkFrames;
		this.walkSheet = walkSheet;
			 
	}
	public void setStateTime(float stateTime){
		this.stateTime =stateTime;
	}
	public void addStateTime(float stateTime){
		this.stateTime +=stateTime;
	}
	public void setSpriteBatch(SpriteBatch spriteBatch){
		this.spriteBatch =spriteBatch;
	}
	public void setSpriteBatch(){
		spriteBatch = new SpriteBatch();
	}
	public void setAnimation(Animation walkAnimation){
		this.walkAnimation = walkAnimation;
	}
	public void setAnimation(float novo){
		walkAnimation = new Animation(novo, this.getTextureRegions());
	}
	public void setTextureRegion(TextureRegion currentFrame){
		this.currentFrame = currentFrame;
	}
	public void setTextureRegions(TextureRegion[]  walkFrames){
		this.walkFrames = walkFrames;
	}
	public void setTextureRegions(int index, TextureRegion  walkFrames){
		this.walkFrames[index] = walkFrames;
	}
	public void setTextureRegions(int framerows, int framecols, int rs,int cs, int re, int ce){
		int index = 0;
		rs--;
		cs--;
		TextureRegion[][] tmp = TextureRegion.split(this.getTexture(), this.getTexture().getWidth()/framecols, this.getTexture().getHeight()/framerows);
		walkFrames = new TextureRegion[(re -rs) * (ce - cs)];
		for (int i = rs; i < framerows && i < re; i++) {
			for (int j = cs; j < framecols && j < ce; j++) {       
			this.setTextureRegions(index++, tmp[i][j]);        
        
			}

		}
	}
	public void setTexture(Texture  walkSheet){
		this.walkSheet = walkSheet;
	}
	public void setTexture(String  walkSheet){
		this.walkSheet = new Texture(Gdx.files.internal(walkSheet));
	}
	public float getStateTime(){
		return stateTime;
	}
	public SpriteBatch getSpriteBatch(){
		return spriteBatch;
	}
	public Animation getAnimation(){
		return walkAnimation;
	}
	public TextureRegion getTextureRegion(){
		return currentFrame;
	}
	
	public TextureRegion[] getTextureRegions(){
		return walkFrames;
	}
	public TextureRegion getTextureRegions(int index){
		return walkFrames[index];
	}
	public Texture getTexture(){
		return walkSheet;
	}
}
