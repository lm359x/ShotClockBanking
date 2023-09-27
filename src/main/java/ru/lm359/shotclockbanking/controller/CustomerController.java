package ru.lm359.shotclockbanking.controller;

import org.springframework.web.bind.annotation.*;
import ru.lm359.shotclockbanking.controller.exception.NotFoundException;
import ru.lm359.shotclockbanking.dtos.create.CreateCustomerDto;
import ru.lm359.shotclockbanking.models.Customer;
import ru.lm359.shotclockbanking.models.User;
import ru.lm359.shotclockbanking.service.CustomerService;
import ru.lm359.shotclockbanking.service.UserService;

import java.util.List;

@RequestMapping("/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final UserService userService;

    public CustomerController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @PostMapping
    public Customer createUser(@RequestBody CreateCustomerDto customerDto) {
        User user = userService.getUserById(customerDto.getUserId());
        if(user==null)
            throw new NotFoundException("User not found");
        Customer customer = new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getAddress(),
                customerDto.getContactDetails(),
                user);
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getUserById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Customer existingCustomer = customerService.getCustomerById(customerId);
        if(existingCustomer==null)
            throw new NotFoundException("Customer not found");
        if(updatedCustomer.getFirstName()!=null)
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
        if(updatedCustomer.getLastName()!=null)
            existingCustomer.setLastName(updatedCustomer.getLastName());
        if(updatedCustomer.getAddress()!=null)
            existingCustomer.setAddress(updatedCustomer.getAddress());
        if(updatedCustomer.getContactDetails()!=null)
            existingCustomer.setContactDetails(updatedCustomer.getContactDetails());

        return customerService.updateCustomer(existingCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
