package org.opencv.javacv.facerecognition.DataBase;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedPreferences {

    private static SharedPreferences sharedPreferences;


    public UserSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("Recognition", Context.MODE_PRIVATE);
    }

    public static void setTraining(Boolean training) {
        SharedPreferences.Editor myedit = sharedPreferences.edit();
        myedit.putBoolean("Training",training);
        myedit.commit();
    }


    public static Boolean getTraining(){
        return sharedPreferences.getBoolean("Training",false);
    }


    public static void setPin(String pin){
        SharedPreferences.Editor myedit = sharedPreferences.edit();
        myedit.putString("pin",pin);
        myedit.commit();
    }


    public static String getPin(){
        return ""+sharedPreferences.getString("pin","");
    }

    public static void setSecurityLevel(String Level){
        SharedPreferences.Editor myedit = sharedPreferences.edit();
        myedit.putString("SecurityLevel",Level);
        myedit.commit();
    }

    public static String getSecurityLevel() {
        return sharedPreferences.getString("SecurityLevel","Medium");
    }

    public static void setIntruderSelefie(Boolean etat){
        SharedPreferences.Editor myedit = sharedPreferences.edit();
        myedit.putBoolean("IntruderSelefie",etat);
        myedit.commit();
    }

    public static String getIntruderSelefie(){
        return ""+sharedPreferences.getBoolean("IntruderSelefie",false);
    }

}
