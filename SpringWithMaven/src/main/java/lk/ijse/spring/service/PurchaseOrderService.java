package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrderDTO;

public interface PurchaseOrderService {
    void purchaseOrder(OrderDTO orderDTO);
    void searchOrder(String oid);
    String genarateOrderId();
}
