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
 * This tab displays all deals
 *
 * @author Shayak Banerjee
 * @version 0.2
 * @since 13 June 2019
 */
public class DealsTab extends Fragment {
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
