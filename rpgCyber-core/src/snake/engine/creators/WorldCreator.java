package snake.engine.creators;

import snake.engine.core.LevelStage;
import snake.engine.core.SnakeScreen;
import snake.engine.models.BlankWorld;
import snake.engine.models.GameWorld;
import snake.map.types.ForestMap_test;
import snake.map.types.TempleMap_test;
import snake.visuals.enhanced.VisualBlankWorld;
import snake.visuals.enhanced.VisualWorldStage;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.levels.MyLevel;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * <br> Factory for GameWorlds and GameStages </br>
 * 
 * <br>
 * 		Note: Customization in Factory type methods (such as createWorld() and createWorldStage()) and
 * 		attributes is recommended.
 * </br>
 * @author Mr.Strings 
 * 
 * 
 * 
 */
public abstract class WorldCreator {

	/** 
	 * Creates World as specified. Can be customized as desired.
	 * 
	 * @author Mr.Strings
	 * @param type of World (String)
	 * @param levelDataID (String)
	 * @return created GameWorld, or null if world specified wasn't found.
	 * */
	public static GameWorld createWorld (String type, String levelDataID) { 
		GameWorld world;
		
		// Set the WorldType of the return to create a custom World class in game
		switch (type.toLowerCase()) {
			case "forestmap":
			case "forest map":
				world =  new ForestMap_test(levelDataID);
				break;
			case "templemap":
			case "temple map":
				world = new TempleMap_test(levelDataID);	
				break;
			case "mylevel":
			case "my level":
				world = new MyLevel(levelDataID);	
				break;	
			case "snakehub":
			case "snake hub":
			case "mainmenu":
			case "main menu":
				world = new VisualBlankWorld();
				break;
				
			//Blank Worlds
			case "visualblank":
			case "visual blank":	
				world = new VisualBlankWorld();
				break;
			case "blank":
				world = new BlankWorld();
				
			default:
				System.out.println("Map type " + type + " not found");
				return null;
		}
		
		return world;
		
	}
	
	/** Creates Stage for GameWorld as specified in method getPrefferedStage(). Can be customized as desired.
	 * 
	 * @author Mr.Strings (Modifiable according to need)
	 * 
	 * @param batch
	 * @param level - Current level
	 * @param world - World to be Staged
	 * @return Stage - Stage created
	 */
	public static LevelStage createWorldStage (Batch batch, SnakeScreen level, GameWorld world) {
		LevelStage stage;
		
		 //change StageType here
		switch  (world.getPrefferedStage().toLowerCase()) {
			case "worldstage":
			case "world stage":
				stage = new LevelStage(level, createWorldViewport(world), batch);
				break;
			case "visualworldstage":	
			case "visual world stage":
				stage = new VisualWorldStage(level, createWorldViewport(world), batch);
				break;
			default:
				System.out.println ("Stage not found. Please check getPreferredStage() method in world");
				return null;
		}
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
		camera.translate(WorldSettings.getCameraPosX() - width/2, WorldSettings.getCameraPosY() - height/2, 0);
		
		return  stage;
	}
	
	/** Creates Viewport for GameWorld to fit
	 * 
	 * @param world
	 * @return Viewport
	 */
	public static Viewport createWorldViewport(GameWorld world) {
		OrthographicCamera camera = new OrthographicCamera();
		
		//creates viewport that stretches to fit resolution
		Viewport viewport = new StretchViewport(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight(), camera);
		
		camera.zoom = 1/WorldSettings.getWorld2ScreenRatio();
		
		return viewport;
	}
}
