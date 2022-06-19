package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.responceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public responceUtil getCustomer(){
        return new responceUtil(200,"Ok",customerService.getAllCustomer());
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customer){
        customerService.saveCustomer(customer);
    }
}
