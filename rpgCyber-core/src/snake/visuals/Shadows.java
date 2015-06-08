package snake.visuals;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;



/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
<br> Controls application shadow system </br>
 * @author Mr.Strings
 */

public abstract class Shadows {
	
	/** Creates circle shadow source */
	public static ShadowSource createCircleShadowSource(float radius, float posx, float posy) {
		
		CircleShape circle = new CircleShape();
		circle.setRadius(radius);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		
		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.fixedRotation = true;
		
		bodyDef.position.set(posx, posy);
	
		ShadowSource shadow = new ShadowSource();
		shadow.createBody (Lights.getWorld().createBody(bodyDef));

		shadow.body.createFixture(fixtureDef);

		circle.dispose();
		
		return shadow;
	}
	
	/** Creates rectangular shadow source */
	public static ShadowSource createRectShadowSource (float width, float height, float posx, float posy) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		
		bodyDef.position.set(posx, posy);
		
		ShadowSource shadow = new ShadowSource();
		shadow.body = Lights.getWorld().createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
      
        shape.setAsBox(width/2, height/2);
        
        shadow.body.createFixture(shape, 0);
		
		return shadow;
	}
	
	
	/** Creates custom shadow source, using Box2d bodies */
	public static ShadowSource createShadowSource (BodyDef bodyDef) {
		ShadowSource shadow = new ShadowSource();
		shadow.body = Lights.getWorld().createBody(bodyDef);
		return shadow;
	}
	
	
	/** Removes shadow Source */
	public static void removeShadowSource (Body shadow) {
		Lights.getWorld().destroyBody(shadow);
	}
}
