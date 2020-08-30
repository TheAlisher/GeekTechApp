package com.alis.geektech.presentation.authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.HomeFragment;

public class SignUpFragment extends Fragment {

    private EditText editName;
    private EditText editEmail;
    private EditText editPhoneNumber;
    private EditText editPassword;
    private Button buttonSignUp;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSignUp();
            }
        });
    }

    private void initializationViews(View view) {
        editName = view.findViewById(R.id.edit_signUp_name);
        editEmail = view.findViewById(R.id.edit_signUp_email);
        editPassword = view.findViewById(R.id.edit_signUp_password);
        editPhoneNumber = view.findViewById(R.id.edit_signUp_phone_number);
        buttonSignUp = view.findViewById(R.id.button_signUp);
    }

    private void clickSignUp() {
        if (
                editName.getText().toString().isEmpty() ||
                        editEmail.getText().toString().isEmpty() ||
                        editPhoneNumber.getText().toString().isEmpty() ||
                        editPhoneNumber.getText().toString().isEmpty()
        ) {
            if (editName.getText().toString().isEmpty()) {
                editName.setError("Заполните");
            }
            if (editEmail.getText().toString().isEmpty()) {
                editEmail.setError("Заполните");
            }
            if (editPhoneNumber.getText().toString().isEmpty()) {
                editPhoneNumber.setError("Заполните");
            }
            if (editPassword.getText().toString().isEmpty()) {
                editPassword.setError("Заполните");
            }
        } else {
            HomeFragment.start(requireActivity(), R.id.action_authenticationFragment_to_navigation_home);
        }
    }
}