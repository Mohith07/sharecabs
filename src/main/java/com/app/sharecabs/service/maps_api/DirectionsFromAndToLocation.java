package com.app.sharecabs.service.maps_api;

import com.google.maps.DirectionsApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;

public class DirectionsFromAndToLocation {
    public static DirectionsRoute[] getDirectionResult(String inFromLocation, String inToLocation) {
        try {
            DirectionsResult result = DirectionsApi.newRequest(GeoContext.getGeoApiContext())
                    .mode(TravelMode.DRIVING)
                    .units(Unit.METRIC)
                    .region("in")
                    .origin(ConvertToCoordinates.getCoordinates(inFromLocation))
                    .destination(ConvertToCoordinates.getCoordinates(inToLocation))
                    .await();
            System.out.println(result.routes[0]);
            return result.routes;
        } catch(Exception e) {
            System.out.println("get directions " + e);
            return null;
        }
    }
}
