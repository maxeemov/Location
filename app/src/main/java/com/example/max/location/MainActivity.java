package com.example.max.location;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;



public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private Button button;
    DownloadFile downloadFile = new DownloadFile();
    ReaderJson readerJson;
    GoogleMap googleMap;
    JsonArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    public void pushButton(View view) {

        button.setClickable(false);

        downloadFile.execute("https://test.www.estaxi.ru/route.txt");
        readerJson = new ReaderJson("/storage/emulated/0/Download/route.txt");
        setRout();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;
    }


    public void setRout() {

        PolylineOptions polyline = new PolylineOptions();
        //polyline.color();
        jsonArray = readerJson.reader();


        for (JsonElement element : jsonArray) {
            polyline.add(new LatLng(element.getAsJsonObject().get("la").getAsDouble(),
                    element.getAsJsonObject().get("lo").getAsDouble()));

        }


        googleMap.addPolyline(polyline);
        

        // set position of the map's camera and set the zoom
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(jsonArray.get(1).getAsJsonObject().get("la").getAsDouble(),
                jsonArray.get(1).getAsJsonObject().get("lo").getAsDouble()), (float) 10.7));

    }


}