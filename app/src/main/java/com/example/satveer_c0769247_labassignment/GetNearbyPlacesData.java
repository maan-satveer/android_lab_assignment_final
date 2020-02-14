package com.example.satveer_c0769247_labassignment;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPlacesData extends AsyncTask<Object, String, String> {
    String place_data,url_location;
    GoogleMap map;


    @Override
    protected String doInBackground(Object... objects) {
        map = (GoogleMap) objects[0];
        url_location = (String) objects[1];

        FetchURL url = new FetchURL();
        try {
            place_data = url.readUrl(url_location);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  place_data;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>> placeList = null;
        DataParser dataParser = new DataParser();
        placeList = dataParser.parse(s);

        showNearByPlaces(placeList);

    }


    private void showNearByPlaces(List<HashMap<String,String>> placesList){
        for (int i = 0;i<placesList.size();i++) {
            MarkerOptions options = new MarkerOptions();
            HashMap<String, String> mapPlace = placesList.get(i);

            String name = mapPlace.get("placeName");
            String vicinity = mapPlace.get("vicinity");
            double lat = Double.parseDouble(mapPlace.get("lat"));
            double longi = Double.parseDouble(mapPlace.get("lng"));

            LatLng latLng = new LatLng(lat, longi);
            options.position(latLng);

            options.title(name + ":" + vicinity);
            options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            map.addMarker(options);
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            map.moveCamera(CameraUpdateFactory.zoomTo(10));

        }

    }
}



