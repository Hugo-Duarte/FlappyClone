package com.hugoduarte.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hugoduarte.game.FlappyClone;

/**
 * Created by Hugo on 10/04/2016.
 */
public class GameOverState extends State {
    private Texture background;
    private Texture gameOver;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyClone.WIDTH / 2, FlappyClone.HEIGHT / 2);
        background = new Texture("bg.png");
        gameOver = new Texture("gameover.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(gameOver, cam.position.x - gameOver.getWidth() / 2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
        System.out.println("Menu State Disposed");
    }
}

