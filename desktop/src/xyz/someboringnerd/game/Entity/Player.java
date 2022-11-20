package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends Entity
{

    int multi = 1;

    public Player(int health, String name, Type type, String texturePath)
    {
        super(health, name, type, texturePath);
    }

    @Override
    public void Update()
    {
        UpdateMovement();
    }

    /**
     * This code manage the movement part of the player.
     */
    void UpdateMovement()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            multi = 2;
        }else{
            multi = 1;
        }


        if(y >= 0 && y <= 418) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += 2 * multi;
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 2 * multi;
        }else{
            y = y <= 0 ? 0 : 418;
        }
        if(x >= 0 && x <= 610) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 2 * multi;
            else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 2 * multi;
        }else{
            x = x <= 0 ? 0 : 610;
        }
    }
}
