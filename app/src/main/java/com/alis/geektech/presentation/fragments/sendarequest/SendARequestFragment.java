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
import com.alis.geektech.presentation.authentication.AuthenticationFragment;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class SendARequestFragment extends Fragment {

    private TextInputLayout inputLayoutName;
    private EditText editName;
    private TextInputLayout inputLayoutPhoneNumber;
    private EditText editPhoneNumber;
    private MaterialButton buttonSend;

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
        inputLayoutName = view.findViewById(R.id.inputLayout_send_a_request_name);
        editName = view.findViewById(R.id.edit_sendARequest_name);
        inputLayoutPhoneNumber = view.findViewById(R.id.inputLayout_send_a_request_phone_number);
        editPhoneNumber = view.findViewById(R.id.edit_sendARequest_phone_number);
        buttonSend = view.findViewById(R.id.materialbutton_sendARequest_send);
    }

    private void clickSend() {
        if (editName.getText().toString().isEmpty() || editPhoneNumber.getText().toString().isEmpty()) {
            if (editName.getText().toString().isEmpty()) {
                inputLayoutName.setError("Заполните");
            }
            if (editPhoneNumber.getText().toString().isEmpty()) {
                inputLayoutName.setError("Заполните");
            }
        } else  {
            inputLayoutName.setErrorEnabled(false);
            inputLayoutPhoneNumber.setErrorEnabled(false);
            if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                AuthenticationFragment.start(requireActivity(), R.id.action_sendARequestFragment_to_authenticationFragment);
            } else {
                HomeFragment.start(requireActivity(), R.id.action_sendARequestFragment_to_navigation_home);
            }
            Navigation
                    .findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_sendARequestFragment_to_navigation_home);
        }
    }
}