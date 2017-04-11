package org.opencv.javacv.facerecognition.Test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;


public class Test_Ayoub extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__ayoub);

        imageView = (ImageView) findViewById(R.id.ImageView);

        Bitmap man    = BitmapFactory.decodeResource(getResources(), R.drawable.man);

        Bitmap bitmap =ImageUtils.GiveFaceFromImage(man,this);

        imageView.setImageBitmap(bitmap);

    }
}
