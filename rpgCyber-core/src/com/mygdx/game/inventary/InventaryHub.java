package com.mygdx.game.inventary;


	import implementations.inventario.Inventario;
import implementations.inventario.Item;
import box2dLight.Light;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
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
		private int i = 0, ini = 0, end = 9;
		static public Rectangle leftButton = new Rectangle(0,0,20,20)
		,rightButton= new Rectangle(200,0,20,20)
		,upButton=new Rectangle(100,200,20,20)
		,downButton =new Rectangle(100,0,20,20);
		boolean flagu = false,flagd = false;
		private OrthographicCamera camera;
		private Inventario inv = Inventario.getInstancia();
		public InventaryHub() {
	
			this.font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
			this.layout = new GlyphLayout();
			for(int i = 0; i<12;i++)
			camera = new OrthographicCamera();
			camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			camera.update();


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
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
				try{inv.remover_item(inv.getMochila(ini+i,ini + i+ 1).get(0).getName());}
				catch(Exception e){
					e.printStackTrace();
				}
			}if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) {
					try {
						ScreenCreator.backToPrevious();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			for(int i = 0; i <5;i++){
				if(Gdx.input.isTouched(i)){
					Vector3 touchPos = new Vector3(Gdx.input.getX(i),Gdx.input.getY(i),0);
					camera.unproject(touchPos);
					Rectangle touch = new Rectangle(touchPos.x-16,touchPos.y-16,32,32);
					if(touch.overlaps(upButton))
						flagu=true;
					if(touch.overlaps(downButton))
						flagd = true;
					}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.UP)||flagu){
				flagu=false;
				if(i <= 0){
					i = 0;
					if(ini<=0){
						ini = 0;
						end = 7;
					}else{
						end--;
						ini--;
					}	
				}else{
					i--;
				}
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)||flagd){
				flagd=false;
				if(i >= 7){
					i = 7;
					if(end>=39){
						end = 39;
						ini = 32;
					
					}else{
						end++;
						ini++;
					}
						
				}else{
					i++;
				}
			}
			for(int i = 0;i<8;i++){
				try{
				instructions[i] = (ini + i+1  + ".   " + inv.getMochila(ini, end).get(i).getName());
				}catch(Exception e){
					instructions[i] = (ini + i+1  + ".   " + "----------------------------------");
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
			for(int j = 0 ; j<8;j++){
				if(i==j){
					font.setColor(Color.RED);
					layout.setText(font, instructions[j]);
					font.draw(batch, layout, w / 2 - layout.width / 2 +345, h / 2 - layout.height / 2 +410-j*75);
					font.setColor(Color.WHITE);
				}else{
					layout.setText(font, instructions[j]);
					font.draw(batch, layout, w / 2 - layout.width / 2 +345, h / 2 - layout.height / 2 + 410-j*75);
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

