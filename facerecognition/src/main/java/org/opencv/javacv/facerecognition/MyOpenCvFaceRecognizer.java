package org.opencv.javacv.facerecognition;

import android.graphics.Bitmap;
import android.util.Log;


import com.googlecode.javacv.cpp.opencv_contrib;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_imgproc;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import static com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2GRAY;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;

public class MyOpenCvFaceRecognizer {

    private int mProb1 = 999;
    opencv_contrib.FaceRecognizer faceRecognizer;
    static  final int WIDTH= 128;
    static  final int HEIGHT= 128;

    MyOpenCvFaceRecognizer(){
        //faceRecognizer = createLBPHFaceRecognizer();  // good 0.0  0.0 0.0  ather 30 greate I chose this
        faceRecognizer =  com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer(2,8,8,8,200); // good ather 32.0 great
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createLBPHFaceRecognizer(1,8,8,8,100);// ather 68 ou 32 ou 44
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createFisherFaceRecognizer(); not good for obama2,3...
        //faceRecognizer = com.googlecode.javacv.cpp.opencv_contrib.createEigenFaceRecognizer(10,123.0); // not good for ather
        //faceRecognizer = createFisherFaceRecognizer(); //not good
        //faceRecognizer = createEigenFaceRecognizer();
    }

    // Train Face take face
    public void Train(Bitmap imageFiles[]) {

        opencv_core.MatVector images = new opencv_core.MatVector(10);
        int[] labels = new int[10];

        int counter = 0;
        int label;

        opencv_core.IplImage img = null;
        opencv_core.IplImage grayImg;


        //opencv_core.IplImage imageFiles[] = new opencv_core.IplImage[10];


            for (Bitmap image : imageFiles) {


            img = BitmapToIplImage(image,WIDTH,HEIGHT);

            if (img==null)
                Log.e("Error","Error cVLoadImage");
            //Log.i("image",p);

            label = 0;

            grayImg = opencv_core.IplImage.create(img.width(), img.height(), IPL_DEPTH_8U, 1);
            cvCvtColor(img, grayImg, CV_BGR2GRAY);
            images.put(counter, grayImg);
            labels[counter] = label;
            counter++;

        }
        faceRecognizer.train(images, labels);
    }


    public void Train2(Bitmap bithmap[]) {

        opencv_core.MatVector images = new opencv_core.MatVector(10);
        int[] labels = new int[10];
// --->
        int counter = 0;
        int label;

        opencv_core.IplImage img = null;
        opencv_core.IplImage grayImg;


        opencv_core.IplImage imageFiles[] = new opencv_core.IplImage[10];

        imageFiles[0]= BitmapToIplImage(bithmap[0],WIDTH,HEIGHT);
        imageFiles[1]= BitmapToIplImage(bithmap[1],WIDTH,HEIGHT);
        imageFiles[2]= BitmapToIplImage(bithmap[2],WIDTH,HEIGHT);


        for (opencv_core.IplImage image : imageFiles) {

            img = image;
                    //cvLoadImage(p);  // chie 7ajahna na9sa

            if (img==null)
                Log.e("Error","Error cVLoadImage");
            //Log.i("image",p);

            grayImg = opencv_core.IplImage.create(128, 128, IPL_DEPTH_8U, 1);
            //cvCvtColor(img, grayImg,CV_RGB2GRAY);// CV_BGR2GRAY

            images.put(counter, grayImg);
            labels[counter] = counter;
            counter++;
        }

        if (counter>0)
                faceRecognizer.train(images, labels);
        Log.d("test","First Test Succes");
    }

    // predict image
    // public String predict(Mat m)
    public String predict(Bitmap bitmap) {

        Mat m = new Mat();
        Utils.bitmapToMat(bitmap,m);

        int n[] = new int[1];
        double p[] = new double[1];
        opencv_core.IplImage ipl = MatToIplImage(m,WIDTH, HEIGHT);
//		IplImage ipl = MatToIplImage(m,-1, -1);

        faceRecognizer.predict(ipl, n, p); // int -> n : Label ;   double -> p : confidence

        return " label "+n[0]+" confidence : "+p[0];
       /* if (n[0]!=-1)
            mProb1 = (int)p[0];
        else
            mProb1 = -1;
        //	if ((n[0] != -1)&&(p[0]<95))
        if (n[0] != -1)
            return  " success -> : "+(n[0]+" prob "+mProb1);//   labelsFile.get(n[0]);
        else
            return "Unkown"; */
    }

    public String TrainAndConfedence(Bitmap bithmap[],Bitmap bitmapTest) {

        opencv_core.MatVector images = new opencv_core.MatVector(3);
        int[] labels = new int[3];
// --->
        int counter = 0;
        int label;

        opencv_core.IplImage img = null;
        opencv_core.IplImage grayImg;


        opencv_core.IplImage imageFiles[] = new opencv_core.IplImage[3];

        imageFiles[0]= BitmapToIplImage(bithmap[0],WIDTH,HEIGHT);
        imageFiles[1]= BitmapToIplImage(bithmap[1],WIDTH,HEIGHT);
        imageFiles[2]= BitmapToIplImage(bithmap[2],WIDTH,HEIGHT);


        for (opencv_core.IplImage image : imageFiles) {

            img = image;
            //cvLoadImage(p);  // chie 7ajahna na9sa

            if (img==null)
                Log.e("Error","Error cVLoadImage");
            //Log.i("image",p);


            //grayImg = opencv_core.IplImage.create(128, 128, IPL_DEPTH_8U, 1);
            //cvCvtColor(img, grayImg,CV_BGR2GRAY);// CV_BGR2GRAY

            images.put(counter, img);
            labels[counter] = counter;
            counter++;
        }

        if (counter>0)
            faceRecognizer.train(images, labels);
        Log.d("test","First Test Succes");

        // prediction
        int n[] = new int[1];
        double p[] = new double[1];
        opencv_core.IplImage ipl = BitmapToIplImage(bitmapTest,WIDTH,HEIGHT);
//		IplImage ipl = MatToIplImage(m,-1, -1);

        faceRecognizer.predict(ipl, n, p); // int -> n : Label ;   double -> p : confidence

        return " label "+n[0]+" confidence : "+p[0];

    }


    public String TrainAndConfidence_3(){

        opencv_core.MatVector images = new opencv_core.MatVector(3);
        int[] labels = new int[3];

        opencv_core.IplImage img = null;
        opencv_core.IplImage grayImg;

        //img = BitmapToIplImage();


        return"";
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
