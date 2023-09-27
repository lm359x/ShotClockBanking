package ru.lm359.shotclockbanking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "contact_details", length = 100)
    private String contactDetails;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Customer(String firstName, String lastName, String address, String contactDetails, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactDetails = contactDetails;
        this.user = user;
    }
}
