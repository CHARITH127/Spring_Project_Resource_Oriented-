package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO customer){
        if (repo.existsById(customer.getId())) {
            throw new RuntimeException("Customer is Already added");
        }else {
            repo.save(mapper.map(customer,Customer.class));
        }
    }

    @Override
    public void deleteCustomer(String id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else {
            throw  new RuntimeException("Please check the customer Id... No Such a customer");
        }

    }
    @Override
    public void updateCustomer(CustomerDTO customer){

        if (repo.existsById(customer.getId())) {
            repo.save(mapper.map(customer,Customer.class));
        }else {
            throw  new RuntimeException("Please check the customer Id... No Such a customer");
        }

    }
    @Override
    public CustomerDTO searchCustomer(String id){

        if (repo.existsById(id)) {
            Customer customer = repo.findById(id).get();
            return mapper.map(customer, CustomerDTO.class);
        }else {
            throw  new RuntimeException("Please check the customer Id... No Such a customer");
        }


    }
    @Override
    public List<CustomerDTO> getAllCustomer(){
        List<Customer> all = repo.findAll();
       return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
