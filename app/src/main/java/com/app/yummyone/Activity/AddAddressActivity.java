package com.app.yummyone.Activity;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app.yummyone.R;

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener{

    Context mContext;
    CircleImageView img_Back;

    // Google Map
    //private GoogleMap googleMap;

    //SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        Log.e("Activity", "AddAddressActivity");

        mContext = this;

        getSupportActionBar().hide();

        ViewInitialization();

        ViewOnClick();
    }

    public void ViewInitialization() {
        img_Back = findViewById(R.id.img_Back);

//        try {
//            // Loading map
//           // initilizeMap();
//            mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.map);
//            mapFragment.getMapAsync(this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

//    private void initilizeMap() {
//        if (googleMap == null) {
//           // googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//            // check if map is created successfully or not
//            if (googleMap == null) {
//                Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }



    public void ViewOnClick() {
        img_Back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_Back:
                finish();
                break;
        }
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(37.4233438, -122.0728817))
//                .title("LinkedIn")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
//
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(37.4629101,-122.2449094))
//                .title("Facebook")
//                .snippet("Facebook HQ: Menlo Park"));
//
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(37.3092293, -122.1136845))
//                .title("Apple"));
//
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), 10));
//    }

}