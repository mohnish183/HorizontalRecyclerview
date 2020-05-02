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

import java.util.ArrayList;

/**
 * This tab displays both deals and coupons
 *
 * @author Shayak Banerjee
 * @version 0.2
 * @since 13 June 2019
 */
public class AllTab extends Fragment {

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
