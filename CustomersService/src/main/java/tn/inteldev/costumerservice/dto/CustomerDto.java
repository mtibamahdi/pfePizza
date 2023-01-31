package tn.inteldev.costumerservice.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link tn.inteldev.costumerservice.entites.Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String avatar;
}