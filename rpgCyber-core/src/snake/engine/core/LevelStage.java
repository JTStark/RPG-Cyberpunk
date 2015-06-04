package snake.engine.core;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 *  Extension of stage -- gives easy access to level and, consequently, elements in it
 *  @author Mr.Strings
 */


public class LevelStage extends Stage{
	private SnakeScreen level;
	
	public LevelStage(SnakeScreen level) {
		super();
		this.level = level;
	}
	
	public LevelStage(SnakeScreen level, Viewport viewport) {
		super(viewport);
		this.level = level;
	}
	
	public LevelStage(SnakeScreen level, Viewport viewport, Batch batch) {
		super(viewport, batch);
		this.level = level;
	}
	
	/* ---------------- Getters --------------- */
	public SnakeScreen getLevel() {
		return level;
	}	
}
