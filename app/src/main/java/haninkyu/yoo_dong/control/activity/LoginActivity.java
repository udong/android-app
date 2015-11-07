/*
package haninkyu.yoo_dong.control.activity;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.control.GlobalApplication;
import haninkyu.yoo_dong.model.Constant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.security.MessageDigest;

public class LoginActivity extends Activity {
    private com.kakao.usermgmt.LoginButton kakao_btn;
    private Session session;
    private MySessionStatusCallback  callback;
    private Context mContext;
    private GlobalApplication gloabal;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        getAppKeyHash();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
*/
/*
        gloabal = GlobalApplication.getGlobalApplicationContext();
        mContext = this;*//*


        callback = new MySessionStatusCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 세션이 완전 종료된 상태로 갱신도 할 수 없으므로 명시적 오픈을 위한 로그인 버튼을 보여준다.
        if (session.isClosed()) {
            kakao_btn.setVisibility(View.VISIBLE);
        }
        // 세션을 가지고 있거나, 갱신할 수 있는 상태로 명시적 오픈을 위한 로그인 버튼을 보여주지 않는다.
        else {
            kakao_btn.setVisibility(View.GONE);
            // 갱신이 가능한 상태라면 갱신을 시켜준다.
            Log.i(Constant.LOG, session.checkState() + "");
            if (session.isOpened()) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else if (session.isOpenable()) {
                session.implicitOpen();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
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

    private class MySessionStatusCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            redirectSignupActivity();
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            kakao_btn.setVisibility(View.VISIBLE);
            if(exception != null) {
                Logger.e(exception);
            }
        }

    }
    protected void redirectSignupActivity() {
        final Intent intent = new Intent(this, SampleSignupActivity.class);
        startActivity(intent);
        finish();
    }
*/
/*
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
    }*//*

}
*/
