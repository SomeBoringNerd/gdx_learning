package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import xyz.someboringnerd.game.WalkingSimulator;

public class Player extends Entity
{

    int multi = 1;

    public PlayerCollider COLLIDER;

    public Player(int health, String name, Type type, String texturePath)
    {
        super(health, name, type, texturePath);
        COLLIDER = PlayerCollider.NONE;
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
        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){multi = 2;}
        else{multi = 1;}


        if(y >= -WalkingSimulator.MaxHeight + 6 &&
                Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
                !Gdx.input.isKeyPressed(Input.Keys.UP)&&
                COLLIDER != PlayerCollider.UP)
        {
            y -= 2 * multi;
        }
        else if(y <= WalkingSimulator.MaxHeight - 32 &&
                Gdx.input.isKeyPressed(Input.Keys.UP) &&
                !Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
                COLLIDER != PlayerCollider.DOWN)
        {
            y += 2 * multi;
        }

        if(x >= -WalkingSimulator.MaxWidth &&
                Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.RIGHT)&&
                COLLIDER != PlayerCollider.LEFT)
        {
            x -= 2 * multi;
        }
        else if(x <= WalkingSimulator.MaxWidth - 32 &&
                Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.LEFT)&&
                COLLIDER != PlayerCollider.RIGHT)
        {
            x += 2 * multi;
        }
    }
}
