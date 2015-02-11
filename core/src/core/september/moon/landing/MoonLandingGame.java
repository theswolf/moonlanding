package core.september.moon.landing;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import core.september.moon.landing.framework.Assets;
import core.september.moon.landing.framework.GamePreferences;
import core.september.moon.landing.framework.screen.DirectedGame;
import core.september.moon.landing.framework.transitions.ScreenTransition;
import core.september.moon.landing.framework.transitions.ScreenTransitionSlice;
import core.september.moon.landing.screens.play.PlayScreen;

public class MoonLandingGame extends DirectedGame {
	SpriteBatch batch;
	//Texture img;
	


    @Override
    public void create () {
        // Set Libgdx log level
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // Load assets
        Assets.instance.init(new AssetManager());

        // Load preferences for audio settings and start playing music
        GamePreferences.instance.load();
        //AudioManager.instance.play(Assets.instance.music.song01);

        // Start game at menu screen
        ScreenTransition transition = ScreenTransitionSlice.init(2, ScreenTransitionSlice.UP_DOWN, 10, Interpolation.pow5Out);
        //setScreen(new TestScreen(this), null);
        setScreen(new PlayScreen(this),null);
    }


}
