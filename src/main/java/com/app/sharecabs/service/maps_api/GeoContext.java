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
                    .apiKey("AIzaSyCUb75qdJGc_q3In7TukItDDMQWvR4cldA")
                    .build();
            return geoApiContext;
        }
        return geoApiContext;
    }
}
