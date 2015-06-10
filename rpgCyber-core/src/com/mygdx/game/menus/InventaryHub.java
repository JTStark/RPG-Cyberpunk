package com.mygdx.game.menus;


	import implementations.inventario.Inventario;
import implementations.inventario.Item;
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
import com.mygdx.game.text.TextHUB;
import com.mygdx.game.text.TextLevel;

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

	public class InventaryHub  extends HUD {
		private BitmapFont font;
		private GlyphLayout layout;
		Light light;
		private float w, h;
		String instructions[]; //will be changed to buttons
		private int i = 0;
		private Inventario inv = Inventario.getInstancia();
		public InventaryHub() {
	
			this.font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
			this.layout = new GlyphLayout();
			for(int i = 0; i<10;i++)
				Inventario.getInstancia().adicionar_item(Item.geraAleatorio().getName());


			w = Gdx.graphics.getWidth();
			h = Gdx.graphics.getHeight();
			
			instructions = new String[10];
		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
		}
		
		/** updates Screen logic */
		@Override
		public void act(float delta) {
			if (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.justTouched()) {
				if(i ==0){	
					try {
						ScreenCreator.addAndGo(new MyLevel("Mapas/MapaExterno.tmx"), new MyHUD("LevelData"));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(i ==2){
					Gdx.app.exit();
				}
			}if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) {
					try {
						ScreenCreator.backToPrevious();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
				if(i <= 0)
					i = 0;
				else{
					i--;
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
				if(i >= 9)
					i = 9;
				else{
					i++;
				}
			}
			for(int i = 0;i<10;i++){
				if( inv.getMochila(0, 9).get(i).getName() != null){
				instructions[i] = inv.getMochila(0, 9).get(i).getName();
				}else{
					instructions[i] = "None";
				}
			}
		}
		
		
		/** Draws figures on Screen */
		@Override
		public void draw(Batch batch, float parentAlpha){
			//Drawing touch input
			if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isTouched())
				font.draw(batch, "You're touching it! (maybe pressing space button).", 0, 80);

			//Drawing instructions
			for(int j = 0 ; j<10;j++){
				if(i==j){
					font.setColor(Color.RED);
					layout.setText(font, instructions[j]);
					font.draw(batch, layout, w / 2 - layout.width / 2 +100, h / 2 - layout.height / 2 + 280-j*40);
					font.setColor(Color.WHITE);
				}else{
					layout.setText(font, instructions[j]);
					font.draw(batch, layout, w / 2 - layout.width / 2 +100, h / 2 - layout.height / 2 + 280-j*40);
				}
			
			}
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

