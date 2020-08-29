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
    private Button buttonAlreadyHaveAccount;

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
        buttonAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAlreadyHaveAccount();
            }
        });
    }

    private void initializationViews(View view) {
        editName =view.findViewById(R.id.edit_signUp_name);
        editEmail = view.findViewById(R.id.edit_signUp_email);
        editPassword = view.findViewById(R.id.edit_signUp_password);
        editPhoneNumber = view.findViewById(R.id.edit_signUp_phone_number);
        buttonSignUp = view.findViewById(R.id.button_signUp);
        buttonAlreadyHaveAccount = view.findViewById(R.id.button_signUp_already_have_account);
    }

    private void clickSignUp() {
        HomeFragment.start(requireActivity(), R.id.action_authenticationFragment_to_navigation_home);
    }

    private void clickAlreadyHaveAccount() {
        AuthenticationFragment.viewPager.setCurrentItem(0);
    }
}