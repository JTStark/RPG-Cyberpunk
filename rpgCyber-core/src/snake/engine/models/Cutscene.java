package snake.engine.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Interface for cutscene support </br>
 * @author Mr.Strings
 */

public interface Cutscene {
	
	public void draw();
	public void act(float delta);

	public void begin(String name);
	
	public boolean isRunning();
	
	public void setBatch (SpriteBatch batch);
}
