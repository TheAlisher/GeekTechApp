package com.alis.geektech.presentation.fragments.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alis.geektech.adapters.ProjectsAdapter;
import com.alis.geektech.R;
import com.alis.geektech.models.Project;
import com.alis.geektech.models.User;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private ImageView imageUserPhoto;
    private TextView textName;
    private ImageView imageVerified;
    private EditText editLevel;
    private EditText editGitHub;
    private MaterialButton buttonEditProfile;
    private MaterialButton buttonLogout;

    private RecyclerView recyclerView;
    private ProjectsAdapter adapter;
    private ArrayList<Project> list = new ArrayList<>();

    private String imageUserPhotoURI = "2131230816";

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
        setDataFromGmailAuth();
        createProjectsRecycler();
        getArgumentsAndSet();

        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEditProfile();

            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogout();
            }
        });
    }

    private void initializationViews(View view) {
        imageUserPhoto = view.findViewById(R.id.image_profile_user_photo);
        textName = view.findViewById(R.id.text_profile_name);
        imageVerified = view.findViewById(R.id.image_profile_verified);
        editLevel = view.findViewById(R.id.edit_profile_level);
        editGitHub = view.findViewById(R.id.edit_profile_github);
        buttonEditProfile = view.findViewById(R.id.materialbutton_profile_edit);
        buttonLogout = view.findViewById(R.id.materialbutton_profile_logout);
        recyclerView = view.findViewById(R.id.recycler_profile);
    }

    private void setDataFromGmailAuth() {
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(requireContext());
        if (googleSignInAccount != null) {
            textName.setText(googleSignInAccount.getDisplayName());
        }
    }

    private void createProjectsRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProjectsAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void getArgumentsAndSet() {
        if (getArguments() != null) {
            User user = (User) getArguments().getSerializable(EditProfileFragment.ARG_USER_DATA);
            if (String.valueOf(user.getUserPhoto()).equals("2131230816")) {
                imageUserPhoto.setImageResource(R.drawable.icon_default_user_photo);
            } else  {
                Glide.with(requireContext()).load(user.getUserPhoto()).circleCrop().into(imageUserPhoto);
                imageUserPhotoURI = user.getUserPhoto();
            }
            textName.setText(user.getUserName());
            editLevel.setText(user.getUserLevel());
            editGitHub.setText(user.getUserGitHub());
        }
    }

    private void clickEditProfile() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(
                EditProfileFragment.ARG_USER_DATA,
                new User(
                        imageUserPhotoURI,
                        textName.getText().toString(),
                        editLevel.getText().toString(),
                        editGitHub.getText().toString()
                ));
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_navigation_profile_to_editProfileFragment, bundle);
    }

    private void clickLogout() {
        FirebaseAuth.getInstance().signOut();
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_navigation_profile_to_authenticationFragment);
        Toast.makeText(getContext(), "Вы успешно вышли с акккаунта", Toast.LENGTH_SHORT).show();
    }
}