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

/**
 * Author Shayak Banerjee
 *
 */
public class ChangePasswordFragment extends Fragment {
/*
    private ImageView iconDropDownArrow, iconDropUpArrow;
    private ConstraintLayout buttonExpandChangePassword;

    private TextView textViewCurrentPassword, textViewNewPassword, textViewConfirmPassword;
    private EditText editTextCurrentPassword, editTextNewPassword, editTextConfirmPassword;
    private Button buttonSaveChanges;

    private boolean areComponentsVisible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.change_password_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewCurrentPassword = getView().findViewById(R.id.textViewCurrentPassword);
        textViewNewPassword = getView().findViewById(R.id.textViewNewPassword);
        textViewConfirmPassword = getView().findViewById(R.id.textViewConfirmPassword);
        editTextCurrentPassword = getView().findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = getView().findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = getView().findViewById(R.id.editTextConfirmPassword);
        buttonExpandChangePassword = getView().findViewById(R.id.buttonExpandChangePassword);
        buttonSaveChanges = getView().findViewById(R.id.buttonSaveChanges);

        iconDropDownArrow = getView().findViewById(R.id.iconDropDownArrow);
        iconDropUpArrow = getView().findViewById(R.id.iconDropUpArrow);

        setAllComponentsAsVisible(false);

        buttonExpandChangePassword = getView().findViewById(R.id.buttonExpandChangePassword);
        buttonExpandChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                if (areComponentsVisible) {
                    setAllComponentsAsVisible(false);
                } else
                    setAllComponentsAsVisible(true);

                areComponentsVisible = !areComponentsVisible;
            }
        });


    }

    private void setAllComponentsAsVisible(boolean decision) {
        if (decision) {
            textViewCurrentPassword.setVisibility(View.VISIBLE);
            textViewNewPassword.setVisibility(View.VISIBLE);
            textViewConfirmPassword.setVisibility(View.VISIBLE);
            editTextCurrentPassword.setVisibility(View.VISIBLE);
            editTextNewPassword.setVisibility(View.VISIBLE);
            editTextConfirmPassword.setVisibility(View.VISIBLE);
            buttonSaveChanges.setVisibility(View.VISIBLE);

            iconDropDownArrow.setVisibility(View.GONE);
            iconDropUpArrow.setVisibility(View.VISIBLE);
        } else {
            textViewCurrentPassword.setVisibility(View.GONE);
            textViewNewPassword.setVisibility(View.GONE);
            textViewConfirmPassword.setVisibility(View.GONE);
            editTextCurrentPassword.setVisibility(View.GONE);
            editTextNewPassword.setVisibility(View.GONE);
            editTextConfirmPassword.setVisibility(View.GONE);
            buttonSaveChanges.setVisibility(View.GONE);

            iconDropDownArrow.setVisibility(View.VISIBLE);
            iconDropUpArrow.setVisibility(View.GONE);
        }
    }*/
}

