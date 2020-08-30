package com.alis.geektech.presentation.fragments.home.help.problem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alis.geektech.R;
import com.alis.geektech.models.Help;


public class ProblemFragment extends Fragment {

    public static final String ARG_PROBLEM_DATA = "problem_data";

    private ImageView imageBack;
    private TextView textTitle;
    private TextView textDescription;
    private TextView textFromWhom;
    private Button buttonHelp;

    public ProblemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_problem, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        getArgumentsAndSet();
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack();
            }
        });
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHelp();
            }
        });
    }

    private void initializationViews(View view) {
        imageBack = view.findViewById(R.id.image_promblem_back);
        textTitle = view.findViewById(R.id.text_problem_title);
        textDescription = view.findViewById(R.id.text_problem_description);
        textFromWhom = view.findViewById(R.id.text_problem_from_whom);
        buttonHelp = view.findViewById(R.id.button_problem_help);
    }

    private void getArgumentsAndSet() {
        if (getArguments() != null) {
            Help help = (Help) getArguments().getSerializable(ARG_PROBLEM_DATA);
            textTitle.setText(help.getProblemTitle());
            textDescription.setText(help.getProblemDescription());
            textFromWhom.setText(help.getProblemFromWhom());
        }
    }

    private void clickBack() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigateUp();
    }

    private void clickHelp() {
        Toast.makeText(getContext(), "Отправить уведомление " + textFromWhom.getText() + " МОГУ ПОМОЧЬ", Toast.LENGTH_SHORT).show();
        clickBack();
    }
}