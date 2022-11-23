package xyz.someboringnerd.game.Util;

import xyz.someboringnerd.game.Entity.blocks.Block;
import xyz.someboringnerd.game.Scene.MainMenu;
import xyz.someboringnerd.game.Scene.WalkingScene;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class SceneManager
{
    public static Scene getActiveScene()
    {
        return loaded;
    }
    private static Scene loaded;

    public static void LoadScene(String _Scene)
    {
        if(loaded != null) loaded.dispose();

        switch (_Scene){
            case "MainMenu":
                MainMenu main = new MainMenu("MainMenu");
                main.Init();
                loaded = main;
                break;
            case "WalkingScene":
                WalkingScene walk = new WalkingScene("WalkingScene");
                walk.Init();
                loaded = walk;
                break;
            default:

                break;
        }
    }
}
