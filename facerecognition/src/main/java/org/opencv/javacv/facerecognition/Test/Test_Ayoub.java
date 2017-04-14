package org.opencv.javacv.facerecognition.Test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import org.opencv.android.Utils;
import org.opencv.javacv.facerecognition.DataBase.DBimage;
import org.opencv.javacv.facerecognition.DataBase.UserSharedPreferences;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;
import org.opencv.javacv.facerecognition.Utils.OpenCvFaceRecognizer;


public class Test_Ayoub extends AppCompatActivity {

    ImageView imageViewSimple;
    ImageView imageViewCut;
    Bitmap bmap;
    DBimage dBimage;

    static final int intREQUEST_IMAGE_CAPTURE =1;

    ImageView imageViewSimple_2;
    ImageView imageViewCut_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__ayoub);

        dBimage = new DBimage(this);


        OpenCvFaceRecognizer openCvFaceRecognizer = new OpenCvFaceRecognizer();
        double a1 = openCvFaceRecognizer.TrainAndPredict(ImageUtils.FromBytesToBithmap(dBimage.afficheFaceImage()) ,ImageUtils.FromBytesToBithmap(dBimage.afficheFaceImage()) );

        Toast.makeText(this, " resulat ->  " + a1, Toast.LENGTH_SHORT).show();
        Log.d("test_", " resultat  ->  " + a1);
    }


        /*

        Bitmap bitmap1_1 =  ImageUtils.FromBytesToBithmap(dBimage.afficheSimpleImage());
        Bitmap bitmap1_2 =  ImageUtils.FromBytesToBithmap(dBimage.afficheFaceImage());

        imageViewSimple_2.setImageBitmap(bitmap1_1);
        imageViewCut_2.setImageBitmap(bitmap1_2);

        */



}
