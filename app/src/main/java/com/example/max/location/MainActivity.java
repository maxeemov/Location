package com.example.max.location;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.*;


public class MainActivity extends Activity   {

    private Button button;
    private GoogleMap googleMap;
    DownloadFile downloadFile = new DownloadFile();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                R.id.mapView)).getMap();


    }


    public void pushButton(View view) {

        button.setClickable(false);
        downloadFile.execute("https://test.www.estaxi.ru/route.txt");
        new ReaderJson("/storage/emulated/0/Download/route.txt").reader();

    }



}