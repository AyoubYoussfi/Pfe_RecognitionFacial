package org.opencv.javacv.facerecognition.control;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.opencv.contrib.FaceRecognizer;
import org.opencv.javacv.facerecognition.R;

public class OpenCVFaceRecognizer extends Activity {

    FaceRecognizer faceRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_cvface_recognizer);

        MyOpenCvFaceRecognizer myOpenCvFaceRecognizer = new MyOpenCvFaceRecognizer();

        Bitmap adnaneIbrahime    = BitmapFactory.decodeResource(getResources(), R.drawable.adname_ibrahime);
        Bitmap dakaireNaik    = BitmapFactory.decodeResource(getResources(), R.drawable.dakirenaik);
        Bitmap Opra    = BitmapFactory.decodeResource(getResources(), R.drawable.opra);
        Bitmap Mark    = BitmapFactory.decodeResource(getResources(), R.drawable.markzougonbare);
        Bitmap BellGate    = BitmapFactory.decodeResource(getResources(), R.drawable.bell_gate);
        Bitmap Mask    = BitmapFactory.decodeResource(getResources(), R.drawable.elon_mask);




        Bitmap trump1    = BitmapFactory.decodeResource(getResources(), R.drawable.trump1);
        Bitmap trump2    = BitmapFactory.decodeResource(getResources(), R.drawable.trump2);
        Bitmap trump3    = BitmapFactory.decodeResource(getResources(), R.drawable.trump3);



        Bitmap mohammed6_1 = BitmapFactory.decodeResource(getResources(), R.drawable.mohamed6_1);
        Bitmap mohammed6_2 = BitmapFactory.decodeResource(getResources(), R.drawable.mohamed6_2);
        Bitmap mohammed6_3 = BitmapFactory.decodeResource(getResources(), R.drawable.mohamed6_3);


        Bitmap obama1 = BitmapFactory.decodeResource(getResources(), R.drawable.obama1);
        Bitmap obama2 = BitmapFactory.decodeResource(getResources(), R.drawable.obama2);
        Bitmap obama3 = BitmapFactory.decodeResource(getResources(), R.drawable.obama3);
        Bitmap obama4 = BitmapFactory.decodeResource(getResources(), R.drawable.obama4);
        Bitmap obama5 = BitmapFactory.decodeResource(getResources(), R.drawable.obama5);

        Bitmap ibrahimFaki_1 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_1);
        Bitmap ibrahimFaki_2 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_2);
        Bitmap ibrahimFaki_3 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_3);
        Bitmap ibrahimFaki_4 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_4);
        Bitmap ibrahimFaki_5 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_5);
        Bitmap ibrahimFaki_6 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_6);
        Bitmap ibrahimFaki_7 = BitmapFactory.decodeResource(getResources(), R.drawable.ibrahime_faiki_7);



        myOpenCvFaceRecognizer.Train_2(obama1);
        String w = myOpenCvFaceRecognizer.Predict_2(obama3);

        Toast.makeText(this, "--> "+w, Toast.LENGTH_SHORT).show();

        /*

        String a1 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_2);
        Toast.makeText(this, " resulat ->  "+a1, Toast.LENGTH_SHORT).show();
        Log.d(" test_a1 "," resultat  ->  "+a1);


        String a2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,adnaneIbrahime);
        Toast.makeText(this, " resulat ->  "+a2, Toast.LENGTH_SHORT).show();
        Log.d("test_a2"," resultat  ->  "+a2);

        String a3 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,dakaireNaik);
        Toast.makeText(this, " resulat ->  "+a3, Toast.LENGTH_SHORT).show();
        Log.d("test_a3"," resultat  ->  "+a3);


        String a4 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,Opra);
        Toast.makeText(this, " resulat ->  "+a4, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a4);

        String a5 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,Mark);
        Toast.makeText(this, " resulat ->  "+a5, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a5);


        String a6 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,BellGate);
        Toast.makeText(this, " resulat ->  "+a6, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a6);


        String a7 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,Mask);
        Toast.makeText(this, " resulat ->  "+a7, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a7);


        Log.d(" test_a3","------------------- ");

        String a1_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_1);
        Toast.makeText(this, " resulat ->  "+a1_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a1 "," resultat  ->  "+a1_2);


        String a2_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_2);
        Toast.makeText(this, " resulat ->  "+a2_2, Toast.LENGTH_SHORT).show();
        Log.d("test_a2"," resultat  ->  "+a2_2);

        String a3_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_3);
        Toast.makeText(this, " resulat ->  "+a3_2, Toast.LENGTH_SHORT).show();
        Log.d("test_a3"," resultat  ->  "+a3_2);


        String a4_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_4);
        Toast.makeText(this, " resulat ->  "+a4_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a4_2);

        String a5_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_5);
        Toast.makeText(this, " resulat ->  "+a5_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a5_2);


        String a6_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_6);
        Toast.makeText(this, " resulat ->  "+a6_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a6_2);


        String a7_2 =myOpenCvFaceRecognizer.TrainAndConfedence_2(ibrahimFaki_1,ibrahimFaki_7);
        Toast.makeText(this, " resulat ->  "+a7_2, Toast.LENGTH_SHORT).show();
        Log.d(" test_a3"," resultat  ->  "+a7_2);




















        //Bitmap trump1    = BitmapFactory.decodeResource(getResources(), R.drawable.trump1);
        //Bitmap mohammed6 = BitmapFactory.decodeResource(getResources(), R.drawable.mohamed6_1);

        /*

        Bitmap justin     = BitmapFactory.decodeResource(getResources(), R.drawable.justin);
        Bitmap johnshnow  = BitmapFactory.decodeResource(getResources(), R.drawable.johnsnow);
        Bitmap clintone   = BitmapFactory.decodeResource(getResources(), R.drawable.clintone);
        Bitmap putiine    = BitmapFactory.decodeResource(getResources(), R.drawable.putiin);
        Bitmap boutaflika = BitmapFactory.decodeResource(getResources(), R.drawable.boutaflika);
        Bitmap chinwie    = BitmapFactory.decodeResource(getResources(), R.drawable.chinwi);

        Bitmap obama2 = BitmapFactory.decodeResource(getResources(), R.drawable.obama2);
        Bitmap obama3 = BitmapFactory.decodeResource(getResources(), R.drawable.obama3);
        Bitmap obama4 = BitmapFactory.decodeResource(getResources(), R.drawable.obama4);

        Bitmap trump2 = BitmapFactory.decodeResource(getResources(), R.drawable.trump2);
        Bitmap trump3 = BitmapFactory.decodeResource(getResources(), R.drawable.trump3);


        Bitmap arrayBitmap [] = new Bitmap[10];
        arrayBitmap[0] =  toGrayscale2(obama1);


        //arrayBitmap[1] =  toGrayscale2(trump1);
        //arrayBitmap[2] =  toGrayscale2(mohammed6);

        //arrayBitmap[2] =  toGrayscale(johnshnow);
        Bitmap myTestBitmapObama    = toGrayscale2(obama1);
        //Bitmap myTestBitmapTrump    = toGrayscale2(trump1);
        //Bitmap myTestBitmapMohammed = toGrayscale2(mohammed6);

        Bitmap myTestBitmapObama_2 = toGrayscale2(obama2);
        Bitmap myTestBitmapObama_3 = toGrayscale2(obama3);
        Bitmap myTestBitmapObama_4 = toGrayscale2(obama4);

        Bitmap myTestBitmapTrump_2 = toGrayscale2(trump2);
        Bitmap myTestBitmapTrump_3 = toGrayscale2(trump3);

        Bitmap myTestBitmapJustinbiber  = toGrayscale2(justin);
        Bitmap myTestBitmapJohnShnow    = toGrayscale2(johnshnow);
        Bitmap myTestBitmapclintone     = toGrayscale2(clintone);
        Bitmap myTestBitmapputtine      = toGrayscale2(putiine);
        Bitmap myTestBitmapboutaflika   = toGrayscale2(boutaflika);
        Bitmap myTestBitmapchinwie   = toGrayscale2(chinwie);

        //myOpenCvFaceRecognizer.Train2(arrayBitmap);
        //String message  = myOpenCvFaceRecognizer.predict(myTestBitmap);

        String mesaage1 =myOpenCvFaceRecognizer.TrainAndConfedence_2(arrayBitmap[0],myTestBitmapObama);
        Toast.makeText(this, " 1) obama -->  "+mesaage1, Toast.LENGTH_LONG).show(); //0
        Log.e("test_obama","-> "+mesaage1);

        //String mesaage2 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapTrump);
        //Toast.makeText(this, " 2) trump -->  "+mesaage2, Toast.LENGTH_LONG).show(); // 1
        //Log.d("test_trump","-> "+mesaage2);

        //String mesaage3 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapMohammed);
        //Toast.makeText(this, " 3) mohammed-->  "+mesaage3, Toast.LENGTH_LONG).show(); // 2
        //Log.d("test_mohammed6","-> "+mesaage3);

        // ayoub youssfi
        String mesaage4 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapObama_2);
        Toast.makeText(this, " obama 4) -->  "+mesaage4, Toast.LENGTH_LONG).show();
        Log.d("test_obama_2","-> "+mesaage4);



        String mesaage5 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapObama_3);
        Toast.makeText(this, "obama 5) -->  "+mesaage5, Toast.LENGTH_LONG).show();
        Log.d("test_obama_3","-> "+mesaage5);

        String mesaage5_2 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapObama_4);
        Toast.makeText(this, "obama 5)_2 -->  "+mesaage5, Toast.LENGTH_LONG).show();
        Log.d("test_obama_4","-> "+mesaage5_2);

        String mesaage6 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapTrump_2);
        Toast.makeText(this, "trump 6) -->  "+mesaage6, Toast.LENGTH_LONG).show();
        Log.d("test_trump_2","-> "+mesaage6);

        String mesaage7 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapTrump_3);
        Toast.makeText(this, "trump 7) -->  "+mesaage7, Toast.LENGTH_LONG).show();
        Log.d("test_trump_3","-> "+mesaage7);

        String mesaage8 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapJustinbiber);
        Toast.makeText(this, "JustinBiber 8) -->  "+mesaage8, Toast.LENGTH_LONG).show();
        Log.d("test_Justin_biber","-> "+mesaage8);

        String mesaage9 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapJohnShnow);
        Toast.makeText(this, "John shnow 9) -->  "+mesaage9, Toast.LENGTH_LONG).show();
        Log.d("test_JohnShnow","-> "+mesaage9);

        String mesaage10 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapclintone);
        Toast.makeText(this, "clintone 10) -->  "+mesaage10, Toast.LENGTH_LONG).show();
        Log.d("test_clintone","-> "+mesaage10);

        String mesaage11 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapputtine);
        Toast.makeText(this, "puttine 11) -->  "+mesaage11, Toast.LENGTH_LONG).show();
        Log.d("test_puttine","-> "+mesaage11);

        String mesaage12 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapboutaflika);
        Toast.makeText(this, "boutaflika 12) -->  "+mesaage12, Toast.LENGTH_LONG).show();
        Log.d("test_boutaflika","-> "+mesaage12);

        String mesaage13 =myOpenCvFaceRecognizer.TrainAndConfedence(arrayBitmap,myTestBitmapchinwie);
        Toast.makeText(this, "boutaflika 12) -->  "+mesaage13, Toast.LENGTH_LONG).show();
        Log.d("test_boutaflika","-> "+mesaage13);
    }

    public Bitmap toGrayscale(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    public Bitmap ConvertToGrayscale(Bitmap bitmap) {

        float[] arrayForColorMatrix = new float[] {0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0};

        Bitmap.Config config = bitmap.getConfig();
        Bitmap grayScaleBitmap = Bitmap.createBitmap(128, 128, config);

        Canvas c = new Canvas(grayScaleBitmap);
        Paint paint = new Paint();

        ColorMatrix matrix = new ColorMatrix(arrayForColorMatrix);
        matrix.setSaturation(0);

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        paint.setColorFilter(filter);

        c.drawBitmap(bitmap, 0, 0, paint);

        return grayScaleBitmap;
    }

    public Bitmap toGrayscale2(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();
        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(f);
        canvas.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;

        */
    }

}
