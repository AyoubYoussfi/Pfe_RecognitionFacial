package org.opencv.javacv.facerecognition.control;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.contrib.FaceRecognizer;
import org.opencv.javacv.facerecognition.R;
import org.opencv.javacv.facerecognition.Utils.ImageUtils;

public class OpenCVFaceRecognizer extends Activity {

    FaceRecognizer faceRecognizer;
    Context context = this;
    ImageView imageView1,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_cvface_recognizer);

        imageView1 = (ImageView) findViewById(R.id.ImageView1);
        imageView2 = (ImageView) findViewById(R.id.ImageView2);

        MyOpenCvFaceRecognizer myOpenCvFaceRecognizer = new MyOpenCvFaceRecognizer();

        Bitmap obama1    = BitmapFactory.decodeResource(getResources(), R.drawable.obama1);
        Bitmap obama2    = BitmapFactory.decodeResource(getResources(), R.drawable.obama2);
        Bitmap obama5    = BitmapFactory.decodeResource(getResources(), R.drawable.obama5);
        Bitmap obama6    = BitmapFactory.decodeResource(getResources(), R.drawable.obama6);
        Bitmap obama7    = BitmapFactory.decodeResource(getResources(), R.drawable.obama7);
        Bitmap obama8    = BitmapFactory.decodeResource(getResources(), R.drawable.obama8);


        Bitmap trump1    = BitmapFactory.decodeResource(getResources(), R.drawable.trump1);
     // Bitmap trump2    = BitmapFactory.decodeResource(getResources(), R.drawable.trump2); // problemme with this
        Bitmap trump3    = BitmapFactory.decodeResource(getResources(), R.drawable.trump3); // good
        Bitmap trump4    = BitmapFactory.decodeResource(getResources(), R.drawable.trump4); // good
        Bitmap trump5    = BitmapFactory.decodeResource(getResources(), R.drawable.trump5);

        Bitmap adnane1    = BitmapFactory.decodeResource(getResources(), R.drawable.adnane_ibrahim1);
        Bitmap adnane2   = BitmapFactory.decodeResource(getResources(), R.drawable.adnane_ibrahim2);

        //adnane1 = ImageUtils.GiveFaceFromImage(adnane1,context);
        //adnane2 = ImageUtils.GiveFaceFromImage(adnane2,context);
        //obama5 = ImageUtils.GiveFaceFromImage(obama5,context);

        //obama8 = ImageUtils.GiveFaceFromImage(obama8,context);

        //imageView1.setImageBitmap(obama8);
        //imageView2.setImageBitmap(adnane2);

/*
        obama3 = ImageUtils.GiveFaceFromImage(obama3,context);
        obama4 = ImageUtils.GiveFaceFromImage(obama4,context);
        obama5 = ImageUtils.GiveFaceFromImage(obama5,context);
*/
        double a1 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama1);
        Toast.makeText(this, " resulat ->  " + a1, Toast.LENGTH_SHORT).show();
        Log.d(" test_a1 ", " resultat  ->  " + a1);

        double a2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama2);
        Toast.makeText(this, " resulat ->  " + a2, Toast.LENGTH_SHORT).show();
        Log.d("test_a2", " resultat  ->  " + a2);

        double a3 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama5);
        Toast.makeText(this, " resulat ->  " + a3, Toast.LENGTH_SHORT).show();
        Log.d("test_a3", " resultat  ->  " + a3);

        double a3_1 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama6);
        Toast.makeText(this, " resulat ->  " + a3_1, Toast.LENGTH_SHORT).show();
        Log.d("test_a3", " resultat  ->  " + a3_1);


        double a3_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama7);
        Toast.makeText(this, " resulat ->  " + a3_2, Toast.LENGTH_SHORT).show();
        Log.d("test_a3", " resultat  ->  " + a3_2);

        double a3_3 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1,obama8);
        Toast.makeText(this, " resulat ->  " + a3_3, Toast.LENGTH_SHORT).show();
        Log.d("test_a3", " resultat  ->  " + a3_3);

        Log.d("test_a3", "-------------------------");


        double a4 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, trump1);
        Toast.makeText(this, " resulat ->  " + a4, Toast.LENGTH_SHORT).show();
        Log.d(" test_a4", " resultat  ->  " + a4);


        double a5 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, trump3);
        Toast.makeText(this, " resulat ->  " + a5, Toast.LENGTH_SHORT).show();
        Log.d(" test_a5", " resultat  ->  " + a5);



        double a6 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, trump4);
        Toast.makeText(this, " resulat ->  " + a6, Toast.LENGTH_SHORT).show();
        Log.d(" test_a6", " resultat  ->  " + a6);

        double a7 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, trump5);
        Toast.makeText(this, " resulat ->  " + a7, Toast.LENGTH_SHORT).show();
        Log.d(" test_a7", " resultat  ->  " + a7);


        double a8 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, adnane1);
        Toast.makeText(this, " resulat ->  " + a8, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3", " resultat  ->  " + a8);



        double a1_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(obama1, adnane1);
        Toast.makeText(this, " resulat ->  " + a1_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a1 ", " resultat  ->  " + a1_2);



/*
        String a2_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_2);
        Toast.makeText(this, " resulat ->  " + a2_2, Toast.LENGTH_SHORT).show();
        Log.d("test_a2", " resultat  ->  " + a2_2);

        String a3_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_3);
        Toast.makeText(this, " resulat ->  " + a3_2, Toast.LENGTH_SHORT).show();
        Log.d("test_a3", " resultat  ->  " + a3_2);


        String a4_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_4);
        Toast.makeText(this, " resulat ->  " + a4_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3", " resultat  ->  " + a4_2);

        String a5_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_5);
        Toast.makeText(this, " resulat ->  " + a5_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3", " resultat  ->  " + a5_2);


        String a6_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_6);
        Toast.makeText(this, " resulat ->  " + a6_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3", " resultat  ->  " + a6_2);


        String a7_2 = myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1, ibrahimFaki_7);
        Toast.makeText(this, " resulat ->  " + a7_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3", " resultat  ->  " + a7_2);

        */

    }

}
