package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO item);
    void deleteItem(String id);
    void updateItem(ItemDTO item);
    ItemDTO searchItem(String id);
    List<ItemDTO> getAllItem();
}
