package com.mygdx.game.levels;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldSettings;
import snake.player.Magician_Test;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;
import snake.visuals.enhanced.VisualGameWorld;
import box2dLight.Light;
import box2dLight.PointLight;

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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.androidkeys.AndroidInput;
import com.mygdx.game.animate.Animator;
import com.mygdx.game.animate.Player;
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

	private TiledMap map;
	private TiledMapRenderer renderer;
	private TiledMapTileLayer colision, bau, bau2;
	private OrthographicCamera camera;
	private float dx,dy,v;
	private int lim;
	Light light;
	private boolean flagv = false, flagmo =true;
	public MyLevel (String LevelData) {
		float w = WorldSettings.getWorldWidth();
		float h =  WorldSettings.getWorldHeight();
		v = 8;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w/h)*10, 10);
		camera.update();
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		map = new TmxMapLoader().load(LevelData);
		renderer = new OrthogonalTiledMapRenderer(map, 1f/32f);
        colision =  (TiledMapTileLayer)map.getLayers().get("Colisoes");
        bau =  (TiledMapTileLayer)map.getLayers().get("Baus");
        bau2 = (TiledMapTileLayer)map.getLayers().get("Baus2");
        lim = colision.getHeight();
        
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.BLACK);
	}
	
	
	
	@Override
	public void act(float delta) {
		if(flagmo){
			Player.ani.setXY((float)(getX()+ 4.172*v),(float)(getY() + 0.3*v));
			camera.position.x+=Player.ani.getX();
			camera.position.y+=Player.ani.getY();
			camera.update();
			flagmo = false;
		}
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
		if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
			Player.change();	
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
		
		
		dx=0;
		dy=0;
		//bau dissapering
				if(bau != null){
					if(bau.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)) !=null){
						if(bau.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("chest")!=null){
						bau.setCell(Math.round(camera.position.x), Math.round(camera.position.y+1), bau2.getCell(0, 0));
						if(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("blocked")!=null)
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
		// move player
	
		if((Gdx.input.isKeyPressed(Input.Keys.RIGHT))&&!(colision.getCell(Math.round(camera.position.x + 1), Math.round(camera.position.y)).getTile().getProperties().get("blocked") != null)){
			dx=1;
		}else
			
		if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("blocked") != null)){
			dy=1;
			if(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("door") != null){
				try {
					ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y+1)).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else
		if((Gdx.input.isKeyPressed(Input.Keys.LEFT))&&!(colision.getCell(Math.round(camera.position.x-1), Math.round( camera.position.y)).getTile().getProperties().get("blocked") != null)){
			dx=-1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&!(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get("blocked") != null)){
			dy=-1;
			if(colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get("door") != null){
				if("MapaExterno.tmx" == colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get("door").toString()){
					try {
						ScreenCreator.addAndGo(new LevelCasas("Mapas/" + colision.getCell(Math.round(camera.position.x), Math.round(camera.position.y-1)).getTile().getProperties().get("door").toString()), new MyHUD("LevelData"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					try {
						ScreenCreator.backToPrevious();
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			}
		}

		Player.ani.setXY(getX()+ dx*delta*v,getY() + dy*delta*v);
		camera.position.x+=Player.ani.getX();
		camera.position.y+=Player.ani.getY();
		camera.update();
		if(camera.position.x<1){ 	camera.position.x=1; } else if(camera.position.x>lim -1){
			camera.position.x=(float) (lim-1);
		}

		if(camera.position.y<1){ 	camera.position.y=1; }else if(camera.position.y>lim-1){
		camera.position.y=(float)( lim-1);
		}

		camera.update();
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
		Player.ani.act();
		super.draw(batch, parentAlpha);
	}

	public void createLights() {

		light = new PointLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, 1f, 1f), 45,50, WorldSettings.heightFix(50));
		light.setSoft(false);
	}
	
	@Override
	public void dispose() {

		map.dispose();
		light.remove();
		light.dispose();
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