package com.example.horizontalrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * @author Shayak Banerjee
 * @version 0.1
 * @since 11 June, 2019
 */
public class RecyclerViewFAQAdapter extends RecyclerView.Adapter<RecyclerViewFAQAdapter.ViewHolder> {

    // List of FAQItems
    private ArrayList<FAQItem> faqItemsList;

    /**
     * Constructor<br>
     * Creates the RecyclerView
     * @param faqItemsList list of FAQItems
     */
    RecyclerViewFAQAdapter(ArrayList<FAQItem> faqItemsList){
        this.faqItemsList = faqItemsList;
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        /**
         * Title of the FAQItem
         */
        TextView textViewTitle;
        /**
         * Description of the FAQItem
         */
        TextView textViewDescription;
        /**
         * Used to determine if the description should be displayed
         */
        private boolean isDescriptionVisible = false;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Holds the FAQItem's title
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            // Holds the FAQItem's description
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            // Description is not visible by default
            textViewDescription.setVisibility(View.GONE);

            // on click, textViewDescription is set to visible. If already visible textViewDescription
            textViewTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View l) {
                    if(isDescriptionVisible)
                        textViewDescription.setVisibility(View.GONE);
                    else
                        textViewDescription.setVisibility(View.VISIBLE);
                    isDescriptionVisible = !isDescriptionVisible;
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.faq_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FAQItem faqItem = faqItemsList.get(i);

        viewHolder.textViewTitle.setText(faqItem.title);
        viewHolder.textViewDescription.setText(faqItem.description);
    }

    @Override
    public int getItemCount() {
        return faqItemsList.size();
    }


}
