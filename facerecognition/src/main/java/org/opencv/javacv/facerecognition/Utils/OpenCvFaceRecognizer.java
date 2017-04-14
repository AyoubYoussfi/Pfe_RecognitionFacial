package org.opencv.javacv.facerecognition.Utils;

import android.graphics.Bitmap;
import android.util.Log;

import com.googlecode.javacv.cpp.opencv_contrib;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_imgproc;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import static com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer;
import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static org.opencv.javacv.facerecognition.Utils.ImageUtils.FromRgbToGrayscale;

public class OpenCvFaceRecognizer {

    private double mProb = 999;
    opencv_contrib.FaceRecognizer faceRecognizer;
    static  final int WIDTH= 128;
    static  final int HEIGHT= 128;

    public OpenCvFaceRecognizer(){
        faceRecognizer =  com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer(2,8,8,8,200);
    }


    public void Train(Bitmap bithmap) {

        opencv_core.MatVector images = new opencv_core.MatVector(1);
        int[] labels = new int[1];

        opencv_core.IplImage img  = BitmapToIplImage(bithmap,WIDTH,HEIGHT);

        if (img==null)
            Log.e("Error","Error cVLoadImage");

        images.put(0, img);
        labels[0] = 1;

        faceRecognizer.train(images, labels);
    }

    public String Predict(Bitmap bitmapTest) {
        int n[] = new int[1];
        double p[] = new double[1];
        opencv_core.IplImage ipl = BitmapToIplImage(bitmapTest,WIDTH,HEIGHT);
        faceRecognizer.predict(ipl, n, p);

        return " label "+n[0]+" confidence : "+p[0];
    }

    public double TrainAndPredict(Bitmap bithmap,Bitmap bitmapTest) {

        opencv_core.MatVector images = new opencv_core.MatVector(1);
        int[] labels = new int[1];

        opencv_core.IplImage img  = BitmapToIplImage(FromRgbToGrayscale(bithmap) ,WIDTH,HEIGHT);

        if (img==null)
            Log.e("Error","Error cVLoadImage");

        images.put(0, img);
        labels[0] = 1;
        // train
        faceRecognizer.train(images, labels);

        // prediction
        int n[] = new int[1];
        double p[] = new double[1];

        opencv_core.IplImage ipl = BitmapToIplImage(FromRgbToGrayscale(bitmapTest) ,WIDTH,HEIGHT);
        faceRecognizer.predict(ipl, n, p);

        //mProb = ;
        return p[0];
    }


    opencv_core.IplImage MatToIplImage(Mat m, int width, int heigth) {
        Bitmap bmp=Bitmap.createBitmap(m.width(), m.height(), Bitmap.Config.ARGB_8888);

        Utils.matToBitmap(m, bmp);
        return BitmapToIplImage(bmp,width, heigth);
    }

    opencv_core.IplImage BitmapToIplImage(Bitmap bmp, int width, int height) {

        if ((width != -1) || (height != -1)) {
            Bitmap bmp2 = Bitmap.createScaledBitmap(bmp, width, height, false);
            bmp = bmp2;
        }

        opencv_core.IplImage image = opencv_core.IplImage.create(bmp.getWidth(), bmp.getHeight(), IPL_DEPTH_8U, 4);

        bmp.copyPixelsToBuffer(image.getByteBuffer());

        opencv_core.IplImage grayImg = opencv_core.IplImage.create(image.width(), image.height(), IPL_DEPTH_8U, 1);

        cvCvtColor(image, grayImg, opencv_imgproc.CV_BGR2GRAY);

        return grayImg;
    }

}
