package com.alis.geektech.presentation.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.alis.geektech.App;
import com.alis.geektech.R;
import com.alis.geektech.presentation.fragments.home.HomeFragment;
import com.alis.geektech.presentation.fragments.qrscanner.QRScannerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    public static FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isIntroOrAuthentication();

        setNavControllerWithBottomNav();
        createFAB();
        listenerNavController();
    }

    private void isIntroOrAuthentication() {
        if (App.appPreferences.isFirstLaunch()) {
            Navigation
                    .findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.introFragment);
        } else if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Navigation
                    .findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.authenticationFragment);
        }
    }

    private void setNavControllerWithBottomNav() {
        bottomNavigationView = findViewById(R.id.bottom_nav_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private boolean WWEorGTM = true;

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
                if (HomeFragment.pagerCurrentItem == 2) {
                    if (WWEorGTM) {
                        Snackbar.make(view, "Кто будет кушать?", Snackbar.LENGTH_LONG)
                                .setAction("Отправить", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(getBaseContext(), "Отправить всем кто в офисе уведомление КТО БУДЕТ КУШАТЬ?", Toast.LENGTH_SHORT).show();

                                    }
                                })
                                .show();
                    } else {
                        Snackbar.make(view, "Я в магазин", Snackbar.LENGTH_LONG)
                                .setAction("Отправить", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(getBaseContext(), "Отправить всем кто в офисе уведомление Я В МАГАЗИН", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .show();
                    }
                    WWEorGTM = !WWEorGTM;
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
                    case R.id.helpFragment:
                        fabShow();
                        bottomNavigationVISIBLE();
                        fab.setImageResource(R.drawable.icon_qr_code_scanner);
                        break;
                    case R.id.navigation_profile:
                        fabHide();
                        bottomNavigationVISIBLE();
                        break;
                    case R.id.QRScannerFragment:
                    case R.id.introFragment:
                    case R.id.authenticationFragment:
                    case R.id.addProblemFragment:
                    case R.id.chatFragment:
                    case R.id.editProfileFragment:
                    case R.id.eventFragment:
                    case R.id.problemFragment:
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case QRScannerFragment.PERM_CAMERA_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    QRScannerFragment.codeScanner.startPreview();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}