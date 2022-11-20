package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity
{
    private int Health;
    private int Name;
    private Type type;

    int x, y;

    private Texture createTexture;

    public Entity(int health, String name, Type type, String texturePath)
    {
        createTexture = new Texture(texturePath + ".png");
    }

    public int getHealth()
    {
        return Health;
    }

    public void Update()
    {

    }

    public void render(SpriteBatch batch)
    {
        Update();

        batch.draw(createTexture, x, y);
    }
}
