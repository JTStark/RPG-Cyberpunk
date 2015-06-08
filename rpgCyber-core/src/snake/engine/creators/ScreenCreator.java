package snake.engine.creators;

import java.util.ArrayDeque;
import java.util.Deque;
import snake.engine.core.LevelStage;
import snake.engine.core.SnakeScreen;
import snake.engine.models.GameStart;
import snake.engine.models.GameWorld;
import snake.engine.models.HUD;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *  
 *  <br> TODO: Secure Screeen changes </br>
 *  
 *  
 *  <br> Create Screen as specified. </br>
 *  <br> has a stack (deque) of all active Screens </br>
 * @Author Mr.Strings
 */
public abstract class ScreenCreator {
	private static GameStart game;
	private static Deque <Screen> screenStack = new ArrayDeque<>();
	private static Deque <Screen> removedStack = new ArrayDeque<>();
	private static boolean updateRequested = false;
	
	/** Creates new String, but doesn't set it as current.
	 * @param Settings[] -- array of settings for desired screen. 
	 */
	public static Screen createScreen(String settings[]) {
		Screen screen;
		try {
			switch (settings[0].toLowerCase()) {
				case "snakelevel":
				case "snake level":
				case "snakescreen":
				case "snake screen":
					screen = new SnakeScreen(settings[1], settings[2]);
					break;
				default:
					System.out.println("Screen type not found.");
					return null;
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println ("Not enough parameters to create requested Screen.");
			return null;
		}

		return screen;
	}
	
	
	/** Creates new SnakeScreen, but doesn't set it as current.
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param levelDataID -- String of info to start level 
	 */
	public static Screen createScreen(GameWorld world, HUD hud) {
		return new SnakeScreen (world, hud);
	}
	
	
	/** Creates new SnakeScreen, but doesn't set it as current.
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param stageWorld -- stage to World
	 * @param stageHUD -- stage to HUD
	 * @param levelDataID -- String of info to start level 
	 */
	public static Screen createScreen(GameWorld world, HUD hud, LevelStage stageWorld,
									  LevelStage stageHUD) {
		return new SnakeScreen (world, hud, stageWorld, stageHUD);
	}
	
	/** Creates Screen and adds it to stack.
	 * 
	 * @param settings[] -- settings used to create Screen
	 * @throws Exception */
	public static void addAndGo (String settings[]) throws Exception {
		
		try {
			Screen screen = createScreen(settings);
		
			screenStack.push(screen);
			
			updateRequested = true;
			
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}

	
	/** Creates Screen and adds it to stack.
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param levelDataID -- String of info to start level 
	 * @throws Exception */
	public static void addAndGo (GameWorld world, HUD hud) throws Exception {
		
		try {
			Screen screen = createScreen(world, hud);
		
			screenStack.push(screen);
			
			updateRequested = true;
			
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	/** Creates Screen and adds it to stack.
	 * 
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param stageWorld -- stage to World
	 * @param stageHUD -- stage to HUD
	 * @param levelDataID -- String of info to start level 
	 * @throws Exception */
	public static void addAndGo (GameWorld world, HUD hud, LevelStage stageWorld,
			  LevelStage stageHUD) throws Exception {
		
		try {
			Screen screen = createScreen(world, hud, stageWorld, stageHUD);
		
			screenStack.push(screen);
			
			updateRequested = true;
			
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}

	
	/** Removes Current Screen from Stack (if there is one) and adds created Screen
	 * with sent settings.
	 *  
	 * @param settings
	 * @throws Exception 
	 */
	public static void switchAndGo (String settings[]) throws Exception {
		try {
			
			if (screenStack.isEmpty() == false) {
				Screen removed = screenStack.pop();
				removedStack.add(removed);
			}
		
			Screen screen = createScreen(settings);
			screenStack.push(screen);
			updateRequested = true;
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	
	/** Removes Current Screen from Stack (if there is one) and adds created Screen
	 * with sent settings.
	 *  
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param levelDataID -- String of info to start level 
	 * @throws Exception 
	 */
	public static void switchAndGo (GameWorld world, HUD hud) throws Exception {
		try {
			
			if (screenStack.isEmpty() == false) {
				Screen removed = screenStack.pop();
				removedStack.add(removed);
			}
		
			Screen screen = createScreen(world, hud);
			screenStack.push(screen);
			updateRequested = true;
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	/** Removes Current Screen from Stack (if there is one) and adds created Screen
	 * with sent settings.
	 *	
	 * @param world -- GameWorld of Screen.
	 * @param hud -- HUD of Screen.
	 * @param stageWorld -- stage to World
	 * @param stageHUD -- stage to HUD
	 * @param levelDataID -- String of info to start level 
	 */
	public static void switchAndGo (GameWorld world, HUD hud, LevelStage stageWorld,
			  LevelStage stageHUD) throws Exception {
		try {
			
			if (screenStack.isEmpty() == false) {
				Screen removed = screenStack.pop();
				removedStack.add(removed);
			}
		
			Screen screen = createScreen(world, hud, stageWorld, stageHUD);
			screenStack.push(screen);
			updateRequested = true;
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	
	/** Pops and disposes current screen from stack.
	 * @throws Exception -- if there is no screen left in stack 
	 * */
	public static void backToPrevious() throws Exception {
		Screen removed = screenStack.pop();
		removedStack.add(removed);
		if (screenStack.isEmpty() == true)
			throw new Exception ("This is the first Screen.");
		else
			updateRequested = true;
	}
	
	public static boolean updateRequested() {
		return updateRequested;
	}
	
	public static void updateScreens () {
		if (screenStack.isEmpty() == false) {
			updateRequested = false;
			while (removedStack.isEmpty() == false) {
				Screen removed = removedStack.pop();
				removed.dispose();
			}
			
			game.setScreen(screenStack.getFirst());
		}
	}
	
	/** Sets Game instance -- can only be done once */
	public static void setGameInstance(GameStart theGame) {
		if (game == null)
			game = theGame;
		else
			System.out.println("Cannot change game instance.");
	}

	
	/** Gets game batch -- doesn't prevent creation of another batch, but this isn't 
	 *  really recommended.
	 */
	public static SpriteBatch getBatch() {
		if (game != null && game.getBatch() instanceof SpriteBatch)
			return (SpriteBatch) game.getBatch();
		else {
			System.out.println("Game instance not yet created, or Batch isn't a SpriteBatch.");
			return null;
		}
	}
}
