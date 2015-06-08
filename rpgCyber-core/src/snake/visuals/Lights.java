package snake.visuals;

import box2dLight.RayHandler;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Controls application Light system.  </br>
 * @author Mr.Strings
 */

public class Lights {
	static float CONVERT2PHYSICS = 1;
	private static World physicsWorld;
	private static RayHandler handler;
	public static boolean isActive = true;
	
	
	
	
	/** Creates Box2d physics world for a illumination system
	 * 
	 * @param ratio - ratio between Box2dMeters and application measures 
	 * @return World created
	 */
	public static World	createWorld(float ratio) {
		
		physicsWorld = new World(new Vector2(0,0), true);
		CONVERT2PHYSICS = ratio;
		return physicsWorld;
	}
	
	/** Creates lights randler */
	public static RayHandler createRayHandler (World world) {
		handler = new RayHandler(world);
		return handler;
	}
	
	/** Sets current lights world -- based on box2d */
	public static void setWorld(World world) {
		physicsWorld = world;
	}
	
	/** Sets current rayHandler */
	public static void setRayhandler (RayHandler rayHandler) {
		handler = rayHandler;
	}
	
	/** set unity convertion ratio for physics (light) world */
	public static void setConversionRatio(float ratio) {
		CONVERT2PHYSICS = ratio;
	}
	/** Gets current rayHandler */
	public static RayHandler getRayhandler () {
		return handler;
	}
	
	/** Gets current physics (light) world */
	public static World getWorld() {
		return physicsWorld;
	}

}
