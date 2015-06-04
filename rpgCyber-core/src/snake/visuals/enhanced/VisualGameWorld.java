package snake.visuals.enhanced;

import snake.engine.models.GameWorld;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Extension of game world that supports lights </br>
 * Module: Mr.Strings
 */


public abstract class VisualGameWorld extends GameWorld{
	
	@Override
	public String getPrefferedStage() {
		return new String ("Visual World Stage");
	}
	
	public abstract void createLights();
	
	
	@Override
	public VisualWorldStage getStage() {
		return (VisualWorldStage) super.getStage();
	}
}
