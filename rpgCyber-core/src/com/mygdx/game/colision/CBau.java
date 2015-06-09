package com.mygdx.game.colision;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class CBau {
	public CBau(){
		
	}
	public static void changeBau(OrthographicCamera camera,TiledMapTileLayer bau,TiledMapTileLayer bau2,TiledMapTileLayer colision){
		if(bau != null){
			if(CCClide.up(bau, camera)){
				if(CCClide.upP(bau, camera, "chest")){
				bau.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1), bau2.getCell(0, 0));
				
				if(CCClide.upP(colision, camera, "blocked"))
					colision.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1), bau2.getCell(0, 0));
				}
			}
			if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)) !=null){
				if(bau.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x+1), Math.round(camera.position.y), bau2.getCell(0, 0));
				if(colision.getCell(Math.round(camera.position.x+1), Math.round(camera.position.y)).getTile().getProperties().get("blocked")!=null)
					colision.setCell(Math.round(camera.position.x+1), Math.round(camera.position.y), bau2.getCell(0, 0));
				}
			}
			if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)) !=null){
				if(bau.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)).getTile().getProperties().get("chest")!=null){
				bau.setCell(Math.round(camera.position.x-1), Math.round(camera.position.y), bau2.getCell(0, 0));
				if(colision.getCell(Math.round(camera.position.x-1), Math.round(camera.position.y)).getTile().getProperties().get("blocked")!=null)
					colision.setCell(Math.round(camera.position.x-1), Math.round(camera.position.y), bau2.getCell(0, 0));
				}
			}
		}
	}
}
