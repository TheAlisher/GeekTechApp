package com.alis.geektech.presentation.fragments.home.help;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alis.geektech.App;
import com.alis.geektech.R;
import com.alis.geektech.adapters.HelpAdapter;
import com.alis.geektech.interfaces.OnItemClickListener;
import com.alis.geektech.models.Help;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.alis.geektech.presentation.fragments.home.help.problem.ProblemFragment;

import java.util.ArrayList;

public class HelpFragment extends Fragment {

    public static final String ARG_HELP_DATA = "help_data";

    private ImageView imageBack;

    private RecyclerView recyclerView;
    private HelpAdapter adapter;
    private ArrayList<Help> list = new ArrayList<>();

    public HelpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializationViews(view);
        createHelpRecycler();
        getArgumentsAndSet();
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBack();
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
        imageBack = view.findViewById(R.id.image_help_back);
        recyclerView = view.findViewById(R.id.recycler_help);
    }

    private void createHelpRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new HelpAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void getArgumentsAndSet() {
        if (getArguments() != null) {
            Help help = (Help) getArguments().getSerializable(ARG_HELP_DATA);
            list.add(help);
        }
    }

    private void clickBack() {
        HomeFragment.viewPager.setCurrentItem(1, true);
    }

    private void clickAdapter(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ProblemFragment.ARG_PROBLEM_DATA, list.get(position));
        Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_navigation_home_to_problemFragment, bundle);
    }
}