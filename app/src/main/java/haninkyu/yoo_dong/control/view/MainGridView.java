package haninkyu.yoo_dong.control.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.model.Constant;
import com.facebook.drawee.view.*;

import java.util.Random;

/**
 * Created by IVE on 2015-11-07.
 */
public class MainGridView extends LinearLayout{
    private SimpleDraweeView sumnail;
    private TextView name, chairman;
    public MainGridView(Context context) {
        super(context);
        init();
    }

    public MainGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MainGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        Log.d(Constant.LOG, "메인 커스텀 리니어레이아웃");
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.linear_main_gridview, this, true);

        sumnail = (SimpleDraweeView) findViewById(R.id.sumnail);
        name = (TextView) findViewById(R.id.name);
        chairman = (TextView) findViewById(R.id.name);

        Random ran = new Random();
        Uri uri = Uri.parse(Constant.URLS[ran.nextInt(34)]);
        sumnail.setImageURI(uri);
    }
}
