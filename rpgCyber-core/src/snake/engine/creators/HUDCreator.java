package snake.engine.creators;

import snake.engine.core.LevelStage;
import snake.engine.core.SnakeScreen;
import snake.engine.models.BlankHUD;
import snake.engine.models.HUD;
import snake.hud.SnakeHUD;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyHub;

/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Factory for HUD and HUDStages </br>
 * @author Mr.Strings (Modifiable according to need)
 */

public class HUDCreator {

	
	/**
	 * Creates HUD as specified. Can be customized as desired.
	 * @author Mr.Strings
	 * @param type of HUD (String)
	 * @param levelDataID (String)
	 * @return created HUD, or null if HUD specified was not found.
	 * */
	public static HUD createHUD (String type, String levelDataID) {
		HUD hud;
		
		switch (type.toLowerCase()) {
		
			case "templemap":
			case "temple map":
			case "forestmap":
			case "forest map":
				hud = new SnakeHUD (levelDataID); //can be changed for another HUD
				break;
			case "snakehub":
			case "snake hub":
			case "mainmenu":
			case "main menu":
				hud = new MyHub();
				break;
			case "blank":
				hud = new BlankHUD();
				break;
			default:
				System.out.println("HUD type " + type + " not found");
				return null;
		}
		
		return hud;
	}
	
	
	/** 
	 * Creates Viewport for HUD. Can be customized as desired.
	 * @param hud
	 * @return created Viewport
	 */
	public static Viewport createHUDViewport(HUD hud) {
		Camera camera = new OrthographicCamera();
		return new StretchViewport(HUDSettings.getHudWidth(), HUDSettings.getHudHeight(), camera); //Aspect ratio Strategy for multiple screen resolutions
	}
	
	
	/** 
	 * Creates Stage for HUD as specified in method getPrefferedStage(). Can be customized as desired.
	 * @param batch
	 * @param level - Current level
	 * @param hud - hud to be Staged
	 * @return Stage - Stage created, or null if stage specified wasn't found.
	 */
	public static LevelStage createHUDStage (Batch batch, SnakeScreen level, HUD hud) {
		LevelStage stage;
		
		switch (hud.getPrefferedStage().toLowerCase()) {
			case ("levelstage"):
			case ("level stage"):
				stage = new LevelStage(level, createHUDViewport(hud), batch);
				break;
			default:
				System.out.println("Stage not found. Please check getPreferredStage() method in HUD");
				return null;
		}
		
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		stage.getViewport().getCamera().translate(HUDSettings.getCameraPosX() - width/2, HUDSettings.getCameraPosY() - height/2, 0);
		
		return  stage;
	}
	
}
