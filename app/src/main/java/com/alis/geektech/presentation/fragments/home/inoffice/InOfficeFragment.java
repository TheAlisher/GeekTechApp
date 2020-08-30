package com.alis.geektech.presentation.fragments.home.inoffice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.alis.geektech.R;
import com.alis.geektech.adapters.StudentsAdapter;
import com.alis.geektech.interfaces.OnItemClickListener;
import com.alis.geektech.models.User;
import com.alis.geektech.presentation.fragments.home.HomeFragment;

import java.util.ArrayList;

public class InOfficeFragment extends Fragment {

    private ImageView imageBack;
    private SearchView searchInOffice;

    private RecyclerView recyclerView;
    private StudentsAdapter adapter;
    private ArrayList<User> list = new ArrayList<>();

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
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack();
            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                clickAdapter();
            }
        });
    }

    private void initializationViews(View view) {
        imageBack = view.findViewById(R.id.image_inOffice_back);
        searchInOffice = view.findViewById(R.id.search_inOffice);
        recyclerView = view.findViewById(R.id.recycler_inOffice);
    }

    private void createStudentsRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new StudentsAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void clickBack() {
        HomeFragment.viewPager.setCurrentItem(1, true);
    }

    private void clickAdapter() {

    }
}