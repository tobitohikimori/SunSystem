package com.tobitoikimori.sunsystem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private Planet sun;
	private Planet planetone;
	private Planet planettwo;
	private Planet sputnik;
	private Texture Sun;
	private Texture PlanetOne;
	private Texture PlanetTwo;
	private Texture Sputnik;
	private double PlanetOneT, PlanetTwoT, SputnikT;
	private boolean isPause;
	private Stage stage;
	private TextButton button;
	private TextButton.TextButtonStyle style;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		batch = new SpriteBatch();
		isPause = false;
		Sun = new Texture("Sun.png");
		PlanetOne = new Texture("Planet1.png");
		PlanetTwo = new Texture("Planet3.png");
		Sputnik = new Texture("Planet2.png");

		sun = new Planet(Sun, 100, 100);
		planetone = new Planet(PlanetOne, 30,30);
		planettwo = new Planet(PlanetTwo, 70,70);
		sputnik = new Planet(Sputnik, 15,15);


		style = new TextButton.TextButtonStyle();
		style.font  =  new BitmapFont();
		style.fontColor = Color.GREEN;
		button = new TextButton("pause/resume",style);
		button.setSize(150,100);
		button.setPosition(330,-20);
		button.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				isPause = !isPause;
				if(isPause==false){
					style.fontColor = Color.GREEN;
				}
				else{
					style.fontColor = Color.RED;
				}
				return true;
			}
		});
		stage.addActor(button);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(!isPause) {
			PlanetOneT += 0.01;
			PlanetTwoT += 0.005;
			SputnikT += 0.03;
		}
		planetone.getPos(365,365,180,PlanetOneT);
		planettwo.getPos(330,330,300,-PlanetTwoT);
		sputnik.getPos(planetone.ObjectPosX,planetone.ObjectPosY,56,SputnikT);

		batch.begin();
		batch.draw(sun.ObjectBody,350 ,350, sun.Width, sun.Height);
		batch.draw(planetone.ObjectBody,planetone.ObjectPosX,planetone.ObjectPosY, planetone.Width, planetone.Height);
		batch.draw(planettwo.ObjectBody, planettwo.ObjectPosX, planettwo.ObjectPosY, planettwo.Width, planettwo.Height);
		batch.draw(sputnik.ObjectBody, sputnik.ObjectPosX , sputnik.ObjectPosY ,sputnik.Width,sputnik.Height );
		batch.end();
		stage.draw();
	}



	@Override
	public void dispose () {
		batch.dispose();
		Sun.dispose();
		PlanetOne.dispose();
		PlanetTwo.dispose();
		Sputnik.dispose();
	}

}
