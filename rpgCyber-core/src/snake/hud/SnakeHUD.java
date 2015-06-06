package snake.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import snake.engine.models.HUD;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * Game HUD, to display status and general information
 * 
 * @author Mr.Strings
 */


public class SnakeHUD extends HUD {
	SnakeInfosHUD infos;
	SnakeDialogHUD dialog;
	BitmapFont font;
	
	public SnakeHUD (String levelData) {
		super();
		
		infos = new SnakeInfosHUD();
		dialog  = new SnakeDialogHUD();
		
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
	}
	
	
	public void show() {
		//TODO: Auto-generated method snub
	}
	
	
	public void draw(Batch batch, float parentAlpha) {
		// Draw fps
		font.setColor(Color.GREEN);
		
		font.getData().setScale(1f);
		if (Gdx.input.isKeyPressed(Input.Keys.H) || Gdx.input.isTouched())
			font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, this.getHeight());
		
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			font.setColor(Color.MAGENTA);
			font.draw(batch, "Wow. Just... Wow.", 50, 50);
		}
		
		font.setColor(Color.ORANGE);
		font.getData().setScale(.5f);
		if (Gdx.input.isKeyPressed(Input.Keys.H))
			font.draw(batch, "Use Directional Arrows and IJKL for moving, YU and OP for zooming", this.getWidth()/4, this.getHeight() * 99/100);
		//Ends drawing
	}


	@Override
	public void dispose() {
		font.dispose();
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
}
