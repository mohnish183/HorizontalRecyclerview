package com.example.horizontalrecyclerview;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity{
    private List<CarRecyclerViewItem> carItemList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);


           //     setTitle("dev2qa.com - Android CardView Example.");

            //  initializeCarItemList();

                // Create the recyclerview.
          //      RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
                // Create the grid layout manager with 2 columns.
          //      GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                // Set layout manager.
             //   carRecyclerView.setLayoutManager(gridLayoutManager);

                // Create car recycler view data adapter with car item list.
           //    CarRecyclerViewDataAdapter carDataAdapter = new CarRecyclerViewDataAdapter(carItemList);
                // Set data adapter.
           //     carRecyclerView.setAdapter(carDataAdapter);

            }

            /* Initialise car items in list. */
            private void initializeCarItemList()
            {
                if(carItemList == null)
                {
                    carItemList = new ArrayList<CarRecyclerViewItem>();
                   //this is a way to insert image in cardview
                    //carItemList.add(new CarRecyclerViewItem("Amazon", R.drawable.amazon));
                }
    }

    public void facebook1(View view) {


            Intent broweserIntent=new Intent( Intent.ACTION_VIEW,Uri.parse("http://m.facebook.com/Udaanpoornima/") );
            startActivity( broweserIntent );

    }
    public void youtube1(View view) {


        Intent broweserIntent=new Intent( Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCVyLr8nu-6DeW9I9PzUe8iA") );
        startActivity( broweserIntent );

    }
    public void insta1(View view) {


        Intent broweserIntent=new Intent( Intent.ACTION_VIEW,Uri.parse("http://www.instagram.com/udaan_aeromodelling_club/?hl=en") );
        startActivity( broweserIntent );

    }
    public void linkedin1(View view) {


        Intent broweserIntent=new Intent( Intent.ACTION_VIEW,Uri.parse("http://www.linkedin.com/mwlite/company/udaan-aeromodelling-club") );
        startActivity( broweserIntent );

    }



    /**
     * This activity hosts a tab layout that displays deals and coupons
     *
     * @author Shayak Banerjee
     * @version 0.1
     * @since 14 June 2019
     */
    public static class CompanyCouponActivity extends AppCompatActivity {

        // the data that is displayed in the various tab's listViews
        private static ArrayList<CarRecyclerViewItem.CompanyOfferAndCoupon> dataset;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_company_coupon);
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
            // viewPager interfaces the tabs
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);

            // applying the company logo
            ImageView imageViewCompanyLogo = (ImageView) findViewById(R.id.imageViewLogo);
            Picasso.get().load("https://i.pinimg.com/originals/66/12/7a/66127a9bdf5c5f62402331976c0d9f7e.jpg").into(imageViewCompanyLogo);

            populateDataset();

        }

        /**
         * populates the dataset
         */
        private void populateDataset(){
            dataset = new ArrayList<>();

            // test data (18 values)
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://s3.amazonaws.com/gp.cdn.images/assets/deals/-1534489131.jpg", "Medical Health Care", "Save 20% on 1Mg Medicines + Upto Rs.200 Amazon Pay Cashback", "Rs. 700", "Rs. 560", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/fab-hotels-cashback-offers.jpg", "Hotel", "[Free Hotel Booking Offer] 1 Night Stay Starting at Rs.550 + Rs.550 GoPaisa Cashback", "Rs. 1199", "Rs. 550", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://res.cloudinary.com/gopaisacom/image/upload/deals/mcase1.jpg", "Mobile Covers", "All Mobile Covers at 99", "Rs. 249", "Rs. 99", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/amazonmidays1-27052019.jpg", "Electronics", "Amazon Mi Days- Get Upto Rs.6500 Off + 5% Off on Axis Bank", "Rs. 10999", "Rs. 9990", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/trollybeg-06062019.jpg", "Luggage", "Luggage & Trolleys On Flat 70% Off on Myntra", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/swiggy-04-june-1-1.jpg", "Food", "Get 50% OFF On North Indian Food: New User Offer", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/indian-sweet-food-kesar-peda_55610-2761.jpg", "Food", "Swiggy Sweets Offer: Get 50% OFF", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://res.cloudinary.com/gopaisacom/image/upload/deals/dominos-pizza-mobikwik-supercash-payment-cashback-coupon-discount-1531375172.jpg", "Fast Food", "Dominos PayPal Offer - Flat 30% Cashback Upto Rs.150", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/trollybeg-06062019.jpg", "Luggage", "Luggage & Trolleys On Flat 70% Off on Myntra", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/nnnow1-16042019.jpg", "Men's Fashion", "Buy 1 Get 1 Free on Branded Men & women Clothing", "Rs. 2000", "Rs. 1000", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/pepperfryfurniture-30052019.jpg", "Wall Art n More", "10% off on all electronics", "Rs. 4999", "Rs. 2190", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/paytmbus-13052019.jpg", "Bus Ticket", "Paytm Bus Offer : Flat Rs.300 Cashback on Bus Ticket Min. Booking Rs.2000", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://res.cloudinary.com/gopaisacom/image/upload/deals/-1533109444.jpg", "Amazon DTH Recharge Offer", "Amazon DTH Recharge Offer - Get Rs. 40 Cashback on Recharge of Rs. 100", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://res.cloudinary.com/gopaisacom/image/upload/deals/compact-stylish-electric-egg-cooker.jpg", "Home & Kitchen", "30% off", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/titan-sunglasses-lens-1.jpg", "Sunglasses", "50% off", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/pepperfryfurniture-30052019.jpg", "Wall Art n More", "10% off on all electronics", "Rs. 4999", "Rs. 2190", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/themancompanyfacescrub-14062019.jpg", "Cosmetics", "TheManCompany Face Scrub Worth Rs.349 at Rs.99 (After Cashback)", "Rs. 349", "Rs. 199", CarRecyclerViewItem.CompanyOfferAndCoupon.OFFER));
            dataset.add(new CarRecyclerViewItem.CompanyOfferAndCoupon("https://assets.gopaisa.com/unsafe/0x0/https://gpcdn.ams3.cdn.digitaloceanspaces.com/deals/fashion-accessories-gearbest.jpg", "Clothing", "Flat 100 off", null,null, CarRecyclerViewItem.CompanyOfferAndCoupon.COUPON));
        }

        /**
         * @author Shayak Banerjee
         * @version 0.1
         * @since 14 June 2019
         */
        public static class SectionsPagerAdapter extends FragmentPagerAdapter {


            /**
             * constructor
             * @param fragmentManager fragment manager
             */
            SectionsPagerAdapter(FragmentManager fragmentManager) {
                super(fragmentManager);
            }


            // getItem is called to instantiate the fragment for the given page.
            @Override
            public Fragment getItem(int position) {

                /* the data is passed into the tab fragments by wrapping the data in a serializable
                class and putting them into a bundle*/
                Bundle bundle = new Bundle();
                bundle.putSerializable("dataset", dataset);

                switch (position){
                    case 0: // displays both deals and coupons
                        CarRecyclerViewItem.AllTab allTab = new CarRecyclerViewItem.AllTab();
                        allTab.setArguments(bundle);
                        return allTab;
                    case 1: // displays deals
                        CarRecyclerViewItem.DealsTab dealsTab = new CarRecyclerViewItem.DealsTab();
                        dealsTab.setArguments(bundle);
                        return dealsTab;
                    case 2: // displays coupons
                        CarRecyclerViewItemHolder.CouponsTab couponsTab = new CarRecyclerViewItemHolder.CouponsTab();
                        couponsTab.setArguments(bundle);
                        return couponsTab;
                }

                return null;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "All (18)";
                    case 1:
                        return "Deals (10)";
                    case 2:
                        return "Coupons (8)";
                }

                return  null;
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 3;
            }
        }
    }
}
