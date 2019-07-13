package com.app.sharecabs.service.maps_api;

import com.google.maps.GeoApiContext;

class GeoContext {
    private static GeoApiContext geoApiContext;

    private GeoContext() {

    }

    static GeoApiContext getGeoApiContext() {
        if (geoApiContext == null) {
            geoApiContext = new GeoApiContext
                    .Builder()
                    .apiKey("Enter your GCP api key")
                    .build();
            return geoApiContext;
        }
        return geoApiContext;
    }
}
