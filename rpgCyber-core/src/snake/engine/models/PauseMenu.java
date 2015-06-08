package snake.engine.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> simple interface for PauseMenu </br>
 * @author Mr.Strings
 */


public interface PauseMenu {
	
	public void act(float delta);
	
	public void draw();
	
	public void setBatch (SpriteBatch batch);
}
