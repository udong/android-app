/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.doing.view.activity;

import android.os.Bundle;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.doing.control.HttpTestConnection;
import haninkyu.yoo_dong.done.view.activity.BaseActivity;

public class ClubCreateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_club);
        new HttpTestConnection(this).execute("clubs");
    }
}
