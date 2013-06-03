package src.tk.Project1;

public class Player extends Entity
{


	private FPSCamera cam;

	public Player(FPSCamera cam)
	{
		super();
		this.cam = cam;
	}
	public Player()
	{
		super();
		cam = new FPSCamera();
	}

	public void setCam(FPSCamera cam)
	{
		this.cam = cam;
	}

	public FPSCamera getCam()
	{
		return cam;
	}

	public void onDeath()
	{
		// TODO: Implement this method
	}

	public void onTakingDamage()
	{
		// TODO: Implement this method
	}

	public void onStatusChange()
	{
		// TODO: Implement this method
	}

	public void update()
	{
		// TODO: Implement this method
	}
}
