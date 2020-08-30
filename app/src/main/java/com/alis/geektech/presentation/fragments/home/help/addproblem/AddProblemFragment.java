package com.alis.geektech.presentation.fragments.home.help.addproblem;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alis.geektech.R;
import com.alis.geektech.models.Help;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.alis.geektech.presentation.fragments.home.help.HelpFragment;
import com.alis.geektech.presentation.main.MainActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class AddProblemFragment extends Fragment {

    private ImageView imageBack;
    private TextInputLayout inputLayoutTitle;
    private EditText editTitle;
    private TextInputLayout inputLayoutDescription;
    private EditText editDescription;
    private TextInputLayout inputLayoutFromWhom;
    private EditText editFromWhom;
    private MaterialButton buttonSend;

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
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack();
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSend();
            }
        });
    }

    private void initializationViews(View view) {
        imageBack = view.findViewById(R.id.image_add_problem_back);
        inputLayoutTitle = view.findViewById(R.id.inputLayout_add_problem_title);
        editTitle = view.findViewById(R.id.edit_add_problem_title);
        inputLayoutDescription = view.findViewById(R.id.inputLayout_add_problem_description);
        editDescription = view.findViewById(R.id.edit_add_problem_description);
        inputLayoutFromWhom = view.findViewById(R.id.inputLayout_add_problem_from_whom);
        editFromWhom = view.findViewById(R.id.edit_add_problem_from_whom);
        buttonSend = view.findViewById(R.id.materialbutton_send);
    }

    private void clickBack() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigateUp();
    }

    private void clickSend() {
        if (editTitle.getText().toString().isEmpty() || editDescription.getText().toString().isEmpty() || editFromWhom.getText().toString().isEmpty()) {
            if (editTitle.getText().toString().isEmpty()) {
                inputLayoutTitle.setError("Заполните поле");
            }
            if (editDescription.getText().toString().isEmpty()) {
                inputLayoutDescription.setError("Заполните поле");
            }
            if (editFromWhom.getText().toString().isEmpty()) {
                inputLayoutFromWhom.setError("Заполните поле");
            }
        } else {
            inputLayoutTitle.setErrorEnabled(false);
            inputLayoutDescription.setErrorEnabled(false);
            inputLayoutFromWhom.setErrorEnabled(false);
            Bundle bundle = new Bundle();
            bundle.putSerializable(HelpFragment.ARG_HELP_DATA, new Help(
                    editTitle.getText().toString(),
                    editDescription.getText().toString(),
                    editFromWhom.getText().toString()
            ));
            hideKeyboard();
            Navigation
                    .findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_addProblemFragment_to_navigation_home, bundle);
            Toast.makeText(getContext(), "Элемент должен быть сохранян в Firebase", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideKeyboard() {
        View view = requireActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager IMM = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            IMM.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}