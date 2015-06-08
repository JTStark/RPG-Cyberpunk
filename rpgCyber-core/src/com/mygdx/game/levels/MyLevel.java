package com.mygdx.game.levels;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.player.Magician_Test;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.animate.Animator;
import com.mygdx.game.battle.BattleHUD;
import com.mygdx.game.battle.BattleWorld;
import com.mygdx.game.menus.MyHub;
import com.mygdx.game.menus.MyLevelMenu;
import com.mygdx.game.savestate.SaveState;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * Map for testing purposes only.
 * @author Mr.Strings
 */

public class MyLevel extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 

	private Magician_Test magician; //Da pra colocar uma array com todas as entities? 
	private TiledMap map;
	private Animator ani;
	private TiledMapRenderer renderer;
	private TiledMapTileLayer colision;
	private OrthographicCamera camera;
	private float dx,dy,v,tempx,tempy;
	private int i, lim;
	private boolean flagv = false;
	public MyLevel (String LevelData/* Add other parameters of choice*/) {
		float w = WorldSettings.getWorldWidth();
		float h =  WorldSettings.getWorldHeight();
		v = 8;
		lim =100;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w/h)*10, 10); 
		camera.update();
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		ani = new Animator("link.png");
		map = new TmxMapLoader().load("Mapas/MapaExterno.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, 1f/32f);
		magician = new Magician_Test(this);

        colision =  (TiledMapTileLayer)map.getLayers().get(2);
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
;
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			String[] param = {"SnakeScreen", "ForestMap", "Some random Data"};
			try {
				ScreenCreator.addAndGo(param);
			}  catch (Exception e) {
				System.out.println ("Could not switch Screens");
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
			
				try {
					ScreenCreator.addAndGo(new BattleWorld("MyLevel"), new BattleHUD("MyLevel"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
			try {
				ScreenCreator.backToPrevious();
			} catch (Exception e) {
				String[] param = {"SnakeLevel", "MainMenu", "LevelDataID"};
				try {
					ScreenCreator.switchAndGo(param);
				} catch (Exception excp) {
					System.out.println("Couldn't switch screens.");
				}
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
			flagv = !flagv;
			if(flagv){
				v=v*5;
			}else{
				v=v/5;
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			WorldSettings.setAmbientColor(new Color (0.1f, 0.1f, 0.1f, 1f));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			WorldSettings.setAmbientColor(Color.WHITE);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_RIGHT)) {
			try {
				SaveState save = new SaveState(this);
			} catch (JAXBException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ALT_LEFT)) {
			try {
				SaveState save = new SaveState(this);
			} catch (JAXBException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Camera Movement
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			getStage().getCameraMan().moveCamera(-20f * delta, 0);
			
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			getStage().getCameraMan().moveCamera(20f * delta, 0);
			
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			getStage().getCameraMan().moveCamera( 0, -20f * delta);
			
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			getStage().getCameraMan().moveCamera(0, 20f * delta);
			
		//Camera Zoom
		if (Gdx.input.isKeyPressed(Input.Keys.O))
			getStage().getCameraMan().zoomCamera(-.5f * delta);
			
		if (Gdx.input.isKeyPressed(Input.Keys.P))
			getStage().getCameraMan().zoomCamera(.5f * delta);
		
		
		//Virtual Camera Movement
		if (Gdx.input.isKeyPressed(Input.Keys.L))
			getStage().getCameraMan().moveVCamera(.01f, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.J))
			getStage().getCameraMan().moveVCamera(-.01f, 0);
			
		if (Gdx.input.isKeyPressed(Input.Keys.I))
			getStage().getCameraMan().moveVCamera(0, .01f);
		
		if (Gdx.input.isKeyPressed(Input.Keys.K))
			getStage().getCameraMan().moveVCamera(0, -.01f);
		
		dx=0;
		dy=0;
		// move player
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&!(colision.getCell(Math.round(camera.position.x + 1), Math.round(camera.position.y)).getTile().getProperties().get("blocked") != null)){
			dx=1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("blocked") != null)){
			dy=1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&&!(colision.getCell(Math.round(camera.position.x-1), Math.round( camera.position.y)).getTile().getProperties().get("blocked") != null)){
			dx=-1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&!(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get("blocked") != null)){
			dy=-1;
		}
		tempx = ani.getX();
		tempy = ani.getY();
		ani.setXY(getX()+ dx*delta*v,getY() + dy*delta*v);
		camera.position.x+=ani.getX();
		camera.position.y+=ani.getY();
		camera.update();
		if(camera.position.x<1){ 	camera.position.x=1; } else if(camera.position.x>lim -1){
			camera.position.x=(float) (lim-1);
		}

		if(camera.position.y<1){ 	camera.position.y=1; }else if(camera.position.y>lim-1){
		camera.position.y=(float)( lim-1);
		}

		camera.update();
		
		//Virtual Camera Zoom
		if (Gdx.input.isKeyPressed(Input.Keys.U))
			getStage().getCameraMan().zoomVCamera(.01f);
			
		if (Gdx.input.isKeyPressed(Input.Keys.Y))
			getStage().getCameraMan().zoomVCamera(-.01f);
		
	}
	@Override
	public void draw (Batch batch, float parentAlpha) {

		
		batch.end();
		camera.update();
		renderer.setView(camera);
		renderer.render();
		batch.begin();
		//magician.draw(batch, parentAlpha);
		batch.end();
		batch.begin();
		ani.act();
		super.draw(batch, parentAlpha);
	}

	public void createLights() {
		for (Actor x : this.getChildren()) {
			LightMapEntity ent = (LightMapEntity) x;
			ent.createLights();
		}
	}
	
	@Override
	public void dispose() {

		map.dispose();
		magician.disposeLights();
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

}