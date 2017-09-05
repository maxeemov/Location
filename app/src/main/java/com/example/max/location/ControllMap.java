package com.example.max.location;


import android.graphics.Color;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class ControllMap {
    Polyline line;


    public void onMapReady(View view) {


        line= map.addPolyline(new PolylineOptions()
            .add(new LatLng(51.5, -0.1), new LatLng(40.7, -74.0))
            .width(5)
            .color(Color.RED));


    }
}
