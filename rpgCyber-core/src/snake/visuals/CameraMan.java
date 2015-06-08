package snake.visuals;

import snake.engine.creators.WorldSettings;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Useful for controlling a camera in a Scene2d Stage. Can Zoom, translate and supports virtual
 * screen size based on WorldSettings Data.</br>
 * <br> Also, sets light for awesome illumination </br>
 * @author Mr.Strings
 * 
 */

public class CameraMan {
	private OrthographicCamera camera;
	private boolean virtualScreen = false;
	private World physicsWorld;
	
	private RayHandler rayHandler;
	
	/** Creates CameraMan with Stage
	 * Note: Only works with OrthographicCamera
	 * @param stage
	 * @Throws UnsupportedOperationException - in case stage passed has unsupported camera type
	 */
	public CameraMan (Stage stage) {
		
		/* Get Stage Camera */
		if (stage.getCamera() instanceof OrthographicCamera)
			camera = (OrthographicCamera) stage.getCamera();
		else {
			throw new UnsupportedOperationException("CameraMan only works with OrthographicCamera for now");
		}
	}
	
	/** Sets virtual Screen to draw, according to WorldSettings Class
	 * @see snake.engine.levelSettings.WorldSettings
	 */
	public void setCamera () {
		     
		if (WorldSettings.hasVirtualScreen()) {
			Gdx.gl.glViewport((int)(WorldSettings.getVScreenX_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenY_Porc() * Gdx.graphics.getHeight()),
							  (int)(WorldSettings.getVScreenWidth_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenHeight_Porc()  * Gdx.graphics.getHeight()));
			virtualScreen = true;
		}
	}
	
	/** "Unsets" virtual Screen
	 */
	public void unsetCamera () {
		Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if (virtualScreen) {
			virtualScreen = false;
		}
	}
	
	/** Translate Camera keeping it in WorldBounds
	 * @see CameraMan#keepInBounds()
	 */
	public void moveCamera (float x, float y) {
		camera.translate(x, y); //Translate camera
		keepInBounds();

		WorldSettings.setCameraPosition(camera.position.x, camera.position.y);
		
	}
	
	
	/** Zooms Camera keeping it in WorldBounds
	 * @see CameraMan#keepInBounds()
	 */
	public void zoomCamera (float zoom) {
		camera.zoom += zoom;
		camera.zoom = MathUtils.clamp(camera.zoom, WorldSettings.getMaxZoom(), WorldSettings.getMinZoom());
		WorldSettings.setWorld2ScreenRatio(1/camera.zoom);
		keepInBounds();
		
	}
	/** Keeps Camera in World Bounds. Adapted from link below
	 * @see https://github.com/libgdx/libgdx/wiki/Orthographic-camera
	*/
	private void keepInBounds () {
		float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f,
        									WorldSettings.getWorldWidth() - effectiveViewportWidth / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f,
        									WorldSettings.getWorldHeight() - effectiveViewportHeight / 2f);
    }
	
	/** translates VirtualScren keeping it in Bounds */
	public void moveVCamera (float x, float y) {
		WorldSettings.setVirtualScreen(MathUtils.clamp(WorldSettings.getVScreenX_Porc() + x, 0, 1 - WorldSettings.getVScreenWidth_Porc()), 
									   MathUtils.clamp(WorldSettings.getVScreenY_Porc() + y, 0, 1 - WorldSettings.getVScreenHeight_Porc()),
									   WorldSettings.getVScreenWidth_Porc(),
									   WorldSettings.getVScreenHeight_Porc());
	}
	
	public void zoomVCamera (float zoom) {
		float beforeX = WorldSettings.getVScreenWidth_Porc();
		float afterX = (float) MathUtils.clamp(beforeX/(1 + zoom), WorldSettings.getVScreenMinSize(), WorldSettings.getVScreenMaxSize());
		float beforeY = WorldSettings.getVScreenWidth_Porc();
		float afterY = (float) MathUtils.clamp(beforeY/(1 + zoom),WorldSettings.getVScreenMinSize(), WorldSettings.getVScreenMaxSize());
		WorldSettings.setVirtualScreen(MathUtils.clamp(WorldSettings.getVScreenX_Porc() - (afterX - beforeX)/2, 0, 1 - afterX),
									   MathUtils.clamp(WorldSettings.getVScreenY_Porc() - (afterY - beforeY)/2, 0, 1 - afterY),
										afterX, afterY);
	}
	
	
	/** Adds light support */
	public void addLightSupport (float ratio) {
		physicsWorld = Lights.createWorld(ratio);
		
		RayHandler.setGammaCorrection(true);
		RayHandler.useDiffuseLight(true);
			 
		rayHandler = Lights.createRayHandler(physicsWorld);
	}
	
	
	/** Sets lights to be updated and rendered accordingly */
	public void setLights() {
		Lights.setWorld(physicsWorld);
		Lights.setRayhandler(rayHandler);
		rayHandler.setAmbientLight(WorldSettings.getAmbientColor());
		rayHandler.setBlurNum(3);
		rayHandler.useCustomViewport((int)(WorldSettings.getVScreenX_Porc() * Gdx.graphics.getWidth()),
							         (int)(WorldSettings.getVScreenY_Porc() * Gdx.graphics.getHeight()),
							         (int)(WorldSettings.getVScreenWidth_Porc() * Gdx.graphics.getWidth()),
							         (int)(WorldSettings.getVScreenHeight_Porc()  * Gdx.graphics.getHeight()));
		rayHandler.setCombinedMatrix(camera);
	}
	
	
	/** Calls rayHandler's update and render */
	public void updateAndRenderLights()  {
		if (rayHandler == null)
			System.out.println("Error: RayHandler wasnt created.");
	
		rayHandler.updateAndRender();
	}

	
	public OrthographicCamera getCamera() {
		return camera;
	}
}
