package com.alis.geektech.presentation.fragments.home.events;

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
import android.widget.ImageView;

import com.alis.geektech.R;
import com.alis.geektech.adapters.EventsAdapter;
import com.alis.geektech.interfaces.OnItemClickListener;
import com.alis.geektech.models.Event;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.alis.geektech.presentation.fragments.home.events.event.EventFragment;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private ImageView imageHelp;
    private ImageView imageInOffice;

    private RecyclerView recyclerView;
    private EventsAdapter adapter;
    private ArrayList<Event> list = new ArrayList<>();

    public EventsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        createEventsRecycler();
        imageHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickHelp();
            }
        });
        imageInOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInOffice();
            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                clickAdapter(position);
            }
        });
    }

    private void initializationViews(View view) {
        imageHelp = view.findViewById(R.id.image_events_help);
        imageInOffice = view.findViewById(R.id.image_events_in_office);
        recyclerView = view.findViewById(R.id.recycler_events);
    }

    private void createEventsRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EventsAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void clickHelp() {
        HomeFragment.viewPager.setCurrentItem(0);
    }

    private void clickInOffice() {
        HomeFragment.viewPager.setCurrentItem(2);
    }

    private void clickAdapter(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EventFragment.ARG_EVENT_DATA, list.get(position));
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_navigation_home_to_eventFragment, bundle);
    }
}