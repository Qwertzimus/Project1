package src.tk.Project1;
import com.badlogic.gdx.scenes.scene2d.*;
import java.util.*;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.*;
public class GUIModule
{	
	private Stage stage;
	private TextField.TextFieldStyle defaultTextFieldStyle;
	private GraphicsModule graphicsModule;
	private Drawable defaultCursor;
	private Drawable defaultSelection;
	private Drawable defaultBackground;
	private List<Widget> actors;
	public GUIModule(GraphicsModule graphicsModule)
	{
		this.graphicsModule = graphicsModule;
		stage = new Stage();
		init();
	}

	private void init()
	{
		defaultCursor = new TextureRegionDrawable(new TextureRegion(
			new Texture(Gdx.files.internal(
							"data/images/cursor.png"))));
		defaultSelection = new TextureRegionDrawable(new TextureRegion(
			new Texture(Gdx.files.internal(
							"data/images/cursor.png"))));
		defaultBackground = new TextureRegionDrawable(new TextureRegion(
			new Texture(Gdx.files.internal(
							"data/images/cursor.png"))));

		defaultTextFieldStyle = new TextField.TextFieldStyle(
			graphicsModule.getFont(), graphicsModule.getFontColor(),
			defaultCursor, defaultSelection, defaultBackground
		);
		actors=new ArrayList<Widget>();
	}
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}

	public synchronized Stage getStage()
	{
		return stage;
	}

	public void render(SpriteBatch batch)
	{
		for(int i=0;i<actors.size();i++){
			actors.get(i).draw(batch,1);
		}
	}

	public void dispose()
	{

	}
}
