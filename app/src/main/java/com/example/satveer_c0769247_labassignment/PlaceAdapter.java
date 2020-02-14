package com.example.satveer_c0769247_labassignment;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PlaceAdapter extends ArrayAdapter {
    Context mcontext;
    int layoutRes;
    DatabaseHelper mDatabase;
    List<Places> listPlace;


    public PlaceAdapter(@NonNull Context mcontext, int layoutRes, List<Places> listPlace, DatabaseHelper mDatabase) {
        super(mcontext, layoutRes,listPlace);
        this.mcontext = mcontext;
        this.layoutRes = layoutRes;
        this.listPlace = listPlace;
        this.mDatabase = mDatabase;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(layoutRes,null);
        TextView tvname = view.findViewById(R.id.tv_name);
        TextView tvaddress = view.findViewById(R.id.tv_address);
        TextView tvlongitude = view.findViewById(R.id.tv_longitude);
        TextView tvlatitude = view.findViewById(R.id.tv_latitude);
        TextView tvdate = view.findViewById(R.id.tv_date);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String addDate = simpleDateFormat.format(calendar.getTime());


        final Places list = listPlace.get(position);
        tvname.setText(list.getDate());
        tvaddress.setText(list.getAddress());
        //tvlatitude.setText(list.getLatitude());
        //tvlongitude.setText(list.getLongitude());
        tvdate.setText(addDate);

//        view.findViewById(R.id.btn_edit).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        view.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        return view;

    }

//    private void loadPlaces(){
//
//        String sql = "SELECT * FROM places";
//        Cursor c = mDatabase.getAllPlaces();
//        listPlace.clear();
//        if (c.moveToFirst()){
//
//            do{
//
//                listPlace.add(new ClassOfPlaces(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5)));
//            }while (c.moveToNext());
//            c.close();
//
//
//
//        }
//        notifyDataSetChanged();
//
//    }
//


}

