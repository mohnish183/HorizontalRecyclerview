package com.example.horizontalrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

/**
 * This fragment adds a carousel to the parent activity <br><br>
 *
 * first add the following two lines to your gradle app module:- <br>
 * <code>
 * implementation 'com.synnapps:carouselview:0.1.5'  // carousel view
 * implementation 'com.squareup.picasso:picasso:2.71828' // Picasso: for loading images into imageViews
 * </code>
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 11th June 2019
 */
public class LoginPageCarouselFragment extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.welcome1, R.drawable.welcome2, R.drawable.welcome5, R.drawable.welcome4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_carousel_fragment);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);


    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    // contains the URLs of images that will be displayed in the carousel
//    private ArrayList<String> sampleImages;
//
//    // displaying the image in the carousel
//    private ImageListener imageListener = new ImageListener() {
//        @Override
//        public void setImageForPosition(int position, ImageView imageView) {
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//
//            String imageLink = sampleImages.get(position);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//            Picasso.get().load(imageLink).into(imageView);
//        }
//    };
//
//    // Inflates the layout resource of the fragment
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.login_page_carousel_fragment, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // the carousel view's images' URLs are stored in sampleImages
//        sampleImages = new ArrayList<>();
//
//        // TODO: remove after testing
//        loadTestData();
//
//        // the carousel view
//        CarouselView carouselView = getView().findViewById(R.id.loginPageCarouselView);
//
//        // sets how many images will be loaded in the carousel
//        carouselView.setPageCount(sampleImages.size());
//        // imageListener listens for the image and then displays it in the carousel
//        carouselView.setImageListener(imageListener);
//    }
//
//    /**
//     * Loads test data into sampleImages
//     */
//    private void loadTestData(){
//        sampleImages.add("http://i68.tinypic.com/biuiib.png");
//        sampleImages.add("https://imgur.com/TegMpzq");
//        sampleImages.add("https://imgur.com/62sI8M8");
//        sampleImages.add("https://imgur.com/3cIkvif");
//    }
}
