package com.example.horizontalrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Refer_and_earn extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_and_earn);

    }

//    public void whatsapp(View view) {
//
//        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//        whatsappIntent.setType("text/plain");
////        whatsappIntent.setPackage("com.whatsapp");
//
//
//        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        try {
//            startActivity(Intent.createChooser(whatsappIntent,"Share via"));
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(this,"Whatsapp not installed",Toast.LENGTH_LONG).show(); }
//
//    }
//
//    public void facebook(View view) {
//        Intent facebookIntent = new Intent(Intent.ACTION_SEND);
//        facebookIntent.setType("text/plain");
//        facebookIntent.setPackage("com.facebook.katana");
//
//
//        facebookIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        try {
//            startActivity(facebookIntent);
//        } catch (android.content.ActivityNotFoundException ex) {
//            Toast.makeText(this,"Facebook not installed",Toast.LENGTH_LONG).show(); }
//
//
//    }

    public void share(View view) {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
       whatsappIntent.setPackage("com.whatsapp");


        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/channel/UCVyLr8nu-6DeW919PzUe8iA");
        try {
            startActivity(Intent.createChooser(whatsappIntent,"Share via"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,"Whatsapp not installed",Toast.LENGTH_LONG).show(); }
    }
}
