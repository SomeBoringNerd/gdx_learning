package xyz.someboringnerd.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.someboringnerd.game.Entity.blocks.Block;

import java.util.HashMap;
import java.util.Map;

public class BlockManager
{

    public Block debugBlock;

    public HashMap<Block, Integer> groundMap = new HashMap();
    public HashMap<Block, Integer> blockMap = new HashMap();

    // maps are rendered in order of execution.
    // if blockMap is rendered before groundMap, the ground will render on top of the map.
    public void Render(SpriteBatch batch)
    {
        EntityManager.getPlayer().overlap_top = false;
        EntityManager.getPlayer().overlap_bot = false;
        EntityManager.getPlayer().overlap_lef = false;
        EntityManager.getPlayer().overlap_rig = false;

        for (Map.Entry<Block, Integer> keyset : groundMap.entrySet())
        {
            keyset.getKey().Render(batch);
        }

        for (Map.Entry<Block, Integer> keyset : blockMap.entrySet())
        {
            keyset.getKey().Render(batch);

            if(keyset.getKey().Collide)
            {
                if(!EntityManager.getPlayer().overlap_top) {
                    EntityManager.getPlayer().overlap_top = keyset.getKey().hitbox.overlaps(EntityManager.getPlayer().top);
                }
                if(!EntityManager.getPlayer().overlap_bot) {
                    EntityManager.getPlayer().overlap_bot = keyset.getKey().hitbox.overlaps(EntityManager.getPlayer().bottom);
                }
                if(!EntityManager.getPlayer().overlap_lef) {
                    EntityManager.getPlayer().overlap_lef = keyset.getKey().hitbox.overlaps(EntityManager.getPlayer().left);
                }
                if(!EntityManager.getPlayer().overlap_rig) {
                    EntityManager.getPlayer().overlap_rig = keyset.getKey().hitbox.overlaps(EntityManager.getPlayer().right);
                }
            }
        }
    }
}