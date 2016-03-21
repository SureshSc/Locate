package com.sivaguru.locate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sivaguru.locate.Adapter.LocationAdapter;
import com.sivaguru.locate.Helper.GooglePlayServicesHelper;
import com.sivaguru.locate.Helper.LocationClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.locationListView);

        ArrayList<LocationClass> data = new ArrayList<>();

        // temporarly clearing

        LocationClass data1 = new LocationClass();
        data1.title = "Title";
        data1.subTitle = "Sub Title";
        data1.location = "location";

        for (int i = 0 ; i < 20 ; i++) {
            data.add(data1);
        }

        LocationAdapter locationAdapter = new LocationAdapter(data,this);
        listView.setAdapter(locationAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                GooglePlayServicesHelper googlePlayServicesHelper = new GooglePlayServicesHelper(MainActivity.this);
                boolean isAvailable = googlePlayServicesHelper.checkPlayServices();

                if (isAvailable){
                    Intent mapIntent = new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(mapIntent);
                } else {

                }

            }
        });
    }
}
