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
        repo.save(mapper.map(customer,Customer.class));
    }
    @Override
    public void deleteCustomer(String id){
        repo.deleteById(id);
    }
    @Override
    public void updateCustomer(CustomerDTO customer){

        repo.save(mapper.map(customer,Customer.class));
    }
    @Override
    public CustomerDTO searchCustomer(String id){

        Customer customer = repo.findById(id).get();
        return mapper.map(customer, CustomerDTO.class);
    }
    @Override
    public List<CustomerDTO> getAllCustomer(){

        List<Customer> all = repo.findAll();
       return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
