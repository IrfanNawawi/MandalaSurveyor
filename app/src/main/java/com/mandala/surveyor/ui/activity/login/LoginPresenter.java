package com.mandala.surveyor.ui.activity.login;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;

import com.mandala.surveyor.data.db.models.UserData;
import com.mandala.surveyor.data.db.response.UserResponse;
import com.mandala.surveyor.data.network.ApiInterface;
import com.mandala.surveyor.data.network.ApiServices;
import com.mandala.surveyor.utils.custom.MD5;

import java.util.List;

import androidx.core.app.ActivityCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    LoginView loginView;
    ApiServices apiServices;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void onLogin(String uid, String pass, final Context context) {
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(pass)) {
            loginView.displayError("Username atau password tidak boleh kosong");
        } else {
            loginView.showProgress();

            String deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            String model = Build.MANUFACTURER + " " + Build.MODEL;
            String osVersion = Build.VERSION.RELEASE
                    + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();
            String encrypt = MD5.md5(pass);

            TelephonyManager telephonyManager;
            telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "You are not setting READ PHONE STATE PERMISSION.", Toast.LENGTH_SHORT).show();
                return;
            }
            String imei = telephonyManager.getDeviceId();

            if (uid.equals("12345678") && pass.equals("12345678")) {
                Toast.makeText(context, "Anda tidak ada akses karena anda adalah collector", Toast.LENGTH_SHORT).show();
            } else if (uid.equals("87654321") && pass.equals("87654321")) {
                loginView.displaySurveyor("Selamat datang " + uid + " No Imei : " + imei + " Password Enkripsi : " + encrypt);
            } else if (uid.equals("12348765") && pass.equals("12348765")) {
                loginView.displayTakstator("Selamat datang " + uid + " No Imei : " + imei + " Password Enkripsi : " + encrypt);
            } else {
                Toast.makeText(context, "NIK atau Password yang anda masukkan salah", Toast.LENGTH_SHORT).show();
            }

//            connect login
//            apiServices = ApiInterface.getService();
//            final Call<UserResponse> userResponseCall = apiServices.login(uid, pass);
//            userResponseCall.enqueue(new Callback<UserResponse>() {
//                @Override
//                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                    loginView.hideProgress();
//                    if (response.isSuccessful()) {
//                        List<UserData> user = response.body().getUser();
//                        for (UserData u : user) {
//                            if (u.getStatus() == 1) {
//                                loginView.displayError("Anda tidak ada akses karena anda adalah collector");
//                            } else if (u.getStatus() == 2) {
//                                loginView.displaySurveyor("Selamat datang " + uid + " No Imei : " + imei + " Password Enkripsi : " + encrypt);
//                            } else if (u.getStatus() == 3) {
//                                loginView.displayTakstator("Selamat datang " + uid + " No Imei : " + imei + " Password Enkripsi : " + encrypt);
//                            } else {
//                                loginView.displayError("NIK atau Password yang anda masukkan salah");
//                            }
//                        }
//                    } else {
//                        loginView.displayError("Anda tidak ada akses, Silahkan dicoba kembali nanti");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<UserResponse> call, Throwable t) {
//                    loginView.hideProgress();
//                    t.printStackTrace();
//                }
//            });
        }
    }
}
