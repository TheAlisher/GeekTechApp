package com.alis.geektech.presentation.fragments.home.help.addproblem;

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
import android.widget.TextView;

import com.alis.geektech.R;
import com.google.android.material.textfield.TextInputLayout;

public class AddProblemFragment extends Fragment {

    private TextInputLayout inputLayoutTitle;
    private EditText editTitle;
    private TextInputLayout inputLayoutDescription;
    private EditText editDescription;
    private Button buttonSend;

    public AddProblemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_problem, container, false);
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
        inputLayoutTitle = view.findViewById(R.id.inputLayout_add_problem_title);
        editTitle = view.findViewById(R.id.edit_add_problem_title);
        inputLayoutDescription = view.findViewById(R.id.inputLayout_add_problem_description);
        editDescription = view.findViewById(R.id.edit_add_problem_description);
        buttonSend = view.findViewById(R.id.button_send);
    }

    private void clickSend() {
        if (editTitle.getText().toString().isEmpty() || editDescription.getText().toString().isEmpty()) {
            if (editTitle.getText().toString().isEmpty()) {
                inputLayoutTitle.setError("Заполните поле");
            }
            if (editDescription.getText().toString().isEmpty()) {
                inputLayoutDescription.setError("Заполните поле");
            }
        } else  {
            inputLayoutDescription.setErrorEnabled(false);
            inputLayoutDescription.setErrorEnabled(false);
            Navigation
                    .findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigateUp();
        }
    }
}