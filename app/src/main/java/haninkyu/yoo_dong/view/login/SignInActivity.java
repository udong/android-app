/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.view.activity.BaseActivity;

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signinBtn(View v){
        if(v.getId()==R.id.email){
            Intent intent = new Intent(this, SignInFormActivity.class);
            startActivity(intent);
        }

    }
}
