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
        for (Map.Entry<Block, Integer> keyset : groundMap.entrySet())
        {
            keyset.getKey().Render(batch);
        }

        for (Map.Entry<Block, Integer> keyset : blockMap.entrySet())
        {
            keyset.getKey().Render(batch);
        }
    }
}
