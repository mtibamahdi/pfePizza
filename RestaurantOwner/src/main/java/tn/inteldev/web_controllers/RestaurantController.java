package tn.inteldev.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.inteldev.dto.Coordination;
import tn.inteldev.dto.Customer;
import tn.inteldev.entites.Restaurant;
import tn.inteldev.services.RestaurantService;

import java.security.Principal;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<?> AddRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllRestaurant() {
        return new ResponseEntity<>(restaurantService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/by/Name/{restaurantName}/{lat}/{lng}")
    public ResponseEntity<?> getAllRestaurant(@PathVariable String restaurantName, @PathVariable double lat, @PathVariable double lng) {
        Coordination customerCoord = new Coordination(lat, lng);
        return new ResponseEntity<>(restaurantService.findRestaurantByName(restaurantName, customerCoord), HttpStatus.ACCEPTED);
    }

    @GetMapping("/cheking")
    public String checking() {
        return "you are authenticated";
    }

}
