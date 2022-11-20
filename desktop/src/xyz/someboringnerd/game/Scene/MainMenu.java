package xyz.someboringnerd.game.Scene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.Util.Scene;

public class MainMenu extends Scene
{

    private ImageTextButton QuitButton;

    public MainMenu(String name)
    {
        super(name);

        // QuitButton = new ImageTextButton("Quit", new Skin());
    }

    @Override
    public void Init()
    {

    }

    @Override
    public void Render(SpriteBatch batch)
    {
        FontManager.drawText("Welcome to the chill walking game", 200, 450, batch);
    }
}
