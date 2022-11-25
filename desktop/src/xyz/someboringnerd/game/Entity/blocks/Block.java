package xyz.someboringnerd.game.Entity.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import xyz.someboringnerd.game.Entity.PlayerCollider;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.WalkingSimulator;

public class Block extends Actor
{
    private Texture createTexture;
    private int x, y;

    public boolean Collide;

    public Block(boolean Collide, String name, String texturePath, int x, int y)
    {
        createTexture = new Texture(texturePath + ".png");
        setBounds(x, y, 32, 32);
        this.x = x;
        this.y = y;
        this.Collide = Collide;
    }

    public void Render(SpriteBatch batch)
    {
        batch.draw(createTexture, x, y);
    }
}
