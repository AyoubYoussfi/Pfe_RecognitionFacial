package org.opencv.javacv.facerecognition;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.opencv.javacv.facerecognition.Activity.AboutUs;
import org.opencv.javacv.facerecognition.Activity.SetIntruderSelfie;
import org.opencv.javacv.facerecognition.Activity.training.FirstTrainingFace;
import org.opencv.javacv.facerecognition.Activity.training.UpdateTrainingFace;
import org.opencv.javacv.facerecognition.DataBase.UserSharedPreferences;


public class MainActivity extends AppCompatActivity {

    final Context context = this;
    UserSharedPreferences userSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userSharedPreferences = new UserSharedPreferences(context);

    }

    public void training(View view) {

        Boolean Training = userSharedPreferences.getTraining();

        if (Training==false){
            startActivity(new Intent(this, FirstTrainingFace.class));
        }
        else {
            startActivity(new Intent(this, UpdateTrainingFace.class));
        }

    }

    public void setPin(View view) {

        if (userSharedPreferences.getPin().toString().equals("")){

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.activity_set_pin, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInputPin             = (EditText) promptsView.findViewById(R.id.pin);
        final EditText userInputConfirmationPin = (EditText) promptsView.findViewById(R.id.ConfirmationPin);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                if(userInputPin.getText().toString().equals(userInputConfirmationPin.getText().toString())){
                                    userSharedPreferences.setPin(userInputPin.getText().toString());
                                }
                                else {
                                    Toast.makeText(context, "Verifier votre pin", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

        }
        else {

            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.activity_modifier_pin, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(promptsView);

            final EditText userInputOldPin             = (EditText) promptsView.findViewById(R.id.oldpin);
            final EditText userInputPin             = (EditText) promptsView.findViewById(R.id.newpin);
            final EditText userInputConfirmationPin = (EditText) promptsView.findViewById(R.id.ConfirmationNewPin);

            // set dialog message
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    if(userInputOldPin.getText().toString().equals(userSharedPreferences.getPin())){
                                        if(userInputPin.getText().toString().equals(userInputConfirmationPin.getText().toString())){
                                            userSharedPreferences.setPin(userInputPin.getText().toString());
                                        }
                                        else{
                                            Toast.makeText(context, "Verifier votre pin", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }

    }


    public void securityLevel(View view) {

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.activity_security_level, null);

        final RadioButton radioHight  = (RadioButton) promptsView.findViewById(R.id.Hight);
        final RadioButton radioMedium = (RadioButton) promptsView.findViewById(R.id.Medium);
        final RadioButton radioEasy   = (RadioButton) promptsView.findViewById(R.id.Easy);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        String EnabledCheckBox =userSharedPreferences.getSecurityLevel().toString();


        if(EnabledCheckBox.toString().equals(radioHight.getText().toString())){
            radioHight.setChecked(true);
        }
        else if(EnabledCheckBox.toString().equals(radioMedium.getText().toString())){
            radioMedium.setChecked(true);
        }
        else if(EnabledCheckBox.toString().equals(radioEasy.getText().toString())){
            radioEasy.setChecked(true);
        }



        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                if(radioEasy.isChecked()){
                                    userSharedPreferences.setSecurityLevel(radioEasy.getText().toString());
                                    radioEasy.setEnabled(true);
                                }
                                else if(radioMedium.isChecked()){
                                    userSharedPreferences.setSecurityLevel(radioMedium.getText().toString());
                                    radioMedium.setEnabled(true);
                                }
                                else if(radioHight.isChecked()){
                                    userSharedPreferences.setSecurityLevel(radioHight.getText().toString());
                                    radioHight.setEnabled(true);
                                }

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void setIntruderSelfie(View view) {
        startActivity(new Intent(MainActivity.this, SetIntruderSelfie.class));
    }

    public void RateApp(View view) {

        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }



        /*
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.activity_rate_this_app, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text

                                //result.setText(userInput.getText());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
        */
    }

    public void AboutUs(View view) {
        startActivity(new Intent(MainActivity.this, AboutUs.class));
    }
}
