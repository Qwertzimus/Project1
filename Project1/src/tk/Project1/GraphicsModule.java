package src.tk.Project1;

import com.badlogic.gdx.*;
import com.badlogic.gdx.controllers.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

public class GraphicsModule
{	
	private	BitmapFont font;
	private SpriteBatch batch;
	private Color fontColor;
	private GUIModule guiModule;
	private World world;
	private Controller mouse;
	public GraphicsModule(World world)
	{
		init();
		this.world = world;
	}
	public GraphicsModule()
	{
		init();
		world=new World();
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
		fontColor=new Color(1,0,0,1);
		guiModule = new GUIModule(this);		
		
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
			font.draw(batch, ""+Controllers.getControllers().size, 512, 400);
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
