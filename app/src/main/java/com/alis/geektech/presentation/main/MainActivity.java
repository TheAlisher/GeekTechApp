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

import com.alis.geektech.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavControllerWithBottomNav();
        createFAB();
        listenerNavController();
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
                navController.navigate(R.id.QRScannerFragment);
            }
        });
    }

    private void listenerNavController() {
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    case R.id.navigation_home:
                    case R.id.navigation_profile:
                    case R.id.inOfficeFragment:
                    case R.id.eventsFragment:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        fab.setVisibility(View.VISIBLE);
                        break;
                    case R.id.QRScannerFragment:
                        bottomNavigationView.setVisibility(View.GONE);
                        fab.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}