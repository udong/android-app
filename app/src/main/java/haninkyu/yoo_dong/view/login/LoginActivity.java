package haninkyu.yoo_dong.view.login;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.model.Constant;
import haninkyu.yoo_dong.model.GlobalApplication;
import haninkyu.yoo_dong.view.activity.BaseActivity;
import haninkyu.yoo_dong.view.activity.BaseMainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.Session;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.security.MessageDigest;

public class LoginActivity extends BaseActivity {
    private Context mContext;
    private GlobalApplication gloabal;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        getAppKeyHash();
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

