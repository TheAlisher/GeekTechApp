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

public class SignInFragment extends Fragment {

    public static void start(Activity activity, int action) {
        Navigation
                .findNavController(activity, R.id.nav_host_fragment)
                .navigate(action);
    }

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
        buttonSingIn = view.findViewById(R.id.button_signIn);
        buttonDontHaveAccount = view.findViewById(R.id.button_signIn_dont_have_account);
    }

    private void clickSignIn() {

    }

    private void clickDontHaveAccount() {
        SignUpFragment.start(requireActivity(), R.id.action_signInFragment_to_signUpFragment);
    }
}