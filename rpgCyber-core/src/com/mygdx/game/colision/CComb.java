package com.mygdx.game.colision;

import snake.engine.creators.ScreenCreator;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.animate.Player;
import com.mygdx.game.battle.BattleHUD;
import com.mygdx.game.battle.BattleWorld;

public class CComb {
	public CComb(){
		
	}
	public static void changeCombat(OrthographicCamera camera,TiledMapTileLayer enemies,TiledMapTileLayer enemies2,TiledMapTileLayer bau){
		try{
		if(enemies != null){
			for(int i = 1; i < 5;i++){
				if(enemies.getCell(Math.round(camera.position.x+i), Math.round(camera.position.y)) != null){
					if(enemies.getCell(Math.round(camera.position.x+i), Math.round(camera.position.y)).getTile().getProperties().get("battle")!=null){
					
						try{
						if(enemies.getCell(Math.round(camera.position.x+i), 
								Math.round(camera.position.y)).getTile().getProperties().get("battle").toString().equalsIgnoreCase("right")){
							bau.setCell(Math.round(camera.position.x+i), Math.round(camera.position.y+1), enemies2.getCell(0, 0));
							enemies.setCell(Math.round(camera.position.x+i), Math.round(camera.position.y), enemies2.getCell(3, 0));
							Player.battle = true;
						}
						}catch(Exception e){}
					}
				}
				if(enemies.getCell(Math.round(camera.position.x), Math.round(camera.position.y+i)) !=null){
					if(enemies.getCell(Math.round(camera.position.x), Math.round(camera.position.y+i)).getTile().getProperties().get("battle")!=null){
						try{
						if(enemies.getCell(Math.round(camera.position.x), 
								Math.round(camera.position.y+i)).getTile().getProperties().get("battle").toString().equalsIgnoreCase("up")){
							bau.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1+i), enemies2.getCell(0, 0));
							enemies.setCell(Math.round(camera.position.x), Math.round(camera.position.y+i), enemies2.getCell(2, 0));
							Player.battle = true;
						}
						}catch(Exception e){}
					}
				}
				if(enemies.getCell(Math.round(camera.position.x-i), Math.round(camera.position.y)) !=null){
					if(enemies.getCell(Math.round(camera.position.x-i), Math.round(camera.position.y)).getTile().getProperties().get("battle")!=null){

						try{
						if(enemies.getCell(Math.round(camera.position.x-i), 
								Math.round(camera.position.y)).getTile().getProperties().get("battle").toString().equalsIgnoreCase("left")){
							bau.setCell(Math.round(camera.position.x-i), Math.round(camera.position.y+1), enemies2.getCell(0, 0));
							enemies.setCell(Math.round(camera.position.x-i), Math.round(camera.position.y), enemies2.getCell(1, 0));
							Player.battle = true;
						}
						}catch(Exception e){}
					}
				}
			
			}
		}
	
		}catch(Exception e){}
	}
}
	
