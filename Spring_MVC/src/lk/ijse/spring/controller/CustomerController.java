package lk.ijse.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping/*Haddler methods*/
    public String getAllCustomer(){
        return "Customer Get Method invoke ";
    }

    @GetMapping(path = "search")/*request narrow down*/
    public String searchAllCustomer(){
        return "Customer second Get Method invoke";
    }

    @PostMapping
    public String postAllCustomer(){
        return "Customer post Method invoke ";
    }

    @DeleteMapping
    public String deleteAllCustomer(){
        return "Customer delete Method invoke ";
    }

    @PutMapping
    public String putAllCustomer(){
        return "Customer put Method invoke ";
    }
}
