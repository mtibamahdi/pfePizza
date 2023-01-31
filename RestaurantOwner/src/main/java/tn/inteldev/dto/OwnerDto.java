package tn.inteldev.dto;

import lombok.Data;
import tn.inteldev.entites.Owner;

import java.io.Serializable;

@Data
public class OwnerDto implements Serializable {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String avatar;
}