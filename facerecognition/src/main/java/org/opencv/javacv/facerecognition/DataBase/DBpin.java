package org.opencv.javacv.facerecognition.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBpin extends SQLiteOpenHelper {

    private static final String DATABASE_NAME2 = "PindDB.db";
    private static final int DATABASE_VERSION2 = 1;

    public DBpin(Context context) {
        super(context,DATABASE_NAME2,null,DATABASE_VERSION2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Pin(id Integer primary key autoincrement,password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Pin");
        onCreate(db);

    }


            public void addpassword(String pass){
                SQLiteDatabase db=this.getWritableDatabase();
                ContentValues value= new ContentValues();
                value.put("password", pass);
                db.insert("Pin", null, value);
            }


            public String afficherpassword(){
                String motp=null;

                SQLiteDatabase db=this.getReadableDatabase();
                Cursor c = db.rawQuery("select password from Pin", null);

                c.moveToFirst();
                while (c.isAfterLast()==false){

                    motp=c.getString(c.getColumnIndex("password"));

                    c.moveToNext();
                }
                return motp;
            }

            public void deletpassword(){
                SQLiteDatabase db=this.getWritableDatabase();
                db.delete("Pin",null,null);

            }

            public void updatepassword(String mpass){
                SQLiteDatabase db=this.getWritableDatabase();
                ContentValues cc=new ContentValues();
                cc.put("password", mpass);
                db.update("Pin",cc,null,null);

            }

}




