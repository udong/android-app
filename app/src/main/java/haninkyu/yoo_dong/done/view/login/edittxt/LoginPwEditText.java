/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.done.view.login.edittxt;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by IVE on 2015-12-03.
 */
public class LoginPwEditText extends EditText implements EditText.OnFocusChangeListener {
    private int myColor;
    private boolean duplicate = false;

    public LoginPwEditText(Context context) {
        super(context);
        init(context);
        setOnFocusChangeListener(this);
    }

    public LoginPwEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setOnFocusChangeListener(this);
    }

    public LoginPwEditText(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
        init(context);
        setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus()) {
            ((LoginPwEditText) v).setHintTextColor(Color.parseColor("#00ffffff"));
            duplicate = false;
        } else {
            ((LoginPwEditText) v).setHintTextColor(myColor);
        }
        v.invalidate();
    }

    public void init(Context context) {/*
        if(context.getClass() == BaseLoginActivity.class){
            myColor = Color.parseColor("#ffffff");
        }else{*/
        myColor = Color.parseColor("#7b7b7b");
        //}
        setTextSize(12);
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        setGravity(Gravity.CENTER_HORIZONTAL);
    }

    public void duplicateChk() {
        duplicate = true;
    }

    public boolean getduplicate() {
        return duplicate;
    }
}