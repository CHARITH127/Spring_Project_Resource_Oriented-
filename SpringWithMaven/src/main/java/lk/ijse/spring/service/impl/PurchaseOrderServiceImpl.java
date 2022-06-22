package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void purchaseOrder(OrderDTO orderDTO) {
        Orders orders = mapper.map(orderDTO, Orders.class);
        System.out.println(orderDTO);
        if (!orderRepo.existsById(orderDTO.getOid())) {
            orderRepo.save(orders);

            /*update item Qty*/
            for (OrderDetailsDTO orderDetail : orderDTO.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetail.getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand()-orderDetail.getQty());
                itemRepo.save(item);
            }

        }else {
            throw new RuntimeException("Order is already add please check the order id");
        }


    }

    @Override
    public void searchOrder(String oid) {

    }

    @Override
    public String genarateOrderId() {
        String s = orderRepo.genarateOrderID();
        String id;
        if (!s.equals(null)) {
            int tempID = Integer.parseInt(s.split("-")[1]);
            tempID = tempID + 1;
            if (tempID < 9) {
                id = "O-00" + tempID;
                return id;
            } else if (tempID < 99) {
                id = "O-0" + tempID;
                return id;
            } else {
                id = "O-" + tempID;
                return id;
            }
        } else {
            id = "O-001";
            return id;
        }

    }
}
