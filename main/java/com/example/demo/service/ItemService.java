package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public Item add (Item item)
    {
        return repo.save(item);
    }

    public List<Item> getAll(){
        return repo.findAll();
    }

    public Item getById(Long id ){
        return repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Item update(Long id, Item data) {
        Item item = getById(id);
        item.setItemName(data.getItemName());
        item.setQuantity(data.getQuantity());
        item.setPrice(data.getPrice());
        return repo.save(item);
    }

    public void delete(Long id) {
        Item item = getById(id);
        repo.delete(item);
    }

    public double getTotalValue() {
        return repo.findAll()
                .stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }

    public List<Item> searchByMinQty(int minQty) {
        return repo.findByQuantityGreaterThanEqual(minQty);
    }

}
