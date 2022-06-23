package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.service.PurchaseOrderService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
@CrossOrigin
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService orderService;

    @PostMapping
    public ResponceUtil purchaseOrder(@RequestBody OrderDTO orderDTO){
        System.out.println(orderDTO.toString());
        orderService.purchaseOrder(orderDTO);
       return new ResponceUtil(200,"Order has bean placed",null);
    }

    @GetMapping
    public ResponceUtil generateOrderId(){
        String id = orderService.genarateOrderId();
        return new ResponceUtil(200,"ok",id);
    }

    @GetMapping(params = {"oid"})
    public ResponceUtil searchOrder(@RequestParam String oid){
        OrderDTO orderDTO = orderService.searchOrder(oid);
        return new ResponceUtil(200,"Ok",orderDTO);
    }

    @DeleteMapping(params = {"oid"})
    public ResponceUtil deleteOrder(@RequestParam String oid){
        orderService.deleteOrder(oid);
        return new ResponceUtil(200,"Order deleted",null);
    }
}
