package com.alis.geektech.presentation.auth;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.HomeFragment;

public class SignUpFragment extends Fragment {

    public static void start(Activity activity, int action) {
        Navigation
                .findNavController(activity, R.id.nav_host_fragment)
                .navigate(action);
    }

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
        buttonSignUp = view.findViewById(R.id.button_signUp);
        buttonAlreadyHaveAccount = view.findViewById(R.id.button_signUp_already_have_account);
    }

    private void clickSignUp() {
        HomeFragment.start(requireActivity(), R.id.action_signUpFragment_to_navigation_home);
    }

    private void clickAlreadyHaveAccount() {
        SignInFragment.start(requireActivity(), R.id.action_signUpFragment_to_signInFragment);
    }
}