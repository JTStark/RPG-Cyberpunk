package com.mygdx.game.colision;

import snake.engine.creators.ScreenCreator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.levels.LevelCasas;
import com.mygdx.game.levels.LevelCasas2;
import com.mygdx.game.levels.MyHUD;

public class CDoors {
	public static  void doorUP(OrthographicCamera camera,TiledMapTileLayer colision){
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			if(CCClide.upP(colision, camera, "door")){
				try {
					ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round((float)(camera.position.y+1.2))).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}if(CCClide.upP(colision, camera, "stair")){
					try {
						ScreenCreator.addAndGo(new LevelCasas2("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round((float)(camera.position.y+1.2))).getTile().getProperties().get("stair").toString()), new MyHUD("LevelData"));
					} catch (Exception e) {
						e.printStackTrace();
					}
			}if(CCClide.upP(colision, camera, "stairHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(CCClide.upP(colision, camera, "doorHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static  void doorDown(OrthographicCamera camera,TiledMapTileLayer colision){
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			if(CCClide.downP(colision, camera, "door")){
				try {
					ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round((float)(camera.position.y-0.8))).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.downP(colision, camera, "stair")){
				try {
					ScreenCreator.addAndGo(new LevelCasas2("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round((float)(camera.position.y-0.8))).getTile().getProperties().get("stair").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}else if(CCClide.downP(colision, camera, "stairHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.downP(colision, camera, "doorHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static  void doorLeft(OrthographicCamera camera,TiledMapTileLayer colision){
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			if(CCClide.leftP(colision, camera, "door")){
				try {
					ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x-1), Math.round((float)(camera.position.y+0.2))).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.leftP(colision, camera, "stair")){
				try {
					ScreenCreator.addAndGo(new LevelCasas2("Mapas/" + colision.getCell(Math.round(camera.position.x-1), Math.round((float)(camera.position.y+0.2))).getTile().getProperties().get("stair").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}else if(CCClide.leftP(colision, camera, "stairHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.leftP(colision, camera, "doorHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static  void doorRight(OrthographicCamera camera,TiledMapTileLayer colision){
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			if(CCClide.rightP(colision, camera, "door")){
				try {
					ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x+1), Math.round((float)(camera.position.y+0.2))).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.rightP(colision, camera, "stair")){
				try {
					ScreenCreator.addAndGo(new LevelCasas2("Mapas/" + colision.getCell(Math.round(camera.position.x+1), Math.round((float)(camera.position.y+0.2))).getTile().getProperties().get("stair").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}else if(CCClide.rightP(colision, camera, "stairHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(CCClide.rightP(colision, camera, "doorHome")){
				try {
					ScreenCreator.backToPrevious();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
