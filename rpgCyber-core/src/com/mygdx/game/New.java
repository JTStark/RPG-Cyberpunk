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
			ScreenCreator.addAndGo(new TextLevel("O ano eh 2119, os personagens encontram-se em Delta City, "
											   + "uma gigantesca metropole riquissima erguida sobre a decadencia "
											   + "da antiga Nova York. Eh noite, o tempo esta quente, o ceu, "
											   + "repleto de nuvens de poeira e foligem, provenientes dos carros, que "
											   + "encobrem a luz das estrelas e tornam parcialmente turva a luz da "
											   + "lua que invade o quarto do dr. Norman Walker, um empreendedor, cuja empresa "
											   + "esta comecando a assustar as maiores.\n"
											   + "O telefone toca, e traz uma noticia nada agradavel: Ashley, a filha do "
											   + "dr. Walker foi sequestrada pela CEO de uma dessas grandes empresas.\n"
											   + "Desesperado, Norman resolve pedir ajuda ao dr. Angus Silvana, outro empresario "
											   + "de respeito que jah havia feito uma oferta pelo trabalho de sua vida.\n"
											   + "Entao, por troca de 51% das acoes das Walker Enterprises, Silvana resolve "
											   + "ajuda-lo, e chama seu grupo de mercenarios para resgatar a garota.\n\n"
											   + "Walker suspeita que sua filha encontra-se no predio a oeste daquele "
											   + "em que se encontram.\n"), new TextHUB());
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