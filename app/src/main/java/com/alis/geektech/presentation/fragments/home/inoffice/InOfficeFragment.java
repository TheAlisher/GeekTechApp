package com.alis.geektech.presentation.fragments.home.inoffice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alis.geektech.R;

public class InOfficeFragment extends Fragment {

    private ImageView imageBack;
    private SearchView searchInOffice;

    private RecyclerView recyclerView;

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
        createStudentsRecycler();
    }

    private void initializationViews(View view) {
        imageBack = view.findViewById(R.id.image_inOffice_back);
        searchInOffice = view.findViewById(R.id.search_inOffice);
        recyclerView = view.findViewById(R.id.recycler_inOffice);
    }

    private void createStudentsRecycler() {

    }
}