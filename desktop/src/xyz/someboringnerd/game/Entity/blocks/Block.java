package xyz.someboringnerd.game.Entity.blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.WalkingSimulator;

public class Block extends Actor
{
    private Texture createTexture;

    public Rectangle hitbox;
    private int x, y;

    public boolean Collide;

    public Block(boolean Collide, String name, String texturePath, int x, int y)
    {
        createTexture = new Texture(texturePath + ".png");
        setBounds(x, y, 32, 32);
        setY(y);
        setX(x);
        hitbox = new Rectangle(x, y, 32, 32);
        this.Collide = Collide;
    }

    public void Render(SpriteBatch batch)
    {

        if(Collide)
        {
            //FontManager.drawText("xMin : " + x + " | xMax : " + (x + 32), (int) (WalkingSimulator.camera.position.x - 630), (int) (WalkingSimulator.camera.position.y + 295), batch);
            //FontManager.drawText("yMin : " + y + " | yMax : " + (y + 32), (int) (WalkingSimulator.camera.position.x - 630), (int) (WalkingSimulator.camera.position.y + 275), batch);
        }

        batch.draw(createTexture, getX(), getY());
    }
}
