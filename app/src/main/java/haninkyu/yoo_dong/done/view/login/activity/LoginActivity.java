/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 *
 * 1. 사용자는 카카오계정으로 로그인 버튼을 클릭합니다.
 * 2. 카카오톡 앱에 연결된 카카오계정의 자격정보(Credentials)를 통해 사용자를 인식합니다.
 * 3. 자격정보가 올바르다면 사용자(Resource Owner)로부터 접근 자원에 대한 동의/허가를 얻습니다.
 * 4. 위 3까지 성공적으로 수행되었다면 인증 코드(Authorization Code)가 발급됩니다.
 *    해당 인증 코드는 Redirection URI를 기반으로 Third 앱에 전달됩니다.
 * 5. Third 앱에서는 전달받은 인증 코드를 기반으로 사용자 토큰(Access Token, Refresh Token)을 요청하고 얻게 됩니다.
 */

package haninkyu.yoo_dong.done.view.login.activity;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.security.MessageDigest;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.done.model.GlobalApplication;
import haninkyu.yoo_dong.done.view.activity.BaseActivity;
import haninkyu.yoo_dong.done.view.activity.BaseMainActivity;

public class LoginActivity extends BaseActivity {
    private Context mContext;
    private GlobalApplication gloabal;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        //getAppKeyHash();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        gloabal = GlobalApplication.getGlobalApplicationContext();
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.d("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }

    public void loginBtn(View v){
        if(v.getId()==R.id.signIn){
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        }else if(v.getId()==R.id.find){
            Intent intent = new Intent(this, FindActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.facebook){
            Intent intent = new Intent(this, BaseMainActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.kakaotalk){
            Intent intent = new Intent(this, BaseMainActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.email){
            Intent intent = new Intent(this, BaseMainActivity.class);
            startActivity(intent);
        }else if(v.getId()==R.id.phone){
            Intent intent = new Intent(this, BaseMainActivity.class);
            startActivity(intent);
        }
    }
    /*protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, SampleSignupActivity.class);
        startActivity(intent);
        finish();
    }


    private void requestMe() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onSuccess(final UserProfile userProfile) {
                name = userProfile.getNickname();
                api = new APITask();
                api.execute();
            }

            @Override
            public void onNotSignedUp() {
                // 가입 페이지로 이동
                //redirectSignupActivity();
            }

            @Override
            public void onSessionClosedFailure(APIErrorResult apiErrorResult) {
                // 다시 로그인 시도
                //redirectLoginActivity();
            }

            @Override
            public void onFailure(final APIErrorResult errorResult) {
                // 실패
                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), "failed to update profile. msg = " + errorResult, Toast.LENGTH_LONG).show();
            }
        });
    }
*/
}

