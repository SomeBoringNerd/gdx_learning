package xyz.someboringnerd.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.someboringnerd.game.Entity.Entity;
import xyz.someboringnerd.game.Entity.Player;
import xyz.someboringnerd.game.Entity.Type;

import java.util.*;

public class EntityManager
{

    public static Player player;

    public static Player getPlayer(){
        return player;
    }

    public HashMap<Entity, UUID> entityMap = new HashMap();

    public EntityManager()
    {
        //player =
    }

    public void Render(SpriteBatch batch)
    {
        if(player != null) {
            player.render(batch);
        }

        for (Map.Entry<Entity, UUID> keyset :entityMap.entrySet())
        {
            keyset.getKey().render(batch);
        }
    }

    public void removePlayer()
    {
        player = null;
    }
}
