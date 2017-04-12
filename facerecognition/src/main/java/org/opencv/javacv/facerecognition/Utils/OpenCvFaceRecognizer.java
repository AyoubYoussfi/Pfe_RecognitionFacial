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

public class OpenCvFaceRecognizer {

    private int mProb1 = 999;
    opencv_contrib.FaceRecognizer faceRecognizer;
    static  final int WIDTH= 128;
    static  final int HEIGHT= 128;

    OpenCvFaceRecognizer(){
        faceRecognizer = createLBPHFaceRecognizer();  // good 0.0  0.0 0.0  ather 30 greate I chose this
        //faceRecognizer =  com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer(2,8,8,8,200); // good ather 32.0 great
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer(1,8,8,8,100);// ather 68 ou 32 ou 44
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createFisherFaceRecognizer(); not good for obama2,3...
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createEigenFaceRecognizer(10,123.0); // not good for ather
        //faceRecognizer = createFisherFaceRecognizer(); //not good
        //faceRecognizer = createEigenFaceRecognizer();
    }


    public void Train_2(Bitmap bithmap) {

        opencv_core.MatVector images = new opencv_core.MatVector(1);
        int[] labels = new int[1];

        opencv_core.IplImage img  = BitmapToIplImage(bithmap,WIDTH,HEIGHT);

        if (img==null)
            Log.e("Error","Error cVLoadImage");

        images.put(0, img);
        labels[0] = 1;

        faceRecognizer.train(images, labels);
    }

    public String Predict_2(Bitmap bitmapTest) {
        int n[] = new int[1];
        double p[] = new double[1];
        opencv_core.IplImage ipl = BitmapToIplImage(bitmapTest,WIDTH,HEIGHT);
        faceRecognizer.predict(ipl, n, p);

        return " label "+n[0]+" confidence : "+p[0];
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
