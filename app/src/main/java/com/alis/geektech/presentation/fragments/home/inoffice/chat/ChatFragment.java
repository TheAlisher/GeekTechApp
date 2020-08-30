package com.alis.geektech.presentation.fragments.home.inoffice.chat;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alis.geektech.R;
import com.alis.geektech.models.User;
import com.google.android.material.textfield.TextInputLayout;

public class ChatFragment extends Fragment {

    public static final String ARG_CHAT_DATA = "chat_data";

    private ImageView imageBack;
    private ImageView imageUserPhoto;
    private TextView textName;
    private TextInputLayout inputLayoutSendMessage;
    private EditText editSendMessage;

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
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
        inputLayoutSendMessage.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSendMessageEndIcon();
            }
        });
    }

    private void initializationViews(View view) {
        imageBack = view.findViewById(R.id.image_chat_back);
        imageUserPhoto = view.findViewById(R.id.image_chat_user_photo);
        textName = view.findViewById(R.id.text_chat_name);
        inputLayoutSendMessage = view.findViewById(R.id.inputLayout_chat_send_message);
        editSendMessage = view.findViewById(R.id.edit_chat_send_message);
    }

    private void getArgumentsAndSet() {
        if (getArguments() != null) {
            User user = (User) getArguments().getSerializable(ARG_CHAT_DATA);
            imageUserPhoto.setImageResource(R.drawable.icon_navigation_account_circle);
            textName.setText(user.getUserName());
        }
    }

    private void clickBack() {
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigateUp();
    }

    private void clickSendMessageEndIcon() {
        hideKeyboard();
    }

    private void hideKeyboard() {
        View view = requireActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager IMM = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            IMM.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}