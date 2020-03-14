package com.mandala.surveyor.ui.activity.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.mandala.surveyor.R;
import com.mandala.surveyor.data.items.BottomMenu;
import com.mandala.surveyor.ui.activity.history.HistoryAbsen;
import com.mandala.surveyor.ui.activity.setting.SettingActivity;
import com.mandala.surveyor.ui.adapter.AdapterBottomMenu;
import com.mandala.surveyor.utils.MarginUtil;
import com.mandala.surveyor.utils.PermissionUtil;
import com.mandala.surveyor.utils.PrefManagerUtil;
import com.mandala.surveyor.utils.RecyclerViewUtil;
import com.mandala.surveyor.utils.custom.GPSTracker;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mandala.surveyor.utils.PrefManagerUtil.SP_ISLOGIN;

public class MainActivity extends AppCompatActivity implements MainView, OnMapReadyCallback {

    AdapterBottomMenu adapterBottomMenu;
    BottomSheetBehavior sheetBehavior;
    Context mContext;
    Double myLat, myLng;
    GPSTracker gpsTracker;
    PrefManagerUtil preferences;
    GoogleMap mMap;
    LatLng myLocation;
    LinearLayout navProfile;
    RecyclerViewUtil recyclerViewUtil;
    RelativeLayout navAkun, navPemberitahuan, navSetting;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.header)
    AppBarLayout header;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.nav_logout)
    LinearLayout navLogout;
    @BindView(R.id.drawer)
    DrawerLayout drawer;
    @BindView(R.id.bottom_menu)
    LinearLayout bottomMenu;
    @BindView(R.id.img_close)
    ImageView imgClose;
    @BindView(R.id.img_open)
    ImageView imgOpen;
    @BindView(R.id.title_open)
    TextView titleOpen;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.img_logout)
    ImageView imgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        preferences = new PrefManagerUtil(this);
        setSupportActionBar(toolbar);

        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 4));
        mRecyclerView.setHasFixedSize(true);

        recyclerViewUtil = new RecyclerViewUtil(MainActivity.this, R.dimen.card_margin);
        mRecyclerView.addItemDecoration(recyclerViewUtil);

        adapterBottomMenu = new AdapterBottomMenu(getBottomMenu(), this);
        mRecyclerView.setAdapter(adapterBottomMenu);

        gpsTracker = new GPSTracker(mContext, this);

        myLat = gpsTracker.getLatitude();
        myLng = gpsTracker.getLongitude();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        initNavigationDrawer();
        initBottomSheetBehavior();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        myLocation = new LatLng(myLat, myLng);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myLocation)
                .zoom(17)
                .build();

        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.addMarker(new MarkerOptions()
                .position(myLocation)
                .title("My Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = null;
                try {
                    v = getLayoutInflater().inflate(R.layout.dialog_map_infowindow, null);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return v;
            }
        });
//        View view = ((LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker, null);
//        TextView titleMarker = (TextView) view.findViewById(R.id.titleMarker);
//        titleMarker.setText("Tugu Tani");
//
//        updateMarker = mMap.addMarker(new MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(MapsWisata.this, view)))
//                .position(tamanKotaLampung));
//
//        mMap.setOnInfoWindowClickListener(this);

        PermissionUtil.checkPermission(this);
    }

    @Override
    public void initNavigationDrawer() {
        View menu = navigationView.getHeaderView(0);
        navProfile = menu.findViewById(R.id.nav_profile);
        navAkun = menu.findViewById(R.id.nav_akun);
        navPemberitahuan = menu.findViewById(R.id.nav_pemberitahuan);
        navSetting = menu.findViewById(R.id.nav_setting);

        navProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DO NOTHING
            }
        });

        navAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(Gravity.LEFT);
            }
        });

        navPemberitahuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(Gravity.LEFT);
            }
        });

        navSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
                drawer.closeDrawer(Gravity.LEFT);
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void initBottomSheetBehavior() {
        sheetBehavior = BottomSheetBehavior.from(bottomMenu);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        bottomMenu.setBackground(getResources().getDrawable(R.drawable.bg_bottom_open));
                        MarginUtil.setMargins(bottomMenu, 0, 0, 0, -20);
                        imgClose.setVisibility(View.VISIBLE);
                        imgOpen.setVisibility(View.GONE);
                        titleOpen.setVisibility(View.GONE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        bottomMenu.setBackground(getResources().getDrawable(R.drawable.bg_bottom_open));
                        imgClose.setVisibility(View.GONE);
                        imgOpen.setVisibility(View.VISIBLE);
                        titleOpen.setVisibility(View.VISIBLE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    private List<BottomMenu> getBottomMenu() {
        List<BottomMenu> bottomMenuList = new ArrayList<>();
        bottomMenuList.add(new BottomMenu(R.drawable.ic_absen, 0, "Absen"));
        bottomMenuList.add(new BottomMenu(R.drawable.ic_assignment, 4, "Penugasan"));
        bottomMenuList.add(new BottomMenu(R.drawable.ic_performance, 0, "My\nPerformance"));
        bottomMenuList.add(new BottomMenu(R.drawable.ic_lacak, 2, "Lacak\nAplikasi"));
        bottomMenuList.add(new BottomMenu(R.drawable.ic_inbox, 2, "Inbox"));
        bottomMenuList.add(new BottomMenu(R.drawable.ic_data, 3, "Kelengkapan\nData"));

        return bottomMenuList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_route:

                break;
            case R.id.action_history:
                startActivity(new Intent(getApplicationContext(), HistoryAbsen.class));

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    @OnClick({R.id.bottom_menu, R.id.nav_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu:
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomMenu.setBackground(getResources().getDrawable(R.drawable.bg_bottom_open));
                    MarginUtil.setMargins(bottomMenu, 0, 0, 0, -20);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    imgClose.setVisibility(View.VISIBLE);
                    imgOpen.setVisibility(View.GONE);
                    titleOpen.setVisibility(View.GONE);
                } else {
                    bottomMenu.setBackground(getResources().getDrawable(R.drawable.bg_bottom_open));
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    imgClose.setVisibility(View.GONE);
                    imgOpen.setVisibility(View.VISIBLE);
                    titleOpen.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.nav_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Apakah kamu yakin ingin keluar?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user pressed "yes", then he is allowed to exit from application
                        finish();
                        preferences.saveSPBoolean(SP_ISLOGIN, false);
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user select "No", just cancel this dialog and continue with app
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
    }
}
