package com.alis.geektech.presentation.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.alis.geektech.App;
import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    public static FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isIntroOrAuth();

        setNavControllerWithBottomNav();
        createFAB();
        listenerNavController();
    }

    private void isIntroOrAuth() {
        if (App.appPreferences.isFirstLaunch()) {
            Navigation
                    .findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.introFragment);
        } else if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Navigation
                    .findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.signUpFragment);
        }
    }

    private void setNavControllerWithBottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private void createFAB() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (HomeFragment.pagerCurrentItem == 0) {
                    navController.navigate(R.id.addProblemFragment);
                }
                if (HomeFragment.pagerCurrentItem == 1) {
                    navController.navigate(R.id.QRScannerFragment);
                }

            }
        });
    }

    private void listenerNavController() {
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    case R.id.navigation_home:
                    case R.id.inOfficeFragment:
                    case R.id.eventsFragment:
                        fabShow();
                        bottomNavigationVISIBLE();
                        fab.setImageResource(R.drawable.icon_qr_code_scanner);
                        break;
                    case R.id.navigation_profile:
                    case R.id.chatFragment:
                        fabHide();
                        break;
                    case R.id.introFragment:
                    case R.id.signUpFragment:
                    case R.id.signInFragment:
                    case R.id.QRScannerFragment:
                    case R.id.addProblemFragment:
                        fabHide();
                        bottomNavigationGONE();
                        break;
                }
            }
        });
    }

    private void bottomNavigationVISIBLE() {
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    private void bottomNavigationGONE() {
        bottomNavigationView.setVisibility(View.GONE);
    }

    private void fabShow() {
        fab.show();
    }

    private void fabHide() {
        fab.hide();
    }
}