package lk.ijse.spring.service.impl;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public void saveCustomer(Customer customer){
        repo.save(customer);
    }
    @Override
    public void deleteCustomer(String id){

        repo.deleteById(id);
    }
    @Override
    public void updateCustomer(Customer customer){

        repo.save(customer);
    }
    @Override
    public Customer searchCustomer(String id){
        return repo.findById(id).get();
    }
    @Override
    public List<Customer> getAllCustomer(){
        return repo.findAll();
    }
}
