package com.alis.geektech.presentation.fragments.profile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.alis.geektech.R;
import com.alis.geektech.models.User;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import static android.app.Activity.RESULT_OK;

public class EditProfileFragment extends Fragment {

    public static final String ARG_USER_DATA = "user_data";
    public final int PERMISSIONS_REQUEST_CODE = 18;
    public final int SELECT_IMAGE_REQUEST = 19;

    private ImageView imageUserPhoto;
    private EditText editName;
    private Spinner spinnerLevel;
    private EditText editGitHub;
    private EditText editPassword;
    private MaterialButton buttonSave;

    private String imageUserPhotoURI = "2131230816";

    public EditProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        createSpinnerLevel();
        getArgumentsAndSet();

        imageUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickUserPhoto();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSave();
            }
        });
    }

    private void initializationViews(View view) {
        imageUserPhoto = view.findViewById(R.id.image_editProfile_user_photo);
        editName = view.findViewById(R.id.edit_editProfile_name);
        spinnerLevel = view.findViewById(R.id.spinner_editProfile_level);
        editGitHub = view.findViewById(R.id.edit_editProfile_github);
        editPassword = view.findViewById(R.id.edit_editProfile_password);
        buttonSave = view.findViewById(R.id.materialbutton_editProfile_save);
    }

    private void createSpinnerLevel() {
        String[] dropdownCategory = getResources().getStringArray(R.array.SpinnerLevelArray);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(requireContext(), R.layout.custom_spinner_item, dropdownCategory);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLevel.setAdapter(adapter);
    }

    private void getArgumentsAndSet() {
        if (getArguments() != null) {
            User user = (User) getArguments().getSerializable(ARG_USER_DATA);
            if (user.getUserPhoto().equals("2131230816")) {
                imageUserPhoto.setImageResource(R.drawable.icon_default_user_photo);
            } else {
                Glide.with(requireContext()).load(user.getUserPhoto()).circleCrop().into(imageUserPhoto);
            }
            editName.setText(user.getUserName());
            spinnerSetSelectedItem(user);
            editGitHub.setText(user.getUserGitHub());
        }
    }

    private void spinnerSetSelectedItem(User user) {
        if (user.getUserLevel().equals("Java 1")) spinnerLevel.setSelection(0, true);
        if (user.getUserLevel().equals("Java 2")) spinnerLevel.setSelection(1, true);
        if (user.getUserLevel().equals("Android 1")) spinnerLevel.setSelection(2, true);
        if (user.getUserLevel().equals("Android 2")) spinnerLevel.setSelection(3, true);
        if (user.getUserLevel().equals("Android 3")) spinnerLevel.setSelection(4, true);
        if (user.getUserLevel().equals("Android 4")) spinnerLevel.setSelection(5, true);
        if (user.getUserLevel().equals("Android 5")) spinnerLevel.setSelection(6, true);
    }

    private void clickUserPhoto() {
        checkPermission();
    }

    private void checkPermission() {
        int permissionStatus = ContextCompat.checkSelfPermission
                (requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else {
            getGalleryPermissions();
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);
        startActivityForResult(galleryIntent, SELECT_IMAGE_REQUEST);
    }

    private void getGalleryPermissions() {
        ActivityCompat.requestPermissions(
                requireActivity(),
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_CODE
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE_REQUEST && resultCode == RESULT_OK && data.getData() != null) {
            Glide.with(this).load(data.getData()).circleCrop().into(imageUserPhoto);
            imageUserPhotoURI = String.valueOf(data.getData());
        }
    }

    private void clickSave() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(
                ARG_USER_DATA,
                new User(
                        imageUserPhotoURI,
                        editName.getText().toString(),
                        spinnerLevel.getSelectedItem().toString(),
                        editGitHub.getText().toString()
                )
        );
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_editProfileFragment_to_navigation_profile, bundle);
    }
}