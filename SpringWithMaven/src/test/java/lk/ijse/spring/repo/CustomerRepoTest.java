package lk.ijse.spring.repo;

import lk.ijse.spring.config.JPAConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@WebAppConfiguration/*test clas*/
@ContextConfiguration(classes = {JPAConfig.class})/*configure the enviromant of junit*/
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void saveCustomer() {

        customerRepo.save(new Customer("C001", "Dasun","Gampaha", 23000.00));
    }

    @Test
    public void getAllCustomes() {
        List<Customer> all = customerRepo.findAll();
        for (Customer customer : all) {
            System.out.println(customer.getId() + " " + customer.getName() + " " + customer.getSalary());
        }
    }

    @Test
    public void searchCustomer(){
        Optional<Customer> optional = customerRepo.findById("C005");
        if (optional.isPresent()) {
            Customer customer = optional.get();
            System.out.println(customer);
        }else {
            System.out.println("There isn't any customer");
        }
    }

    @Test
    public void deleteCustomer(){
        customerRepo.deleteById("C001");
    }

    @Test
    public void updateCustomer(){
        customerRepo.save(new Customer("C001", "Dasun","Gampaha", 23000.00));
    }

    @Test
    public void testDTO(){
        CustomerDTO customerDTO = new CustomerDTO();
    }

    @Test
    public void searchCustomerByName(){
        Customer charith = customerRepo.findCustomersByName("Charith");
        System.out.println(charith);
    }

}