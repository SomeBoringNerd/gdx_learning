package xyz.someboringnerd.game.Util;

import xyz.someboringnerd.game.Entity.blocks.Block;
import xyz.someboringnerd.game.Scene.MainMenu;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class SceneManager
{
    public static Scene getActiveScene()
    {
        return loaded;
    }
    private static CopyOnWriteArrayList<Scene> SceneList = new CopyOnWriteArrayList<>();
    private static Scene loaded;

    public SceneManager()
    {
        SceneList.add(new MainMenu("MainMenu"));
    }

    public static void LoadScene(String Scene)
    {
        for (Scene scene: SceneList)
        {
            if(Scene.equals(scene.getName()))
            {
                if(loaded != null) {
                    loaded.dispose();
                }

                scene.Init();
                loaded = scene;
                return;
            }
        }
    }
}
