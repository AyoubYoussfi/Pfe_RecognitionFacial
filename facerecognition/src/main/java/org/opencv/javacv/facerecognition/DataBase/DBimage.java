package org.opencv.javacv.facerecognition.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBimage extends SQLiteOpenHelper {

    private static final String DATABASE_NAME1 = "ImagedDB.db";
    private static final int DATABASE_VERSION1 = 1;

    public DBimage(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("Create table Image(id Integer primary key autoincrement, Photo Blob)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Image");
            onCreate(db);
    }


        public void addimage(byte[] phot){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues value= new ContentValues();
            value.put("Photo", phot);
            db.insert("Image", null, value);
        }



        public byte[] afficherImage(){

            byte[] img=null;
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor c = db.rawQuery("select Photo from Image", null);

            c.moveToFirst();
            while (c.isAfterLast()==false){

                img=c.getBlob(c.getColumnIndex("Photo"));

                c.moveToNext();
            }
            return img;
        }


        public void deletImage(){
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete("Image",null,null);

        }

        public void updateImage(byte[] photoo){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cc=new ContentValues();
            cc.put("Photo", photoo);
            db.update("Image",cc,null,null);

        }

}




