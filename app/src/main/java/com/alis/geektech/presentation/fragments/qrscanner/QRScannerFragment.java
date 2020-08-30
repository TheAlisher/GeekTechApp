package com.alis.geektech.presentation.fragments.qrscanner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.alis.geektech.App;
import com.alis.geektech.R;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.Result;

public class QRScannerFragment extends Fragment {

    public static final int PERM_CAMERA_REQUEST_CODE = 16;

    private CodeScannerView codeScannerView;
    public static CodeScanner codeScanner;

    public QRScannerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qr_scanner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createScanner(view);
    }

    private void createScanner(final View view) {
        codeScannerView = view.findViewById(R.id.codeScannerView);
        codeScanner = new CodeScanner(requireContext(), codeScannerView);
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                requireActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result.toString().equals("GeekTech")) {
                            if (App.appPreferences.inOfficeOrNot()) {
                                Snackbar.make(view, "В офисе", Snackbar.LENGTH_LONG).show();
                                App.appPreferences.setInOffice(false);
                            } else {
                                Snackbar.make(view, "Не в офисе", Snackbar.LENGTH_LONG).show();
                                App.appPreferences.setInOffice(true);
                            }
                        }
                        Navigation
                                .findNavController(requireActivity(), R.id.nav_host_fragment)
                                .navigateUp();
                    }
                });
            }
        });
        checkPermissionCamera();
    }

    private void checkPermissionCamera() {
        int permissionCameraStatus = ContextCompat.checkSelfPermission
                (requireContext(), Manifest.permission.CAMERA);
        if (permissionCameraStatus == PackageManager.PERMISSION_GRANTED) {
            codeScanner.startPreview();
        } else {
            getCameraPermission();
        }
    }

    private void getCameraPermission() {
        ActivityCompat.requestPermissions(
                requireActivity(),
                new String[]{Manifest.permission.CAMERA}, PERM_CAMERA_REQUEST_CODE
        );
    }
}