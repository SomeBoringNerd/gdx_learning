package xyz.someboringnerd.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.someboringnerd.game.Entity.PlayerCollider;
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

        // we dont want a collision check occur when
        // we already know the player is colliding with something
        // to avoid collisions with block A being overriden by block B
        // since B's collision check is made after block A
        boolean UpdateCollision = true;

        for (Map.Entry<Block, Integer> keyset : blockMap.entrySet())
        {
            keyset.getKey().Render(batch);

            if(keyset.getKey().Collide)
            {
                if(UpdateCollision) {
                    if (EntityManager.getPlayer().x >= keyset.getKey().getX() - 24 &&
                            EntityManager.getPlayer().x <= keyset.getKey().getX() + 24 &&
                            EntityManager.getPlayer().y >= keyset.getKey().getY() - 5 &&
                            !(EntityManager.getPlayer().y >= keyset.getKey().getY() + 32)
                    ) {
                        UpdateCollision = false;
                        EntityManager.getPlayer().COLLIDER = PlayerCollider.DOWN;
                    } else if (EntityManager.getPlayer().x >= keyset.getKey().getX() - 24 &&
                            EntityManager.getPlayer().x <= keyset.getKey().getX() + 24 &&
                            EntityManager.getPlayer().y >= keyset.getKey().getY() + 32 &&
                            !(EntityManager.getPlayer().y >= keyset.getKey().getY() + 34)
                    ) {
                        UpdateCollision = false;
                        EntityManager.getPlayer().COLLIDER = PlayerCollider.UP;
                    } else if (EntityManager.getPlayer().y >= keyset.getKey().getY() &&
                            EntityManager.getPlayer().y <= keyset.getKey().getY() + 32 &&
                            EntityManager.getPlayer().x >= keyset.getKey().getX() &&
                            !(EntityManager.getPlayer().x >= keyset.getKey().getX() + 32)
                    ) {
                        UpdateCollision = false;
                        EntityManager.getPlayer().COLLIDER = PlayerCollider.LEFT;
                    } else if (EntityManager.getPlayer().y >= keyset.getKey().getY() &&
                            EntityManager.getPlayer().y <= keyset.getKey().getY() + 32 &&
                            EntityManager.getPlayer().x <= keyset.getKey().getX() &&
                            !(EntityManager.getPlayer().x <= keyset.getKey().getX() - 32)
                    ) {
                        UpdateCollision = false;
                        EntityManager.getPlayer().COLLIDER = PlayerCollider.RIGHT;
                    } else {
                        UpdateCollision = true;
                        EntityManager.getPlayer().COLLIDER = PlayerCollider.NONE;
                    }
                }
            }
        }
    }
}
