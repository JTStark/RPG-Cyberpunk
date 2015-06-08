package snake.map.sets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.engine.creators.WorldSettings;
import snake.engine.models.GameWorld;
import snake.visuals.ShadowSource;
import snake.visuals.Shadows;
import snake.visuals.enhanced.LightMapEntity;

public class Box_Test extends LightMapEntity{
	private Sprite sprite;
	private ShadowSource shadow;
	
	public Box_Test(GameWorld world) {
		super(world);
			
		//Procedimento padrao para se carregar uma textura
		Texture texture = new Texture(Gdx.files.internal("mysteryBox.png"));
		sprite = new Sprite(texture);
		this.setBounds(38, WorldSettings.heightFix(53), 23, 23);
		sprite.setAlpha(1f);
		
		this.setPosition(38, WorldSettings.heightFix(53));
		
	}
	
	@Override
	public void act(float delta) {}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}


	@Override
	public boolean hasLights() {
		return true;
	}

	@Override
	public void createLights() {
		shadow = Shadows.createRectShadowSource(15, 15, 50, WorldSettings.heightFix(70));
	}
	
	public void disposeLights() {
		shadow.destroyShadow();
	}
}
