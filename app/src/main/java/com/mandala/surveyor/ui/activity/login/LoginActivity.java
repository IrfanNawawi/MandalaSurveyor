package com.mandala.surveyor.ui.activity.login;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.material.textfield.TextInputLayout;
import com.mandala.surveyor.R;
import com.mandala.surveyor.ui.activity.main.MainActivity;
import com.mandala.surveyor.ui.activity.register.RegisterActivity;
import com.mandala.surveyor.ui.activity.takstator.TakstatorActivity;
import com.mandala.surveyor.utils.PermissionUtil;
import com.mandala.surveyor.utils.PrefManagerUtil;

import java.util.prefs.Preferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mandala.surveyor.utils.PrefManagerUtil.SP_ISLOGIN;


public class LoginActivity extends AppCompatActivity implements LoginView, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.input_nik)
    EditText inputNik;
    @BindView(R.id.input_layout_nik)
    TextInputLayout inputLayoutNik;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_forgot)
    TextView btnForgot;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    PrefManagerUtil preferences;
    LoginPresenter loginPresenter;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    PendingResult<LocationSettingsResult> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        preferences = new PrefManagerUtil(this);
        loginPresenter = new LoginPresenter(this);

        checkingPermissionGPS();

        if (preferences.getIsLogin() == true) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PermissionUtil.REQUEST_MAIN) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                mGoogleApiClient = new GoogleApiClient.Builder(LoginActivity.this)
                        .addApi(LocationServices.API)
                        .addConnectionCallbacks(LoginActivity.this)
                        .addOnConnectionFailedListener(LoginActivity.this).build();
                mGoogleApiClient.connect();

            } else {
                Toast.makeText(this, "Mohon aktifkan gps untuk dapat melanjutkan proses", Toast.LENGTH_LONG).show();
                checkingPermissionGPS();
            }
        }
    }

    private void checkingPermissionGPS() {
        if (!PermissionUtil.hasPermissions(LoginActivity.this, PermissionUtil.PERMISSIONS_LOCATION)) {
            ActivityCompat.requestPermissions(LoginActivity.this, PermissionUtil.PERMISSIONS_LOCATION, PermissionUtil.REQUEST_MAIN);
        } else {
            //Displaying a toast
            mGoogleApiClient = new GoogleApiClient.Builder(LoginActivity.this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(LoginActivity.this)
                    .addOnConnectionFailedListener(LoginActivity.this).build();
            mGoogleApiClient.connect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(30 * 1000);
        mLocationRequest.setFastestInterval(5 * 1000);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);

        result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());

        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                //final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        // All location settings are satisfied. The client can initialize location
                        // requests here.
                        //...
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        // Location settings are not satisfied. But could be fixed by showing the user
                        // a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(
                                    LoginActivity.this,
                                    PermissionUtil.REQUEST_LOCATION);
                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.
                        //...
                        break;
                }
            }
        });

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void onBackPressed() {
        finish();
    }

    @OnClick({R.id.btn_login, R.id.btn_forgot, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String uid = inputNik.getText().toString().trim();
                String pass = inputPassword.getText().toString().trim();
                loginPresenter.onLogin(uid, pass, this);
                break;
            case R.id.btn_forgot:

                break;
            case R.id.btn_register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

                break;
        }
    }


    @Override
    public void displaySurveyor(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        preferences.saveSPBoolean(SP_ISLOGIN, true);
        finish();
    }

    @Override
    public void displayTakstator(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), TakstatorActivity.class));
        preferences.saveSPBoolean(SP_ISLOGIN, true);
        finish();
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
