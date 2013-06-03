package tk.Project1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.*;
import com.badlogic.gdx.controllers.*;
import com.badlogic.gdx.graphics.g2d.*;
import src.tk.Project1.*;
import com.badlogic.gdx.backends.android.*;

public class Project1 implements ApplicationListener
{
	BitmapFont font;
	GraphicsModule graphicsModule;
	LogicModule logicModule;
	@Override
	public void create()
	{	
		graphicsModule=new GraphicsModule();
		logicModule=new LogicModule();
	}

	@Override
	public void dispose()
	{
	graphicsModule.dispose();
	logicModule.dispose();
	}

	@Override
	public void render()
	{		
	
	graphicsModule.render();
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
