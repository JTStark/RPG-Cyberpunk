package com.mygdx.game;

import snake.engine.models.*;
import snake.engine.creators.ScreenCreator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.menus.MyHub;
import com.mygdx.game.menus.MyLevelMenu;
import com.mygdx.game.text.TextHUB;
import com.mygdx.game.text.TextLevel;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @Author Mr.Strings
 */

public class New extends GameStart {
	

	public void create () {
		super.batch = new SpriteBatch();
		ScreenCreator.setGameInstance(this);
		
		try {
			ScreenCreator.addAndGo(new TextLevel("0la"), new TextHUB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScreenCreator.updateScreens();
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}