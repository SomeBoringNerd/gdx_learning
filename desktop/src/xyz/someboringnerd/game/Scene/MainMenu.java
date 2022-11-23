package xyz.someboringnerd.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import xyz.someboringnerd.game.DesktopLauncher;
import xyz.someboringnerd.game.Entity.Player;
import xyz.someboringnerd.game.Entity.Type;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.UI.UIElement.Button;
import xyz.someboringnerd.game.UI.UIElement.Pointer;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.Util.Scene;
import xyz.someboringnerd.game.Util.SceneManager;
import xyz.someboringnerd.game.WalkingSimulator;

public class MainMenu extends Scene
{

    private Button QuitButton, PlayButton;

    private xyz.someboringnerd.game.UI.UIElement.Pointer _Pointer;

    int selected = 0;

    public MainMenu(String name)
    {
        super(name);

        System.out.println("[1] " + getSceneName());
        System.out.println("[2] " + name);
    }

    @Override
    public void Init()
    {
        dispose();

        QuitButton = new Button(Gdx.files.internal("Textures/GUISkins/Quit.png"), -150, -300);
        PlayButton = new Button(Gdx.files.internal("Textures/GUISkins/Play.png"), -150, 50);
        _Pointer = new Pointer(Gdx.files.internal("Textures/GUISkins/Pointer.png"), -275, -300);
    }

    @Override
    public void Render(SpriteBatch batch)
    {

        FontManager.drawText("select : " + selected, 0, 320, batch);
        QuitButton.Render(batch);
        PlayButton.Render(batch);

        _Pointer.y = selected == 1 ? -300 : 50;

        _Pointer.Render(batch);

        Update();
    }

    void Update()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && selected > 0)
        {
            selected--;
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && selected < 1)
        {
            selected++;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.E))
        {
            if(selected == 1)
            {
                Gdx.app.exit();
            }else
            {
                SceneManager.LoadScene("WalkingScene");
            }
        }
    }
}
