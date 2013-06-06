package src.tk.Project1;

import com.badlogic.gdx.*;
import com.badlogic.gdx.controllers.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.controllers.android.*;
import com.badlogic.gdx.math.*;

public class GraphicsModule
{	
	private	BitmapFont font;
	private SpriteBatch batch;
	private Color fontColor;
	private GUIModule guiModule;
	private World world;
	private AndroidController mouse;
	private boolean mouseButtonPressed=false;
	private String error;
	public GraphicsModule(World world)
	{
		init();
		this.world = world;
	}
	public GraphicsModule()
	{
		init();
		world = new World();
	}

	public void setFontColor(Color fontColor)
	{
		this.fontColor = fontColor;
	}

	public Color getFontColor()
	{
		return fontColor;
	}

	public void setBatch(SpriteBatch batch)
	{
		this.batch = batch;
	}

	public SpriteBatch getBatch()
	{
		return batch;
	}

	public void setFont(BitmapFont font)
	{
		this.font = font;
	}

	public BitmapFont getFont()
	{
		return font;
	}


	private void init()
	{

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		System.out.println(w + " "
						   + h);
		batch = new SpriteBatch();

		font = new BitmapFont(Gdx.files.internal("data/arial.fnt"), false);
		fontColor = new Color(1, 0, 0, 1);
		guiModule = new GUIModule(this);		
		for (int i=0;i < Controllers.getControllers().size;i++)
		{
			Controller c=Controllers.getControllers().get(i);
			if (c.getName().contains("Mouse"))
			{
				mouse = (AndroidController)c;
				break;
			}
		}

		if (mouse != null)
		{
			//	error = "";
		}
		else
		{
			error = "NO MOUSE NBALA";
		}


	}
	public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		drawWorld();
		//Test: Drawing Text
		{
		 	batch.begin();
			font.setColor(1.f, 0, 0, 1f);
			if (mouse.getButton(Input.Buttons.LEFT))
			{
				font.draw(batch, "LEFT" , 512, 100);
			}
			if (mouse.getButton(Input.Buttons.RIGHT))
			{
				font.draw(batch, "RIGHT" , 512, 200);
			}
			if (mouse.getButton(Input.Buttons.MIDDLE))
			{
				font.draw(batch, "MIDDLE" , 512, 300);
			}
			font.draw(batch, "" + error, 512, 400);
			batch.end();
		}
		drawGUI();
	}
	public void drawWorld()
	{
		world.render();
	}
	public void drawGUI()
	{
		guiModule.render(batch);
	}
	public void dispose()
	{
		batch.dispose();
	}
}
