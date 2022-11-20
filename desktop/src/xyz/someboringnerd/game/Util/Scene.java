package xyz.someboringnerd.game.Util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.someboringnerd.game.WalkingSimulator;

public abstract class Scene
{

    private static String name;

    public static String getName()
    {
        return name;
    }

    public Scene(String _name)
    {
        name = _name;
    }

    public abstract void Init();

    public void dispose()
    {
        WalkingSimulator.getBlockManager().blockMap.clear();
        WalkingSimulator.getBlockManager().groundMap.clear();

        WalkingSimulator.getEntityManager().player = null;
        WalkingSimulator.getEntityManager().entityMap.clear();
    }

    public abstract void Render(SpriteBatch batch);
}
