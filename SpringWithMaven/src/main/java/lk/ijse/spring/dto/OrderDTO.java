package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String oid;
   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Customer customer;
    List<OrderDetailsDTO> orderDetails;
}
