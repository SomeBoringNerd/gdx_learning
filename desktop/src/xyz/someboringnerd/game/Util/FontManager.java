package xyz.someboringnerd.game.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontManager
{



    private static BitmapFont font;

    public FontManager()
    {
        font = new BitmapFont(Gdx.files.internal("fonts/party_confetti_18.fnt"));
    }

    public static void drawText(String text, int x, int y, SpriteBatch batch)
    {
        font.draw(batch, text, x, y);
    }
}
