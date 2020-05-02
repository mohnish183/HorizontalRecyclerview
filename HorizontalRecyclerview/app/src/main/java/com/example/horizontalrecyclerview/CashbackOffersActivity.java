package com.example.horizontalrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CashbackOffersActivity extends AppCompatActivity {
    private ArrayList<CashbackVouchers> latestOfferArrayList;
    private ListView listViewLatestVouchers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashback_offers);
        latestOfferArrayList = new ArrayList<>();
        listViewLatestVouchers = findViewById(R.id.listViewLatestVouchers);
        loadTestData();
        LatestOfferListAdapter latestOfferListAdapter = new LatestOfferListAdapter(this, latestOfferArrayList);
        listViewLatestVouchers.setAdapter(latestOfferListAdapter);
        setDynamicHeight(listViewLatestVouchers);
    }


    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }
    public void loadTestData() {
        latestOfferArrayList.add(new CashbackVouchers(
                "https://img.etimg.com/thumb/msid-66421537,width-1200,height-900,resizemode-4,imgsize-165547/untitled-7.jpg",
                "Flat 50% cashback on all your Pepperfy orders",
                "UpTo Rs.200 Cashback"

        ));

        latestOfferArrayList.add(new CashbackVouchers(
                "https://hippoprod.s3.amazonaws.com/merchants/logos/000/000/037/large/cleartrip_india_logo.png",
                "Flat 30% cashback on all your Cleartrip orders",
                "UpTo Rs.250 Cashback"));
            //    "24",
            //    "80 days left"
        latestOfferArrayList.add(new CashbackVouchers(
                "https://www.searchpng.com/wp-content/uploads/2019/03/Swiggy-PNG-Logo-715x715.png",
                "Flat 25% cashback on all your Swiggy orders",
                "UpTo Rs.300 Cashback"));
        latestOfferArrayList.add(new CashbackVouchers(
                "https://upload.wikimedia.org/wikipedia/en/0/09/Zomato_company_logo.png",
                "Flat 45% cashback on all your Zomato orders",
                "UpTo Rs.150 Cashback"));
        latestOfferArrayList.add(new CashbackVouchers(
                "https://pngimg.com/uploads/amazon/amazon_PNG13.png",
                "Avail 10% cashback on all your amazon orders",
                "UpTo Rs.100 Cashback"));

    }
    public class LatestOfferListAdapter extends BaseAdapter {

        // The activity in which the listView exists
        Context context;
        // List of offers
        ArrayList<CashbackVouchers> listOfVouchers;



        LatestOfferListAdapter(Context context, ArrayList<CashbackVouchers> listOfVouchers) {
            this.context = context;
            this.listOfVouchers = listOfVouchers;
        }

        /**
         * @return the number of items in the list view
         */
        @Override
        public int getCount() {
            return listOfVouchers.size();
        }

        /**
         *
         * @param position position of item in the list
         * @return the list item
         */
        @Override
        public Object getItem(int position) {
            return listOfVouchers.get(position);
        }


        @Override
        public long getItemId(int position) {
            return (long)position;
        }

        /**
         * Assignment and handling of all widgets in the view ticket
         * @param position position of item in the list
         * @param convertView converted view
         * @param parent parent activity
         * @return view that will be displayed in the listview
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CashbackVouchers cashbackVouchers = listOfVouchers.get(position);

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View listOfVouchers = layoutInflater.inflate(R.layout.activity_vouchers, null);

            ImageView imageViewLogo = listOfVouchers.findViewById(R.id.imageViewLogo);
            TextView textViewOffer = listOfVouchers.findViewById(R.id.textViewOffer);
            TextView buttonCashback = listOfVouchers.findViewById(R.id.buttonCashback);
      //      TextView textViewNumberOfUsers = listOfVouchers.findViewById(R.id.textViewNumberOfUsers);
        //    TextView textViewTimeLeft = listOfVouchers.findViewById(R.id.textViewTimeLeft);

            Picasso.get().load(cashbackVouchers.getLogoLink()).into(imageViewLogo);
            textViewOffer.setText(cashbackVouchers.getOffer());
            String cashback = cashbackVouchers.getCashback() + " ";
            buttonCashback.setText(cashback);
          //  textViewNumberOfUsers.setText(cashbackVouchers.getNumberOfUsers());
          //  textViewTimeLeft.setText(cashbackVouchers.getTimeLeft());

            return listOfVouchers;
        }
    }

}
