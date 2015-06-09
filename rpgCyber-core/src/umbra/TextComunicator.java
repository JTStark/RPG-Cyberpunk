package umbra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;


public class TextComunicator implements IComunicator, InputProcessor {

    // Define constants
    static final float textSpeed = 0.5f;

    // Flags
    private boolean cursor;
    private boolean cursorOn;
    private boolean end; // true when the text is written entirely
    private boolean inputReady;
    private boolean readInput;
    
    private float hight;
    private float width;
    private float textSize;
    private BitmapFont font;
    private SpriteBatch batch;
    private String text;
    private String fullText;
    private int index;
    StringBuilder input;
    // counter of updates
    private float counter;

    public TextComunicator(){
        batch = new SpriteBatch();

        // initialize font
        try {
            font = new BitmapFont(Gdx.files.internal("Fonts/proggy.fnt"));
        }catch (GdxRuntimeException e){
        	font = new BitmapFont();
        }
        font.setColor(1,1,1,1);

        newText("", 0,0,0,false);
    }

    public void newText(String fullText, float width, float hight, int letters, boolean cursorOn){
        newText(fullText, width, hight, width + letters * font.getSpaceWidth(), cursorOn);
    }

    public void newText(String fullText, float width, float hight, float textSize, boolean cursorOn){
        if(cursorOn) Gdx.input.setInputProcessor(this);
        this.width = width;
        this.hight = hight;
        this.textSize = textSize;
        this.cursorOn = cursorOn;
        if(cursorOn) {
            //if(this.fullText == null || !this.fullText.equals(fullText)) {
                this.fullText = fullText;
                counter = 0;
                index = 0;
                text = "_";
                readInput = false;
                end = false;
            //} else {
            //    text = fullText + "_";
            //}
            inputReady = false;
            cursor = true;
            input = new StringBuilder();
        }else{
            text = fullText;
        }
    }

    public String getInput(){
    	readInput = true;
    	if(inputReady){
    		return input.toString();
    	}else{
    		return null;
    	}
    }

    public boolean update(float dt){
        if(cursorOn) {
            end = end || (fullText.length() + 1 == text.length());
            // Control of text speed
            counter += dt;
            if (counter > textSpeed * dt) {
                if (!end) {
                    nextChar(dt);
                } else {
                    // no more characters to add start blink cursor
                    blink(dt);
                }
                counter = 0;
            }
            return end;
        }else{
            return true;
        }
    }

    public void addChar(char c){
    	if(end){
    		text = text.substring(0, text.length() - 1);
            text += c;
            text += '_';
    	}
    }
    
    private void nextChar(float dt){
        text = text.substring(0, text.length() - 1);
        text += fullText.charAt(index);
        text += '_';
        index++;
    }

    private void blink(float dt) {
        text = text.substring(0, text.length() - 1);
        if (cursor) text += ' ';
        else text += '_';
        cursor ^= true;
    }

    public void draw(){
        batch.begin();
        if(text != null){
        	if(hight - 200 - ((font.getCapHeight()*text.length())/(Gdx.graphics.getWidth() - 300))*font.getCapHeight() < 0) hight += font.getCapHeight();
        	font.draw(batch,text,width,hight,textSize,-5,true);
        }
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
    
    @Override
	public boolean keyTyped(char character) {
		if(readInput && ( (character <= 'Z' && character >= 'A') || (character <= 'z' && character >= 'a') ||
                (character <= '9' && character >= '0') || character == ' ') ){
			input.append(character);
			addChar(character);
		}
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(readInput){
            if(keycode == Input.Keys.ENTER) inputReady = true;
            if(keycode == Input.Keys.BACKSPACE){
                input = new StringBuilder();
                text = fullText + ( (cursor) ? "_" : " ");
            }
		}
		return false;
	}

	/* unused methods of InputProcessor */
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
