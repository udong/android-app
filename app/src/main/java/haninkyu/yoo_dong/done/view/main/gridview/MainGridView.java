package haninkyu.yoo_dong.done.view.main.gridview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.done.model.Constant;
import haninkyu.yoo_dong.doing.view.activity.ClubCreateActivity;

/**
 * Created by IVE on 2015-11-07.
 */
public class MainGridView extends LinearLayout implements View.OnClickListener{
    private SimpleDraweeView logo;
    private TextView clubName, region, leader, category, memberCount, memberLimit, permission;
    private Context mContext;
    private boolean exist;

    public MainGridView(Context context) {
        super(context);
        init(context);
    }

    public MainGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        Log.d(Constant.LOG, "메인 커스텀 리니어레이아웃");
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.linear_main_gridview, this, true);

        logo = (SimpleDraweeView) findViewById(R.id.logo);
        clubName = (TextView) findViewById(R.id.clubName);
        region = (TextView) findViewById(R.id.region);
        leader = (TextView) findViewById(R.id.leader);
        category = (TextView) findViewById(R.id.category);
        memberCount = (TextView) findViewById(R.id.memberCount);
        memberLimit = (TextView) findViewById(R.id.memberLimit);
        permission = (TextView) findViewById(R.id.permission);

        Random ran = new Random();
        Uri uri = Uri.parse(Constant.URLS[ran.nextInt(34)]);
        logo.setImageURI(uri);

        setOnClickListener(this);
    }

    public void addView(JSONObject result) throws JSONException {
        logo.setImageURI(Uri.parse(result.getString("logoUrl")));
        clubName.setText(result.getString("clubName"));
        region.setText(result.getString("region"));
        leader.setText(result.getString("leader"));
        category.setText(result.getString("category"));
        memberCount.setText("현재 " + result.getInt("memberCount") + "명");
        memberLimit.setText("제한 " + result.getInt("memberLimit") + "명");
        if(result.getInt("permission")==0){
            permission.setText("공개 동호회");
        }else if(result.getInt("permission")==1){
            permission.setText("비공개 동호회");
        }else if(result.getInt("permission")==2){
            permission.setText("비밀 동호회");
        }
        this.exist = true;
    }
    public void addTestView() {
        logo.setImageURI(Uri.parse(Constant.URLS[0]));
        clubName.setText("clubName");
        region.setText("region");
        leader.setText("leader");
        category.setText("category");
        memberCount.setText("현재 명");
        memberLimit.setText("제한 명");
        permission.setText("공개 동호회");
        this.exist = true;
    }
    public void addPlusView() {
        logo.setImageURI(Uri.parse(Constant.URLS[1]));
        clubName.setText("동호회 생성");
        region.setVisibility(GONE);
        leader.setVisibility(GONE);
        category.setVisibility(GONE);
        memberCount.setVisibility(GONE);
        memberLimit.setVisibility(GONE);
        permission.setVisibility(GONE);
        this.exist = false;
    }

    @Override
    public void onClick(View v) {
        if(exist){
            Intent intent = new Intent(mContext, ClubCreateActivity.class);
            mContext.startActivity(intent);
        }else{
            Intent intent = new Intent(mContext, ClubCreateActivity.class);
            mContext.startActivity(intent);
        }
    }
}
