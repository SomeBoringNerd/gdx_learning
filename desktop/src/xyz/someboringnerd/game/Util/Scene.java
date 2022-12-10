package xyz.someboringnerd.game.Util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import xyz.someboringnerd.game.WalkingSimulator;

public abstract class Scene extends Stage
{

    private static String _name;

    public static String getSceneName()
    {
        return _name;
    }

    public Scene(String __name)
    {

        _name = __name;
        Init();
    }

    public abstract void Init();

    /**
     * Simple function to change the size of the play area.
     */
    protected void ChangeBoundary(){

    }

    public void dispose()
    {
        WalkingSimulator.getBlockManager().blockMap.clear();
        WalkingSimulator.getBlockManager().groundMap.clear();

        WalkingSimulator.getEntityManager().removePlayer();
        WalkingSimulator.getEntityManager().entityMap.clear();
    }

    public abstract void Render(SpriteBatch batch);
}
