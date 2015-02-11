package core.september.moon.landing.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import core.september.moon.landing.framework.AbstractGameObject;
import core.september.moon.landing.framework.Assets;

/**
 * Created by christian on 11/02/15.
 */
public class Lem extends AbstractGameObject {

    public static final String TAG = Lem.class.getName();





    public Lem () {
        init();
    }

    public void init () {
        dimension.set(480, 800);

        // Center image on game object
        origin.set(dimension.x / 2, dimension.y / 2);

        // Bounding box for collision detection
        bounds.set(0, 0, dimension.x, dimension.y);

        // Set physics values
        /*terminalVelocity.set(3.0f, 4.0f);
        friction.set(12.0f, 0.0f);
        acceleration.set(0.0f, -25.0f);*/

    }

    @Override
    public void update (float deltaTime) {
        super.update(deltaTime);
        /*if (velocity.x != 0) {
            viewDirection = velocity.x < 0 ? VIEW_DIRECTION.LEFT : VIEW_DIRECTION.RIGHT;
        }
        if (timeLeftFeatherPowerup > 0) {
            if (animation == animCopterTransformBack) {
                // Restart "Transform" animation if another feather power-up
                // was picked up during "TransformBack" animation. Otherwise,
                // the "TransformBack" animation would be stuck while the
                // power-up is still active.
                setAnimation(animCopterTransform);
            }
            timeLeftFeatherPowerup -= deltaTime;
            if (timeLeftFeatherPowerup < 0) {
                // disable power-up
                timeLeftFeatherPowerup = 0;
                setFeatherPowerup(false);
                setAnimation(animCopterTransformBack);
            }
        }
        dustParticles.update(deltaTime);

        // Change animation state according to feather power-up
        if (hasFeatherPowerup) {
            if (animation == animNormal) {
                setAnimation(animCopterTransform);
            } else if (animation == animCopterTransform) {
                if (animation.isAnimationFinished(stateTime)) setAnimation(animCopterRotate);
            }
        } else {
            if (animation == animCopterRotate) {
                if (animation.isAnimationFinished(stateTime)) setAnimation(animCopterTransformBack);
            } else if (animation == animCopterTransformBack) {
                if (animation.isAnimationFinished(stateTime)) setAnimation(animNormal);
            }
        }*/
    }


    @Override
    public void render (SpriteBatch batch) {
        TextureRegion reg = null;



        // Apply Skin Color
       // batch.setColor(CharacterSkin.values()[GamePreferences.instance.charSkin].getColor());

        float dimCorrectionX = 0;
        float dimCorrectionY = 0;

        // Draw image
        reg = Assets.instance.lem.module;

        batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x + dimCorrectionX, dimension.y
                        + dimCorrectionY, scale.x, scale.y, rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(),
                reg.getRegionHeight(), false, false);

        // Reset color to white
        batch.setColor(1, 1, 1, 1);
    }




}
