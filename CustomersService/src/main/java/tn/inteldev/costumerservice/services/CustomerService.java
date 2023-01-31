package tn.inteldev.costumerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tn.inteldev.costumerservice.entites.Customer;
import tn.inteldev.costumerservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(KafkaTemplate<String, String> kafkaTemplate, CustomerRepository customerRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.customerRepository = customerRepository;
    }


    public void sendMessage(String msg) {
        kafkaTemplate.send("pizzaApp", msg);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void sendMsg(String msg) {
        sendMessage(msg);
    }
}
