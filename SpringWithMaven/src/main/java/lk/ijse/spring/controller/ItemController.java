package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponceUtil saveItem(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
        return new ResponceUtil(200,"Item Saved",null);
    }

    @DeleteMapping(params = {"id"})
    public ResponceUtil deleteItem(@RequestParam String id){
        itemService.deleteItem(id);
        return new ResponceUtil(200,"Item Deleted",null);
    }

    @PutMapping
    public ResponceUtil updateItem(@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemDTO);
        return new ResponceUtil(200,"Item Updated",null);
    }

    @GetMapping(params = {"id"})
    public ResponceUtil searchItem(@RequestParam String id){
        ItemDTO itemDTO = itemService.searchItem(id);
        System.out.println(itemDTO.getCode()+" "+itemDTO.getName());
        return new ResponceUtil(200,"Ok",itemDTO);
    }

    @GetMapping
    public ResponceUtil getAllItems(){
        List<ItemDTO> allItem = itemService.getAllItem();
        return new ResponceUtil(200,"Ok",allItem);
    }


}
