package src.tk.Project1;

import java.io.*;

public abstract class Item implements Serializable
{
	public static final int ID_OFFSET=4096;
	protected ItemId id;
	public Item()
	{

	}
	

	public abstract void onUse(Entity user);
}
