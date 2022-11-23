package xyz.someboringnerd.game.UI.UIElement;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Button
{

    Texture sprite;

    public int x, y;

    public Button(FileHandle file, int x, int y)
    {
        sprite = new Texture(file.path());
        this.x = x;
        this.y = y;
    }

    public void Render(SpriteBatch batch)
    {
        batch.draw(sprite, x, y);
    }
}
