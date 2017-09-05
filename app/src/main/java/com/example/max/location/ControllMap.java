//package com.example.max.location;
//
//
//import android.support.v7.app.AppCompatActivity;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Polygon;
//import com.google.android.gms.maps.model.Polyline;
//import com.google.android.gms.maps.model.PolylineOptions;
//
//public class ControllMap extends AppCompatActivity implements OnMapReadyCallback,
//        GoogleMap.OnPolylineClickListener,
//        GoogleMap.OnPolygonClickListener  {
//
//
//
//
//
//    @Override
//    public void onPolygonClick(Polygon polygon) {
//
//    }
//
//    @Override
//    public void onPolylineClick(Polyline polyline) {
//
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//
//
//        // Add polylines and polygons to the map. This section shows just
//        // a single polyline. Read the rest of the tutorial to learn more.
//        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
//                .clickable(true)
//                .add(
//                        new LatLng(-35.016, 143.321),
//                        new LatLng(-34.747, 145.592),
//                        new LatLng(-34.364, 147.891),
//                        new LatLng(-33.501, 150.217),
//                        new LatLng(-32.306, 149.248),
//                        new LatLng(-32.491, 147.309)));
//
//        // Position the map's camera near Alice Springs in the center of Australia,
//        // and set the zoom factor so most of Australia shows on the screen.
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.684, 133.903), 4));
//
//        // Set listeners for click events.
//        googleMap.setOnPolylineClickListener(this);
//        googleMap.setOnPolygonClickListener(this);
//
//    }
//}
