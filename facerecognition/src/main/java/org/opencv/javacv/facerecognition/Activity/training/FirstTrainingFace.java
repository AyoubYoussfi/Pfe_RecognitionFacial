package org.opencv.javacv.facerecognition.Activity.training;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.opencv.javacv.facerecognition.DataBase.DBimage;
import org.opencv.javacv.facerecognition.DataBase.UserSharedPreferences;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;


public class FirstTrainingFace extends AppCompatActivity {

    static final int intREQUEST_IMAGE_CAPTURE = 1;
    DBimage dBimage;
    UserSharedPreferences userSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_training_face);

        dBimage = new DBimage(this);
        userSharedPreferences = new UserSharedPreferences(this);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!= null ){
            startActivityForResult(takePictureIntent,intREQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == intREQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imageBithmap = (Bitmap) extras.get("data");
            Bitmap imageFace    = ImageUtils.GiveFaceFromImage(imageBithmap,this);

            //imageViewSimple.setImageBitmap(imageBithmap);
            //imageViewCut.setImageBitmap(bitmap2);

            dBimage.addimage(ImageUtils.FromBithMapToBytes(imageBithmap),ImageUtils.FromBithMapToBytes(imageFace));
            userSharedPreferences.setTraining(true);
            super.finish();
        }
    }
}
