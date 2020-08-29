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
import android.widget.TextView;
import android.widget.Toast;

import com.alis.geektech.adapters.ProjectsAdapter;
import com.alis.geektech.R;
import com.alis.geektech.models.Project;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private TextView textName;
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
        setUserData();
        createRecycler(view);

        textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(), "SignOut", Toast.LENGTH_SHORT).show();
            }
        });
        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEditProfile();
            }
        });
    }

    private void initializationViews(View view) {
        textName = view.findViewById(R.id.tv_nick_name);
        buttonEditProfile = view.findViewById(R.id.button_edit_profile);
    }

    private void setUserData() {
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(requireContext());
        if (googleSignInAccount != null) {
            Toast.makeText(getContext(), googleSignInAccount.getDisplayName(), Toast.LENGTH_SHORT).show();
        }
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