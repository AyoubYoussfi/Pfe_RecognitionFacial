package org.opencv.javacv.facerecognition.Test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.javacv.facerecognition.DataBase.UserSharedPreferences;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;


public class Test_Ayoub extends AppCompatActivity {

    RadioButton radioButtonHomme,radioButtonFemme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__ayoub);

        radioButtonHomme = (RadioButton) findViewById(R.id.homme);
        radioButtonFemme = (RadioButton) findViewById(R.id.femme);

        radioButtonHomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test_Ayoub.this, ""+radioButtonHomme.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        radioButtonFemme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(Test_Ayoub.this, ""+radioButtonFemme.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
