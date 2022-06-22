package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepo extends JpaRepository<Orders,String> {
    @Query(value = "select oid from Orders order by oid desc limit 1",nativeQuery = true)
    String genarateOrderID();
}
