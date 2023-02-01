package tn.inteldev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tn.inteldev.entites.Restaurant;
import tn.inteldev.services.RestaurantService;

@Component
public class DBInitializer implements ApplicationRunner {
    private final RestaurantService restaurantService;

    @Autowired
    public DBInitializer(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initRestaurants();
    }
    private void initRestaurants(){
        Restaurant firstRestaurant = new Restaurant();
        firstRestaurant.setRestaurantName("Pizza Bambo");
        firstRestaurant.setAddress("Nassriya");
        firstRestaurant.setContactNumber("55180612");
        firstRestaurant.setRadius(3000.0);
        firstRestaurant.setLatitude(34.747847);
        firstRestaurant.setLongitude(10.766163);
        Restaurant secondRestaurant = new Restaurant();
        secondRestaurant.setRestaurantName("Pizza Bambo");
        secondRestaurant.setAddress("Nassriya");
        secondRestaurant.setContactNumber("55180612");
        secondRestaurant.setRadius(3000.0);
        secondRestaurant.setLatitude(34.747847);
        secondRestaurant.setLongitude(10.766163);
        restaurantService.addRestaurant(firstRestaurant);
        restaurantService.addRestaurant(secondRestaurant);

    }
}
