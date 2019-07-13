package com.app.sharecabs.service.maps_api;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.TrafficModel;

import java.io.IOException;
import java.time.Instant;

public class DistanceCalculator {
    public static DistanceMatrixElement getDistanceAndTime(String inFromLocation, String inToLocation) {
        try {
            DistanceMatrix matrix = getDefaultDistanceMatrix(inFromLocation, inToLocation);
            System.out.println(matrix.rows[0].elements[0]);
            return matrix.rows[0].elements[0];
        } catch(Exception e) {
            System.out.println("Distance calculator : " + e);
            return null;
        }
    }

    static long getTimeToTravelByVehicle(String inFromPosition, String inToPosition) {
        try {
            DistanceMatrix matrix = getDefaultDistanceMatrix(inFromPosition, inToPosition);
            System.out.println(matrix.rows[0].elements[0].duration);
            return matrix.rows[0].elements[0].duration.inSeconds;
        } catch(Exception e) {
            System.out.println("Distance calculator : " + e);
            return 0L;
        }
    }

    private static DistanceMatrix getDefaultDistanceMatrix(String inFromLocation, String inToLocation) throws InterruptedException, ApiException, IOException {
        return DistanceMatrixApi.newRequest(GeoContext.getGeoApiContext())
                .origins(ConvertToCoordinates.getCoordinates(inFromLocation))
                .destinations(ConvertToCoordinates.getCoordinates(inToLocation))
                .departureTime(Instant.ofEpochMilli(System.currentTimeMillis() + 60*60))
                .trafficModel(TrafficModel.BEST_GUESS)
                .await();
    }
}
