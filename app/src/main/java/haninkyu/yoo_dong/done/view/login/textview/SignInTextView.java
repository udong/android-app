/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.done.view.login.textview;

import android.app.ActionBar;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by IVE on 2015-12-03.
 */
public class SignInTextView extends TextView {
    public SignInTextView(Context context) {
        super(context);
        Init();
    }

    public SignInTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init();
    }

    public SignInTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init();
    }

    private void Init(){
        setTextSize(12);
        setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setGravity(Gravity.CENTER);
    }
}
