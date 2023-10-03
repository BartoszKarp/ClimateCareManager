package pl.karpiu.climatecaremanager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
}
