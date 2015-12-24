/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.done.view.login.edittxt;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by IVE on 2015-12-03.
 */
public class LoginEditText extends EditText implements View.OnFocusChangeListener{
    private int myColor;
    private boolean duplicate = false;

    public LoginEditText(Context context) {
        super(context);
        init(context);
        setOnFocusChangeListener(this);
    }

    public LoginEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setOnFocusChangeListener(this);
    }

    public LoginEditText(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
        init(context);
        setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            ((LoginEditText) v).setHintTextColor(Color.parseColor("#00ffffff"));
            duplicate = false;
        } else {
            ((LoginEditText) v).setHintTextColor(myColor);
        }
        v.invalidate();
    }

    public void init(Context context) {/*
        if(context.getClass() == BaseLoginActivity.class){
            myColor = Color.parseColor("#ffffff");
        }else{*/
        myColor = Color.parseColor("#7b7b7b");
        setGravity(Gravity.CENTER_HORIZONTAL);
        setTextSize(12);
        //}
    }

    public void duplicateChk() {
        duplicate = true;
    }

    public boolean getduplicate() {
        return duplicate;
    }
}
