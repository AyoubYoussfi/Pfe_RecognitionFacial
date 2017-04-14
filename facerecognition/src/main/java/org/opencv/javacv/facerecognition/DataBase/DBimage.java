package org.opencv.javacv.facerecognition.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class DBimage extends SQLiteOpenHelper {

    private static final String DATABASE_NAME1 = "ImagedDB.db";
    private static final int DATABASE_VERSION1 = 1;

    // Table Names
    private static final String DB_TABLE  = "table_image";

    // column names
    private static final String Id          = "id";
    private static final String ImageSimple = "image_Simple";
    private static final String ImageFace   = "image_Face";

    // Table create statement
    private static final String Create_Table_Image  = " create table "+DB_TABLE +" " +
            "("+Id+" Integer primary key AUTOINCREMENT," +
            " "+ImageSimple+" Blob, " +
            " "+ImageFace+" Blob )";


    // Table selection des donnees
    private static final String Affiche_Table_Image = "select * from "+DB_TABLE+"";



    public DBimage(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(Create_Table_Image);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Image");
            onCreate(db);
    }


    public void addimage(byte[] PphotSimple,byte[] PphotFace) throws SQLiteException {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value= new ContentValues();
        value.put(ImageSimple, PphotSimple);
        value.put(ImageFace, PphotFace);
        db.insert( DB_TABLE, null, value );
    }


    public byte[] afficheSimpleImage() {

        byte[] imgSimple =null;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery(Affiche_Table_Image, null);

        c.moveToFirst();
        while (c.isAfterLast()==false) {
            imgSimple=c.getBlob(c.getColumnIndex(ImageSimple));
            c.moveToNext();
        }

        return imgSimple;
    }


    public byte[] afficheFaceImage() {

        byte[] imgFace   =null;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c = db.rawQuery(Affiche_Table_Image, null);

        c.moveToFirst();
        while (c.isAfterLast()==false) {
            imgFace  =c.getBlob(c.getColumnIndex(ImageFace));
            c.moveToNext();
        }

        return imgFace;
    }


    public void deletImage() {
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
