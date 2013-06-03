package tk.Project1;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.surfaceview.*;

public class MainActivity extends AndroidApplication
{
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
		//	cfg.resolutionStrategy.calcMeasures(800,600);
        initialize(new Project1(), cfg);
    }
	@Override
    public boolean onGenericMotionEvent(android.view.MotionEvent event){
		
		 return super.onGenericMotionEvent(event);
	}
}
