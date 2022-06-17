package lk.ijse.spring.service;

import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(Customer customer);
    public void deleteCustomer(String id);
    public void updateCustomer(Customer customer);
    public Customer searchCustomer(String id);
    public List<Customer> getAllCustomer();
}
