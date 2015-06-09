package com.mygdx.game.colision;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class CCColide {
	public static boolean up(TiledMapTileLayer generic, OrthographicCamera camera){
		if(generic.getCell(Math.round(camera.position.x), Math.round((float)(camera.position.y+0.5))) != null)
			return true;
		if(generic.getCell(Math.round((float)(camera.position.x - 0.4)), Math.round((float)(camera.position.y+0.5))) != null)
			return true;
		if(generic.getCell(Math.round((float)(camera.position.x + 0.3)), Math.round((float)(camera.position.y+0.5))) != null)
			return true;
		return false;
	}
	public static boolean down(TiledMapTileLayer generic, OrthographicCamera camera){
		if(generic.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)) != null)
			return true;
		return false;
	}
	public static boolean left(TiledMapTileLayer generic, OrthographicCamera camera){
		if(generic.getCell(Math.round((float)(camera.position.x - 0.3)), Math.round((float)(camera.position.y-0.5))) != null)
			return true;
		return false;
	}
	public static boolean right(TiledMapTileLayer generic, OrthographicCamera camera){
		if(generic.getCell(Math.round((float)(camera.position.x+1)), Math.round((float)(camera.position.y-0.5))) != null)
			return true;
		return false;
	}
	public static boolean upP(TiledMapTileLayer generic, OrthographicCamera camera, String prop){
		if(up(generic,camera)){
			if(generic.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1/2)).getTile().getProperties().get(prop) != null)
				return true;
			if(generic.getCell(Math.round((float)(camera.position.x - 0.4)), Math.round(camera.position.y+1/2)).getTile().getProperties().get(prop) != null)
				return true;
			if(generic.getCell(Math.round((float)(camera.position.x + 0.3)), Math.round(camera.position.y+1/2)).getTile().getProperties().get(prop) != null)
				return true;
		}
		return false;
	}
	public static boolean downP(TiledMapTileLayer generic, OrthographicCamera camera, String prop){
		if(down(generic,camera)){
		if(generic.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get(prop) != null)
			return true;
		}
		return false;
	}
	public static boolean leftP(TiledMapTileLayer generic, OrthographicCamera camera, String prop){
		if(left(generic,camera))
		if(generic.getCell(Math.round((float)(camera.position.x - 0.4)), Math.round((float)(camera.position.y-0.5))).getTile().getProperties().get(prop) != null)
			return true;
		return false;
	}
	public static boolean rightP(TiledMapTileLayer generic, OrthographicCamera camera, String prop){
		if(right(generic,camera)){
		if(generic.getCell(Math.round((float)(camera.position.x+1)), Math.round((float)(camera.position.y-0.5))).getTile().getProperties().get(prop) != null)
			return true;
		if(generic.getCell(Math.round((float)(camera.position.x+1)), Math.round((float)(camera.position.y))).getTile().getProperties().get(prop) != null)
			return true;
		}
		return false;
	}
	
}
