package haninkyu.yoo_dong.done.view.activity;

import android.app.Activity;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by IVE on 2015-09-19.
 */
public class BaseActivity extends Activity {

    @Override
    public void setContentView(int layoutResID) {
        Fresco.initialize(this);
        super.setContentView(layoutResID);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}