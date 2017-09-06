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

/**
 * Main method
 */

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private Button button;
    private DownloadFile downloadFile = new DownloadFile();
    private ReaderJson readerJson;
    private GoogleMap googleMap;
    private JsonArray jsonArray;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        //get fragment by id
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    public void pushButton(View view) {

        button.setClickable(false); //set button to false after her push, listener button set through xml settings

        downloadFile.execute("https://test.www.estaxi.ru/route.txt"); //
        readerJson = new ReaderJson("/storage/emulated/0/Download/route.txt");
        setRout();


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;//setter
    }


    public void setRout() {

        PolylineOptions polyline = new PolylineOptions();
        //polyline.color();
        jsonArray = readerJson.reader();

    //added coordinates to polyline and build their on map
        for (JsonElement element : jsonArray) {
            polyline.add(new LatLng(element.getAsJsonObject().get("la").getAsDouble(),
                    element.getAsJsonObject().get("lo").getAsDouble()));
        i++;// getting coordinates number
        }


        googleMap.addPolyline(polyline);// add on map lines
        

        // set position of the map's camera and set the zoom, get middle of list coordinate and set cameraPosition
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(jsonArray.get(i/2).getAsJsonObject().get("la").getAsDouble(),
                jsonArray.get(i/2).getAsJsonObject().get("lo").getAsDouble()), (float) 10.9));

    }


}