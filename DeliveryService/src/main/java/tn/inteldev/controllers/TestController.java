package tn.inteldev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tn.inteldev.entites.Customer;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static tn.inteldev.helpers.Services.CUSTOMERS_SERVICE;

@RestController
@RequestMapping("/test")
public class TestController {
    /*
    private final String CUSTOMER_SERVICE = "http://cutomer-service/customer";
    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = restTemplate.getForObject(CUSTOMERS_SERVICE.baseUrl,List.class);
        return new ResponseEntity<>(customers, ACCEPTED);
    }*/
}
