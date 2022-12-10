package xyz.someboringnerd.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import xyz.someboringnerd.game.WalkingSimulator;

public class Player extends Entity
{

    int multi = 1;
    public Rectangle top;
    public Rectangle bottom;
    public Rectangle left;
    public Rectangle right;
    public Player(int health, String name, Type type, String texturePath)
    {
        super(health, name, type, texturePath);

        setBounds(0, 0, 32, 64);
        top     =    new Rectangle(0, 64, 32, 3);
        bottom  =    new Rectangle(0, 0, 32, 3);
        left    =    new Rectangle(0, 0, 3, 64);
        right   =    new Rectangle(32, 0, 3, 64);
    }



    @Override
    public void Update()
    {
        UpdateMovement();
    }

    public static boolean overlap_top;
    public static boolean overlap_bot;
    public static boolean overlap_lef;
    public static boolean overlap_rig;

    /**
     * This code manage the movement part of the player.
     */
    void UpdateMovement()
    {
        Vector2 prev = new Vector2(getX(), getY());

        if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){multi = 2;}
        else{multi = 1;}

        if (y >= -WalkingSimulator.MaxHeight + 6 &&
                Gdx.input.isKeyPressed(Input.Keys.DOWN) &&
                !Gdx.input.isKeyPressed(Input.Keys.UP) && !overlap_bot) {
            moveBy(0, -2 * multi);
        } else if (y <= WalkingSimulator.MaxHeight - 32 &&
                Gdx.input.isKeyPressed(Input.Keys.UP) &&
                !Gdx.input.isKeyPressed(Input.Keys.DOWN) && !overlap_top) {
            moveBy(0, 2 * multi);
        }

        if (x >= -WalkingSimulator.MaxWidth &&
                Gdx.input.isKeyPressed(Input.Keys.LEFT) &&
                !Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !overlap_lef) {
            moveBy(-2 * multi, 0);
        } else if (x <= WalkingSimulator.MaxWidth - 32 &&
                Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
                !Gdx.input.isKeyPressed(Input.Keys.LEFT) && !overlap_rig) {
            moveBy(2 * multi, 0);
        }

        x = (int) getX();
        y = (int) getY();

        top     =    new Rectangle(getX() + 3 ,getY() + 32, 26, 3);
        bottom  =    new Rectangle(getX() + 3 , getY(), 26, 3);

        left    =    new Rectangle(getX()        , getY() + 4, 3, 26);
        right   =    new Rectangle(getX() + 32, getY() + 4, 3, 26);
    }
}
