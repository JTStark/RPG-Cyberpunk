package snake.engine.models;

import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.core.LevelStage;
import snake.engine.creators.WorldSettings;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Class for a World of the game -- Can be anything such as 2D side-scroller or top-down, or even fully 3D game (although
 * the focus is on 2D) </br>
 * Module: Mr.Strings
 */


public abstract class GameWorld extends Group /* Group makes it connected to MapEntities */ {
	
	public GameWorld () {
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight()); //Sets world size to be displayed on screen
	}
	
	public String getPrefferedStage() {
		return new String ("LevelStage");
	}
	
	
	/** Is called when the Screen in which the GameWorld is is set to current.*/
	public abstract void show();
	
	/** Is called when the Screen in witch the GameWorld is is hidden -- usually in Android apps */
	public abstract void hide();
	
	/** Is called when the Screen in witch the GameWorld is is paused -- usually in Android apps */
	public abstract void pause();
	
	/** Is called when the Screen in witch the GameWorld is gains focus */
	public abstract void resume();
	
	@Override
	public LevelStage getStage() {
		return (LevelStage) super.getStage();
	}
	
	
	public abstract void dispose();
	
	
}
