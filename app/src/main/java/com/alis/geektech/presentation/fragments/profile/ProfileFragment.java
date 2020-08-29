package com.alis.geektech.presentation.fragments.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alis.geektech.adapters.ProjectsAdapter;
import com.alis.geektech.R;
import com.alis.geektech.models.Project;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private Button buttonEditProfile;

    private RecyclerView recyclerView;
    private ProjectsAdapter adapter;
    private ArrayList<Project> list = new ArrayList<>();

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        createRecycler(view);
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEditProfile();
            }
        });
    }

    private void initializationViews(View view) {
        buttonEditProfile = view.findViewById(R.id.button_edit_profile);
    }

    private void createRecycler(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProjectsAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void clickEditProfile() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_navigation_profile_to_editProfileFragment);
    }
}