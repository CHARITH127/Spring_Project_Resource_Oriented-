package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponceUtil getCustomer(){
        return new ResponceUtil(200,"Ok",customerService.getAllCustomer());
    }

    @PostMapping
    public ResponceUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponceUtil(200,"Customer saved",null);
    }

    @PutMapping
    public ResponceUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponceUtil(200,"Customer Updated",null);
    }

    @GetMapping(params = {"custID"})
    public ResponceUtil searchCustomer(@RequestParam String custID){
        CustomerDTO customerDTO = customerService.searchCustomer(custID);
        return new ResponceUtil(200,"Ok",customerDTO);
    }

    @DeleteMapping(params = {"custID"})
    public ResponceUtil deleteCustomer(@RequestParam String custID){
        return new ResponceUtil(200,"Customer Deleted",null);
    }

}
