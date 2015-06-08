package snake.engine.creators;

/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * @author Mr.Strings (Modifiable according to need)
 * 
 * Controls HUD Parameters, such as size, camera infos, etc.
 */

public abstract class HUDSettings {
	private static float HUD_WIDTH = 1280, HUD_HEIGHT = 720;
	private static float CAMERAPOSITIONX = 640, CAMERAPOSITIONY = 360;
	
	
	
	/* ------------------------------ Getters ------------------------------ */
	public static float getHudWidth() {
		return HUD_WIDTH;
	}
	
	public static float getHudHeight() {
		return HUD_HEIGHT;
	}
	
	public static float getCameraPosX() {
		return CAMERAPOSITIONX;
	}
	
	public static float getCameraPosY() {
		return CAMERAPOSITIONY;
	}
	
	/* ------------------------------ Setters ------------------------------ */
	public static void setCameraPosition(float posX, float posY) {
		CAMERAPOSITIONX = posX;
		CAMERAPOSITIONY = posY;
	}
	public static void setHUDSSize(float width, float height) {
		HUD_WIDTH = width;
		HUD_HEIGHT = height;
	}
	
	
}
