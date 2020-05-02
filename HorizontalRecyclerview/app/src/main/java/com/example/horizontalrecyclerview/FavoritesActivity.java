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

/**
 * This activity displays all the favorites
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 12th June 2019
 */
public class FavoritesActivity extends AppCompatActivity {

    // Lists that are displayed
    private ArrayList<NewOffer> newOfferArrayList;
    private ArrayList<LatestOffer> latestOfferArrayList;

    // List views which contain the lists
    private ListView listViewNewOffers;
    private ListView listViewLatestOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        newOfferArrayList = new ArrayList<>();
        latestOfferArrayList = new ArrayList<>();

        loadTestData();

        listViewNewOffers = findViewById(R.id.listViewNewOffers);
        NewOfferListAdapter newOfferListAdapter = new NewOfferListAdapter( this, newOfferArrayList);
        listViewNewOffers.setAdapter(newOfferListAdapter);

        listViewLatestOffers = findViewById(R.id.listViewLatestOffers);
        LatestOfferListAdapter latestOfferListAdapter = new LatestOfferListAdapter(this, latestOfferArrayList);
        listViewLatestOffers.setAdapter(latestOfferListAdapter);

        // sets the height of list views to enable full page scroll
        setDynamicHeight(listViewLatestOffers);
        setDynamicHeight(listViewNewOffers);

        // the offer heading
        setNewOfferNumberInHeading(377);
        // Showing Stores 1 of 1
        setShowingStores(1, 1);
    }

    /**
     * Set listview height based on listview children
     *
     * @param listView
     */
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

    /**
     * Loads test data
     * remove after testing
     */
   /**/ public void loadTestData(){
        newOfferArrayList.add(new NewOffer(

                "https://pmcvariety.files.wordpress.com/2018/01/amazon-logo.jpg",
                "Amazon",
                "5 "
        ));
/**/

        latestOfferArrayList.add(new LatestOffer(
                "https://img.etimg.com/thumb/msid-66421537,width-1200,height-900,resizemode-4,imgsize-165547/untitled-7.jpg",
                "Flat 50% cashback on all your Pepperfy orders",
                "UpTo Rs.200 Cashback",
                "34",
                "193 days left"
        ));

        latestOfferArrayList.add(new LatestOffer(
                "https://hippoprod.s3.amazonaws.com/merchants/logos/000/000/037/large/cleartrip_india_logo.png",
                "Flat 30% cashback on all your Cleartrip orders",
                "UpTo Rs.250 Cashback",
                "24",
                "80 days left"
        ));
    }

    /**
     * Sets the number of showing stores<br>
     * eg.<br>
     * Showing 1 of 1 stores
     * @param showing
     * @param total
     */
    public void setShowingStores(int showing, int total){
        TextView textViewShowingStores = findViewById(R.id.textViewShowingStores);
        String text = "Showing " + showing + " of " + total + " stores";
        textViewShowingStores.setText(text);
    }

    /**
     * Sets the number of new offers in the header of the Activity (the topmost LinearLayout)
     * @param number the number of new offers
     */
    public void setNewOfferNumberInHeading(int number){
        TextView textViewNewOfferNumber = findViewById(R.id.textViewNewOfferNumber);
        String text = " " + number + " ";
        textViewNewOfferNumber.setText(text);
    }


    /**
     * Adapter for listViewNewOffers
     */
    public class NewOfferListAdapter extends BaseAdapter{

        private ArrayList<NewOffer> listOfNewOffers;
        private Context context;

        /**
         * Constructor
         * @param context activity in which the listView exists
         * @param listOfNewOffers list of offers
         */
        public NewOfferListAdapter(Context context, ArrayList<NewOffer> listOfNewOffers) {
            this.listOfNewOffers = listOfNewOffers;
            this.context = context;
        }

        /**
         * @return the number of items in the list view
         */
        @Override
        public int getCount() {
            return listOfNewOffers.size();
        }

        /**
         * @param position position of item in the list
         * @return the list item
         */
        @Override
        public Object getItem(int position) {
            return listOfNewOffers.get(position);
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

            NewOffer newOffer = listOfNewOffers.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View newOfferTicket = inflater.inflate(R.layout.new_offer_ticket, null);

            ImageView imageViewLogo = newOfferTicket.findViewById(R.id.imageViewLogo);
            TextView textViewCompanyName = newOfferTicket.findViewById(R.id.textViewCompanyName);
            // clickable text view
            final TextView buttonRewards = newOfferTicket.findViewById(R.id.buttonRewards);
            buttonRewards.setClickable(true);
            buttonRewards.setFocusable(true);
            buttonRewards.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View l) {
                    //TODO: write here what happens when buttonRewards is clicked
                }
            });

            // loading company logo
            Picasso.get().load(newOffer.getLogoLink()).into(imageViewLogo);
            // loading company and offer details
            textViewCompanyName.setText(newOffer.getCompanyName());
            buttonRewards.setText(newOffer.getNumberOfRewards().concat(getString(R.string.rewards)));

            return newOfferTicket;
        }
    }

    /**
     * Adapter for listViewLatestOffers
     */
    public class LatestOfferListAdapter extends BaseAdapter{

        // The activity in which the listView exists
        Context context;
        // List of offers
        ArrayList<LatestOffer> listOfLatestOffers;

        /**
         * Constructor
         * @param context activity in which the listView exists
         * @param listOfLatestOffers list of offers
         */
        LatestOfferListAdapter(Context context, ArrayList<LatestOffer> listOfLatestOffers) {
            this.context = context;
            this.listOfLatestOffers = listOfLatestOffers;
        }

        /**
         * @return the number of items in the list view
         */
        @Override
        public int getCount() {
            return listOfLatestOffers.size();
        }

        /**
         *
         * @param position position of item in the list
         * @return the list item
         */
        @Override
        public Object getItem(int position) {
            return listOfLatestOffers.get(position);
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
            LatestOffer latestOffer = listOfLatestOffers.get(position);

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View latestOfferTicket = layoutInflater.inflate(R.layout.latest_offer_ticket, null);

            ImageView imageViewLogo = latestOfferTicket.findViewById(R.id.imageViewLogo);
            TextView textViewOffer = latestOfferTicket.findViewById(R.id.textViewOffer);
            TextView buttonCashback = latestOfferTicket.findViewById(R.id.buttonCashback);
            TextView textViewNumberOfUsers = latestOfferTicket.findViewById(R.id.textViewNumberOfUsers);
            TextView textViewTimeLeft = latestOfferTicket.findViewById(R.id.textViewTimeLeft);

            Picasso.get().load(latestOffer.getLogoLink()).into(imageViewLogo);
            textViewOffer.setText(latestOffer.getOffer());
            String cashback = latestOffer.getCashback() + " ";
            buttonCashback.setText(cashback);
            textViewNumberOfUsers.setText(latestOffer.getNumberOfUsers());
            textViewTimeLeft.setText(latestOffer.getTimeLeft());

            return latestOfferTicket;
        }
    }


}
