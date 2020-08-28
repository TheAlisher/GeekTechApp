package com.alis.geektech.presentation.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.inoffice.InOfficeFragment;
import com.alis.geektech.presentation.fragments.home.events.EventsFragment;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createViewPager(view);
    }

    private void createViewPager(View view) {
        viewPager = view.findViewById(R.id.view_pager_events);
        viewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager()));
    }

    public class HomePagerAdapter extends FragmentPagerAdapter {

        public HomePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public HomePagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new EventsFragment();
                    break;
                default:
                    fragment = new InOfficeFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}