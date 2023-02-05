package com.example.petakos;

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
import com.example.petakos.databinding.ActivityMapsBinding;
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
        LatLng kos = new LatLng(-0.88698, 119.87586);
        LatLng stimik = new LatLng(-0.88670, 119.875571);
        //add market
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_standard_color_18);
        BitmapDrawable bitmapDes = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_disabled_color_18);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap marketStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add market to map
        mMap.addMarker(new MarkerOptions().position(kos).title("Marker in jl Suprapto")
                .snippet("Tempat tinggal saya")
                .icon(BitmapDescriptorFactory.fromBitmap(marketStart)));
        mMap.addMarker(new MarkerOptions().position(stimik).title("Marker in Stimik")
                .snippet("ini kampus saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.addPolyline(new PolylineOptions().add(
            kos,
            new LatLng(-0.88692, 119.87541),
                new LatLng(-0.88668, 119.87545),
        stimik).width(10).color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stimik,19));
    }
}