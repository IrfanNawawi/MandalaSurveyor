package com.mandala.surveyor.ui.fragment.absen;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mandala.surveyor.R;
import com.mandala.surveyor.utils.PermissionUtil;
import com.mandala.surveyor.utils.custom.GPSTracker;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.mandala.surveyor.utils.PermissionUtil.REQUEST_CODE_TAKE_PICTURE;
import static com.mandala.surveyor.utils.PermissionUtil.REQUEST_MAIN;

public class AbsenMobile extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.img_photo)
    ImageView imgPhoto;
    @BindView(R.id.btn_camera)
    RelativeLayout btnCamera;
    @BindView(R.id.place_holder)
    LinearLayout placeHolder;
    @BindView(R.id.place_map)
    LinearLayout placeMap;
    @BindView(R.id.btn_absen)
    Button btnAbsen;
    @BindView(R.id.frameMap)
    FrameLayout frameMap;
    private Context context;
    private File tempFile;
    Double myLat, myLng;
    GPSTracker gpsTracker;
    Context mContext;
    GoogleMap mMap;
    LatLng myLocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.absen_mobile, container, false);
        unbinder = ButterKnife.bind(this, v);
        context = getActivity();

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_MAIN:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera();
                } else {
                    checkingPermissions();
                }
                break;
        }
    }

    private void checkingPermissions() {
        if (PermissionUtil.isGranted(getActivity(), Manifest.permission.CAMERA,
                new String[]{Manifest.permission.CAMERA},
                REQUEST_MAIN,
                "Akses kamera diperlukan untuk melanjutkan proses")) {
            openCamera();
        }
    }

    private void openCamera() {
        int randomName = (int) (Math.random() * 9000) + 1000;

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        tempFile = new File(context.getExternalCacheDir() + File.separator + randomName + "-collection.jpg" + File.separator);
        Uri uri = Uri.fromFile(tempFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(cameraIntent, REQUEST_CODE_TAKE_PICTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {

            return;
        }

        if (requestCode == REQUEST_CODE_TAKE_PICTURE) {

            Glide.with(context)
                    .load(tempFile)
                    .thumbnail(0.5f)
                    .into(imgPhoto);

            imgPhoto.setVisibility(View.VISIBLE);
            placeHolder.setVisibility(View.GONE);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_camera, R.id.place_map, R.id.btn_absen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_camera:
                checkingPermissions();

                break;
            case R.id.place_map:
                placeMap.setVisibility(View.GONE);
//                frameLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_absen:
                if (tempFile == null || !tempFile.exists()) {
                    Toast.makeText(getActivity(), R.string.error_absen, Toast.LENGTH_SHORT).show();

                } else {
                    View alertLayout = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_absen_success, null);
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setView(alertLayout);
                    alert.setCancelable(true);

                    final AlertDialog dialog = alert.create();
                    dialog.show();
//                    AlertDialog.Builder alt_bld = new AlertDialog.Builder(getActivity());
//                    alt_bld.setTitle("Absen Sukses")
//                            .setMessage("Terima kasih anda telah melakukan absen masuk").setCancelable(false)
//                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//                    AlertDialog alert = alt_bld.create();
//                    alert.show();
                }

                break;
        }
    }
}
