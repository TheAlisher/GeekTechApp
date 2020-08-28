package com.alis.geektech.presentation.fragments.home.inoffice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alis.geektech.R;

public class InOfficeFragment extends Fragment {

    private Button buttonWhoWillEat;

    public InOfficeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_in_office, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);

        buttonWhoWillEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickWhoWillEat();
            }
        });
    }

    private void initializationViews(View view) {
        buttonWhoWillEat = view.findViewById(R.id.button_inOffice_who_will_eat);
    }

    private void clickWhoWillEat() {
        Toast.makeText(getContext(), "Отправить всем кто в офисе уведомление КТО БУДЕТ КУШАТЬ?", Toast.LENGTH_SHORT).show();
    }
}