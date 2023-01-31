package tn.inteldev.costumerservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.inteldev.costumerservice.services.CustomerService;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<?> updateProfile() {

        return new ResponseEntity<>(customerService.getAllCustomer(), ACCEPTED);
    }
    @GetMapping("sendMsg/{msg}")
    public String sendMessage(@PathVariable String msg){
        customerService.sendMsg(msg);
        return "hello";
    }
}
