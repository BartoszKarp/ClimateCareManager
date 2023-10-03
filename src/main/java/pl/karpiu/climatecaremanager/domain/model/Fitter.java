package pl.karpiu.climatecaremanager.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "fitters")
@Data
public class Fitter {

    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String email;
}
