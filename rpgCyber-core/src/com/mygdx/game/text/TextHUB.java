package com.mygdx.game.text;


	import box2dLight.Light;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.mygdx.game.androidkeys.AndroidInput;
import com.mygdx.game.levels.MyHUD;
import com.mygdx.game.levels.MyLevel;

import snake.engine.creators.ScreenCreator;
import snake.engine.models.HUD;
import snake.hud.SnakeHUD;


	/**                               Developed By:
	 *                                  NoDark
	 *                               sessaGlasses
	 *                               
	 * <br> Example menu for SnakeEngine </br>
	 * @author Mr.Strings
	 */

	public class TextHUB  extends HUD {
		private BitmapFont font;
		private GlyphLayout layout;
		Light light;
		private float w, h;
		String instructions[]; //will be changed to buttons
		private int i = 0;
		public TextHUB() {
	
			this.font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
			this.layout = new GlyphLayout();



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
			
		}
		/** Draws figures on Screen */
		@Override
		public void draw(Batch batch, float parentAlpha){
			
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

