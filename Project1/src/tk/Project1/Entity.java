package src.tk.Project1;

import com.badlogic.gdx.math.*;
import java.io.*;
public abstract class Entity implements Serializable
{
	private int health,mana,energy;
	private Vector3 position;
	private RenderInformation renderInformation;
	public Entity()
	{
		position = new Vector3();
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getHealth()
	{
		return health;
	}

	public void setMana(int mana)
	{
		this.mana = mana;
	}

	public int getMana()
	{
		return mana;
	}

	public void setEnergy(int energy)
	{
		this.energy = energy;
	}

	public int getEnergy()
	{
		return energy;
	}

	public void setRenderInformation(RenderInformation renderInformation)
	{
		this.renderInformation = renderInformation;
	}

	public RenderInformation getRenderInformation()
	{
		return renderInformation;
	}

	public void setPosition(Vector3 position)
	{
		this.position = position;
	}

	public Vector3 getPosition()
	{
		return position;
	}
	public abstract void onDeath();
	public abstract void onTakingDamage();
	public abstract void onStatusChange();
	public abstract void update();
}
