package xyz.someboringnerd.game.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontManager
{


    public static BitmapFont getFont(){
        return font;
    }
    private static BitmapFont font;

    //Gdx.files.internal("fonts/party_confetti_18.fnt")
    public FontManager()
    {
        font = new BitmapFont();
    }


    /**
     * Draw text on the screen. At the moment it can only be with the default BitmapFont
     * @TODO : fix other BitmapFont crashing.
     * @param text : Text to draw
     * @param x : X position (left / right). For text that follow the camera, you need to take the camera's x position as x=0
     * @param y : Y position (up / down). For text that follow the camera, you need to take the camera's position as y=0.
     *
     */
    public static void drawText(String text, int x, int y, SpriteBatch batch)
    {
        font.draw(batch, text, x, y);
    }
}
