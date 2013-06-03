package src.tk.Project1;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.collision.*;
import java.io.*;
import com.badlogic.gdx.graphics.*;
public class Chunk implements Serializable
{
	private World world;
	private Block[][][] blocks;
	private Vector3 position;
	private RenderInformation renderInformation;
	private boolean renderInformationShouldBeUpdated;
	private Mesh mesh;
	public Chunk()
	{
		init();
	}

	public void setRenderInformationShouldBeUpdated(boolean renderInformationShouldBeUpdated)
	{
		this.renderInformationShouldBeUpdated = renderInformationShouldBeUpdated;
	}

	public boolean renderInformationShouldBeUpdated()
	{
		return renderInformationShouldBeUpdated;
	}

	public void setRenderInformation(RenderInformation renderInformation)
	{
		this.renderInformation = renderInformation;
	}

	public RenderInformation getRenderInformation()
	{
		return renderInformation;
	}
	
	public void setWorld(World world)
	{
		this.world = world;
	}

	public World getWorld()
	{
		return world;
	}

	private void init()
	{
		position = new Vector3();
		blocks = new Block[16][16][16];

	}

	public void setPosition(Vector3 position)
	{
		this.position = position;
	}

	public Vector3 getPosition()
	{
		return position;
	}
	/*
	 Returns the required maximum position for constructing a bounding box.
	 */
	public Vector3 getEdgePosition()
	{
		return new Vector3(getPosition()
						   ).add(blocks.length,
								 blocks[0].length, blocks[0][0].length);
	}

	public Block getBlock(Vector3 position)
	{
		int x=(int)(getPosition().x - position.x);
		int y=(int)(getPosition().y - position.y);
		int z=(int)(getPosition().z - position.z);
		if (x >= 0 && x < 16 && y >= 0 && y < 16 && z >= 0 && z < 16)
		{

			return getBlock(x, y, z);
		}
		return null;

	}
	
	public void setBlock(Vector3 position,short id){
		Block b=getBlock(position);
		
	}
	public Block getBlock(int x, int y, int z)
	{
		return blocks[x][y][z];
	}
	/*
	 Returns the position of the specified block.
	 The block needs to belong to this chunk.

	 */
	public Vector3 getBlockPosition(Block block)
	{
		float x=0,y=0,z=0;
		boolean stop=false;
		for (int i=0;i < blocks.length;i++)
		{
			if (stop)
			{
				break;
			}
			for (int k=0;k < blocks[0].length;k++)
			{
				if (stop)
				{
					break;
				}
				for (int j=0;j < blocks[0][0].length;j++)
				{
					if (stop)
					{
						break;
					}
					if (blocks[i][j][k] == block)
					{
						x = i;
						y = j;
						z = k;
					}
				}
			}
		}
		return new Vector3(getPosition()).add(x, y, z);
	}

	public BoundingBox getBoundingBox()
	{
		return new BoundingBox(getPosition(), getEdgePosition());
	}
	public void setBlocks(Block[][][] blocks)
	{
		this.blocks = blocks;
	}

	public Block[][][] getBlocks()
	{
		return blocks;
	}
	public void render()
	{
		if (renderInformation != null)
		{
			renderInformation.render();
		}
		else
		{
			System.out.println("Occured in Chunk,render(): "
							   + "renderInformation==null");
		}
	}
	public void dispose(){
		saveChunkData();
	}
	
	
	public void saveChunkData(){
		
	}
	
	public void loadChunkData(){
		
	}
	public void updateRenderData(){
		
		if(mesh!=null){
		//	mesh=new Mesh();
		}
	}
}
