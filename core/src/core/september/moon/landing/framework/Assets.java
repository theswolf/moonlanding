package core.september.moon.landing.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by christian on 10/02/15.
 */
public class Assets implements Disposable, AssetErrorListener {

    public static final String TAG = Assets.class.getName();
    private AssetManager assetManager;
    public static final Assets instance = new Assets();
    public AssetLem lem;
    public AssetBack back;
    public AssetMoon moon;
    public AssetLaser laser;

    public final static int LASER_START_BG = 0;
    public final static int LASER_START_OL = 1;
    public final static int LASER_MIDDLE_BG = 2;
    public final static int LASER_MIDDLE_OL = 3;
    public final static int LASER_END_BG = 4;
    public final static int LASER_END_OL = 5;
    public final static int LASER_ANIMATION = 6;

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", (Exception)throwable);
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    public void init (AssetManager assetManager) {
        this.assetManager = assetManager;
        // set asset manager error handler
        assetManager.setErrorListener(this);
        // load texture atlas
        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
        /* load sounds
        assetManager.load("sounds/jump.wav", Sound.class);
        assetManager.load("sounds/jump_with_feather.wav", Sound.class);
        assetManager.load("sounds/pickup_coin.wav", Sound.class);
        assetManager.load("sounds/pickup_feather.wav", Sound.class);
        assetManager.load("sounds/live_lost.wav", Sound.class);
        // load music
        assetManager.load("music/keith303_-_brand_new_highscore.mp3", Music.class);
        // start loading assets and wait until finished
        */
        assetManager.finishLoading();

        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
        for (String a : assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + a);
        }

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

        // enable texture filtering for pixel smoothing
        for (Texture t : atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        // create game resource objects
        /*fonts = new AssetFonts();
        bunny = new AssetBunny(atlas);
        rock = new AssetRock(atlas);
        goldCoin = new AssetGoldCoin(atlas);
        feather = new AssetFeather(atlas);
        levelDecoration = new AssetLevelDecoration(atlas);
        sounds = new AssetSounds(assetManager);
        music = new AssetMusic(assetManager);*/
        lem = new AssetLem(atlas);
        back = new AssetBack(atlas);
        moon = new AssetMoon(atlas);
        laser = new AssetLaser(atlas);
    }

    public class AssetLem {
        public final TextureAtlas.AtlasRegion module;


        public AssetLem (TextureAtlas atlas) {
            module = atlas.findRegion("lem-mini");
        }
    }

    public class AssetBack {
        public final TextureAtlas.AtlasRegion background;


        public AssetBack (TextureAtlas atlas) {
            background = atlas.findRegion("background");
        }
    }

    public class AssetMoon {
        public final TextureAtlas.AtlasRegion moon;


        public AssetMoon (TextureAtlas atlas) {
            moon = atlas.findRegion("moon");
        }
    }


    public class AssetLaser {
        public final TextureAtlas.AtlasRegion[] laser;


        public AssetLaser (TextureAtlas atlas) {
            laser = new TextureAtlas.AtlasRegion[7];
            laser[LASER_START_BG] = atlas.findRegion("startBg");
            laser[LASER_START_OL] = atlas.findRegion("startOl");
            laser[LASER_MIDDLE_BG] = atlas.findRegion("middleBg");
            laser[LASER_MIDDLE_OL] = atlas.findRegion("middleOl");
            laser[LASER_END_BG] = atlas.findRegion("endBg");
            laser[LASER_END_OL] = atlas.findRegion("endOl");
            laser[LASER_ANIMATION] = atlas.findRegion("olAnimation");
        }
    }
}
