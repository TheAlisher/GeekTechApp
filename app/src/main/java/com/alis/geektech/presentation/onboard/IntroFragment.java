package com.alis.geektech.presentation.onboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alis.geektech.App;
import com.alis.geektech.R;

public class IntroFragment extends Fragment {

    private Button buttonSendARequest;

    public IntroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        buttonSendARequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSendARequest();
            }
        });
    }

    private void initializationViews(View view) {
        buttonSendARequest = view.findViewById(R.id.button_intro_send_a_request);
    }

    private void clickSendARequest() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_introFragment_to_signInFragment);
        App.appPreferences.setLaunched();
    }
}