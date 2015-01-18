package com.os.operando.selectimagesample;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_GALLERY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSelectImage(View v) {
        startActivityForResult(IntentUtil.createPickImage(), REQUEST_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_GALLERY) {
            Uri uri = data.getData();
            if (ContentResolver.SCHEME_CONTENT.equals(uri.getScheme())) {
                ((ImageView) findViewById(R.id.image)).setImageURI(uri);
            }
        }
    }
}
