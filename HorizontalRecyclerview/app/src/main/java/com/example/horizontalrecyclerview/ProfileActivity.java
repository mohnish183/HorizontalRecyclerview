package com.example.horizontalrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void click_history_view_all(View view) {
        Toast.makeText(this,"No History Yet",Toast.LENGTH_SHORT).show();
    }

    public void redeem_history_view_all(View view) {
        Toast.makeText(this,"No History Yet",Toast.LENGTH_SHORT).show();
    }

    public void Redeem(View view) {
        Intent redeem=new Intent(this,PaymentGateWay.class);
        startActivity(redeem);
    }
}
