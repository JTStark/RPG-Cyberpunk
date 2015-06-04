package snake.engine.creators;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * <br> Controls World Parameters, such as size, camera infos, virtual Screen Parameters, etc. </br>
 * <br>
 * 		Note: Customization in Factory type methods (such as createWorld() and createWorldStage()) and
 * 		attributes is recommended.
 * </br>
 * @author Mr.Strings 
 * 
 * 
 * 
 */
public class WorldSettings {
	private static float WORLD_WIDTH = 100, WORLD_HEIGHT = heightFix(100); //Arbitrary coordinate System.
	private static float WORLD2SCREEN_RATIO = 1f; //Relative to World (Changeable)
	private static float CAMERAPOSITIONX = 50,  CAMERAPOSITIONY = heightFix(50); //center of camera position (Changeable)
	private static float MAXZOOM = .1f, MINZOOM = 1f;
	private static boolean HAS_VIRTUAL_SCREEN = true; //Defines if World camera occupies whole screen or is clipped
	private static float VSCREEN_X_PORC = 0f, VSCREEN_Y_PORC = 0f; // Starting point of Virtual Screen (if set) (porcentage to Screen Size
	private static float VSCREEN_WIDTH_PORC = 1f, VSCREEN_HEIGHT_PORC = 1f; //Size of Virtual Screen (porcentage to Screen Size)
	private static float VSCREEN_MINSIZE = .3f, VSCREEN_MAXSIZE = 1;
	//IMPORTANT NOTE -- VSCREEN is UNreliable if it goes beyond the Screen size
	
	
	public static Color ambientColor = new Color (0f, 0f, 0f, 1f);
	
	
	
	/** Adjusts the height so that 0 is the bottom of the world and 100 is the top of it.
	 *  Should be used when drawing or positioning objects of GameWorld. 
	 */
	public static float heightFix (float height) {
		return height * Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
	}
	
	
	
	/* ------------------------------ Getters ------------------------------ */
	
	/** Gets World Width - arbitrary coordinate System
	 * 
	 * @return WORLD_WIDTH
	 */
	public static float getWorldWidth() {
		return WORLD_WIDTH;
	}
	
	/** Gets World Height - arbitrary coordinate System
	 * 
	 * @return WORLD_WIDTH
	 */
	public static float getWorldHeight() {
		return WORLD_HEIGHT;
	}
	
	/** Gets World/Screen ratio
	 * 
	 * @return ratio
	 */
	public static float getWorld2ScreenRatio() {
		return WORLD2SCREEN_RATIO;
	}
	
	/** Gets Camera Center coordinate X - arbitrary coordinate System
	 * 
	 * @return CameraCenterX
	 */
	public static float getCameraPosX() {
		return CAMERAPOSITIONX;
	}
	
	/** Gets Camera Center coordinate Y - arbitrary coordinate System
	 * 
	 * @return CameraCenterY
	 */
	public static float getCameraPosY() {
		return CAMERAPOSITIONY;
	}
	
	/** Gets Camera's max zoom
	 * 
	 * @return MAXZOOM
	 */
	public static float getMaxZoom() {
		return MAXZOOM;
	}
	
	/** Gets Camera's minimum zoom
	 * 
	 * @return MINZOOM
	 */
	public static float getMinZoom() {
		return MINZOOM;
	}
	
	
	/** True if virtual screen is toggled on
	 * 
	 * @return boolean
	 */
	public static boolean hasVirtualScreen () {
		return HAS_VIRTUAL_SCREEN;
	}
	
	/** gets Virtual Screen starting point X(Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenX_Porc() {
		return VSCREEN_X_PORC;
	}
	
	/** gets Virtual Screen starting point Y (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenY_Porc() {
		return VSCREEN_Y_PORC;
	}
	
	/** gets Virtual Screen Width (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenWidth_Porc() {
		return VSCREEN_WIDTH_PORC;
	}
	
	/** gets Virtual Screen Height (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenHeight_Porc() {
		return VSCREEN_HEIGHT_PORC;
	}
	
	/** gets Virtual Screen MaxSize (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenMaxSize() {
		return VSCREEN_MAXSIZE;
	}
	
	/** gets Virtual Screen MinSize (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenMinSize() {
		return VSCREEN_MINSIZE;
	}
	
	public static Color getAmbientColor() {
		return ambientColor;
	}
	/* ------------------------------ Setters ------------------------------ */
	
	/** Sets Camera Center coordinates - arbitrary coordinate System.*/
	public static void setCameraPosition(float posX, float posY) {
		CAMERAPOSITIONX = posX;
		CAMERAPOSITIONY = posY;
	}
	
	/** Sets World size - arbitrary coordinate System.*/
	public static void setWorldSSize(float sizex, float sizey) {
		WORLD_WIDTH = sizex;
		WORLD_HEIGHT = sizey;
	}
	
	/** Sets World/screen ratio. */
	public static void setWorld2ScreenRatio(float ratio) {
		WORLD2SCREEN_RATIO = ratio;
	}
	
	/** Toggles virtual screen.*/
	public static void toggleVirtualScreen (boolean option) {
		HAS_VIRTUAL_SCREEN = option;
	}
	
	/** Sets virtual screen (viewport) to draw */
	public static boolean setVirtualScreen (float x, float y, float width, float height) {
		if (x >= 0 && x + width <= 1) {
			VSCREEN_X_PORC = x;
			VSCREEN_WIDTH_PORC = width;
		}
		else
			return false;
		
		
		if (y >= 0 && y + height <= 1) {
			VSCREEN_Y_PORC = y;
			VSCREEN_HEIGHT_PORC = height;
		}
		else
			return false;

		return true;
	}
	
	public static void setAmbientColor(Color color) {
		ambientColor = color;
	}
	
}
