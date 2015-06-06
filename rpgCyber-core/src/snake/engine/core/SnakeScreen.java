package snake.engine.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import snake.engine.creators.HUDCreator;
import snake.engine.creators.ScreenCreator;
import snake.engine.creators.WorldCreator;
import snake.engine.models.Cutscene;
import snake.engine.models.GameLevel;
import snake.engine.models.GameWorld;
import snake.engine.models.HUD;
import snake.engine.models.PauseMenu;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * <br> Controls a generic game Level flow, with a World and HUD. </br>
 * @author Mr.Strings
 */

public class SnakeScreen implements GameLevel {

	public enum State {ACTIVE, NOINPUT, CUTSCENE, PAUSED}
	public enum Strategy {UPDATEFOCUS, DRAWFOCUS, NOFOCUS}
	
	private static float EXPECTED_DELTA_DRAW = 1/60, EXPECTED_DELTA_UPDATE = 1/60;
	private static int MAX_FRAMES_SKIPPED = 5, MAX_LOGIC_SKIPPED =  5;
	
	private InputMultiplexer input;
	private LevelStage stageWorld, stageHUD; //Is used as a Subscriber, controls update, render, input polling (if applicable) and viewports
	private GameWorld world; //the world in which is the game
	private HUD hud; //Game HUD -- info display and such
	private Cutscene cutscene;
	private PauseMenu pauseMenu;
	private State state = State.ACTIVE;
	private Strategy strategy = Strategy.UPDATEFOCUS;
	private int framesSkipped = 0, logicSkipped = 0;

	
	/** Creates level with the types provided by the Creator Classes. */
	public SnakeScreen(String levelType, String levelDataID) {
		// Creates GameWorld
		world = WorldCreator.createWorld(levelType, levelDataID);
		// Creates HUD
		hud = HUDCreator.createHUD(levelType, levelDataID);

		// Creates a stage (world organizer)
		stageWorld = WorldCreator.createWorldStage(ScreenCreator.getBatch(), this, world);
		// Creates a stage (UI organizer)
		stageHUD = HUDCreator.createHUDStage(ScreenCreator.getBatch(), this, hud);

		// Adds world and HUD to the stages
		stageWorld.addActor(world);
		stageHUD.addActor(hud);
		
		
		// Let stages listen to input events
		input = new InputMultiplexer();
		input.addProcessor(stageWorld);
		input.addProcessor(stageHUD);
		 
		Gdx.input.setInputProcessor(input);
		
	}
	
	
	/** Creates Level with custom World and HUD */
	public SnakeScreen(GameWorld world, HUD hud) {

		// Creates GameWorld
		this.world = world;
		// Creates HUD
		this.hud = hud;

		// Creates a stage (world organizer)
		stageWorld = WorldCreator.createWorldStage(ScreenCreator.getBatch(), this, world);
		// Creates a stage (UI organizer)
		stageHUD = HUDCreator.createHUDStage(ScreenCreator.getBatch(), this, hud);

		// Adds world and HUD to the stages
		stageWorld.addActor(world);
		stageHUD.addActor(hud);
		
		
		// Let stages listen to input events
		input = new InputMultiplexer();
		input.addProcessor(stageWorld);
		input.addProcessor(stageHUD);
		 
		Gdx.input.setInputProcessor(input);
		
	}
	
	/** Sets Level with custom world, HUD and Stages. */
	public SnakeScreen(GameWorld world, HUD hud, LevelStage stageWorld, LevelStage stageHUD) {

		// Creates GameWorld
		this.world = world;
		// Creates HUD
		this.hud = hud;

		// Sets the stage (world organizer)
		this.stageWorld = stageWorld;
		// sets the stage (UI organizer)
		this.stageHUD = stageHUD;

		// Adds world and HUD to the stages
		stageWorld.addActor(world);
		stageHUD.addActor(hud);
		
		
		// Let stages listen to input events
		input = new InputMultiplexer();
		input.addProcessor(stageWorld);
		input.addProcessor(stageHUD);
		 
		Gdx.input.setInputProcessor(input);
	}
	
	
	/** is triggered when the Screen is set. */
	@Override
	public void show() {
		world.show();
		hud.show();
	}

	
	/** Controls game logic -- keeps looping, updating and drawing as the game goes. */
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		getInput();
		
		switch (state) {
			case NOINPUT:
			case ACTIVE:
				onRender(delta);
				break;
				
			case PAUSED:
				pauseMenu.act(delta);
				pauseMenu.draw();
			case CUTSCENE:
				if (cutscene != null) {
					cutscene.act(delta);
					cutscene.draw();
				}
				break;
				
			default:
				break;
		}
		
		if (ScreenCreator.updateRequested())
			ScreenCreator.updateScreens();
	}
	
	
	/** Auxiliary class for rendering options */
	private void onRender(float delta) {
		
		switch (strategy) {
			case UPDATEFOCUS:
				stageWorld.act(delta);
				
				stageHUD.act(delta);
			
				if (delta <= EXPECTED_DELTA_DRAW || framesSkipped < MAX_FRAMES_SKIPPED) {
					framesSkipped = 0;
					stageWorld.draw();
					stageHUD.draw();
				}
				else
					framesSkipped++;
				break;
		
			case DRAWFOCUS:
				if (delta <= EXPECTED_DELTA_UPDATE|| logicSkipped < MAX_LOGIC_SKIPPED) {
					logicSkipped = 0;
					stageWorld.act();
					stageHUD.act();
				}
				else
					logicSkipped++;
				stageWorld.draw();
				stageHUD.draw();
				break;
				
			case NOFOCUS:
				stageWorld.act();
				stageHUD.act();
			
				stageWorld.draw();
				stageHUD.draw();
				break;
			default:
				break; //Exception can be added
		}
		
		
	}

	
	/** Is triggered when the Screen is resized */
	@Override
	public void resize(int width, int height) {
		stageWorld.getViewport().update(width, height);
		stageHUD.getViewport().update(width, height);
		// stageWorld.getViewport().getCamera().translate(Gdx.graphics.getWidth(),
		// Gdx.graphics.getHeight(), 0);
	}

	@Override
	public void pause() {
		world.pause();
		hud.pause();
	}

	/** Is triggered when the screen goes out of paused state, usually when it regain focus on Android. */
	@Override
	public void resume() {
		world.resume();
		hud.resume();
	}

	@Override
	public void hide() {
		world.hide();
		hud.hide();
	}

	
	/** Prevents memory leak, disposing the Screen when it won't be used anymore 
	 * -- is done automatically by the ScreenCreator if used. */
	@Override
	public void dispose() {
		stageWorld.dispose();
		stageHUD.dispose();
		
		world.dispose();
		hud.dispose();
	}
	
	/** Is triggered when input is received */
	private void getInput () {
		if (Gdx.input.isKeyPressed(Input.Keys.F1)) {
			// set resolution to default and toggles full-screen
			Gdx.graphics.setDisplayMode(
					Gdx.graphics.getDesktopDisplayMode().width,
					Gdx.graphics.getDesktopDisplayMode().height,
					!Gdx.graphics.isFullscreen());
		}
	}
	
	
	/* ------------------------------ Getters ------------------------------ */

	
	/** Gets Level gameWorld */
	public GameWorld getGameWorld() {return world;}
	
	/** Gets Level HUD */
	public HUD getHUD() {return hud;}
	
	/** Gets Stage for HUD */
	public Stage getHudStage() {return stageHUD;}
	
	/** Gets Stage for World */
	public Stage getWorldStage() {return stageWorld;}
	
	
	/* ------------------------------ Setters ------------------------------ */
	
	/** Sets game stage (paused, active, etc.) */
	public void setGameState(State state) {this.state = state; }
	
	/** Sets rendering strategy -- prioritize update or drawing or none */
	public void setStrategy (Strategy strategy) {this.strategy = strategy;}
}
