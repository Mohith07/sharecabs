package com.app.sharecabs.service.maps_api;

public class CheckForShare {

    private static TimeShareThreshold timeShareThreshold = TimeShareThreshold.DEFAULT;

    public boolean isSharePossible(String inFromPosition, String inDestPosition, String inSharePosition) {

        long orginalDuration = DistanceCalculator
                .getTimeToTravelByVehicle(inFromPosition, inDestPosition);

        long newDuration = getNewDuration(inFromPosition, inSharePosition, inDestPosition);

        return isNewDurationUnderThreshold(orginalDuration, newDuration);
    }

    private static boolean isNewDurationUnderThreshold(long inOriginalDuration, long inNewDuration) {
        if(inNewDuration < inOriginalDuration) {
            return true;
        }

        long percentageDifference = ((inNewDuration - inOriginalDuration) * 100)/inOriginalDuration;

        if(percentageDifference <= timeShareThreshold.getValue()) {
            return true;
        }
        return false;
    }

    private static long getNewDuration(String inFromPosition, String inSharePosition, String inDestPosition) {
        long fromToShareTime = DistanceCalculator
                .getTimeToTravelByVehicle(inFromPosition, inSharePosition);
        long shareToDestTime = DistanceCalculator
                .getTimeToTravelByVehicle(inSharePosition, inDestPosition);

        return fromToShareTime+shareToDestTime;
    }

    public CheckForShare setTimeThreshold(TimeShareThreshold inTimeShareThreshold) {
        timeShareThreshold = inTimeShareThreshold;
        return this;
    }

    public static CheckForShare newRequest() {
        return new CheckForShare();
    }


}
