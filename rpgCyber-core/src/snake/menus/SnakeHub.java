package snake.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import snake.engine.creators.ScreenCreator;
import snake.engine.models.HUD;


/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Example menu for SnakeEngine </br>
 * @author Mr.Strings
 */

public class SnakeHub extends HUD {
	private BitmapFont font;
	private GlyphLayout layout;
	private float w, h;
	String instructions[]; //will be changed to buttons

	public SnakeHub() {
		this.font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		this.layout = new GlyphLayout();

		font.setColor(Color.GREEN);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		instructions = new String[3];
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}
	
	/** updates Screen logic */
	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
			String[] param = {"SnakeScreen", "TempleMap", "Some random Data"};
			try {
				ScreenCreator.switchAndGo(param);
			} catch (Exception e) {
				System.out.println("Cannot create Screen.");
			}
		}

		instructions[0] = "Para comecar o jogo";
		instructions[1] = "tecle ENTER";
	}
	
	
	/** Draws figures on Screen */
	@Override
	public void draw(Batch batch, float parentAlpha){

		//Drawing touch input
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched())
			font.draw(batch, "You're touching it! (maybe pressing space button).", 0, 80);

		//Drawing instructions
		layout.setText(font, instructions[0]);
		font.draw(batch, layout, w / 2 - layout.width / 2, h / 2 - layout.height / 2 + 50);
		layout.setText(font, instructions[1]);
		font.draw(batch, layout, w / 2 - layout.width / 2, h / 2 - layout.height / 2 - 20);


		font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), 0, h*99/100);
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
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}

