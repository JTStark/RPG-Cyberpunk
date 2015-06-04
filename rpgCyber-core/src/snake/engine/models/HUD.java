package snake.engine.models;

import snake.engine.creators.HUDSettings;
import com.badlogic.gdx.scenes.scene2d.Group;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 *  <br> Generic game HUD -- information screens </br>
 * @author Mr.Strings
 */


public abstract class HUD extends Group {

	public HUD() {
		this.setBounds(0, 0, HUDSettings.getHudWidth(), HUDSettings.getHudHeight());
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
	
	
	public abstract void dispose();
}
