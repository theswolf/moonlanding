package core.september.moon.landing.screens.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import core.september.moon.landing.framework.Constants;
import core.september.moon.landing.framework.screen.AbstractGameScreen;
import core.september.moon.landing.framework.screen.DirectedGame;
import core.september.moon.landing.gameobjects.Back;

/**
 * Created by christian on 11/02/15.
 */
public class TestScreen extends AbstractGameScreen {

    SpriteBatch batch;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    private Sprite sprite;
    private Back back;


    public TestScreen(DirectedGame game) {
        super(game);
        create();
    }

    public void create () {
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);
        camera.position.set(Constants.VIEWPORT_WIDTH/2, Constants.VIEWPORT_HEIGHT/2, 0);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        back = new Back();
    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glDisable(GL20.GL_BLEND);

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        back.render(batch);
        batch.end();
        //batch.draw(sprite, 200, 200, 64, 64);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(75, 100, 32);

        shapeRenderer.triangle( 50,50, 75, 100,100, 50);
        shapeRenderer.setColor(new Color(Color.argb8888(212,175,55,0)));
        shapeRenderer.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public InputProcessor getInputProcessor() {
        return null;
    }


}

