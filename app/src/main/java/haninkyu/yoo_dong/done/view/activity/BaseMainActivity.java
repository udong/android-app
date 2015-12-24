package haninkyu.yoo_dong.done.view.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.done.model.Constant;
import haninkyu.yoo_dong.done.view.main.fragment.MainFragment;
import haninkyu.yoo_dong.done.view.main.fragment.NotifiFragment;
import haninkyu.yoo_dong.done.view.main.fragment.SearchFragment;
import haninkyu.yoo_dong.done.view.main.fragment.SettingFragment;
import haninkyu.yoo_dong.done.view.main.fragment.MessageFragment;

/**
 * Created by IVE on 2015-09-19.
 */

public class BaseMainActivity extends BaseActivity {
    private ImageView main, matching, message, search, setting;
    private ImageView preButton;
    private String preName;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_main);

        main = (ImageView) findViewById(R.id.main);
        matching = (ImageView) findViewById(R.id.matching);
        message = (ImageView) findViewById(R.id.message);
        search = (ImageView) findViewById(R.id.search);
        setting = (ImageView) findViewById(R.id.setting);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if (savedInstanceState == null) {
            preName = "main";
            preButton = main;
            fragmentTransaction.add(new MainFragment(), preName);
            fragmentTransaction.commit();
        }
    }
    public void mainBtn(View v) {
        switch (v.getId()) {
            case R.id.main:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, new MainFragment(), "main");
                fragmentTransaction.commit();
                break;
            case R.id.matching:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, new NotifiFragment(), "matching");
                fragmentTransaction.commit();
                break;
            case R.id.message:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, new MessageFragment(), "message");
                fragmentTransaction.commit();
                break;
            case R.id.search:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, new SearchFragment(), "search");
                fragmentTransaction.commit();
                break;
            case R.id.setting:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, new SettingFragment(), "setting");
                fragmentTransaction.commit();
                break;
        }
    }

    public void nowBtn(String name) {
        switch (name) {
            case "main":
                preButton.setImageResource(getResources().getIdentifier(preName, "drawable", Constant.PACKAGE));
                preName = "main";
                preButton = main;
                main.setImageResource(R.drawable.mainline);
                break;
            case "matching":
                preButton.setImageResource(getResources().getIdentifier(preName, "drawable", Constant.PACKAGE));
                preName = "matching";
                preButton = matching;
                matching.setImageResource(R.drawable.matchingline);
                break;
            case "message":
                preButton.setImageResource(getResources().getIdentifier(preName, "drawable", Constant.PACKAGE));
                preName = "message";
                preButton = message;
                message.setImageResource(R.drawable.messageline);
                break;
            case "search":
                preButton.setImageResource(getResources().getIdentifier(preName, "drawable", Constant.PACKAGE));
                preName = "search";
                preButton = search;
                search.setImageResource(R.drawable.searchline);
                break;
            case "setting":
                preButton.setImageResource(getResources().getIdentifier(preName, "drawable", Constant.PACKAGE));
                preName = "setting";
                preButton = setting;
                setting.setImageResource(R.drawable.settingline);
                break;
        }
    }
}