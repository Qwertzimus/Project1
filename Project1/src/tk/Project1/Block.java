package src.tk.Project1;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.collision.*;
import java.io.*;
import src.tk.Project1.blocks.*;

public abstract class Block implements Serializable
{
	protected BlockId id;
	protected BlockStatus status;
	protected String name;
	protected boolean activated;
	protected BlockType type;
	protected boolean visible;
	public Block()
	{
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	public boolean isVisible()
	{
		return visible;
	}

	public Block setType(BlockType type)
	{
		this.type = type;
		return this;
	}

	public BlockType getType()
	{
		return type;
	}

	public Block setActivated(boolean activated)
	{
		this.activated = activated;
		return this;
	}

	public boolean isActivated()
	{
		return activated;
	}

	public abstract void onPlacement();
	public abstract void onDestruction();
	public abstract void onChange();
	public abstract void update();
	public String getName()
	{
		return name;
	}
	public static final Dirt dirt=new Dirt();
}
