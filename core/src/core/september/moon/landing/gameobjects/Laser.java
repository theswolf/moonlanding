package core.september.moon.landing.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import core.september.moon.landing.framework.AbstractGameObject;
import core.september.moon.landing.framework.Assets;

/**
 * Created by christian on 12/02/15.
 */
public class Laser extends AbstractGameObject{

    public final static String TAG = Laser.class.getName();
    private AbstractGameObject parent;
    public Laser(AbstractGameObject parent) {
        init(parent);
    }


    public void init (AbstractGameObject parent) {
        this.parent = parent;
        dimension.set(64, 64);
        position.set(parent.position.x,parent.position.y);
        // Center image on game object
        rotation = parent.rotation;
        origin.set(parent.origin.x, parent.origin.y);
        //origin.set(dimension.x / 2, dimension.y / 2);

        // Bounding box for collision detection
        bounds.set(0, 0, dimension.x, dimension.y);

        // Set physics values
        /*terminalVelocity.set(3.0f, 4.0f);
        friction.set(12.0f, 0.0f);
        acceleration.set(0.0f, -25.0f);*/

    }


    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        rotation = parent.rotation;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg[] = new TextureRegion[7];



        // Apply Skin Color
        // batch.setColor(CharacterSkin.values()[GamePreferences.instance.charSkin].getColor());



        // Draw image
        reg[Assets.LASER_START_BG] =  Assets.instance.laser.laser[Assets.LASER_START_BG];
        //reg[Assets.LASER_START_BG].getTexture().

        Vector2 vector = new Vector2();
        Vector2 originOffset = new Vector2();
        drawSprite(batch,Assets.instance.laser.laser[Assets.LASER_START_BG],vector,Color.RED,originOffset);
        drawSprite(batch,Assets.instance.laser.laser[Assets.LASER_START_OL],vector,Color.RED,originOffset);

        vector.set(dimension.x,dimension.y-0.5f);
        originOffset.set(dimension.x/2,dimension.y/2);

        drawSprite(batch, Assets.instance.laser.laser[Assets.LASER_MIDDLE_BG], vector, Color.RED,originOffset);
        drawSprite(batch,Assets.instance.laser.laser[Assets.LASER_MIDDLE_OL],vector,Color.RED,originOffset);

        vector.set(dimension.x+vector.x,dimension.y+vector.y);
        originOffset.set(dimension.x,dimension.y);

        drawSprite(batch,Assets.instance.laser.laser[Assets.LASER_END_BG],vector,Color.RED,originOffset);
        drawSprite(batch,Assets.instance.laser.laser[Assets.LASER_END_OL],vector,Color.RED,originOffset);



        logObject(TAG,Assets.instance.laser.laser[Assets.LASER_START_BG],0,0);
        // Reset color to white
        batch.setColor(1, 1, 1, 1);
    }

    private void drawSprite(SpriteBatch batch,TextureRegion region,Vector2 parent,Color color,Vector2 originOffset) {

        float dimCorrectionX = 0;
        float dimCorrectionY = 0;


        batch.setColor(color);
        batch.draw(region.getTexture(),
                position.x,
                position.y+parent.y,
                origin.x+originOffset.x,
                origin.y+originOffset.y,
                dimension.x + dimCorrectionX,
                dimension.y + dimCorrectionY,
                scale.x,
                scale.y,
                rotation,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(), false, false);


    }
}
