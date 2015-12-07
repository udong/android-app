/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.view.login;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.model.Constant;
import haninkyu.yoo_dong.view.activity.BaseActivity;
import haninkyu.yoo_dong.view.imageview.CircleImageView;

public class SignInFormActivity extends BaseActivity {
    private String path;
    private Bitmap bitmap;
    private CircleImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_form);
        profile = (CircleImageView) findViewById(R.id.image);

    }

    public void signinformBtn(View v) {
        if (v.getId() == R.id.image) {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, Constant.REQUEST_IMAGE_ALBUM);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constant.REQUEST_IMAGE_ALBUM:
                    path = getPathFromUri(data.getData());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(path, options);
                    profile.setImageBitmap(bitmap);
                    break;
            }
        } else {
            finish();
        }
    }

    public String getPathFromUri(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToNext();
        String path = cursor.getString(cursor.getColumnIndex("_data"));
        cursor.close();

        return path;
    }
}
