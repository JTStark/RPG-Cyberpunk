package snake.engine.models;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *          
 *  <br> Interface for a starting point (core) of a Game. </br>
 *  <br> See snake.core.SnakeStart for an example implementation.</br>
 * @Author Mr.Strings
 */

public abstract class GameStart extends Game{
	protected Batch batch;
	
	public Batch getBatch() {return batch;}
}
