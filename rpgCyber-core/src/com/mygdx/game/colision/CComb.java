package com.mygdx.game.colision;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class CComb {
	public CComb(){
		
	}
	public static void changeCombat(OrthographicCamera camera,TiledMapTileLayer bau,TiledMapTileLayer bau2){
		if(bau != null){
			if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)) != null){
				if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x+1), Math.round(camera.position.y), bau2.getCell(0, 0));
				}
			}
			if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)) !=null){
				if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x+1), Math.round(camera.position.y), bau2.getCell(0, 0));
				}
			}
			if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)) !=null){
				if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x-1), Math.round(camera.position.y), bau2.getCell(0, 0));
			
				}
			}
			if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)) !=null){
				if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x-1), Math.round(camera.position.y), bau2.getCell(0, 0));
				}
			}
		}
	}
}
	
