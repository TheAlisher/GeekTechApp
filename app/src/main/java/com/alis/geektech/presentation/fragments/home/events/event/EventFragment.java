package com.alis.geektech.presentation.fragments.home.events.event;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alis.geektech.R;
import com.alis.geektech.models.Event;
import com.bumptech.glide.Glide;

public class EventFragment extends Fragment {

    public static final String ARG_EVENT_DATA = "event_data";

    private ImageView imageEvent;
    private TextView textName;
    private TextView textDescription;
    private TextView textData;
    private TextView textTime;

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        getArgumentsAndSend();
    }

    private void initializationViews(View view) {
        imageEvent = view.findViewById(R.id.image_event_photo);
        textName = view.findViewById(R.id.text_event_title);
        textDescription = view.findViewById(R.id.text_event_description);
        textData = view.findViewById(R.id.text_event_data);
        textTime = view.findViewById(R.id.text_event_time);
    }

    private void getArgumentsAndSend() {
        if (getArguments() != null) {
            Event event = (Event) getArguments().getSerializable(ARG_EVENT_DATA);
            imageEvent.setImageResource(R.drawable.background_profile);
            textName.setText(event.getEventName());
            textDescription.setText(event.getEventDescription());
            textData.setText(event.getEventData());
            textTime.setText(event.getEventTime());
        }
    }
}