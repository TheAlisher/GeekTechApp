package com.alis.geektech.presentation.fragments.sendarequest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alis.geektech.R;
import com.alis.geektech.presentation.auth.SignInFragment;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class SendARequestFragment extends Fragment {

    private EditText editName;
    private EditText editPhoneNumber;
    private Button buttonSend;

    public SendARequestFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_a_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSend();
            }
        });
    }

    private void initializationViews(View view) {
        editName = view.findViewById(R.id.edit_sendARequest_name);
        editPhoneNumber = view.findViewById(R.id.edit_sendARequest_phone_number);
        buttonSend = view.findViewById(R.id.button_sendARequest_send);
    }

    private void clickSend() {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            SignInFragment.start(requireActivity(), R.id.action_sendARequestFragment_to_signInFragment);
        } else {
            HomeFragment.start(requireActivity(), R.id.action_sendARequestFragment_to_navigation_home);
        }
    }
}