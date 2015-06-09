package umbra;

public interface IComunicator {

    public void newText(String fullText, float width, float hight, float textSize, boolean cursorOn);
    public void newText(String fullText, float width, float hight, int letters, boolean cursorOn);
    public String getInput();
    public boolean update(float dt);
    public void draw();
    public void dispose();

}
