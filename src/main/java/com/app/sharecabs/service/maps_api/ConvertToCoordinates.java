package com.app.sharecabs.service.maps_api;

import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

class ConvertToCoordinates {
    static LatLng getCoordinates(String location)  {
        try {
            GeocodingResult[] results =  GeocodingApi.geocode(GeoContext.getGeoApiContext(),
                    location).await();
            return results[0].geometry.location;
        } catch(Exception e) {
            System.out.println("get coordinates : " + e);
            return new LatLng();
        }
    }
}
