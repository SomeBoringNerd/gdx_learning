package xyz.someboringnerd.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import xyz.someboringnerd.game.Entity.Player;
import xyz.someboringnerd.game.Entity.Type;
import xyz.someboringnerd.game.Entity.blocks.Block;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.Util.Scene;
import xyz.someboringnerd.game.WalkingSimulator;

import java.util.UUID;

import static xyz.someboringnerd.game.WalkingSimulator.MaxHeight;
import static xyz.someboringnerd.game.WalkingSimulator.MaxWidth;

public class WalkingScene extends Scene
{

    public WalkingScene(String _name)
    {
        super(_name);
    }

    @Override
    public void Init()
    {

        MaxHeight = 256;
        MaxWidth = 256;

        for(int x = -256; x < 256; x += 32){
            for(int y = -256; y < 256; y += 32){
                WalkingSimulator.getBlockManager().groundMap.put(new Block(false, "block", "Textures/Blocks/ground", x, y), 0);
            }
        }

        WalkingSimulator.getBlockManager().blockMap.put(new Block(true, "debug_collider", "Textures/DebugTextures/Collider", 64, 64), 0);
        WalkingSimulator.getBlockManager().blockMap.put(new Block(true, "debug_collider", "Textures/DebugTextures/Collider", 64, 96), 0);
        WalkingSimulator.getBlockManager().blockMap.put(new Block(true, "debug_collider", "Textures/DebugTextures/Collider", 96, 96), 0);
        WalkingSimulator.getBlockManager().blockMap.put(new Block(true, "debug_collider", "Textures/DebugTextures/Collider", -64, -64), 0);

        System.out.println("[" + WalkingSimulator.FrameCount + "]Walking is summoned");
        WalkingSimulator.getEntityManager().player =  new Player(20, "Player", Type.PLAYER, Gdx.files.internal("Textures/DebugTextures/PlayerTest").path());
    }

    @Override
    public void Render(SpriteBatch batch)
    {
        FontManager.drawText("X:" + EntityManager.getPlayer().x + " | Y:" + EntityManager.getPlayer().y, (int) (EntityManager.getPlayer().x) - 12, (int) (EntityManager.getPlayer().y + 100), batch);

        FontManager.drawText(EntityManager.getPlayer().getName(), EntityManager.getPlayer().x - 5, EntityManager.getPlayer().y + 80, batch);
    }
}
