package com.example.max.location;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class MainActivity extends Activity {

    Button button;
     MapFragment googleMap;
    DownloadFile downloadFile = new DownloadFile();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);




    }

    public void pushButton(View view) {

        button.setClickable(false);
        downloadFile.execute("https://test.www.estaxi.ru/route.txt");
        new ReaderJson("/storage/emulated/0/Download/route.txt").reader();

    }



}