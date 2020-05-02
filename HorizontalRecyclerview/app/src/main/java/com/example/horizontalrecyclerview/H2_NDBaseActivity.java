package com.example.horizontalrecyclerview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;



public class H2_NDBaseActivity extends AppCompatActivity {
    ImageView ProfileImage;
    LayoutInflater layoutInflater;
    ActionMenuView actionMenuView;
    String ProfileName;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void setBaseContentView(int id) {
        layoutInflater = getLayoutInflater();

        View contentView = layoutInflater.inflate(id, null);
        View baseView = layoutInflater.inflate(R.layout.activity_h2__ndbase, null);

        FrameLayout layout = (FrameLayout) baseView.findViewById(R.id.cantainer);
        layout.addView(contentView);
        setContentView(baseView);

       actionMenuView = (ActionMenuView) findViewById(R.id.setting_menu_view);
       MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.h2_setting_menu, actionMenuView.getMenu());
       // menuInflater.inflate(R.menu.h2_setting_menu,actionMenuView.getMenu());
        actionMenuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                case R.id.h2_mnu_AdvanceSearch:
                        //startActivity(new Intent(getBaseContext(), A14_AdvanceSearch.class));
                        break;
                    case R.id.h2_mnu_ProfilePicture:
                        //startActivity(new Intent(getBaseContext(), A15_ProfilePhoto.class));
                        break;
                    case R.id.h2_mnu_category:
                        //startActivity(new Intent(getBaseContext(), A4_ShowCategory.class));
                        break;
                    case R.id.h2_mnu_edit_profile:
                        //startActivity(new Intent(getBaseContext(), A11_EditProfile.class));
                        break;
                    case R.id.h2_mnu_logout:
//                        SharedPreferences pref = getApplicationContext().getSharedPreferences("GTel", 0); // 0 - for private mode
//                        SharedPreferences.Editor editor = pref.edit();
//                        editor.putString("Name", ""); // Storing boolean - true/false
//                        editor.putString("Mobile", ""); // Storing boolean - true/false
//                        editor.putString("StateId", ""); // Storing boolean - true/false
//                        editor.putString("PhotoUrl", ""); // Storing boolean - true/false
//                        editor.putBoolean("IsRegConfirm", false); // Storing boolean - true/false
//                        editor.commit(); // commit changes

                        //startActivity(new Intent(getBaseContext(), A5_Login.class));
                        finish();
                        break;
                }
                return false;
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        TextView txt = (TextView) drawerLayout.findViewById(R.id.profile_name);
        txt.setText(ProfileName);

        ProfileImage = (ImageView) drawerLayout.findViewById(R.id.profile_image);
        ProfileImage.setImageResource(R.drawable.loginn);

        ActionBarDrawerToggle mDrawerToggle;

        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {

                public void onDrawerClosed(View view) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView) {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }
   }

    public void Refer(View view) {
        Intent refer=new Intent(this,Refer_and_earn.class);
        startActivity(refer);
    }

    public void About(View view) {
        Intent about=new Intent(this,Aboutus.class);
        startActivity(about);
    }

    public void Sign_out(View view) {
        //Intent sign_out=new Intent(this,WELCOME.class);
        //startActivity(sign_out);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to sign out")
                .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent sign_out=new Intent(H2_NDBaseActivity.this,WELCOME.class);
                startActivity(sign_out);
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void Settings(View view) {
        Intent setting=new Intent(this,Setting.class);
        startActivity(setting);
    }

    public void rateUs(View view) {
        Intent rate=new Intent(this,RateUsActivity.class);
        startActivity(rate);
    }

    public void store(View view) {
        Intent store=new Intent(this,CardViewActivity.class);
        startActivity(store);
    }

    public void Home(View view) {
        Intent home=new Intent(this,MainActivity.class);
        startActivity(home);
    }

    public void help(View view) {
        Intent favourites=new Intent(this,CardViewActivity.class);
        startActivity(favourites);

        //Intent help=new Intent(this,FAQActivity.class);
        //startActivity(help);
    }
/*cart in navigation bar*/
    public void Favourites(View view) {
        Intent favourites=new Intent(this,CardViewActivity.class);
        startActivity(favourites);
    }
/**/
//    public void Vouchers(View view) {
//        Intent store=new Intent(this,CardViewActivity.class);
//    /**/    startActivity(store);

        // Intent vouchers=new Intent(this,CashbackOffersActivity.class);
        //startActivity(vouchers);
//    }
/*gallery option*/
    public void Categories(View view) {
       // Intent s=new Intent(this,Categories.class);
       // startActivity(s);

        Intent categories= new Intent(this,Categories.class);
        startActivity(categories);
    }

    public void Profile(View view) {
        Intent profile = new Intent(this,ProfileActivity.class);
        startActivity(profile);
    }
}

