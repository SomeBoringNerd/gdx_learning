package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import xyz.someboringnerd.game.WalkingSimulator;

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


        if(y >= -WalkingSimulator.MaxHeight && y <= WalkingSimulator.MaxHeight - 32) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += 2 * multi;
            else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= 2 * multi;
        }else{
            y = y <= -WalkingSimulator.MaxHeight ? -WalkingSimulator.MaxHeight : WalkingSimulator.MaxHeight - 32;
        }
        if(x >= -WalkingSimulator.MaxWidth && x <= WalkingSimulator.MaxWidth - 32) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 2 * multi;
            else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 2 * multi;
        }else{
            x = x <= -WalkingSimulator.MaxWidth ? -WalkingSimulator.MaxWidth : WalkingSimulator.MaxWidth - 32;
        }
    }
}
