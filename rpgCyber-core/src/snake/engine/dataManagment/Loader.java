package snake.engine.dataManagment;

import com.badlogic.gdx.assets.AssetManager;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: ------
 */

public class Loader {
	private static AssetManager assetMan = null;
	
	private Loader() {};
	
	public static AssetManager getManager () {
		if (assetMan == null)
			assetMan = new AssetManager ();
		return assetMan;
	}
}