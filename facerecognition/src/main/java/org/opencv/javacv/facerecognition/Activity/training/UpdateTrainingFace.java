package org.opencv.javacv.facerecognition.Activity.training;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.opencv.javacv.facerecognition.DataBase.DBimage;
import org.opencv.javacv.facerecognition.DataBase.UserSharedPreferences;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;
import org.opencv.javacv.facerecognition.Utils.OpenCvFaceRecognizer;


public class UpdateTrainingFace extends AppCompatActivity {

    static final int intREQUEST_IMAGE_CAPTURE = 1;
    DBimage dBimage;
    OpenCvFaceRecognizer openCvFaceRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_training_face);

        dBimage = new DBimage(this);
        openCvFaceRecognizer = new OpenCvFaceRecognizer();

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!= null ) {
            startActivityForResult(takePictureIntent,intREQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == intREQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imageBithmap = (Bitmap) extras.get("data");

            Bitmap ImageDataBase =  ImageUtils.FromBytesToBithmap(dBimage.afficheSimpleImage());

            double score = openCvFaceRecognizer.TrainAndPredict(ImageDataBase,imageBithmap);
            Toast.makeText(this, "score "+score, Toast.LENGTH_SHORT).show();
            Log.d(" test_ ", " resultat  ->  " + score);


            super.finish();
        }
    }

}
