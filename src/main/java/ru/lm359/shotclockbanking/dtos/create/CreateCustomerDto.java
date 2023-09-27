package ru.lm359.shotclockbanking.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String address;
    private String contactDetails;
    private Long userId;
}
