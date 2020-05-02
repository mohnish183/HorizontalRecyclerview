package com.example.horizontalrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends H2_NDBaseActivity{
    private static final String TAG = "MainActivity";
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.iit, R.drawable.jet, R.drawable.quadcopter, R.drawable.prototype, R.drawable.udaan_member};
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_main);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

//        getImages();
    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    //This is responsible for the mainactivty slider


//    private void getImages(){
//        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
//
//        mImageUrls.add("https://img.etimg.com/thumb/msid-66421537,width-1200,height-900,resizemode-4,imgsize-165547/untitled-7.jpg");
//           mNames.add("papperfy");
//
//        mImageUrls.add("https://hippoprod.s3.amazonaws.com/merchants/logos/000/000/037/large/cleartrip_india_logo.png");
//         mNames.add("Cleartip");
//
//        mImageUrls.add("https://www.searchpng.com/wp-content/uploads/2019/03/Swiggy-PNG-Logo-715x715.png");
//        mNames.add("Swiggy");
//
//        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/0/09/Zomato_company_logo.png");
//        mNames.add("Zomato");
//
//
//        mImageUrls.add("https://pngimg.com/uploads/amazon/amazon_PNG13.png");
//        mNames.add("Amazon");
//


//        initRecyclerView();
//
// }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageUrls,mNames);
        recyclerView.setAdapter(adapter);
    }

    public void Refers(View view) {
        Intent refer=new Intent(this,Refer_and_earn.class);
        startActivity(refer);
    }
}

