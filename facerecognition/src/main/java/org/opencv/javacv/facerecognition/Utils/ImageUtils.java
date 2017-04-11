package org.opencv.javacv.facerecognition.Utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.media.FaceDetector;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.io.IOException;

import static android.media.FaceDetector.Face.EULER_Y;


public class ImageUtils {

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    //Get Path Image file
    public final static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    //Rotate Bitmap
    public final static Bitmap rotate(Bitmap b, float degrees) {
        if (degrees != 0 && b != null) {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) b.getWidth() / 2,
                    (float) b.getHeight() / 2);

            Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(),
                    b.getHeight(), m, true);
            if (b != b2) {
                b.recycle();
                b = b2;
            }
        }
        return b;
    }


    public static Bitmap getBitmap(String filePath, int width, int height) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = ImageUtils.calculateInSampleSize(options, width, height);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;

        Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

        if (bitmap != null) {
            try {
                ExifInterface ei = new ExifInterface(filePath);
                int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                switch (orientation) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        bitmap = ImageUtils.rotate(bitmap, 90);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        bitmap = ImageUtils.rotate(bitmap, 180);
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        bitmap = ImageUtils.rotate(bitmap, 270);
                        break;
                    // etc.
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bitmap;
    }


    public static Bitmap cropBitmap(Bitmap bitmap, Rect rect) {
        int w = rect.right - rect.left;
        int h = rect.bottom - rect.top;
        Bitmap ret = Bitmap.createBitmap(w, h, bitmap.getConfig());
        Canvas canvas = new Canvas(ret);
        canvas.drawBitmap(bitmap, -rect.left, -rect.top, null);
        bitmap.recycle();
        return ret;
    }


    public static Bitmap cropFace(FaceResult face, Bitmap bitmap, int rotate) {
        Bitmap bmp;

        float eyesDis = face.eyesDistance();
        PointF mid = new PointF();
        face.getMidPoint(mid);

        Rect rect = new Rect(
                (int) (mid.x - eyesDis * 1.20f),
                (int) (mid.y - eyesDis * 0.55f),
                (int) (mid.x + eyesDis * 1.20f),
                (int) (mid.y + eyesDis * 1.85f));

        Bitmap.Config config = Bitmap.Config.RGB_565;
        if (bitmap.getConfig() != null) config = bitmap.getConfig();
        bmp = bitmap.copy(config, true);

        switch (rotate) {
            case 90:
                bmp = ImageUtils.rotate(bmp, 90);
                break;
            case 180:
                bmp = ImageUtils.rotate(bmp, 180);
                break;
            case 270:
                bmp = ImageUtils.rotate(bmp, 270);
                break;
        }

        bmp = ImageUtils.cropBitmap(bmp, rect);
        return bmp;
    }

    public static Bitmap GiveFaceFromImage(Bitmap photoFromCamera, Context context) {

        /*
        convertir oo=new convertir();
        Intent ii=new Intent(MainActivity.this,cadre.class);
        ii.putExtra("img",oo.getBytes(photo));
        startActivity(ii);
        */

        Bitmap RFaceFromImage;
        Bitmap destination;

        final Bitmap image = photoFromCamera;
        //final Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
        destination = Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.RGB_565);

        final Canvas canvas = new Canvas(destination);

        float mXRatio=50;
        float mYRatio=50;

        int viewWidth = canvas.getWidth();
        int viewHeight = canvas.getHeight();

        Paint mColor = new Paint(Paint.ANTI_ALIAS_FLAG);

        canvas.drawBitmap(image, null, new Rect(0, 0, viewWidth, viewHeight), mColor);
        // canvas.drawBitmap(image, 0, 0,mColor);

        final PointF pt = new PointF();
        final Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);


        final FaceDetector.Face[] faces = new FaceDetector.Face[1];
        final FaceDetector detect = new FaceDetector(image.getWidth(), image.getHeight(), 1);
        int n = detect.findFaces(destination, faces);


        if (n > 0) {
            final FaceDetector.Face f = faces[0];
            f.getMidPoint(pt);
            //canvas.drawCircle(pt.x,pt.y,f.eyesDistance(),paint);


            float eyeDistance = f.eyesDistance();
            float confidence = f.confidence();
            float pose = f.pose(EULER_Y);

            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            int stroke = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, metrics);
            paint.setStrokeWidth(stroke);

            Paint mIdPaint = new Paint();
            mIdPaint.setColor(Color.GREEN);


            //PointF mid = new PointF();
            f.getMidPoint(pt);
            RectF rectF = new RectF();
            if (pt.x != 0.0f && pt.y != 0.0f) {
                float eyesDis = f.eyesDistance();

                rectF.set(new RectF(
                        (pt.x - eyesDis * 1.2f), (pt.y - eyesDis * 0.55f),
                        (pt.x + eyesDis * 1.2f), (pt.y + eyesDis * 1.85f)));

                canvas.drawRect(rectF, paint);


                FaceResult faceResult = new FaceResult();
                faceResult.set(0,pt,eyeDistance,confidence,pose,1000);

                RFaceFromImage = cropFace(faceResult,image,0);

                return RFaceFromImage;
            }
        }
        return null;

    }

}
