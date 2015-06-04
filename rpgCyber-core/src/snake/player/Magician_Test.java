package snake.player;

import box2dLight.ConeLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.engine.creators.WorldSettings;
import snake.engine.models.GameWorld;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;



/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Player for testing purposes at TempleMap </br>         
 * 
 * @author Mr.Strings
 * 
 */

public class Magician_Test extends LightMapEntity {
	
	private ConeLight light;
	private Sprite sprite;
	
	
	public Magician_Test (GameWorld world) {
		super(world);
		//Procedimento padrao para carregar uma imagem -- vai ser melhorado com o assetManager
		Texture texture = new Texture(Gdx.files.internal("magician.png")); //cria textura
		sprite = new Sprite(texture); // coloca na sprite
		sprite.setAlpha(1f); //Transparencia -- de 0 a 1 (0 eh invisivel)
		
		this.setBounds(40, WorldSettings.heightFix(20), 30, 30); // Perceba o heightFix -- otimo para trabalhar com porcentagem em relacao ao mundo
		//... Com o heightFix, o topo fica 100, o chao fica 0 (Highly recommended)
		this.setOrigin(13, 16); // A origem ficou zoada pois o PNG nao ficou bom -- arrumar isso
	}
	
	@Override
	public void act (float delta) { // Aqui se realizam as atualizacoes
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			this.setRotation(270);
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			this.setRotation(0);
		}else
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			this.setRotation(90);
		}
		 
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			this.setRotation(180);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.C)) {
			this.rotateBy(5);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.V)) {
			this.rotateBy(-5);
		}
		
		light.setPosition(getOriginX() + getX(), getOriginY() + getY());
		light.setDirection(getRotation() + 90);
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		//sprite.draw(batch);
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	@Override
	public boolean hasLights() {
		return false;
	}

	@Override
	public void createLights() { //Criacao de luzes tem que ser algo separado (senao da pau) -- tudo aqui
		light = new ConeLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f),
				   			   100, 50, WorldSettings.heightFix(50), 90, 30);
	} //Se quiser destruir a luz, pode ser em qualquer lugar

	@Override
	public void disposeLights() {
		light.remove(); // IF you don't remove stuff gets crazy
		light.dispose();
	}
}
