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

public class SignInFragment extends Fragment {

    private EditText editUsername;
    private EditText editPassword;
    private Button buttonSingIn;
    private Button buttonDontHaveAccount;

    public SignInFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);

        buttonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSignIn();
            }
        });
        buttonDontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDontHaveAccount();
            }
        });
    }

    private void initializationViews(View view) {
        editUsername = view.findViewById(R.id.edit_signIn_username);
        editPassword = view.findViewById(R.id.edit_signIn_password);
        buttonSingIn = view.findViewById(R.id.button_signIn);
        buttonDontHaveAccount = view.findViewById(R.id.button_signIn_dont_have_account);
    }

    private void clickSignIn() {
        HomeFragment.start(requireActivity(), R.id.action_authenticationFragment_to_navigation_home);
    }

    private void clickDontHaveAccount() {
        AuthenticationFragment.viewPager.setCurrentItem(1);
    }
}