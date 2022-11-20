package xyz.someboringnerd.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import xyz.someboringnerd.game.Managers.BlockManager;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.Util.SceneManager;

public class WalkingSimulator extends ApplicationAdapter {
	SpriteBatch batch;



	@Override
	public void create ()
	{
		walk = this;
		new SceneManager();
		FontManager = new FontManager();
		EntityManager = new EntityManager();
		BlockManager = new BlockManager();

		batch = new SpriteBatch();

		SceneManager.LoadScene("MainMenu");
	}

	int x, y;

	@Override
	public void render()
	{
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		getBlockManager().Render(batch);
		SceneManager.getActiveScene().Render(batch);
		getEntityManager().Render(batch);

		batch.end();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}



	private static WalkingSimulator walk;

	public static WalkingSimulator getInstance(){
		return walk;
	}

	private static EntityManager EntityManager;

	public static EntityManager getEntityManager(){
		return EntityManager;
	}

	private static BlockManager BlockManager;

	public static BlockManager getBlockManager(){
		return BlockManager;
	}

	private static FontManager FontManager;

	public static FontManager getFontManager(){
		return FontManager;
	}
}
