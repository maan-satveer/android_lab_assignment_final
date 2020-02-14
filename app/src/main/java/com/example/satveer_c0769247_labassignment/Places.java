package com.example.satveer_c0769247_labassignment;

public class Places {
    int id ;
    String address,nameoffavrtplace,date;
    Double latitude,longitude;

    public Places( String nameoffavrtplace,String date,String address,Double longitude,Double latitude) {
        this.nameoffavrtplace = nameoffavrtplace;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getNameoffavrtplace() {
        return nameoffavrtplace;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getDate() {
        return date;
    }
}

