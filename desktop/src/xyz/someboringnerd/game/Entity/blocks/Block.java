package xyz.someboringnerd.game.Entity.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Block
{
    private Texture createTexture;
    private int x, y;

    public Block(boolean Collide, String name, String texturePath, int x, int y)
    {
        createTexture = new Texture(texturePath + ".png");
        this.x = x;
        this.y = y;
    }

    public void Render(SpriteBatch batch)
    {
        batch.draw(createTexture, x, y);
    }
}
