package com.alis.geektech.presentation.fragments.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.help.HelpFragment;
import com.alis.geektech.presentation.fragments.home.inoffice.InOfficeFragment;
import com.alis.geektech.presentation.fragments.home.events.EventsFragment;
import com.alis.geektech.presentation.main.MainActivity;

public class HomeFragment extends Fragment {

    public static void start(Activity activity, int action) {
        Navigation
                .findNavController(activity, R.id.nav_host_fragment)
                .navigate(action);
    }

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
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        MainActivity.fab.show();
                        MainActivity.fab.setImageResource(R.drawable.icon_add);
                        break;
                    case 1:
                        MainActivity.fab.show();
                        MainActivity.fab.setImageResource(R.drawable.icon_qr_code_scanner);
                        break;
                    case 2:
                        MainActivity.fab.hide();
                        break;
                }
            }
        });
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
                    fragment = new HelpFragment();
                    break;
                case 1:
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
            return 3;
        }
    }
}