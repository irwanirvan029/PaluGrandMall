package com.example.palugrandmall;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.palugrandmall.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng home = new LatLng(-0.888969, 119.839065);
        LatLng Mall= new LatLng(-0.883486, 119.842468);
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapstart = (BitmapDrawable)getResources().getDrawable(R.drawable.house);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.mall);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(home).title("Marker in home")
                .snippet("Ini adalah rumah saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(Mall).title("Marker in Mall")
                .snippet("Ini adalah Mall")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                new LatLng(-0.888969, 119.839065),
                new LatLng(-0.888932, 119.839596),
                new LatLng(-0.887809, 119.839677),
                new LatLng(-0.889030, 119.841175),
                new LatLng(-0.884872, 119.843675),
                new LatLng(-0.883528, 119.841550),
                new LatLng(-0.883058, 119.841835),
                new LatLng(-0.882956, 119.841690),
                new LatLng(-0.882647, 119.841883),
                new LatLng(-0.882606, 119.841949),
                new LatLng(-0.882848, 119.842378),
                new LatLng(-0.882870, 119.842507),
                new LatLng(-0.883446, 119.842468),

                Mall
                ).width(10)
                        .color(Color.RED)

        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
    }
}