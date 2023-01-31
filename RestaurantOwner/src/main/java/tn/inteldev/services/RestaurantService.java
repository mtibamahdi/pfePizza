package tn.inteldev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.inteldev.dto.Coordination;
import tn.inteldev.entites.Restaurant;
import tn.inteldev.repositories.RestaurantRepository;

import java.util.List;
import java.util.stream.Collectors;

import static tn.inteldev.helpers.LocationHelpers.checkRestaurantInCustomerRange;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> findRestaurantByName(String restaurantName, Coordination customerCoordination) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurantByRestaurantName(restaurantName);
        return restaurants.stream()
                .filter(restaurant -> checkRestaurantInCustomerRange(restaurant, customerCoordination))
                .collect(Collectors.toList());
    }
    // TODO
    //TO BE REMOVED
    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

}
