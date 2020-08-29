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

    private Button buttonApply;

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
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickApply();
            }
        });
    }

    private void initializationViews(View view) {
        buttonApply = view.findViewById(R.id.button_intro_apply);
    }

    private void clickApply() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_introFragment_to_sendARequestFragment);
        App.appPreferences.setLaunched();
    }
}