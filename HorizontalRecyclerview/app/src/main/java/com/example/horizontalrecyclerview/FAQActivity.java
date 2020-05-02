package com.example.horizontalrecyclerview;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.horizontalrecyclerview.R;

import java.util.ArrayList;

public class FAQActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFAQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        recyclerViewFAQ = findViewById(R.id.recyclerViewFAQ);

        recyclerViewFAQ.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));

        // faq data
        ArrayList<FAQItem> faqItemArrayList = new ArrayList<>();
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_1), getString(R.string.faq_answer_1)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_2), getString(R.string.faq_answer_2)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_3), getString(R.string.faq_answer_3)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_4), getString(R.string.faq_answer_4)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_5), getString(R.string.faq_answer_5)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_6), getString(R.string.faq_answer_6)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_7), getString(R.string.faq_answer_7)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_8), getString(R.string.faq_answer_8)));
        faqItemArrayList.add(new FAQItem(getString(R.string.faq_title_9), getString(R.string.faq_answer_9)));

        RecyclerViewFAQAdapter recyclerViewFAQAdapter = new RecyclerViewFAQAdapter(faqItemArrayList);
        recyclerViewFAQ.setAdapter(recyclerViewFAQAdapter);

    }

    /**
     * Launches a dialog for entering a new question or a new topic
     * @param view button (can't find your topic here)
     */
    public void onClickButton(View view){

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.fragment_faq_new_topic);

        final Button buttonSend = dialog.findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                EditText editTextNewQuestion = dialog.findViewById(R.id.editTextNewQuestion);
                sendNewFAQQuestion(editTextNewQuestion.getText().toString());
            }
        });

        dialog.show();
    }

    /**
     * sends a new question to the database for the faq
     * @param text the text data that is sent to the database
     */
    private void sendNewFAQQuestion(@SuppressWarnings("unused") String text){
        //TODO: send question to the database
    }
}
