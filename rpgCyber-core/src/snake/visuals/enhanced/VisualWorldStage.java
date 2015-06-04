package snake.visuals.enhanced;

import snake.engine.core.LevelStage;
import snake.engine.core.SnakeScreen;
import snake.visuals.CameraMan;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * <br> Convenient extension of Stage for camera Handling and lights </br>
 * 
 * @author Mr.Strings
 */

public class VisualWorldStage extends LevelStage {
	private CameraMan cameraMan;
	
	public VisualWorldStage(SnakeScreen level) {
		super(level);
		cameraMan = new CameraMan(this);
		cameraMan.addLightSupport(1);
		
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
	}
	public VisualWorldStage(SnakeScreen level, Viewport viewport) {
		super(level, viewport);
		cameraMan = new CameraMan (this);
		cameraMan.addLightSupport(1);
		
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
	}
	public VisualWorldStage(SnakeScreen level, Viewport viewport, Batch batch) {
		super(level, viewport, batch);
		cameraMan = new CameraMan(this);
		cameraMan.addLightSupport(1);
		
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
	}
	
	@Override
	public void draw() {
		
		cameraMan.setCamera();
		super.draw();
		
		cameraMan.setLights();
		cameraMan.updateAndRenderLights();
		cameraMan.unsetCamera();
	}
	
	
	public CameraMan getCameraMan() {
		return cameraMan;
	}
}
