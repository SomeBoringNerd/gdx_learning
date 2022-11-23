package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity
{
    private int Health;
    private String Name;
    private Type type;

    public static int x, y;

    private Texture createTexture;

    public Entity(int health, String name, Type type, String texturePath)
    {
        createTexture = new Texture(texturePath + ".png");
        Health = health;
        Name = name;
        this.type = type;
    }

    public int getHealth()
    {
        return Health;
    }
    public String getName()
    {
        return Name;
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
