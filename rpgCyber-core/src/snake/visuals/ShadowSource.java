package snake.visuals;

import com.badlogic.gdx.physics.box2d.Body;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> a generic shadow source </br> 
 * @author Mr.Strings
 */


public class ShadowSource {
	Body body;

	ShadowSource() {}
	
	void createBody (Body body) {
		this.body = body;
	}
	
	
	public void moveBody (float x, float y) {
		moveBody(x, y, 0);
	}
	
	public void moveBody (float x, float y, float angle) {
		body.setTransform((body.getPosition().x + x) * Lights.CONVERT2PHYSICS,
				(body.getPosition().y + y)* Lights.CONVERT2PHYSICS, angle);
	}
	
	
	
	public Body getBody () {
		return body;
	}
	
	
	public void destroyShadow() {
		Lights.getWorld().destroyBody(body);
	}
}
