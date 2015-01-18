package com.os.operando.selectimagesample;

import android.content.Intent;

public class IntentUtil {

    public static Intent createPickImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        return intent;
    }
}
