package tn.inteldev.helpers;

import tn.inteldev.dto.Coordination;
import tn.inteldev.entites.Restaurant;

public class LocationHelpers {

    public static boolean checkRestaurantInCustomerRange(Restaurant restaurant ,Coordination customerCoordination){
        Coordination restaurantCoordination = new Coordination(restaurant.getLatitude(),restaurant.getLongitude());
        return getDistanceBetweenTwoCoordination(restaurantCoordination,customerCoordination) <= restaurant.getRadius();
    }
    private static final int EARTH_MEAN_RADIUS_IN_METER = 6378137;

    private static double getDistanceBetweenTwoCoordination(Coordination firstCoordination , Coordination secondCoordination){
    double distanceLatitude = convertToRadian(secondCoordination.getLatitude() - firstCoordination.getLatitude());
    double distanceLongitude = convertToRadian(secondCoordination.getLongitude() - firstCoordination.getLongitude());
    double a = Math.sin(distanceLatitude / 2) * Math.sin(distanceLatitude / 2) + Math.cos(convertToRadian(firstCoordination.getLatitude())) * Math.cos(convertToRadian(secondCoordination.getLatitude())) * Math.sin(distanceLongitude / 2) * Math.sin(distanceLongitude / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return EARTH_MEAN_RADIUS_IN_METER * c;
    }

    private static double convertToRadian(double x){
        return x * Math.PI / 180;
    }
}
