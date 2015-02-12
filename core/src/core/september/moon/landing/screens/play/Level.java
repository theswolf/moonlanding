package core.september.moon.landing.screens.play;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import core.september.moon.landing.gameobjects.Back;
import core.september.moon.landing.gameobjects.Laser;
import core.september.moon.landing.gameobjects.Lem;
import core.september.moon.landing.gameobjects.Moon;

/**
 * Created by christian on 10/02/15.
 */
public class Level {

    public static final String TAG = Level.class.getName();



    // player character
    //public BunnyHead bunnyHead;

    // objects
    /*public Array<Rock> rocks;
    public Array<GoldCoin> goldcoins;
    public Array<Feather> feathers;
    public Array<Carrot> carrots;*/

    // decoration
   /* public Clouds clouds;
    public Mountains mountains;
    public WaterOverlay waterOverlay;
    public Goal goal;*/

    public Back back;
    public Lem lem;
    public Moon moon;
    public Laser laser;





    public Level() {
        init();
    }

    private void init () {
        // player character
      /*  bunnyHead = null;

        // objects
        rocks = new Array<Rock>();
        goldcoins = new Array<GoldCoin>();
        feathers = new Array<Feather>();
        carrots = new Array<Carrot>();

        // load image file that represents the level data
        Pixmap pixmap = new Pixmap(Gdx.files.internal(filename));
        // scan pixels from top-left to bottom-right
        int lastPixel = -1;
        for (int pixelY = 0; pixelY < pixmap.getHeight(); pixelY++) {
            for (int pixelX = 0; pixelX < pixmap.getWidth(); pixelX++) {
                AbstractGameObject obj = null;
                float offsetHeight = 0;
                // height grows from bottom to top
                float baseHeight = pixmap.getHeight() - pixelY;
                // get color of current pixel as 32-bit RGBA value
                int currentPixel = pixmap.getPixel(pixelX, pixelY);
                // find matching color value to identify block type at (x,y)
                // point and create the corresponding game object if there is
                // a match

                // empty space
                if (BLOCK_TYPE.EMPTY.sameColor(currentPixel)) {
                    // do nothing
                }
                // rock
                else if (BLOCK_TYPE.ROCK.sameColor(currentPixel)) {
                    if (lastPixel != currentPixel) {
                        obj = new Rock();
                        float heightIncreaseFactor = 0.25f;
                        offsetHeight = -2.5f;
                        obj.position.set(pixelX, baseHeight * obj.dimension.y * heightIncreaseFactor + offsetHeight);
                        rocks.add((Rock)obj);
                    } else {
                        rocks.get(rocks.size - 1).increaseLength(1);
                    }
                }
                // player spawn point
                else if (BLOCK_TYPE.PLAYER_SPAWNPOINT.sameColor(currentPixel)) {
                    obj = new BunnyHead();
                    offsetHeight = -3.0f;
                    obj.position.set(pixelX, baseHeight * obj.dimension.y + offsetHeight);
                    bunnyHead = (BunnyHead)obj;
                }
                // feather
                else if (BLOCK_TYPE.ITEM_FEATHER.sameColor(currentPixel)) {
                    obj = new Feather();
                    offsetHeight = -1.5f;
                    obj.position.set(pixelX, baseHeight * obj.dimension.y + offsetHeight);
                    feathers.add((Feather)obj);
                }
                // gold coin
                else if (BLOCK_TYPE.ITEM_GOLD_COIN.sameColor(currentPixel)) {
                    obj = new GoldCoin();
                    offsetHeight = -1.5f;
                    obj.position.set(pixelX, baseHeight * obj.dimension.y + offsetHeight);
                    goldcoins.add((GoldCoin)obj);
                }
                // goal
                else if (BLOCK_TYPE.GOAL.sameColor(currentPixel)) {
                    obj = new Goal();
                    offsetHeight = -7.0f;
                    obj.position.set(pixelX, baseHeight + offsetHeight);
                    goal = (Goal)obj;
                }
                // unknown object/pixel color
                else {
                    // red color channel
                    int r = 0xff & (currentPixel >>> 24);
                    // green color channel
                    int g = 0xff & (currentPixel >>> 16);
                    // blue color channel
                    int b = 0xff & (currentPixel >>> 8);
                    // alpha channel
                    int a = 0xff & currentPixel;
                    Gdx.app.error(TAG, "Unknown object at x<" + pixelX + "> y<" + pixelY + ">: r<" + r + "> g<" + g + "> b<" + b
                            + "> a<" + a + ">");
                }
                lastPixel = currentPixel;
            }
        }

        // decoration
        clouds = new Clouds(pixmap.getWidth());
        clouds.position.set(0, 2);
        mountains = new Mountains(pixmap.getWidth());
        mountains.position.set(-1, -1);
        waterOverlay = new WaterOverlay(pixmap.getWidth());
        waterOverlay.position.set(0, -3.75f);

        // free memory
        pixmap.dispose();
        Gdx.app.debug(TAG, "level '" + filename + "' loaded");*/

        back = new Back();
        moon = new Moon();
        lem = new Lem();
        laser = new Laser(lem);

    }



    public void update (float deltaTime) {

        back.update(deltaTime);
        moon.update(deltaTime);
        lem.update(deltaTime);
        laser.update(deltaTime);


        // Bunny Head
       /* bunnyHead.update(deltaTime);
        // Rocks
        for (Rock rock : rocks)
            rock.update(deltaTime);
        // Gold Coins
        for (GoldCoin goldCoin : goldcoins)
            goldCoin.update(deltaTime);
        // Feathers
        for (Feather feather : feathers)
            feather.update(deltaTime);
        for (Carrot carrot : carrots)
            carrot.update(deltaTime);
        // Clouds
        clouds.update(deltaTime);*/
    }

    public void render (SpriteBatch batch) {

        back.render(batch);
        //moon.render(batch);
        lem.render(batch);
        laser.render(batch);

        // Draw Mountains
        /*mountains.render(batch);
        // Draw Goal
        goal.render(batch);
        // Draw Rocks
        for (Rock rock : rocks)
            rock.render(batch);
        // Draw Gold Coins
        for (GoldCoin goldCoin : goldcoins)
            goldCoin.render(batch);
        // Draw Feathers
        for (Feather feather : feathers)
            feather.render(batch);
        // Draw Carrots
        for (Carrot carrot : carrots)
            carrot.render(batch);
        // Draw Player Character
        bunnyHead.render(batch);
        // Draw Water Overlay
        waterOverlay.render(batch);
        // Draw Clouds
        clouds.render(batch);*/
    }

}