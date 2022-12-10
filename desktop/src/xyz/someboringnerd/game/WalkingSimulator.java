package xyz.someboringnerd.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import xyz.someboringnerd.game.Managers.BlockManager;
import xyz.someboringnerd.game.Managers.EntityManager;
import xyz.someboringnerd.game.Util.FontManager;
import xyz.someboringnerd.game.Util.SceneManager;

public class WalkingSimulator extends ApplicationAdapter {
	SpriteBatch batch;

	public static OrthographicCamera camera;

	public static int FrameCount;

	public static int MaxHeight = 720 / 2;
	public static int MaxWidth = 1280 / 2;

	SceneManager sman;

	@Override
	public void create ()
	{
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);

		//camera.project(new Vector3(1280 / 2, 720 / 2, 30));

		walk = this;
		sman = new SceneManager();
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
		FrameCount++;
		ScreenUtils.clear(0, 0, 0, 1);

		if(getEntityManager().player != null)
		{
			camera.position.set(new Vector3(getEntityManager().player.getX(), getEntityManager().player.getY(), 4));

			batch.setProjectionMatrix(camera.combined);
		}else{
			batch.setProjectionMatrix(camera.projection);
		}

		batch.begin();

		getBlockManager().Render(batch);
		getEntityManager().Render(batch);

		if(SceneManager.getActiveScene() != null)
		{
			SceneManager.getActiveScene().Render(batch);
		}

		camera.update();
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
