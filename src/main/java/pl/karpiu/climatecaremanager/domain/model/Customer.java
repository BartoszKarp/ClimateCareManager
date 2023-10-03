package pl.karpiu.climatecaremanager.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Pattern(regexp = "^[\\p{L}]+$", message = "Only Polish alphabet")
    @Size(min = 2, message = "Name must be min 2 characters long")
    private String firstName;

    private String lastName;

    private String address;

    private String city;

    @Pattern(regexp = "^[0-9]{9}$", message = "Only numbers")
    private String phoneNumber;

    private String email;
}
