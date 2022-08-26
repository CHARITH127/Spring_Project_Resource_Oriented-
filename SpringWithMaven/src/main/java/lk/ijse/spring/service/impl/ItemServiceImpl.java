package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveItem(ItemDTO item) {
        if (itemRepo.existsById(item.getCode())) {
            throw new RuntimeException("Item is already added");
        } else {
            itemRepo.save(mapper.map(item, Item.class));

        }
    }

    @Override
    public void deleteItem(String id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
        } else {
            throw new RuntimeException("Not such a item.. please check the item code");
        }
    }

    @Override
    public void updateItem(ItemDTO item) {
        if (itemRepo.existsById(item.getCode())) {
            itemRepo.save(mapper.map(item, Item.class));
        } else {
            throw new RuntimeException("Not such a item.. please check the item code");
        }
    }

    @Override
    public ItemDTO searchItem(String id) {
        if (itemRepo.existsById(id)) {
            Item item = itemRepo.findById(id).get();
            return mapper.map(item, ItemDTO.class);
        } else {
            throw new RuntimeException("Not such a item.. please check the item code");
        }

    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> all = itemRepo.findAll();
        return mapper.map(all,new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
