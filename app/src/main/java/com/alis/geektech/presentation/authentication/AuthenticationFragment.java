package com.alis.geektech.presentation.authentication;

import android.app.Activity;
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
import com.alis.geektech.presentation.fragments.home.events.EventsFragment;
import com.alis.geektech.presentation.fragments.home.help.HelpFragment;
import com.alis.geektech.presentation.fragments.home.inoffice.InOfficeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AuthenticationFragment extends Fragment {

    public static void start(Activity activity, int action) {
        Navigation
                .findNavController(activity, R.id.nav_host_fragment)
                .navigate(action);
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public AuthenticationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_authentication, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createTabLayoutWithViewPager(view);
    }

    private void createTabLayoutWithViewPager(View view) {
        tabLayout = view.findViewById(R.id.tabLayout_authentication);
        viewPager = view.findViewById(R.id.viewPager_authentication);
        tabLayout.setupWithViewPager(viewPager);
        AuthenticationPagerAdapter authenticationPagerAdapter = new AuthenticationPagerAdapter(getChildFragmentManager());
        authenticationPagerAdapter.addFragment(new SignInFragment(), "Войти");
        authenticationPagerAdapter.addFragment(new SignUpFragment(), "Зарегистрироваться");
        viewPager.setAdapter(authenticationPagerAdapter);

    }

    public class AuthenticationPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments = new ArrayList<>();
        private ArrayList<String> fragmentTitle = new ArrayList<>();

        public AuthenticationPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public AuthenticationPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}