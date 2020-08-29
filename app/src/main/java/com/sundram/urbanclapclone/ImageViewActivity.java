package com.sundram.urbanclapclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ImageViewActivity.this, DashBoard.class));
        finish();
//    }
//    Intent _intent = new Intent(this, newscreen.class);
//    Bitmap _bitmap; // your bitmap
//    ByteArrayOutputStream _bs = new ByteArrayOutputStream();
//_bitmap.compress(Bitmap.CompressFormat.PNG, 50, _bs);
//_intent.putExtra("byteArray", _bs.toByteArray());
//    startActivity(_intent);
//        if(getIntent().hasExtra("byteArray")) {
//            ImageView _imv= new ImageView(this);
//            Bitmap _bitmap = BitmapFactory.decodeByteArray(
//                    getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
//            _imv.setImageBitmap(_bitmap);
//        }
    }
}
