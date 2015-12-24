/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.done.view.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.done.view.activity.BaseActivity;

public class TutorialActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
    }

    public void tutorialBtn(View v){
        if(v.getId()==R.id.logIn){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.signIn){
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }
}
