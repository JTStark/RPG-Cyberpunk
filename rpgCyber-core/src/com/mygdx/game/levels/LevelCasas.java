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
import com.mygdx.game.animate.Player;
import com.mygdx.game.battle.BattleHUD;
import com.mygdx.game.battle.BattleWorld;
import com.mygdx.game.colision.CBau;
import com.mygdx.game.colision.CCClide;
import com.mygdx.game.colision.CCColide;
import com.mygdx.game.colision.CComb;
import com.mygdx.game.colision.CDoors;
import com.mygdx.game.inventary.*;
import com.mygdx.game.menus.MyHub;
import com.mygdx.game.menus.MyLevelMenu;
import com.mygdx.game.savestate.SaveState;
import com.mygdx.game.screenshot.ScreenShotFactory;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * Map for testing purposes only.
 * @author Mr.Strings
 */

public class LevelCasas extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 

	private Magician_Test magician; //Da pra colocar uma array com todas as entities? 
	private TiledMap map;
	private TiledMapRenderer renderer;
	private TiledMapTileLayer colision, bau, bau2,enemies,enemies2;
	private OrthographicCamera camera;
	private float dx,dy,v;
	private int i, lim;
	private boolean flagv = false, flagmo =true;;
	public LevelCasas (String LevelData) {
		float w = WorldSettings.getWorldWidth();
		float h =  WorldSettings.getWorldHeight();
		v = Player.v;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, (w/h)*10, 10);
		camera.update();
		WorldSettings.setAmbientColor(Color.WHITE);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		map = new TmxMapLoader().load(LevelData);
		renderer = new OrthogonalTiledMapRenderer(map, 1f/32f);
		magician = new Magician_Test(this);
        colision =  (TiledMapTileLayer)map.getLayers().get("Colisoes");
        bau =  (TiledMapTileLayer)map.getLayers().get("Baus");
        bau2 = (TiledMapTileLayer)map.getLayers().get("Baus2");
        enemies = (TiledMapTileLayer)map.getLayers().get("Enemies");
        enemies2 = (TiledMapTileLayer)map.getLayers().get("Exclamacao");
        lim = colision.getHeight();
	}
	
	
	public void show () {
		WorldSettings.setAmbientColor(Color.WHITE);
	}
	
	
	
	@Override
	public void act(float delta) {
		super.act(delta);
		
		if(Player.battle){
			try {
				ScreenCreator.addAndGo(new BattleWorld("MyLevel"), new BattleHUD("MyLevel"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Player.battle = false;
		}
		if(flagmo){
			Player.ani.setXY((float)(getX()-0.325*8),(float)(getY() -1.1*8));
			camera.position.x+=Player.ani.getX();
			camera.position.y+=Player.ani.getY();
			camera.update();
			flagmo = false;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			
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
if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
			
			try {
				ScreenCreator.addAndGo(new InventaryMenu("MyLevel"), new InventaryHub());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
	ScreenShotFactory.saveScreenshot();
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
			Player.speed();
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
		CBau.changeBau(camera, bau, bau2, colision);
		CDoors.doorUP(camera, colision);
		CDoors.doorDown(camera, colision);
		CDoors.doorLeft(camera, colision);
		CDoors.doorRight(camera, colision);
		CComb.changeCombat(camera, enemies, enemies2,bau);
		// move player
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&!CCColide.rightP(colision, camera, "blocked")){
			dx=1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.UP)&&!CCColide.upP(colision, camera, "blocked")){
			dy=1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&&!CCColide.leftP(colision, camera, "blocked")){
			dx=-1;
		}else
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)&&!CCColide.downP(colision, camera, "blocked")){
			dy=-1;
		}
		Player.ani.setXY(getX()+ dx*delta*Player.v,getY() + dy*delta*Player.v);
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