package com.example.satveer_c0769247_labassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlacesActivity extends AppCompatActivity {
    DatabaseHelper mDatabase;
    List<Places> listPlace;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        listView = findViewById(R.id.lvplaces);
        listPlace = new ArrayList<>();
        mDatabase = new DatabaseHelper(this);
        loadPlaces();


        PlaceAdapter placesAdaptor = new PlaceAdapter(this,R.layout.list_places,listPlace,mDatabase);
        listView.setAdapter(placesAdaptor);

    }



    private void loadPlaces(){

        Cursor cursor = mDatabase.getAllPlaces();
        if(cursor.moveToFirst()){

            do{


                listPlace.add(new Places(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3),cursor.getDouble(4)
                ));

            }while (cursor.moveToNext());

            cursor.close();
        }


        // Custom Adaptor
//        PlacesAdaptor placesAdaptor = new PlacesAdaptor(this,R.layout.list_layout_favrtplaces,listPlace,mDatabase);
//        listView.setAdapter(placesAdaptor);

    }

}

