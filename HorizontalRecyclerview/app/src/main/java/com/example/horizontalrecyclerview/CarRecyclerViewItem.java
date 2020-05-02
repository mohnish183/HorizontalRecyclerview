package com.example.horizontalrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class CarRecyclerViewItem {
    // Save car name.
    private String carName;

    // Save car image resource id.
    private int carImageId;

    public CarRecyclerViewItem(String carName, int carImageId) {
        this.carName = carName;
        this.carImageId = carImageId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarImageId() {
        return carImageId;
    }

    public void setCarImageId(int carImageId) {
        this.carImageId = carImageId;
    }

    /**
     * This tab displays both deals and coupons
     *
     * @author Shayak Banerjee
     * @version 0.2
     * @since 13 June 2019
     */
    public static class AllTab extends Fragment {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.tab_all, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            // coupon and offer data that is passed from CompanyCouponActivity
            ArrayList<CompanyOfferAndCoupon> dataset = (ArrayList<CompanyOfferAndCoupon>) getArguments().getSerializable("dataset");

            // applying the custom adapter to the listView
            AllTabListAdapter allTabListAdapter = new AllTabListAdapter(dataset);
            ListView listViewAll = getActivity().findViewById(R.id.listViewAll);
            listViewAll.setAdapter(allTabListAdapter);
        }

        /**
         * custom adapter for listViewAll
         *
         * @author Shayak Banerjee
         * @version 0.1
         * @since 15 June 2019
         */
        public class AllTabListAdapter extends BaseAdapter {
            private ArrayList<CompanyOfferAndCoupon> listOfOffersAndCoupons;

            /**
             * Constructor
             */
            AllTabListAdapter(ArrayList<CompanyOfferAndCoupon> listOfOffersAndCoupons) {
                this.listOfOffersAndCoupons = listOfOffersAndCoupons;
            }

            /**
             * @return number of items in listOfOffersAndCoupons
             */
            @Override
            public int getCount() {
                return listOfOffersAndCoupons.size();
            }

            /**
             * @param position position of data item in listOfOffersAndCoupons
             * @return data item at listOfOffersAndCoupons[position]
             */
            @Override
            public Object getItem(int position) {
                return listOfOffersAndCoupons.get(position);
            }

            @Override
            public long getItemId(int position) {
                return (long) position;
            }

            /**
             * Customizes the view according to the data in the data set
             *
             * @param position    position of data item in listOfOffersAndCoupons
             * @param convertView converted view
             * @param parent      the parent view in which the customized view exists
             * @return a <code>view</code> customized according to the coupon and offer data
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CompanyOfferAndCoupon couponOrOffer = listOfOffersAndCoupons.get(position);
                View myView = getLayoutInflater().inflate(R.layout.company_coupon_ticket, null);

                // customizing myView
                ImageView imageViewLogo = myView.findViewById(R.id.imageViewLogo);
                TextView textViewCategory = myView.findViewById(R.id.textViewCategory);
                TextView textViewCouponDescription = myView.findViewById(R.id.textViewCouponDescription);
                TextView textViewMarkedPrice = myView.findViewById(R.id.textViewMarkedPrice);
                TextView textViewDiscountedPrice = myView.findViewById(R.id.textViewDiscountedPrice);
                TextView buttonGrabOffer = myView.findViewById(R.id.buttonGrabOffer);
                TextView buttonGetCouponCode = myView.findViewById(R.id.buttonGetCouponCode);

                if (couponOrOffer.getType() == CompanyOfferAndCoupon.OFFER) { // offer data
                    // hiding the unwanted views
                    buttonGetCouponCode.setVisibility(View.GONE);

                    // setting the offer data into the views
                    Picasso.get().load(couponOrOffer.getImageLink()).into(imageViewLogo);
                    textViewCategory.setText(couponOrOffer.getCategory());
                    textViewCouponDescription.setText(couponOrOffer.getOfferDescription());
                    textViewMarkedPrice.setText(couponOrOffer.getMarkedPrice());
                    textViewDiscountedPrice.setText(couponOrOffer.getDiscountedPrice());
                    buttonGrabOffer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View l) {
                            //TODO: write here what happens when buttonGrabOffer is clicked
                        }
                    });

                } else if (couponOrOffer.getType() == CompanyOfferAndCoupon.COUPON) { // coupon data
                    // hiding the unwanted views
                    buttonGrabOffer.setVisibility(View.GONE);
                    textViewMarkedPrice.setVisibility(View.GONE);
                    textViewDiscountedPrice.setVisibility(View.GONE);

                    // setting the coupon data in the views
                    Picasso.get().load(couponOrOffer.getImageLink()).into(imageViewLogo);
                    textViewCategory.setText(couponOrOffer.getCategory());
                    textViewCouponDescription.setText(couponOrOffer.getOfferDescription());
                    buttonGetCouponCode.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View l) {
                            //TODO: write here what happens when buttonGetCouponCode is clicked
                        }
                    });


                }

                // return customized view
                return myView;
            }
        }
    }

    /**
     * This class is used to insert data into the offers in CompanyCouponActivity
     *
     * @author Shayak Banerjee
     * @version 0.1
     * @since 15 June 2019
     */
    public static class CompanyOfferAndCoupon implements Serializable {
        private String imageLink;
        private String category;
        private String offerDescription;
        private String markedPrice;
        private String discountedPrice;
        private int type; // offer or coupon

        public static final int COUPON = 0;
        public static final int OFFER = 1;

        public int getType() {
            return type;
        }

        /**
         * Constructor
         *
         * @param category         category of the merchandise
         * @param offerDescription description displayed in offer
         * @param markedPrice      marked price of merchandise
         * @param discountedPrice  discounted price of merchandise
         * @param type             <code>CompanyOfferAndCoupon.COUPON</code> or <code>CompanyOfferAndCoupon.OFFER</code>. Non null, must be specified
         * @param imageLink        image URL
         */
        public CompanyOfferAndCoupon(@NonNull String imageLink, @NonNull String category,
                                     @NonNull String offerDescription, @Nullable String markedPrice,
                                     @Nullable String discountedPrice, @NonNull Integer type) {
            this.category = category;
            this.offerDescription = offerDescription;
            this.markedPrice = markedPrice;
            this.discountedPrice = discountedPrice;
            this.type = type;
            this.imageLink = imageLink;
        }

        /**
         * @return category of the merchandise
         */
        public String getCategory() {
            return category;
        }

        /**
         * @return description displayed in offer
         */
        public String getOfferDescription() {
            return offerDescription;
        }

        /**
         * @return marked price of merchandise
         */
        public String getMarkedPrice() {
            return markedPrice;
        }

        /**
         * @return discounted price of merchandise
         */
        public String getDiscountedPrice() {
            return discountedPrice;
        }

        /**
         *
         * @return image URL
         */
        public String getImageLink() {
            return imageLink;
        }

    }

    /**
     * This tab displays all deals
     *
     * @author Shayak Banerjee
     * @version 0.2
     * @since 13 June 2019
     */
    public static class DealsTab extends Fragment {
        private ArrayList<CompanyOfferAndCoupon> allData;
        private ArrayList<CompanyOfferAndCoupon> dealsData;
        private ListView listViewDeals;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.tab_deals, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // deals data that will be displayed in this tab
            dealsData = new ArrayList<>();

            // coupon and offer data that is passed from CompanyCouponActivity is then sorted
            allData = (ArrayList<CompanyOfferAndCoupon>) getArguments().getSerializable("dataset");
            for (int i = 0; i < allData.size(); i++) {
                // adding all OFFER data, hence omitting COUPON data
                if (allData.get(i).getType() == CompanyOfferAndCoupon.OFFER)
                    dealsData.add(allData.get(i));
            }

            // applying the custom adapter to the listView
            DealsTabListAdapter dealsTabListAdapter = new DealsTabListAdapter(dealsData);
            listViewDeals = getActivity().findViewById(R.id.listViewDeals);
            listViewDeals.setAdapter(dealsTabListAdapter);

        }

        /**
         * custom adapter for listViewDeals
         *
         * @author Shayak Banerjee
         * @version 0.1
         * @since 17 June 2019
         */
        public class DealsTabListAdapter extends BaseAdapter {
            private ArrayList<CompanyOfferAndCoupon> listOfOffers;

            /**Constructor*/
            DealsTabListAdapter(ArrayList<CompanyOfferAndCoupon> listOfOffersAndCoupons) {
                this.listOfOffers = listOfOffersAndCoupons;
            }

            /**
             * @return number of items in listOfOffers
             */
            @Override
            public int getCount() {
                return listOfOffers.size();
            }

            /**
             * @param position position of data item in listOfOffers
             * @return data item at listOfOffers[position]
             */
            @Override
            public Object getItem(int position) {
                return listOfOffers.get(position);
            }

            @Override
            public long getItemId(int position) {
                return (long) position;
            }

            /**
             * Customizes the view according to the data in the data set
             *
             * @param position    position of data item in listOfOffersAndCoupons
             * @param convertView converted view
             * @param parent      the parent view in which the customized view exists
             * @return a <code>view</code> customized according to the coupon and offer data
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CompanyOfferAndCoupon couponOrOffer = listOfOffers.get(position);
                View myView = getLayoutInflater().inflate(R.layout.company_coupon_ticket, null);

                // customizing myView
                ImageView imageViewLogo = myView.findViewById(R.id.imageViewLogo);
                TextView textViewCategory = myView.findViewById(R.id.textViewCategory);
                TextView textViewCouponDescription = myView.findViewById(R.id.textViewCouponDescription);
                TextView textViewMarkedPrice = myView.findViewById(R.id.textViewMarkedPrice);
                TextView textViewDiscountedPrice = myView.findViewById(R.id.textViewDiscountedPrice);
                TextView buttonGrabOffer = myView.findViewById(R.id.buttonGrabOffer);
                TextView buttonGetCouponCode = myView.findViewById(R.id.buttonGetCouponCode);

                // hiding the unwanted views
                buttonGetCouponCode.setVisibility(View.GONE);

                // setting the offer data into the views
                Picasso.get().load(couponOrOffer.getImageLink()).into(imageViewLogo);
                textViewCategory.setText(couponOrOffer.getCategory());
                textViewCouponDescription.setText(couponOrOffer.getOfferDescription());
                textViewMarkedPrice.setText(couponOrOffer.getMarkedPrice());
                textViewDiscountedPrice.setText(couponOrOffer.getDiscountedPrice());
                buttonGrabOffer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View l) {
                        //TODO: write here what happens when buttonGrabOffer is clicked
                    }
                });

                // return customized view
                return myView;
            }
        }
    }
}
