package src.tk.Project1;
import java.util.*;

public class World
{	
	private List<Chunk> chunks;
	private List<Player> players;
	public World()
	{
		init();
	}

	public void removeChunk(Chunk chunk)
	{
		getChunks().remove(chunk);
	}
	public void addChunk(Chunk chunk)
	{
		getChunks().add(chunk);
	}

	public synchronized List<Chunk> getChunks()
	{
		return chunks;
	}
	public void removePlayer(Player player)
	{
		getPlayers().remove(player);
	}
	public void addPlayer(Player player)
	{
		getPlayers().add(player);
	}

	public synchronized List<Player> getPlayers()
	{
		return players;
	}
	private void init()
	{
		chunks = new ArrayList<Chunk>();
	}
	public void render()
	{
		for (int i=0;i < getChunks().size();i++)
		{
			Chunk c=getChunks().get(i);
			if (getPlayers().get(0).getCam().frustum.boundsInFrustum(c.getBoundingBox()))
			{
				c.render();
			}
		}
	}
	public void dispose()
	{
		for (int i=0;i < getChunks().size();i++)
		{
			getChunks().get(i).dispose();
		}
	}
}
