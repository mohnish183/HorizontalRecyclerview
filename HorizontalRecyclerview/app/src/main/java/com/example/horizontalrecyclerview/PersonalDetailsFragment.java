package com.example.horizontalrecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonalDetailsFragment extends Fragment {

 /*   private ImageView iconDropDownArrow, iconDropUpArrow;
    private ConstraintLayout buttonExpandPersonalDetails;

    private TextView textViewFullName, textViewEmailAddress, textViewContactNumber;
    private EditText editTextFullName, editTextEmailAddress, editTextContactNumber;
    private Button buttonSaveChanges;

    private boolean areComponentsVisible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // view assignments
        textViewFullName = getView().findViewById(R.id.textViewFullName);
        textViewEmailAddress = getView().findViewById(R.id.textViewEmailAddress);
        textViewContactNumber = getView().findViewById(R.id.textViewContactNumber);
        editTextFullName = getView().findViewById(R.id.editTextFullName);
        editTextEmailAddress = getView().findViewById(R.id.editTextEmailAddress);
        editTextContactNumber = getView().findViewById(R.id.editTextContactNumber);
        buttonSaveChanges = getView().findViewById(R.id.buttonSaveChanges);

        iconDropDownArrow = getView().findViewById(R.id.iconDropDownArrow);
        iconDropUpArrow = getView().findViewById(R.id.iconDropUpArrow);
        iconDropUpArrow.setVisibility(View.GONE); // hides the up arrow, as the view is already collapsed

        buttonExpandPersonalDetails = getView().findViewById(R.id.buttonExpandPersonalDetails);
        buttonExpandPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                if(areComponentsVisible)
                    setAllComponentsAsVisible(false);
                else
                    setAllComponentsAsVisible(true);
                areComponentsVisible = !areComponentsVisible;
            }
        });

        // all components are hidden by default
        setAllComponentsAsVisible(false);

    }

    private void setAllComponentsAsVisible(boolean decision){
        if(decision){
            textViewFullName.setVisibility(View.VISIBLE);
            textViewEmailAddress.setVisibility(View.VISIBLE);
            textViewContactNumber.setVisibility(View.VISIBLE);
            editTextFullName.setVisibility(View.VISIBLE);
            editTextEmailAddress.setVisibility(View.VISIBLE);
            editTextContactNumber.setVisibility(View.VISIBLE);
            buttonSaveChanges.setVisibility(View.VISIBLE);
            iconDropDownArrow.setVisibility(View.GONE);
            iconDropUpArrow.setVisibility(View.VISIBLE);
        } else {
            textViewFullName.setVisibility(View.GONE);
            textViewEmailAddress.setVisibility(View.GONE);
            textViewContactNumber.setVisibility(View.GONE);
            editTextFullName.setVisibility(View.GONE);
            editTextEmailAddress.setVisibility(View.GONE);
            editTextContactNumber.setVisibility(View.GONE);
            buttonSaveChanges.setVisibility(View.GONE);
            iconDropDownArrow.setVisibility(View.VISIBLE);
            iconDropUpArrow.setVisibility(View.GONE);
        }
    }*/
}
