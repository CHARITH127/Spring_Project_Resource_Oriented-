package lk.ijse.spring.controller;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public List<Customer> getCustomer(){
       return customerService.getAllCustomer();
    }

    @PostMapping
    public void saveCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
    }
}
