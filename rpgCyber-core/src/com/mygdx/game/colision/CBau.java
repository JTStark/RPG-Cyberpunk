package com.mygdx.game.colision;

import implementations.inventario.Inventario;
import implementations.inventario.Item;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class CBau {
	public CBau(){
		
	}
	public static void changeBau(OrthographicCamera camera,TiledMapTileLayer bau,TiledMapTileLayer bau2,TiledMapTileLayer colision){
		if(bau != null){
			if(CCClide.up(bau, camera)){
				if(CCClide.upP(bau, camera, "chest")&&Inventario.getInstancia().adicionar_item(Item.geraAleatorio().getName())){
					
				bau.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1), bau2.getCell(0, 0));
				
				if(CCClide.upP(colision, camera, "blocked"))
					colision.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1), bau2.getCell(0, 0));
				}
			}
			else if(CCClide.right(bau, camera)){
				if(CCClide.rightP(bau, camera, "chest")&&Inventario.getInstancia().adicionar_item(Item.geraAleatorio().getName())){
					
				bau.setCell(Math.round(camera.position.x+1), Math.round((float)(camera.position.y+0.2)), bau2.getCell(0, 0));
				
				if(CCClide.rightP(colision, camera, "blocked"))
					colision.setCell(Math.round(camera.position.x+1), Math.round((float)(camera.position.y+0.2)), bau2.getCell(0, 0));
				}
			}
			else if(CCClide.left(bau, camera)){
				if(CCClide.leftP(bau, camera, "chest")&&Inventario.getInstancia().adicionar_item(Item.geraAleatorio().getName())){
					
				bau.setCell(Math.round(camera.position.x-1), Math.round((float)(camera.position.y+0.2)), bau2.getCell(0, 0));
				
				if(CCClide.leftP(colision, camera, "blocked"))
					colision.setCell(Math.round(camera.position.x-1), Math.round((float)(camera.position.y+0.2)), bau2.getCell(0, 0));
				}
			}
		}
	}
}
