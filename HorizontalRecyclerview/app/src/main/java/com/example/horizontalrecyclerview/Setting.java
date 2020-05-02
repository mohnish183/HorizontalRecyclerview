package com.example.horizontalrecyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {
    Button personal_details,change_password;
    ConstraintLayout personal_details_layout,change_password_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        personal_details=findViewById(R.id.personal_details);
        change_password=findViewById(R.id.change_password);
        personal_details_layout=findViewById(R.id.personal_details_layout);
        change_password_layout=findViewById(R.id.change_password_layout);
    }

    public void personal_details(View view) {
        personal_details_layout.setVisibility(View.VISIBLE);
        change_password_layout.setVisibility(View.GONE);

    }

    public void change_password(View view) {
        change_password_layout.setVisibility(View.VISIBLE);
        personal_details_layout.setVisibility(View.GONE);
    }
}
