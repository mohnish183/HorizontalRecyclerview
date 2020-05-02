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
 * This tab displays coupons
 *
 * @author Shayak Banerjee
 * @version 0.2
 * @since 13 June 2019
 */
public class CouponsTab extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_coupons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // coupons data that will be displayed in this tab
        ArrayList<CompanyOfferAndCoupon> couponsData = new ArrayList<>();

        // coupon and offer data that is passed from CompanyCouponActivity is then sorted
        ArrayList<CompanyOfferAndCoupon> allData = (ArrayList<CompanyOfferAndCoupon>) getArguments().getSerializable("dataset");
        for (int i = 0; i < allData.size(); i++) {
            // adding all COUPON data, hence omitting OFFER data
            if (allData.get(i).getType() == CompanyOfferAndCoupon.COUPON)
                couponsData.add(allData.get(i));
        }

        // applying the custom adapter to the listView
        CouponsTabListAdapter couponsTabListAdapter = new CouponsTabListAdapter(couponsData);
        ListView listViewCoupons = getActivity().findViewById(R.id.listViewCoupons);
        listViewCoupons.setAdapter(couponsTabListAdapter);
    }

    /**
     * custom adapter for listViewCoupons
     *
     * @author Shayak Banerjee
     * @version 0.1
     * @since 17 June 2019
     */
    public class CouponsTabListAdapter extends BaseAdapter {
        private ArrayList<CompanyOfferAndCoupon> listOfOffersAndCoupons;

        /**Constructor*/
        CouponsTabListAdapter(ArrayList<CompanyOfferAndCoupon> listOfOffersAndCoupons) {
            this.listOfOffersAndCoupons = listOfOffersAndCoupons;
        }

        /**
         * @return number of items in listOfOffers
         */
        @Override
        public int getCount() {
            return listOfOffersAndCoupons.size();
        }

        /**
         * @param position position of data item in listOfOffers
         * @return data item at listOfOffers[position]
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

            // hiding the unwanted views
            buttonGrabOffer.setVisibility(View.GONE);
            textViewMarkedPrice.setVisibility(View.GONE);
            textViewDiscountedPrice.setVisibility(View.GONE);

            // setting the coupon data into the views
            Picasso.get().load(couponOrOffer.getImageLink()).into(imageViewLogo);
            textViewCategory.setText(couponOrOffer.getCategory());
            textViewCouponDescription.setText(couponOrOffer.getOfferDescription());
            buttonGetCouponCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View l) {
                    //TODO: write here what happens when buttonGetCouponCode is clicked
                }
            });

            return myView;
        }
    }
}
